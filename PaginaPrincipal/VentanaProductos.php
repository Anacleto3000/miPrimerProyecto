<?php
session_start();

?>


<?php

// Identico a driverManager.GetConnection( )

$conn = new mysqli("localhost", "root", "", "miprimerproyecto");


if ($conn->connect_error) {
    die("Error de conexión: " . $conn->connect_error);
}



// SOLO 2 ANUNCIOS ACTIVOS POR TENER LIMIT 2

$sql = "SELECT imagen FROM anuncios WHERE activo = 1 LIMIT 2";

//Identico a executeQuery(SqlText) devolviendo un resultset como en java (jdbc)
$result_anuncios = $conn->query($sql);


$sql_promociones = "SELECT imagen FROM promociones WHERE activo = 1 LIMIT 6";
$result_promociones = $conn->query($sql_promociones);

$sql_productos = "SELECT * FROM productos LIMIT 4";
$result_productos = $conn->query($sql_productos);



$sql_categotias = "SELECT * FROM categorias";
$result_categorias = $conn->query($sql_categotias);

$sql_productos_tecno = "SELECT * FROM productos WHERE categoria_id = 7 LIMIT 5";
$result_productos_tecno = $conn->query($sql_productos_tecno);




$sql_ofertas = "SELECT * FROM ofertas";
$result_ofertas = $conn->query($sql_ofertas);



?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos</title>
    <link rel="stylesheet" href="VentanaProductos.css">
    <link rel="stylesheet" href="../carrito/VerCarrito.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Krona+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=AR+One+Sans:wght@400;500;700&display=swap" rel="stylesheet">


    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
    <div id="overlay"></div>

    <header>
        <img src="../iconos/image 2.png" alt="" width="150" height="100">
        <nav id="buttons_header">

            <div id="Barra_busqueda">

                <form action="../ResultadoProductos.php" method="GET">
                    <input type="text" name="busqueda" placeholder="Buscar productos...">

                    <button id="Button_buscar" type="submit">
                        <img src="../iconos/image 21.png" alt="">
                    </button>
                </form>



            </div>
            <div id="Box_Button_Otros">

                <?php
                if (isset($_SESSION["usuario_id"])) {
                ?>
                    <a href="../PerfilCliente.php" style="text-decoration: none;"><span style="background-color: white;color:black;padding: 10px;border-radius: 10px;">Hola &nbsp;<?php echo $_SESSION["usuario_name"] ?></span></a>

                    <a href="../LogoutCliente.php" style="text-decoration: none;"><span>Cerrar Sesión</span></a>

                    <div id="Box_Button_carrito">
                        <img src="../iconos/image 20.png" alt="">
                        <span id="btn-Carrito">Carrito</span>
                    </div>

                <?php
                } else {
                ?>
                    <a href="../account/LoginCliente.php"><span id="button_iniciar_sesion">Iniciar sesión</span></a>
                    <a href="../account/RegistroCliente.php"><span id="button_registrate">Regístrate</span></a>

                <?php
                }

                ?>



            </div>
        </nav>
    </header>

    <main>

        <div id="Box_Principal_Anuncios">

            <?php if ($result_anuncios->num_rows > 0): ?>
                <?php while ($row = $result_anuncios->fetch_assoc()): ?>
                    <div class="anuncio">
                        <img src="../imagenes/<?= $row['imagen'] ?>" alt="Anuncio">
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
                            <img src="../imagenes/<?= $row_promociones['imagen'] ?>" class="d-block w-100" alt="Promoción">
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
                        <a href="../DetallesProducto.php?id=<?= $prod['id'] ?>" class="producto-link">
                            <div class="imagen_producto">
                                <img src="../imagenes/<?= $prod['imagen'] ?>" alt="<?= $prod['nombre'] ?>">
                            </div>

                            <h2><?= $prod['nombre'] ?></h2>
                            <p><strong>Precio:</strong> S/ <?= $prod['precio'] ?></p>
                        </a>

                        <button class="btn-agregar-carrito" data-id="<?= $prod['id'] ?>">Agregar al carrito</button>

                    </div>






                <?php endwhile; ?>
            </div>





        </div>


        <div id="Box_Principal_Categorias">
            <div id="Contenedor_Categorias">
                <?php while ($cat = $result_categorias->fetch_assoc()): ?>
                    <div class="tarjeta_categoria">
                        <div id="imagen_and_text">
                            <img src="../imagenes/<?= $cat['imagen'] ?>" alt="<?= $cat['nombre'] ?>">
                            <h4><?= $cat['nombre'] ?></h4>
                        </div>

                    </div>
                <?php endwhile; ?>
            </div>

        </div>


        <div id="Box_Principal_Ofertas">
            <div id="Contenedor_Ofertas">
                <?php while ($ofe = $result_ofertas->fetch_assoc()): ?>
                    <div class="tarjeta_oferta">
                        <img src="../imagenes/<?= $ofe['imagen'] ?>" alt="<?= $ofe['nombre'] ?>">
                    </div>
                <?php endwhile; ?>
            </div>

        </div>

        <div id="contenedor_tecnologia">
            <h3>Productos de Tecnología</h3>
            <div id="productos_tecnologia">
                <?php while ($prod_tecno = $result_productos_tecno->fetch_assoc()): ?>

                    <div class="tarjeta_producto_tecno">

                        <div class="imagen_producto_tecno">
                            <img src="../imagenes/<?= $prod_tecno['imagen'] ?>" alt="<?= $prod_tecno['nombre'] ?>">
                        </div>

                        <h4><?= $prod_tecno['nombre'] ?></h4>

                        <p><strong>Precio:</strong> S/ <?= $prod_tecno['precio'] ?></p>
                        <button class="btn-agregar-carrito" data-id="<?= $prod_tecno['id'] ?>">Agregar al carrito</button>


                    </div>

                <?php endwhile; ?>



            </div>
        </div>




        <div id="box_principal_finalOption">
            <div id="title">
                <p>Conoce mas de Jeap</p>
            </div>

            <div id="container_opciones">


                <div class="box_option">
                    <img src="../iconos/icono pregunta.png" alt="">
                    <p>Preguntas frecuentes</p>
                </div>

                <div class="box_option">
                    <img src="../iconos/icono de tienda.png" alt="">
                    <p>Nuestras tiendas</p>
                </div>

                <div class="box_option">
                    <img src="../iconos/icono libro.png" alt="">
                    <p>Libro de reclamaciones</p>
                </div>


            </div>
        </div>


        <footer class="footer-seguro">
            <div class="footer-contenedor">
                <div class="footer-columna">
                    <h3>Enlaces</h3>
                    <a href="#">Inicio</a>
                    <a href="#">Productos</a>
                    <a href="#">Contacto</a>
                </div>

                <div class="footer-columna">
                    <h3>Nosotros</h3>
                    <a href="../Presentacion/index.html">Quienes somos</a>
                    <a href="#">Misión</a>
                    <a href="#">Visión</a>
                </div>

                <div class="footer-columna">
                    <h3>Síguenos</h3>
                    <div class="footer-redes">
                        <a href="#"><img src="../iconos/facebook.png" alt=""></a>
                        <a href="#"><img src="../iconos/instagram.png" alt=""></a>
                        <a href="#"><img src="../iconos/twitter.png" alt=""></a>
                    </div>
                </div>
            </div>

            <p class="footer-copy">© 2024 Jeap - Todos los derechos reservados</p>
        </footer>






    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../JavaScript/carrito.js"></script>

</body>

</html>