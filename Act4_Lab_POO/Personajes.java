package Personaje;

public class Personajes implements Skill.Combatientes {
    //Atributos
    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;
    
    //Constructor
    public Personajes(String nombre, int nivel, int puntosVida, boolean estaVivo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    //Metodos
    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
            System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida);
            System.out.println(nombre + " Ha sido derrotado\n");
        } else {
            System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida + "\n");
        }
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con un golpe basico");
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se pone en guardia" );
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", Vida=" + puntosVida +
                ", Vivo=" + estaVivo;
    }
}
