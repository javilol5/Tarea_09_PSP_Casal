package javier.casal;

//import javier.casal.Colors;

public class GestorDescargas {

    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) {

        /* CODIGO MODIFICADO DEL APARTADO 1
        // 1 crear las descargas
        Descarga cuarzos = new Descarga("cuarzos.png");
        Descarga meditacion = new Descarga("meditacion.mp4");
        Descarga mantras = new Descarga("mantras.mp3");
        Descarga horoscopo = new Descarga("horoscopo.pdf");

        // 1 nombre de los hilos
        cuarzos.setName("Descarga-cuarzos.png");
        meditacion.setName("Descarga-meditacion.mp4");
        mantras.setName("Descarga-mantras.mp3");
        horoscopo.setName("Descarga-horoscopo.pdf");
        */

        // 2 archivos por defecto
        String[] archivos;

        if (args.length == 0) {

            archivos = new String[]{
                    "cuarzos.png",
                    "meditacion.mp4",
                    "mantras.mp3",
                    "horoscopo.pdf"
            };
        } else {
            archivos = args;
        }

        // 2 crear las descargas
        Descarga[] descargas = new Descarga[archivos.length];

        for (int i = 0; i < descargas.length; i++) {

            descargas[i] = new Descarga(archivos[i]);

            // 2 nombre de los hilos
            descargas[i].setName("Descarga-" + archivos[i]);
        }

        // 2 crear monitor
        Monitor monitor = new Monitor(descargas);
        Thread hiloMonitor = new Thread(monitor);

        // 1 guardar tiempo de inicio del programa
        long inicio = System.currentTimeMillis();

        /* CODIGO MODIFICADO DEL APARTADO 1
        // 1 arrancar los hilos
        cuarzos.start();
        meditacion.start();
        mantras.start();
        horoscopo.start();

        // 1 esperar a que TODOS terminen
        try {
            cuarzos.join();
            meditacion.join();
            mantras.join();
            horoscopo.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        */

        // 2 arrancar las descargas
        for (int i = 0; i < descargas.length; i++) {
            descargas[i].start();
        }

        // 2 arrancar el monitor
        hiloMonitor.start();

        // 2 esperar a que TODAS terminen
        try {

            for (int i = 0; i < descargas.length; i++) {
                descargas[i].join();
            }

            hiloMonitor.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        // 1 calcular duracion del programa
        long tiempoReal = System.currentTimeMillis() - inicio;

        /* CODIGO MODIFICADO DEL APARTADO 1
        // 1 sumar tiempos
        long tiempoTotal =
                cuarzos.getTiempoTotal()
                        + meditacion.getTiempoTotal()
                        + mantras.getTiempoTotal()
                        + horoscopo.getTiempoTotal();
        */

        // 2 sumar tiempos
        long tiempoTotal = 0;

        for (int i = 0; i < descargas.length; i++) {
            tiempoTotal += descargas[i].getTiempoTotal();
        }

        // 1 resultado final
        System.out.println();
        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo real del programa: " + BLUE + (tiempoReal-1) + "ms " + RED + "±" + BLUE + "1ms" + RESET);
        System.out.println("Tiempo si fueran una detrás de otra: " + BLUE + tiempoTotal + " ms" + RESET);
    }
}

