import java.io.*;
import java.util.ArrayList;

public class GestorArchivos {

    private static final
    String ARCHIVO_PRENDAS =
            "datosPrendas.txt";

    private static final
    String ARCHIVO_LOTES =
            "datosLotes.txt";

    public static void
    registrarPrendaArchivo(
            Prenda prendaActual) {

        try {

            BufferedWriter escritor =
                    new BufferedWriter(
                            new FileWriter(
                                    ARCHIVO_PRENDAS,
                                    true));

            escritor.write(

                    prendaActual.getModelo()
                            + "," +

                            prendaActual.getGenero()
                            + "," +

                            prendaActual.getTemporada()
                            + "," +

                            prendaActual.getTela()
                            + "," +

                            prendaActual
                                    .getCostoProduccion()

            );

            escritor.newLine();

            escritor.close();

        } catch(IOException e) {

            System.out.println(
                    "Error al guardar prenda");

        }

    }

    public static
    ArrayList<Prenda>
    leerPrendasArchivo() {

        ArrayList<Prenda>
                listaPrendas =
                new ArrayList<>();

        try {

            BufferedReader lector =
                    new BufferedReader(
                            new FileReader(
                                    ARCHIVO_PRENDAS));

            String linea;

            while((linea =
                    lector.readLine())
                    != null) {

                String datos[] =
                        linea.split(",");

                String modelo =
                        datos[0];

                String genero =
                        datos[1];

                String temporada =
                        datos[2];

                String tela =
                        datos[3];

                double costo =
                        Double.parseDouble(
                                datos[4]);

                Prenda prendaNueva =
                        new Prenda(
                                modelo,
                                genero,
                                temporada,
                                tela,
                                costo,
                                1000
                        );

                listaPrendas
                        .add(prendaNueva);

            }

            lector.close();

        } catch(Exception e) {

            System.out.println(
                    "No existen prendas registradas");

        }

        return listaPrendas;

    }

    public static void
    registrarLoteArchivo(
            Lote loteActual) {

        try {

            BufferedWriter escritor =
                    new BufferedWriter(
                            new FileWriter(
                                    ARCHIVO_LOTES,
                                    true));

            escritor.write(

                    loteActual
                            .getNumeroLote()
                            + "," +

                            loteActual
                                    .getNumeroPiezas()
                            + "," +

                            loteActual
                                    .getFechaFabricacion()
                            + "," +

                            loteActual
                                    .getPrenda()
                                    .getModelo()

            );

            escritor.newLine();

            escritor.close();

        } catch(IOException e) {

            System.out.println(
                    "Error al guardar lote");

        }

    }

}