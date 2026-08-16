package Animales;

public class Canario extends Animal {
    private String color;
    private String canta;

    //constructor para canarios.
    public Canario(String nombre, int edad, double peso, String color, String canta) {
        super(nombre, edad, peso);
        this.color = color;
        this.canta = canta;
    }

    //Metodos

        //Cantar
    public void cantar() {
        System.out.println(getNombre() + " está cantando: ¡Pío! ¡Pío!");
    }
       
        //Volar
    public void volar() {
        System.out.println(getNombre() + " está volando...");
    }
       
        //To string
    @Override
    public String toString() {
        return super.toString() + ", color=" + this.color + ", canta=" +
                (this.canta.equals("Sí") ? "Sí" : "No") + "}";
    }

}
