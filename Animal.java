package Animales;

public class Animal {
    private String nombre;
    private int edad;
    private double peso;

    //constructor
    public Animal(String nombre, int edad, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }

    //Getters

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    //Metodos
    
        //Comer
    public void comer() {
        System.out.println(this.nombre + " está comiendo.");
    }
    
        //Dormir
    public void dormir() {
        System.out.println(this.nombre + " está durmiendo.");
    }

        //To string
    @Override
    public String toString() {
    return "\nAnimal{" +
            "nombre='" + nombre + '\'' +
            ", edad=" + edad +
            ", peso=" + peso;
    }
}
