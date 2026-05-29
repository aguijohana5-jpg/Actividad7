public class Prenda {

        private String modelo;
        private String genero;
        private String temporada;
        private String tela;

        private double costoProduccion;

        private double limiteCosto;

        public Prenda(String modelo,
                      String genero,
                      String temporada,
                      String tela,
                      double costoProduccion,
                      double limiteCosto)
                throws
                CostoExcedidoException {

            if(costoProduccion >
                    limiteCosto) {

                throw new
                        CostoExcedidoException(
                        "El costo supera el limite permitido");

            }

            this.modelo = modelo;
            this.genero = genero;
            this.temporada = temporada;
            this.tela = tela;

            this.costoProduccion =
                    costoProduccion;

            this.limiteCosto =
                    limiteCosto;

        }

        public String getModelo() {
            return modelo;
        }

        public String getGenero() {
            return genero;
        }

        public String getTemporada() {
            return temporada;
        }

        public String getTela() {
            return tela;
        }

        public double
        getCostoProduccion() {

            return costoProduccion;

        }

        public double
        calcularPrecioVentaPieza() {

            return costoProduccion
                    * 1.15;

        }

        public void mostrarResumen() {

            System.out.println(
                    "\n===== PRENDA =====");

            System.out.println(
                    "Modelo: " + modelo);

            System.out.println(
                    "Genero: " + genero);

            System.out.println(
                    "Temporada: " +
                            temporada);

            System.out.println(
                    "Precio venta: " +
                            calcularPrecioVentaPieza());

        }

        @Override
        public String toString() {

            return "\nModelo: " +
                    modelo +

                    "\nGenero: " +
                    genero +

                    "\nTemporada: " +
                    temporada +

                    "\nTela: " +
                    tela +

                    "\nCosto produccion: " +
                    costoProduccion;

        }

    }
}
