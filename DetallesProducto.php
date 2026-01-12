<?php
if (!isset($_GET['id'])) {
    die("Producto no encontrado");
}

$id = $_GET['id'];


$conn = new mysqli("localhost", "root", "", "miprimerproyecto");

$stmt = $conn->prepare("SELECT * FROM productos WHERE id = ?");
$stmt->bind_param("i", $id);
$stmt->execute();

$result = $stmt->get_result();
$producto = $result->fetch_assoc();

if (!$producto) {
    die("Producto no existe");
}



?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="DetallesProducto.css">



    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Krona+One&display=swap" rel="stylesheet">



    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=AR+One+Sans:wght@400;500;700&display=swap" rel="stylesheet">
</head>

<body>
    <header>
        <img src="iconos/ChatGPT Image 8 dic 2025, 11_54_12.png" alt="" width="150px" height="100px">
        <nav id="buttons_header">
            <span>inicio</span>
            <span>producto</span>
            <span>contacto</span>
        </nav>
    </header>

    <main>
        <div id="container_principal">
            <div id="container_secundario">

                <div id="imagen_producto">
                    <img src="imagenes/<?= $producto['imagen'] ?>">
                </div>

                <div id="Textbox_producto">
                    <div id="title_producto">
                        <p><?= $producto['nombre'] ?></p>

                    </div>

                    <div id="info_precio">
                        <p> S/ <?= $producto['precio'] ?></p>
                    </div>

                    <div id="container_button">
                        <button id="button_Agregar_carrito" type="submit">Agregar al carrito</button>
                    </div>


                </div>



            </div>

            <div id="Info_producto">
                <div id="especificaciones">

                </div>
                <div id="descripcion_producto">
                    <p><?= $producto['descripcion'] ?></p>
                </div>

            </div>


        </div>







    </main>


</body>

</html>