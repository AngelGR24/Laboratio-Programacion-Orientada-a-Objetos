package Vehiculos;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    protected double velocidadmax;

    public Vehiculo(String marca, String modelo, int anio, double velocidadmax) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidadmax = velocidadmax;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getVelocidadmax() {
        return velocidadmax;
    }

    // Setters
    public void setAnio(int anio) {
        if (anio >= 1885 && anio <= 2100) {
            this.anio = anio;
        } 
        else {
            System.out.println("Error: año no válido.");
        }
    }

    public void setVelocidadmax(double velocidadmax) {
        if (velocidadmax > 0) {
            this.velocidadmax = velocidadmax;
        } else {
            System.out.println("Error: velocidad máxima no válida.");
        }
    }

    //Metodos
    public void describir() {
        System.out.println("Marca: " + marca + "Modelo: " + modelo + " Año: " + 
        anio + " Velocidad máxima: " + velocidadmax + " km/h");
    }
    
    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", velocidadmax=" + velocidadmax + "]";
    }
}
