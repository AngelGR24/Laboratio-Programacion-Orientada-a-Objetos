package Vehiculos;

public class Avion extends Vehiculo {
    private int numMotores;
    private double altitudMax;

    public Avion(String marca, String modelo, int anio, double velocidadmax, int numMotores, double altitudMax) {
        super(marca, modelo, anio, velocidadmax);
        this.numMotores = numMotores;
        this.altitudMax = altitudMax;
    }

    // Getters
    public int getNumMotores() {
        return numMotores;
    }

    public double getAltitudMax() {
        return altitudMax;
    }

    // Setters
    public void setNumMotores(int numMotores) {
        if (numMotores > 0) {
            this.numMotores = numMotores;
        } else {
            System.out.println("Error: número de motores no válido.");
        }
    }

    public void setAltitudMax(double altitudMax) {
        if (altitudMax > 0) {
            this.altitudMax = altitudMax;
        } else {
            System.out.println("Error: altitud máxima no válida.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Avion [numMotores=" + numMotores + 
        ", altitudMax=" + altitudMax + "]";
    }

}
