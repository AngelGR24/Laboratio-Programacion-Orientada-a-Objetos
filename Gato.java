package Animales;

public class Gato extends Animal {
    private String color;
    private String tienePelargeLargo;

    //constructor para gatos.
    public Gato(String nombre, int edad, double peso, String color, String tienePelargeLargo) {
        super(nombre, edad, peso);
        this.color = color;
        this.tienePelargeLargo = tienePelargeLargo;
    }

    //Metodos

        //Maullar
    public void maullar() {
        System.out.println(getNombre() + " está maullando: ¡Miau! ¡Miau!");
    }
        //Arañar
    public void arañar() {
        System.out.println(getNombre() + " está arañando...");
    }
        
        //To string
    @Override
    public String toString() {
        return super.toString() + ", color=" + 
        this.color + ", tienePeloLargo=" + 
        (this.tienePelargeLargo.equals("Sí") ? "Sí" : "No") + "}";
    }

}
