package Personaje;

public class Mago extends Personajes{
    //Atributos
    private int NivelMagia;
    private String tipoMagia;

    //Constructor
    public Mago(String nombre, int nivel, int puntosVida, boolean estaVivo, int NivelMagia, String tipoMagia) {
        super(nombre, nivel, puntosVida, estaVivo);
        this.NivelMagia = NivelMagia;
        this.tipoMagia = tipoMagia;
    }

    //Getters
    public int getNivelMagia() {
        return NivelMagia;
    }

    public String getTipoMagia() {
        return tipoMagia;
    }
    
    //Sobreescribir
    @Override
    public void atacar() {
        super.atacar();
        //System.out.println(getNombre() + " lanza un hechizo de " + tipoMagia + " causando " + NivelMagia + " de daño!\n");
    }

    @Override
    public void defender() {
        super.defender();
        System.out.println(getNombre() + " se protege con un escudo mágico de " + tipoMagia + "\n");
    }

    @Override
    public String toString() {
        return "Mago {" + super.toString() +
                ", NivelMagia=" + NivelMagia +
                ", tipoMagia='" + tipoMagia + '\'' +
                '}';
    }

    @Override   
    public int calcularDanio() {
        return getNivel() * NivelMagia;  // daño base más nivel de magia del mago
    }
}
