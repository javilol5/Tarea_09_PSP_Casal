package javier.casal;

//import javier.casal.Colors;

public class GestorDescargas {

    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";

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

        // 3 buscar meditacion.mp4 y mantras.mp3
        Descarga meditacion = null;
        Descarga mantras = null;

        for (int i = 0; i < descargas.length; i++) {

            if (archivos[i].equals("meditacion.mp4")) {
                meditacion = descargas[i];
            }

            if (archivos[i].equals("mantras.mp3")) {
                mantras = descargas[i];
            }
        }

        // 2 crear monitor
        Monitor monitor = new Monitor(descargas);
        Thread hiloMonitor = new Thread(monitor);

        // 3 crear instalador
        Instalador instalador = null;
        Thread hiloInstalador = null;

        if (meditacion != null && mantras != null) {

            instalador = new Instalador(meditacion, mantras);
            hiloInstalador = new Thread(instalador);
        }

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

        // 3 arrancar el instalador
        if (hiloInstalador != null) {
            hiloInstalador.start();
        }

        // 3 esperar maximo 3 segundos
        if (meditacion != null) {

            try {
                meditacion.join(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            if (meditacion.isAlive()) {
                System.out.println(CYAN + "[Main] " + RESET + "meditacion.mp4 sigue en segundo plano");
            }
        }

        // 2 esperar a que TODAS terminen
        try {

            for (int i = 0; i < descargas.length; i++) {
                descargas[i].join();
            }

            // esperar al monitor
            hiloMonitor.join();

            // esperar al instalador
            if (hiloInstalador != null) {
                hiloInstalador.join();
            }

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

