package Animales;

public class Perro extends Animal {
    private String raza;
    private String estaVacunado;

    //constructor con vacuna
    public Perro(String nombre, int edad, double peso, String raza, String estaVacunado) {
        super(nombre, edad, peso);
        this.raza = raza;
        this.estaVacunado = estaVacunado;
    }

    //Metodos

        //Ladrar
    public void ladrar() {
        System.out.println(getNombre() + " está ladrando: ¡Guau! ¡Guau!");
    }
        //ConseguirPelota
    public void buscarPelota() {
        System.out.println(getNombre() + " está buscando la pelota...");
    }
        
        //To string
    @Override
    public String toString() {
        return super.toString() + ", raza=" + 
        this.raza + ", vacunado=" + 
        (this.estaVacunado.equals("Sí") ? "Sí" : "No") + "}";
    }

}
