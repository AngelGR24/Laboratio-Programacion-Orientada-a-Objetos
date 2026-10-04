package Personaje;
import java.util.Random;

public class Arquero extends Personajes{
    //Atributos
    private int Danio;
    private int CantidadFlechas;
    private int Agilidad;

    //Constructor
    public Arquero(String nombre, int nivel, int puntosVida, boolean estaVivo, int Danio, int CantidadFlechas, int Agilidad) {
        super(nombre, nivel, puntosVida, estaVivo);
        this.Danio = Danio;
        this.CantidadFlechas = CantidadFlechas;
        this.Agilidad = Agilidad;
    }

    //Getters
    //public int getDanio() {
        //return Danio;
    //}

    public int getCantidadFlechas() {
        return CantidadFlechas;
    }

    public int getAgilidad() {
        return Agilidad;
    }

    //Sobreescribir
    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (CantidadFlechas > 0) {
            System.out.println(getNombre() + " dispara una flecha causando " + Danio + " de daño!\n");
            CantidadFlechas--;
            System.out.println("[" + getNombre() + "] dispara una flecha. " +
            "Flechas restantes: " + CantidadFlechas);
        } else {
            throw new RecursoInsuficienteException("flechas", CantidadFlechas);
        }
    }
    
    @Override
    public void defender() {
        Random random = new Random();
        // Número entero entre 0 y 100
        int numero = random.nextInt(101); 
        if (numero < Agilidad) {
            super.defender();
            System.out.println(getNombre() + " esquiva el ataque con su agilidad de " + Agilidad + "\n");
        } else {
            super.defender();
            System.out.println(getNombre() + " no logra esquivar el ataque.\n");
        }
    }

    @Override
    public String toString() {  
        return "Arquero {" + super.toString() +
                ", Danio=" + Danio +
                ", CantidadFlechas=" + CantidadFlechas +
                ", Agilidad=" + Agilidad +
                '}';
    }

    @Override   
    public int calcularDanio() {
        return getNivel() * Danio;  // daño base más daño del arquero
    }
}
