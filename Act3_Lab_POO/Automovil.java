package Vehiculos;

public class Automovil extends Vehiculo {
    private int numPuertas;
    private String esElectrico;

    public Automovil(String marca, String modelo, int anio, double velocidadmax, int numPuertas, String esElectrico) {
        super(marca, modelo, anio, velocidadmax);
        this.numPuertas = numPuertas;
        this.esElectrico = esElectrico;
    }

    // Getters
    public int getNumPuertas() {
        return numPuertas;
    }

    public String getEsElectrico() {
        return esElectrico;
    }
    // Setters
    public void setNumPuertas(int numPuertas) {
        if (numPuertas >= 2 && numPuertas <= 6) {
            this.numPuertas = numPuertas;
        } else {
            System.out.println("Error: número de puertas no válido.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Automovil [numPuertas=" + numPuertas 
        + ", esElectrico=" + esElectrico + ", " + "]";
    }

}
