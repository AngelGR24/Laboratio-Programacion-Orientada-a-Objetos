/* Preguntas
1.-¿Cuál es la diferencia entre sobreescritura y sobrecarga?. Da un ejemplo de cada uno tomado de este laboratorio.
    Override es lo que venimos usando desde el comienzo de las clases del laboratorio, es un mismo metodo que se hereda
    en diferentes clases y que cambia segun la ejecucion, sin embargo, la sobre carga son varios metodos con el mismo nombre 
    que se ejecutaran dependiendo los parametros que se le pasen, es decir, el mismo metodo pero con diferentes parametros.
    Ejemplos: Las sobreescrituras de ataque y las sobrecargas de entrenamiento.
    
2.-Si tienes Personaje p = new Mago(...) y llamas p.calcularDanio(), ¿Java usa el método de Personaje o el de Mago? ¿Por qué? 
    El de mago, por que p es un objeto de la subclase hija llamada mago que es hija de la clase padre Personaje.

3.-¿Para qué sirve instanceof? ¿En qué situaciones lo usarías en un sistema real?
    Sirve para identificar el tipo de objeto que es, en este caso, si es un mago, guerrero o arquero.
    Se usaria en un sistema real para identificar el tipo de objeto que es una instancia.
    */
package Personaje;

public class Main {
    //Objetos
    public static void main(String[] args) {
        //Creacion de personajes
        Mago mago1 = new Mago("Gandalf", 10, 100, true, 50, "Fuego");
        Guerrero guerrero1 = new Guerrero("Conan", 8, 120, true, 30, "Acero");
        Arquero arquero1 = new Arquero("Legolas", 9, 90, true, 40, 20, 80);

        //Mostrar informacion de los personajes
        System.out.println("\n--- Informacion inicial de los personajes ---");
        System.out.println(mago1);
        System.out.println(guerrero1);
        System.out.println(arquero1);

        //Atacar
        System.out.println("\n--- Ataques de los personajes ---");
        mago1.atacar();
        guerrero1.atacar();
        arquero1.atacar();

        //Defender
        System.out.println("\n--- Defensa de los personajes ---");
        mago1.defender();
        guerrero1.defender();   
        arquero1.defender();

        //Recibir 
        System.out.println("\n--- Personajes reciben daño ---");
        mago1.recibirDanio(100);
        guerrero1.recibirDanio(50);
        arquero1.recibirDanio(90);

        //Mostrar informacion actualizada de los personajes
        System.out.println("\n--- Informacion actualizada de los personajes ---");
        System.out.println(mago1);
        System.out.println(guerrero1);
        System.out.println(arquero1);

        //Laboratorio 5
        //3a — Variable de tipo padre apunta a objeto hijo
        System.out.println("\n--- Calculo de daño con variable de tipo padre ---");
        System.out.println(mago1.calcularDanio());
        System.out.println(guerrero1.calcularDanio());
        System.out.println(arquero1.calcularDanio());

        //3b — Arreglo polimórfico
        System.out.println("\n--- Arreglo polimórfico ---");
        Personajes[] personajes = {mago1, guerrero1, arquero1};
        for (Personajes p : personajes) {
            System.out.println(p.getNombre() + " Daño: " + p.calcularDanio());
        }

        //3c — Usar GestorBatalla con las tres sobrecargas
        System.out.println("\n--- Batalla con GestorBatalla ---");
        GestorBatalla gestor = new GestorBatalla();
        gestor.ejecutar_ataque(mago1);
        gestor.ejecutar_ataque(arquero1, guerrero1);
        gestor.ejecutar_ataque(personajes);

        System.out.println("\n--- Historial de la batalla ---");
        gestor.mostrar_historial();

        //3d — Identificar tipo real con instanceof
        System.out.println("\n--- Identificación de tipos de personajes con instaceof ---");
        for (Personajes p : personajes) {
            if (p instanceof Mago) {
                System.out.println(p.getNombre() + " es un Mago");
            } else if (p instanceof Guerrero) {
                System.out.println(p.getNombre() + " es un Guerrero");
            } else if (p instanceof Arquero) {
                System.out.println(p.getNombre() + " es un Arquero");
            }
        }

        //Demostracion de metodo sobrecargado
        System.out.println("\n--- Entrenamiento del Guerrero ---");
        guerrero1.entrenar();
        guerrero1.entrenar(3);
        guerrero1.entrenar(2, 4);

        System.out.println("\n--- Curacion del personaje ---");
        arquero1.curar();
        mago1.curar(3);
        mago1.curar(true);
    }
}
