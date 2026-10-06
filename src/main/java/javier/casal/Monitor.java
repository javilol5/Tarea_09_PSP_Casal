package javier.casal;

public class Monitor implements Runnable {

    private Descarga[] descargas;

    public static final String RESET = "\u001B[0m";
    public static final String ORANGE = "\u001B[33m";

    public Monitor(Descarga[] descargas) {
        this.descargas = descargas;
    }

    @Override
    public void run() {

        int enCurso;

        do {

            enCurso = 0;

            for (int i = 0; i < descargas.length; i++) {

                if (descargas[i].isAlive()) {
                    enCurso++;
                }
            }

            if (enCurso > 0) {

                System.out.println( ORANGE + "[Monitor]" + RESET + " Descargas en curso: " + enCurso);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

        } while (enCurso > 0);

        System.out.println( ORANGE + "[Monitor]" + RESET + "  No queda ninguna descarga en curso");
    }
}