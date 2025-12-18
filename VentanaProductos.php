<?php
$conn = new mysqli("localhost", "root", "", "miprimerproyecto");

if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}



// SOLO 2 ANUNCIOS ACTIVOS
$sql = "SELECT imagen FROM anuncios WHERE activo = 1 LIMIT 2";
$result_anuncios = $conn->query($sql);


$sql_promociones = "SELECT imagen FROM promociones WHERE activo = 1 LIMIT 6";
$result_promociones = $conn->query($sql_promociones);

$sql_productos = "SELECT * FROM productos";
$result_productos = $conn->query($sql_productos);


$sql_categotias = "SELECT * FROM categorias";
$result_categorias = $conn->query($sql_categotias);

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos</title>
    <link rel="stylesheet" href="VentanaProductos.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Krona+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=AR+One+Sans:wght@400;500;700&display=swap" rel="stylesheet">


    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

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

        <div id="Box_Principal_Anuncios">

            <?php if ($result_anuncios->num_rows > 0): ?>
                <?php while ($row = $result_anuncios->fetch_assoc()): ?>
                    <div class="anuncio">
                        <img src="imagenes/<?= $row['imagen'] ?>" alt="Anuncio">
                    </div>
                <?php endwhile; ?>
            <?php else: ?>
                <p>No hay anuncios activos</p>
            <?php endif; ?>

        </div>

        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">

            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"></button>
            </div>

            <div class="carousel-inner">

                <?php
                $activeClass = "active";
                if ($result_promociones->num_rows > 0):
                    while ($row_promociones = $result_promociones->fetch_assoc()):
                ?>
                        <div class="carousel-item <?= $activeClass ?>">
                            <img src="imagenes/<?= $row_promociones['imagen'] ?>" class="d-block w-100" alt="Promoción">
                        </div>
                    <?php
                        $activeClass = ""; // Solo la primera debe tener la clase active
                    endwhile;
                else:
                    ?>
                    <p>No hay promociones activas</p>
                <?php endif; ?>
            </div>

            <!-- BOTÓN PREVIOUS -->
            <button class="carousel-control-prev" type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon"></span>
                <span class="visually-hidden">Previous</span>
            </button>

            <!-- BOTÓN NEXT -->
            <button class="carousel-control-next" type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next">
                <span class="carousel-control-next-icon"></span>
                <span class="visually-hidden">Next</span>
            </button>

        </div>

        <div id="box_principal_productos">
            <div id="titulo_productos">
                <h3>Productos destacados</h3>
            </div>

            <div id="Contenedor_productos">
                <?php while ($prod = $result_productos->fetch_assoc()): ?>

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





        </div>


        <div id="Box_Principal_Categorias">
            <div id="Contenedor_Categorias">
                <?php while ($cat = $result_categorias->fetch_assoc()): ?>
                    <div class="tarjeta_categoria">
                        <div id="imagen_and_text">
                            <img src="imagenes/<?= $cat['imagen'] ?>" alt="<?= $cat['nombre'] ?>">
                            <h4><?= $cat['nombre'] ?></h4>
                        </div>

                    </div>
                <?php endwhile; ?>
            </div>

        </div>


    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>