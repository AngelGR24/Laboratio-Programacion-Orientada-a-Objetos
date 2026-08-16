package Animales;

/*
  1. ¿Por qué declaramos los atributos como private y no como public?
     Para acceder a ellos mediante un getter y no directamente del atributo y asi poder controlas
     que no se modifiquen de manera que no queramos

  2. ¿Qué pasaría si quitaras el super() del constructor de Perro?
     El programa buscaria un constructor sin parametros en la clase Animal, y al no existir daria
     un error de compilacion, de esta manera podemos ejecutar el constructor principal de 
     la clase animal sin problema.

  3. ¿Qué ventaja tiene sobreescribir toString() en lugar de crear un método con otro nombre?
    Porque toString() es el método basico que usa Java cuando queremos imprimir un objeto.
    Así no necesitamos llamar un método distinto cada vez.
*/

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro("Firulais", 5, 18.5, "Labrador", "Sí");
        Gato gato = new Gato("Milo", 3, 4.2, "Negro", "No");
        Canario canario = new Canario("Pio", 2, 0.8, "Amarillo", "Sí");

        System.out.println(perro);
        perro.ladrar();
        perro.comer();
        perro.buscarPelota();

        System.out.println(gato);
        gato.maullar();
        gato.dormir();
        gato.arañar();

        System.out.println(canario);
        canario.cantar();
        canario.volar();
        canario.comer();
    }
}
