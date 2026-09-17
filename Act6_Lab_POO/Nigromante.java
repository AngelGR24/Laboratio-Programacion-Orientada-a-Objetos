package Personaje;

public class Nigromante extends Personajes implements Hechicero {
    private int mana;
    private String maldicion;
    private int poderOscuridad;

    public Nigromante(String nombre, int nivel, int puntosVida, boolean estaVivo, int mana, int poderOscuridad, String maldicion) {
        super(nombre, nivel, puntosVida, estaVivo);
        this.mana = mana;
        this.poderOscuridad = poderOscuridad;
        this.maldicion = maldicion;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con las fuerzas de la oscuridad");
    }

    @Override
    public int calcularDanio() {
        return poderOscuridad * 10; // daño base según nivel
    }

    @Override
    public void lanzarHechizo() {
        if (mana >= 5) {
            mana -= 5;
            System.out.println(nombre + " lanza la maldición: " + maldicion + ". Mana restante: " + mana);
        } else {
            System.out.println(nombre + " no tiene suficiente mana para lanzar un hechizo.");
        }
    }

    @Override
    public int getMana() {
        return mana;
    }

}
