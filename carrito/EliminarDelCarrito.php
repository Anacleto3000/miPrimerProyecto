<?php  
session_start();

$conn = new mysqli("localhost", "root", "", "miprimerproyecto");

if (!isset($_POST['producto_id'])) {
    echo "Producto inválido";
    exit;
}

$producto_id = $_POST['producto_id'];
$usuario_id = $_SESSION['usuario_id'];

$sql = "DELETE dc
FROM detalle_carrito dc
JOIN carrito c ON dc.carrito_id = c.id
WHERE c.usuario_id = ? AND dc.producto_id = ?";

$stmt = $conn->prepare($sql);
$stmt->bind_param("ii", $usuario_id, $producto_id);
$stmt->execute();

if ($stmt->affected_rows > 0) {
    echo "Producto eliminado del carrito";
} else {
    echo "No se pudo eliminar el producto";
}