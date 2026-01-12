<?php

session_start();


$conn = new mysqli("localhost", "root", "", "miprimerproyecto");

if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

if (!isset($_SESSION['usuario_id'])) {
    echo "Debes iniciar sesión";
    exit;
}

if (!isset($_POST['producto_id'])) {
    echo "Producto inválido";
    exit;
}

$usuario_id  = $_SESSION['usuario_id'];
$producto_id = $_POST['producto_id'];


// 1️⃣ Verificar si el carrito existe
$sql = "SELECT id FROM carrito WHERE usuario_id = $usuario_id";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    $carrito_id = $row['id'];
} else {
    // 2️⃣ Crear carrito
    $conn->query("INSERT INTO carrito (usuario_id) VALUES ($usuario_id)");
    $carrito_id = $conn->insert_id;
}

// 3️⃣ Verificar si el producto ya está en el carrito
$sql = "SELECT id, cantidad FROM detalle_carrito 
        WHERE carrito_id = $carrito_id AND producto_id = $producto_id";

$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "El producto ya está en el carrito";
}
else {
    // 5️⃣ Insertar producto
    $conn->query(
        "INSERT INTO detalle_carrito (carrito_id, producto_id, cantidad)
         VALUES ($carrito_id, $producto_id, 1)"
         
    );
    echo "Producto agregado al carrito";
}


