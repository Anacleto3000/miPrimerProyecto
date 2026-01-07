package Logica;

public class Herramientas{
    public enum TipoValidacion {
        SOLO_LETRAS,
        SOLO_NUMEROS,
        LETRAS_NUMEROS,
        DECIMAL,
        TEXTO_LIBRE,
        FECHA
    }




    public static boolean ValidarEntradas(String texto, TipoValidacion tipo) {

        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }

        texto = texto.trim();

        switch (tipo) {

            case SOLO_LETRAS:
                return texto.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$");

            case SOLO_NUMEROS:
                return texto.matches("^[0-9]+$");

            case LETRAS_NUMEROS:
                return texto.matches("^[A-Za-z0-9ÁÉÍÓÚáéíóúñÑ ]+$");

            case DECIMAL:
                return texto.matches("^[0-9]+(\\.[0-9]{1,2})?$");

            case TEXTO_LIBRE:
                return true;



            case FECHA:
                try {
                    java.time.LocalDate.parse(texto);
                    return true;
                } catch (Exception e) {
                    return false;
                }

            default:
                return false;
        }
    }






}
