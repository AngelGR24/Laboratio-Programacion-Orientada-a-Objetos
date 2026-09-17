package Personaje;

public class Druida extends Personajes implements Hechicero, Sanador {
    private int mana;
    private int poderCuracion;
    private String formaAnimal;

    public Druida(String nombre, int nivel, int puntosVida, boolean estaVivo, int mana, int poderCuracion, String formaAnimal) {
        super(nombre, nivel, puntosVida, estaVivo);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.formaAnimal = formaAnimal;
    }
    
    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con las fuerzas de la naturaleza en su forma de " + formaAnimal);
    }

    @Override
    public int calcularDanio() {
        return mana * 8; // daño base según nivel
    }

    @Override
    public void lanzarHechizo() {
        if (mana >= 5) {
            mana -= 5;
            System.out.println(nombre + " lanza un hechizo. Mana restante: " + mana);
        } else {
            System.out.println(nombre + " no tiene suficiente mana para lanzar un hechizo.");
        }
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void curarAliado(Personajes aliado) {
        if (mana >= 5) {
            mana -= 5;
            System.out.println(nombre + " cura a: " + aliado.getNombre() + ". Mana restante: " + mana);
            aliado.puntosVida += poderCuracion;
            System.out.println(aliado.getNombre() + " ahora tiene " + aliado.getPuntosVida() + " puntos de vida.\n");
        } else {
            System.out.println(nombre + " no tiene suficiente mana para curar a un aliado.");
        }
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }
}
