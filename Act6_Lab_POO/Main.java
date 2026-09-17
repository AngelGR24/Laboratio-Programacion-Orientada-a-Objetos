/*
 (1)
     ¿Por qué Personaje debe ser abstracta y no concreta? ¿Qué problema resuelve?
     En este proyecto la clase base es Personajes (la idea de "Personaje" como entidad general).
     Debe ser abstracta porque no tiene sentido crear un objeto de tipo "personaje genérico" sin
     definir cómo ataca ni cuánto daño hace. 

 (2) 
     ¿Qué ventaja tiene que Druida implemente dos interfaces? ¿Podría extender dos clases en lugar de implementar dos interfaces?
     La ventaja es que un Druida puede cumplir dos roles: ser Hechicero y ser Sanador. Esto permite reutilizar 
     comportamientos sin mezclar lógica de herencia rígida. 
     Java no permite heredar de dos clases a la vez, así que la alternativa correcta es implementar varias 
     interfaces. Las interfaces representan capacidades, no una jerarquía de objetos, y eso evita el problema 
     de herencia múltiple de clases.
 
  (3) 
     Si agregas un nuevo personaje Paladín que cura y combate físicamente, ¿qué clase extiende y qué interfaces implementa?
     Extiende Personajes e implementa Sanador (porque cura), mientras que el ataque físico ya está cubierto
     por la clase base Personajes que extiende de combatientes
 
     No necesitas modificar las clases existentes para esto, porque el diseño ya permite que cualquier
     personaje nuevo herede la lógica común de Personajes y agregue capacidades extra mediante interfaces.
     Solo se crea la nueva subclase y se implementa la interfaz que corresponda.
 */
package Personaje;

public class Main {
    public static void main(String[] args) {
        //Personaje personaje = new Personaje("Juan", 5, 100, true);
        //"message": "Personaje cannot be resolved to a type",
        Druida druida = new Druida("Druida", 5, 100, true, 60, 20, "Oso");
        Bardo bardo = new Bardo("Bardo", 3, 80, true, "Guitarra", "Canción de Curación", 15);
        Nigromante nigromante = new Nigromante("Nigromante", 7, 120, true, 20,25, "Maldición de la Muerte"); 
        
        //Polimorfismo
        Personajes[] personajes = {druida, bardo, nigromante};
        for(Personajes personaje : personajes){
            System.out.println("----------- Ataques y daño calculado -----------");
            personaje.atacar();
            System.out.println("Daño calculado: " + personaje.calcularDanio() + "\n");
        }

        //Instanceof
        for (Personajes p : personajes) {
            System.out.println("----------Hechiceros----------");
            if (p instanceof Hechicero) {
                Hechicero h = (Hechicero) p;
                h.lanzarHechizo();
            }
        }
        for (Personajes p : personajes) {
            System.out.println("----------Sanadores----------");
            if (p instanceof Sanador) {
                Sanador s = (Sanador) p;
                s.curarAliado(nigromante);
            }
        }

        System.out.println("----------Curacion a nigromante----------");
        int danio = druida.calcularDanio();
        nigromante.recibirDanio(danio);
        druida.curarAliado(nigromante);
    
        System.out.println(druida);
        System.out.println(bardo);
        System.out.println(nigromante);
    }
}
