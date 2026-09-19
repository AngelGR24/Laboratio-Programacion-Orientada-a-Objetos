/*
 * 1) Diferencia entre una excepción chequeada y una no chequeada
 * Las chequeadas heredan de Exception y el compilador obliga a manejarlas con try/catch o declararlas con throws.
 * Las no chequeadas heredan de RuntimeException. No es obligatorio capturarlas ni declararlas en la firma del método.
 *
 * ¿Por qué PersonajeNuloException no extiende Exception?
 * Porque un personaje nulo indica un error de programación de quien llama la funcion: se pasó un valor inválido por mala lógica, no un caso esperable del juego.
 * Es un problema de programación y no un “error del juego” que el programa deba manejar de forma forzada en cada llamada.
 *
 * 2) ¿Para qué sirve finally?
 * El bloque finally se ejecuta siempre, haya o no excepción.
 * Es indispensable para cerrar conexiones, streams o archivos antes de salir del método.
 *
 * 3) Diferencia entre throw y throws
 * - throw se usa dentro del método para lanzar una excepción en ese punto exacto.
 * - throws se usa en la firma del método para avisar que ese método puede lanzar una excepción chequeada y que quien lo llame debe manejarla o re-lanzarla.
 */
package Personaje;

public class Main {
    public static void main(String[] args) throws RpgException {
        Druida druida = new Druida("Druida", 5, 100, true, 60, 20, "Oso");
        Nigromante nigromante = new Nigromante("Nigromante", 7, 120, true, 20,25, "Maldición de la Muerte");
        
        //Escenario 1. Turno normal sin excepcion.
        System.out.println("\n--- Turno: druida vs nigromante ---");
        MotorCombate motor = new MotorCombate();
        motor.ejecutarTurno(druida, nigromante);

        //Escenario 2 — Personaje derrotado intenta atacar
        System.out.println("\n--- Turno: druida vs nigromante ---");
        druida.recibirDanio(9999);   // primero derrota al druida
        motor.ejecutarTurno(druida, nigromante);
    
        Druida druida2 = new Druida("Druida", 5, 100, true, 60, 20, "Oso");
        //Creamos nuevo druida para suplir al que murio

        //Escenario 3 — Arquero sin flechas
        System.out.println("\n--- Turno: Legolas vs nigromante ---");
        Arquero sinFlechas = new Arquero("Legolas", 6, 150, true, 10, 0, 95);
        motor.ejecutarTurno(sinFlechas, nigromante);
    
        //Escenario 4  — Curar aliado derrotado
        System.out.println("\n-- Intento de curar aliado derrotado --");
        try {
            druida2.curarAliado(druida);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        //Escenario 5 — Daño negativo con finally
        System.out.println("\n-- Bloque manual try-catch-finally --");
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        //Escenario 6 — Mostrar bitácora completa
        //System.out.println("")
        motor.mostrarBitacora();
    }
}
