package es22.pkg2;

import java.util.ArrayList;
import java.util.List;

public class MainRunnable {
    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();

        // Variabile locale (effectively final) catturata dalla classe anonima
        String contextMessage = "Esercizio 22 pkg2 - Classi Anonime con Runnable";

        // Passiamo un'implementazione anonima dell'interfaccia Runnable direttamente come parametro del metodo add()
        tasks.add(new Runnable() {
            @Override
            public void run() { 
                System.out.println("Task 1 eseguito! Contesto: " + contextMessage);
            }
        });

        // Aggiunta di una seconda implementazione anonima di Runnable
        tasks.add(new Runnable() {
            @Override
            public void run() { 
                int sum = 0;
                for (int i = 1; i <= 5; i++) {
                    sum += i;
                }
                System.out.println("Task 2 eseguito! Calcolo somma 1..5 = " + sum);
            }
        });

        // Esecuzione di tutti i task registrati nella lista
        System.out.println("--- Avvio esecuzione dei task Runnable ---");
        for (Runnable task : tasks) {
            task.run();
        }
        System.out.println("--- Tutti i task completati con successo ---");
    }
}
