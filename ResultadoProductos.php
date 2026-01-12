<?php
$conn = new mysqli("localhost", "root", "", "miprimerproyecto");

$busqueda = $_GET['busqueda'] ?? '';

$sql = "SELECT * FROM productos WHERE nombre LIKE ?";
$stmt = $conn->prepare($sql);

$param = "%" . $busqueda . "%";
$stmt->bind_param("s", $param);
$stmt->execute();

$result = $stmt->get_result();

?>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="ResultadoProductos.css">


    <link href="https://fonts.googleapis.com/css2?family=Krona+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=AR+One+Sans:wght@400;500;700&display=swap" rel="stylesheet">

</head>

<body>


    <header>
        <img src="iconos/image 2.png" alt="" width="150" height="100">
        <nav id="buttons_header">
            <div id="Box_Button_Inicio"><span>Inicio</span></div>
            <div id="Barra_busqueda">


                <input type="text" placeholder="Buscar productos...">

                <button id="Button_buscar" type="submit">
                    <img src="iconos/image 21.png" alt="">
                </button>


            </div>
            <div id="Box_Button_Otros">
                <span>Iniciar sesión</span>
                <span>Regístrate</span>
                <div id="Box_Button_carrito">
                    <img src="iconos/image 20.png" alt="">
                    <span>Carrito</span>
                </div>
            </div>
        </nav>
    </header>

    <main>
        <div id="box_principal">
            <div id="Menu">
                <div>
                    <div id="container_titulo">
                        <h3>Filtrar productos</h3>
                    </div>
                    <div id="container_opciones">

                        <p>Ordenar Por :</p>
                        <p>Marca :</p>

                    </div>

                </div>

            </div>

            <div id="resultado_productos">
                <div id="contenedor_productos">



                    <?php while ($prod = $result->fetch_assoc()): ?>

                        <div class="producto">

                            <div class="img_producto">
                                <img
                                    src="imagenes/<?= htmlspecialchars($prod['imagen']) ?>"
                                    alt="<?= htmlspecialchars($prod['nombre']) ?>">
                            </div>

                            <strong><?= htmlspecialchars($prod['nombre']) ?></strong><br>
                            <span>S/ <?= htmlspecialchars($prod['precio']) ?></span>

                        </div>




                    <?php endwhile; ?>

                </div>

            </div>
        </div>
    </main>

    <script src="buscador.js"></script>
</body>


</html>