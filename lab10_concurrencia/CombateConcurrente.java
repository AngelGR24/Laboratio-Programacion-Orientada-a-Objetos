package Personaje;

public class CombateConcurrente implements Runnable {
    private String           nombre;
    private Personajes        atacante;
    private Personajes        defensor;
    private TablaResultados  resultados;

    public CombateConcurrente(String nombre,
                               Personajes atacante,
                               Personajes defensor,
                               TablaResultados resultados) {
        this.nombre     = nombre;
        this.atacante   = atacante;
        this.defensor   = defensor;
        this.resultados = resultados;
    }

    @Override
    public void run() {
        System.out.println("[" + nombre + "] INICIO - " +
                           atacante.getNombre() + " vs " +
                           defensor.getNombre());

        int ronda = 1;

        while (atacante.isEstaVivo() && defensor.isEstaVivo()) {

            System.out.println("[" + nombre + "] Ronda " + ronda);

            try {
                // Simula que el combate tarda un tiempo
                Thread.sleep(500);

                atacante.atacar();
                int danio = atacante.calcularDanio();
                defensor.recibirDanio(danio);

            } catch (RpgException e) {
                System.out.println("[" + nombre + "] " + e.getMessage());
                break;

            } catch (InterruptedException e) {
                System.out.println("[" + nombre + "] Combate interrumpido.");
                Thread.currentThread().interrupt();
                break;
            }

            ronda++;
        }

        // Determinar ganador y registrar en la tabla compartida
        String ganador = atacante.isEstaVivo()
                       ? atacante.getNombre()
                       : defensor.getNombre();

        String registro = nombre + " - Ganador: " + ganador +
                          " (rondas: " + ronda + ")";

        resultados.registrar(registro);

        System.out.println("[" + nombre + "] FIN - " + ganador + " gana.");
    }
}
