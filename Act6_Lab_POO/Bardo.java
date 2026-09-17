package Personaje;

public class Bardo extends Personajes implements Sanador {
    private String cancion;
    private int poderCuracion;
    private String instrumento;

    public Bardo(String nombre, int nivel, int puntosVida, boolean estaVivo, String instrumento, String cancion, int poderCuracion) {
        super(nombre, nivel, puntosVida, estaVivo);
        this.instrumento = instrumento;
        this.cancion = cancion;
        this.poderCuracion = poderCuracion;
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con su instrumento musical: " + instrumento);
    }

    @Override
    public int calcularDanio() {
        return nivel * 5; // daño base según nivel
    }

    @Override
    public void curarAliado(Personajes aliado) {
        aliado.curar();
        System.out.println(nombre + " ha curado a " + aliado.getNombre() + " con la canción: " + cancion + ". Vida de " + aliado.getNombre() + ": " + aliado.getPuntosVida() + "\n");
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }

}
