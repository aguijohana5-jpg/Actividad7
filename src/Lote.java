public class Lote {

        private int numeroLote;

        private int numeroPiezas;

        private String fechaFabricacion;

        private Prenda prenda;

        public Lote(int numeroLote,
                    int numeroPiezas,
                    String fechaFabricacion,
                    Prenda prenda)
                throws
                PiezasInvalidasException {

            if(numeroPiezas < 50
                    || numeroPiezas > 350) {

                throw new
                        PiezasInvalidasException(
                        "Cantidad invalida de piezas");

            }

            this.numeroLote =
                    numeroLote;

            this.numeroPiezas =
                    numeroPiezas;

            this.fechaFabricacion =
                    fechaFabricacion;

            this.prenda = prenda;

        }

        public int getNumeroLote() {
            return numeroLote;
        }

        public int getNumeroPiezas() {
            return numeroPiezas;
        }

        public String
        getFechaFabricacion() {

            return fechaFabricacion;

        }

        public Prenda getPrenda() {
            return prenda;
        }

        public double
        calcularCostoProduccionLote() {

            return numeroPiezas *
                    prenda
                            .getCostoProduccion();

        }

        public double
        calcularMontoRecuperacion() {

            double precioVenta =
                    prenda
                            .getCostoProduccion()
                            * 1.05;

            return precioVenta *
                    numeroPiezas;

        }

        @Override
        public String toString() {

            return "\n===== LOTE =====" +

                    "\nNumero lote: " +
                    numeroLote +

                    "\nNumero piezas: " +
                    numeroPiezas +

                    "\nFecha fabricacion: " +
                    fechaFabricacion +

                    "\nPrenda asociada: " +
                    prenda.getModelo();

        }

    }
}
