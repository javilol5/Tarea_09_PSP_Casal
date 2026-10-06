package javier.casal;

public class Instalador implements Runnable {

    private Descarga meditacion;
    private Descarga mantras;

    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";

    public Instalador(Descarga meditacion, Descarga mantras) {
        this.meditacion = meditacion;
        this.mantras = mantras;
    }

    @Override
    public void run() {

        try {
            meditacion.join();
            mantras.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println(CYAN + "[Instalador]" + RESET + " Meditación y mantras listos: instalando...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println(CYAN + "[Instalador]" + RESET + " Instalación terminada");
    }
}