package Personaje;

public class Guerrero extends Personajes {
    //Atributos
    private int fuerza;
    private String armadura;

    //Constructor
    public Guerrero(String Nombre, int nivel, int puntosVida, boolean estaVivo, int fuerza, String armadura){
        super(Nombre, nivel, puntosVida, estaVivo);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    //Getters
    public int getFuerza() {
        return fuerza;
    }

    public String getArmadura() {
        return armadura;
    } 

    //Sobreescribir
    @Override
    public void atacar() {
        super.atacar();
        //System.out.println(getNombre() + " golpea con su espada causando " + fuerza + "de daño!\n");
    }

    @Override
    public void defender() {
        super.defender();
        System.out.println(getNombre() + " bloquea con su armadura de " + armadura + "\n");
    }

    @Override
    public String toString() {
        return "Guerrero {" + super.toString() +
                ", fuerza=" + fuerza +
                ", armadura='" + armadura + '\'' +
                '}';
    }

    @Override   
    public int calcularDanio() {
        return getNivel() * fuerza;  // daño base más fuerza del guerrero
    }

    //Metodo sobrecargado
    public void entrenar(){
        fuerza += 5;
        System.out.println(getNombre() + " ha entrenado y su fuerza ahora es " + fuerza + "\n");
    }

    public void entrenar(int sesiones){
        fuerza += 5 * sesiones;
        System.out.println(getNombre() + " ha entrenado " + sesiones + " veces y su fuerza ahora es " + fuerza + "\n");
    }

    public void entrenar(int sesiones, int intensidad){
        fuerza += 5 * sesiones * intensidad;
        System.out.println(getNombre() + " ha entrenado " + sesiones + " veces con una intensidad de " + intensidad + " y su fuerza ahora es " + fuerza + "\n");
    }
}
