package javier.casal;

//import javier.casal.Colors;

public class GestorDescargas {

    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) {

        // crear las descargas
        Descarga cuarzos = new Descarga("cuarzos.png");
        Descarga meditacion = new Descarga("meditacion.mp4");
        Descarga mantras = new Descarga("mantras.mp3");
        Descarga horoscopo = new Descarga("horoscopo.pdf");

        // nombre de los hilos
        cuarzos.setName("Descarga-cuarzos.png");
        meditacion.setName("Descarga-meditacion.mp4");
        mantras.setName("Descarga-mantras.mp3");
        horoscopo.setName("Descarga-horoscopo.pdf");

        // guardar tiempo de inicio del programa
        long inicio = System.currentTimeMillis();

        // arrancar los hilos
        cuarzos.start();
        meditacion.start();
        mantras.start();
        horoscopo.start();

        // esperar a que TODOS terminen
        try {
            cuarzos.join();
            meditacion.join();
            mantras.join();
            horoscopo.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        // calcular duracion del programa
        long tiempoReal = System.currentTimeMillis() - inicio;

        // sumar tiempos
        long tiempoTotal =
                cuarzos.getTiempoTotal()
                        + meditacion.getTiempoTotal()
                        + mantras.getTiempoTotal()
                        + horoscopo.getTiempoTotal();

        // resultado final
        System.out.println();
        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo real del programa: " + BLUE + (tiempoReal-1) + "ms " + RED + "±" + BLUE + "1ms" + RESET);
        System.out.println("Tiempo si fueran una detrás de otra: " + BLUE + tiempoTotal + " ms" + RESET);
    }
}

