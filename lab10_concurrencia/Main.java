package Personaje;

public class Main {
    private static ContadorCompartido contador = new ContadorCompartido();

    public static void main(String[] args) throws InterruptedException{
        
//Bloque 1 — Torneo con 3 combates simultáneos:
    TablaResultados tabla = new TablaResultados();

    Personajes s1 = new Druida("Sylva",10, 300, true, 100, 20, "Lobo");
    Personajes m1 = new Nigromante("Malachar", 8, 150, true, 120, 25, "Sombras");
    Personajes l1 = new Arquero("Legolas", 6, 200, true, 10, 95, 50);
    Personajes t1 = new Guerrero("Thorin", 9, 400, true, 80, "Diamante");
    Personajes b1 = new Druida("Brego", 7, 250, true, 80, 60, "Oso");
    Personajes k1 = new Nigromante("Kael", 5, 180, true, 90, 10, "Vacio");

    // Crear los Runnable
    CombateConcurrente c1 = new CombateConcurrente("Campo-1", s1, m1, tabla);
    CombateConcurrente c2 = new CombateConcurrente("Campo-2", l1, t1, tabla);
    CombateConcurrente c3 = new CombateConcurrente("Campo-3", b1, k1, tabla);

    // Envolver en Thread e iniciar
    Thread h1 = new Thread(c1);
    Thread h2 = new Thread(c2);
    Thread h3 = new Thread(c3);

    h1.start();
    h2.start();
    h3.start();

//Bloque 2 — Monitor del torneo (hilo independiente):
    MonitorTorneo monitor = new MonitorTorneo("Torneo Principal", 3);
    monitor.start();

//Bloque 3 — Esperar a que todos terminen con join():
    try {
        h1.join();   // espera a que Campo-1 termine
        h2.join();   // espera a que Campo-2 termine
        h3.join();   // espera a que Campo-3 termine
        monitor.join();
    } catch (InterruptedException e) {
        System.out.println("Espera interrumpida.");
    }

    System.out.println("\nTodos los combates han terminado.");
    tabla.mostrarResultados();
    
//Tarea - //Bloque 4 — Demostración de race condition: 
        // Sin synchronized — resultado incorrecto
        Thread[] hilos = new Thread[5];
        for (int i = 0; i < 5; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) contador.incrementar();
            });
            hilos[i].start();
        }
        for (Thread t : hilos) t.join();
        System.out.println("Sin sync  - esperado: 5000 | real: " +
                        contador.getContador());

        // Con synchronized — resultado correcto
        contador.resetear();
        for (int i = 0; i < 5; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) contador.incrementarSeguro();
            });
            hilos[i].start();
        }
        for (Thread t : hilos) t.join();
        System.out.println("Con sync  - esperado: 5000 | real: " +
                        contador.getContador());
            }
}
