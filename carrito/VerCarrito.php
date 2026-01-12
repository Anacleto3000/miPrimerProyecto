<?php
session_start();



$conn = new mysqli("localhost", "root", "", "miprimerproyecto");

$sql = "SELECT producto_id, cantidad, p.nombre, p.imagen, p.precio from detalle_carrito dc
        JOIN carrito c ON dc.carrito_id = c.id
        Join productos p ON dc.producto_id = p.id
        WHERE c.usuario_id = ?";

$stmt = $conn->prepare($sql);
$stmt->bind_param("i", $_SESSION['usuario_id']);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows === 0) {
    echo "<p>🛒 El carrito está vacío</p>";
}

while ($row = $result->fetch_assoc()) {
    echo
    "  
     <div class='item-carrito'>

        <div class='box_primary'> 
               <img src='../imagenes/{$row['imagen']}'  width='80px' height='80px'>
                   <div class='info-producto'> 
                       <span style='font-weight: bold;'>{$row['nombre']}</span>
                       <span style='font-weight: bold;' class='precio-producto' data-precio='{$row['precio']}'> S/ {$row['precio']}</span>
                   </div>
    
        </div>
       

          <div class='acciones-producto'>
            <input type='number' min='1' value='{$row['cantidad']}' class='cantidad-producto' data-id='{$row['producto_id']}'>
            <button class='btn-eliminar-producto' data-id='{$row['producto_id']}'>Eliminar</button>
          </div>

        
    </div>

       
       ";
}



?>


