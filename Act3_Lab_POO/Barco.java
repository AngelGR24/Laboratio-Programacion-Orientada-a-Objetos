package Vehiculos;

public class Barco extends Vehiculo {
    private String tipo;
    private double tonelajeMaximo;

    public Barco(String marca, String modelo, int anio, double velocidadmax, String tipo, double tonelajeMaximo) {
        super(marca, modelo, anio, velocidadmax);
        this.tipo = tipo;
        this.tonelajeMaximo = tonelajeMaximo;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public double getTonelajeMaximo() {
        return tonelajeMaximo;
    }

    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTonelajeMaximo(double tonelajeMaximo) {
        if (tonelajeMaximo > 0) {
            this.tonelajeMaximo = tonelajeMaximo;
        } else {
            System.out.println("Error: tonelaje máximo no válido.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Barco [tipo=" + tipo + ", tonelajeMaximo=" +
         tonelajeMaximo + "]";
    }

}
