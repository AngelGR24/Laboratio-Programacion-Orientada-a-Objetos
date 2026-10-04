package Personaje;

public abstract class Personajes implements Personaje.Combatientes {
    //Atributos
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected boolean estaVivo;
    
    //Constructor
    public Personajes(String nombre, int nivel, int puntosVida, boolean estaVivo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true;
    }

    //Getters
    public String getNombre() { return nombre; }

    public int getNivel() { return nivel; }

    public int getPuntosVida() { return puntosVida; }

    public boolean isEstaVivo() { return estaVivo; }

    //Metodos
    public void recibirDanio(int danio) throws AccionInvalidaException {
        if (danio < 0) {
            throw new AccionInvalidaException("recibirDanio", "El daño no puede ser negativo: " + danio);
        }        
        puntosVida -= danio;
        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
            System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida);
            System.out.println(nombre + " Ha sido derrotado\n");
        } else {
            System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida + "\n");
        }
    }


    public abstract void atacar() throws RpgException;
    public abstract int calcularDanio();

    @Override
    public void defender() {
        System.out.println(nombre + " se pone en guardia" );
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", Vida=" + puntosVida +
                ", Vivo=" + estaVivo;
    }

    //Metodo sobrecargado
    public void curar(){
        puntosVida += 10;
        System.out.println(nombre + " se ha curado y su vida ahora es " + puntosVida + "\n");
    }

    public void curar(int cantidad){
        puntosVida = 10*cantidad;
        System.out.println(nombre + " se ha curado " + cantidad + " veces y su vida ahora es " + puntosVida + "\n");
    }

    public void curar(boolean dorada){
        if(dorada){
            puntosVida += 100;
            System.out.println(nombre + " ha usado una pocion dorada y su vida ahora es " + puntosVida + "\n");
        }else{
            puntosVida += 10;
            System.out.println(nombre + " ha usado una pocion normal y su vida ahora es " + puntosVida + "\n");
        }
    }
}
