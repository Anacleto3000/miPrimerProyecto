<?php
// Conexión a la base de datos
$conn = new mysqli("localhost", "root", "", "miprimerproyecto");

if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}

$result = $conn->query("SELECT * FROM productos");
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de productos</title>
    <link rel="stylesheet" href="Lista de productos.css">
</head>

<body>

    <h1>Lista de productos</h1>

    <div id="contenedor_principal">

        <?php while ($prod = $result->fetch_assoc()): ?>

            <div class="tarjeta_producto">

                <div class="imagen_producto">
                    <img src="imagenes/<?= $prod['imagen'] ?>" alt="<?= $prod['nombre'] ?>">
                </div>

                <h2><?= $prod['nombre'] ?></h2>
                <p><?= $prod['descripcion'] ?></p>
                <p><strong>Precio:</strong> S/ <?= $prod['precio'] ?></p>
                <p><strong>Stock:</strong> <?= $prod['stock'] ?></p>
                <p><strong>Categoría:</strong> <?= $prod['categoria_id'] ?></p>

            </div>


        <?php endwhile; ?>

    </div>

</body>

</html>

<?php $conn->close(); ?>