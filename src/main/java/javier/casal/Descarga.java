package javier.casal;

import java.util.Random;

public class Descarga extends Thread {

    private String nombreArchivo;
    private int tiempoBloque;
    private long tiempoTotal;

    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    Random random = new Random();

    public Descarga(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;


        this.tiempoBloque = random.nextInt(400) + 100; // 100-500 ms
    }

    @Override
    public void run() {
        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(random.nextInt(800)+200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            int porcentaje = i * 10;
            System.out.println(RED + "[" + nombreArchivo + "] " + RESET + porcentaje + "%");
        }

        tiempoTotal = System.currentTimeMillis() - inicio;

        System.out.println(GREEN +  "[" + nombreArchivo + "]" + RESET + "completada en " + BLUE + tiempoTotal + " ms" + RESET);
    }

    public long getTiempoTotal() {
        return tiempoTotal;
    }
}
