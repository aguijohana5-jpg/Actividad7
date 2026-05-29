import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(
            String[] args) {

        Scanner teclado =
                new Scanner(System.in);

        ArrayList<Prenda>
                listaPrendas =
                GestorArchivos
                        .leerPrendasArchivo();

        ArrayList<Lote>
                listaLotes =
                new ArrayList<>();

        int opcion;

        do {

            System.out.println(
                    "\n===== SISTEMA ROPA =====");

            System.out.println(
                    "1. Registrar nueva prenda");

            System.out.println(
                    "2. Mostrar prendas");

            System.out.println(
                    "3. Registrar lote");

            System.out.println(
                    "4. Mostrar lotes");

            System.out.println(
                    "5. Salir");

            opcion =
                    teclado.nextInt();

            teclado.nextLine();

            switch(opcion) {

                case 1:

                    try {

                        System.out.println(
                                "Modelo:");

                        String modelo =
                                teclado.nextLine();

                        System.out.println(
                                "Genero:");

                        String genero =
                                teclado.nextLine();

                        System.out.println(
                                "Temporada:");

                        String temporada =
                                teclado.nextLine();

                        System.out.println(
                                "Tela:");

                        String tela =
                                teclado.nextLine();

                        System.out.println(
                                "Costo:");

                        double costo =
                                teclado.nextDouble();

                        Prenda nuevaPrenda =
                                new Prenda(
                                        modelo,
                                        genero,
                                        temporada,
                                        tela,
                                        costo,
                                        1000
                                );

                        listaPrendas
                                .add(nuevaPrenda);

                        GestorArchivos
                                .registrarPrendaArchivo(
                                        nuevaPrenda);

                        System.out.println(
                                "Prenda registrada");

                    } catch(Exception e) {

                        System.out.println(
                                e.getMessage());

                    }

                    break;

                case 2:

                    for(Prenda p :
                            listaPrendas) {

                        System.out.println(p);

                    }

                    break;

                case 3:

                    try {

                        if(listaPrendas
                                .isEmpty()) {

                            System.out.println(
                                    "No hay prendas");

                            break;

                        }

                        System.out.println(
                                "Numero lote:");

                        int numero =
                                teclado.nextInt();

                        System.out.println(
                                "Numero piezas:");

                        int piezas =
                                teclado.nextInt();

                        teclado.nextLine();

                        System.out.println(
                                "Fecha:");

                        String fecha =
                                teclado.nextLine();

                        System.out.println(
                                "\nSeleccione prenda:");

                        for(int i = 0;
                            i < listaPrendas.size();
                            i++) {

                            System.out.println(
                                    i + " - " +

                                            listaPrendas
                                                    .get(i)
                                                    .getModelo());

                        }

                        int indice =
                                teclado.nextInt();

                        Lote loteNuevo =
                                new Lote(
                                        numero,
                                        piezas,
                                        fecha,
                                        listaPrendas
                                                .get(indice)
                                );

                        listaLotes
                                .add(loteNuevo);

                        GestorArchivos
                                .registrarLoteArchivo(
                                        loteNuevo);

                        System.out.println(
                                "Lote registrado");

                    } catch(Exception e) {

                        System.out.println(
                                e.getMessage());

                    }

                    break;

                case 4:

                    for(Lote l :
                            listaLotes) {

                        System.out.println(l);

                        System.out.printf(
                                "Costo total: %.2f\n",
                                l.calcularCostoProduccionLote());

                        System.out.printf(
                                "Monto recuperacion: %.2f\n",
                                l.calcularMontoRecuperacion());

                    }

                    break;

            }

        } while(opcion != 5);

    }

}
