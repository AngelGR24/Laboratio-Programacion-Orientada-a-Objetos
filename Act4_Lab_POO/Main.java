/*
  PREGUNTAS Y RESPUESTAS SOBRE POO EN JAVA
  =========================================
  
    ¿Cuál es la diferencia entre 'extends' e 'implements'? ¿Cuándo usas cada uno?
  
    extends: Se usa para HERENCIA de clases. Una clase hijo hereda la implementación 
    (métodos y atributos) de una clase padre. Una clase solo puede extender UNA clase.
    Ejemplo: public class Guerrero extends Personaje { }
  
    implements: Se usa para implementar INTERFACES. Una interface define qué métodos 
    debe tener una clase (el "qué"), pero NO la implementación (el "cómo"). 
    Una clase puede implementar MÚLTIPLES interfaces.
    Ejemplo: public class Guerrero extends Personaje implements Combatientes { }
  
  
   ¿Qué ventaja tiene llamar 'super.atacar()' dentro de 'Guerrero.atacar()' 
   en lugar de reescribir todo?
  
   - No repites la lógica que ya existe en la clase padre.
   - Reutilizas el comportamiento base y solo agregas lo específico del Guerrero.
   - Si el padre cambia, todos los hijos usan automáticamente la nueva versión.
   - Permite agregar comportamiento adicional sin reescribir todo desde cero.

   Si declaras 'Personaje p = new Guerrero(...)' y llamas 'p.atacar()', 
   ¿qué método se ejecuta, el de 'Personaje' o el de 'Guerrero'? ¿Por qué?
  
   Se ejecuta el método de Guerrero por el concepto de polimorfismo

   Conceptos vistos en clase
   En la clase del dia jueves se vio el concepto de herencia que lo tratamos de la manera
   en que creamos una interfaz con atributos generales que deberan tener todos los objetos 
   queramos crear, sin embargo, se declaran vacios para que cada objeto le de su 
   personalizacion correspondiente.
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
    }
}
