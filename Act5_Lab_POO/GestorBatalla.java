package Personaje;

import java.util.ArrayList;

public class GestorBatalla {

    ArrayList<String> Historial = new ArrayList<>();

    public void ejecutar_ataque(Personajes atacante){
        int danio = atacante.calcularDanio();
        atacante.atacar();
        System.out.println(atacante.getNombre() + " ataca causando " + danio + " de daño. \n");
        Historial.add(atacante.getNombre() + " ataca causando " + danio + " de daño.");
    }

    public void ejecutar_ataque(Personajes atacante, Personajes defensor){
        int danio = atacante.calcularDanio();
        atacante.atacar();
        defensor.recibirDanio(danio);
        defensor.defender();
        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " causando " + danio + " de daño.\n");
        Historial.add(atacante.getNombre() + " ataca a " + defensor.getNombre() + " causando " + danio + " de daño.");
    }

    public void ejecutar_ataque(Personajes[] atacantes){
        for (Personajes atacante : atacantes) {
            ejecutar_ataque(atacante);
        }
    }

    public void mostrar_historial() {
        for (String evento : Historial) {
            System.out.println(evento);
        }
    }

    public void limpiar_historial() {
        Historial.clear();
    }
}
