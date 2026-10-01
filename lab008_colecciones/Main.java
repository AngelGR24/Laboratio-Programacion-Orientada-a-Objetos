package Personaje;

public class Main {
    public static void main(String[] args) {
        // Bloque 1 — Gestión de roster con ArrayList:
        GestionGremio gremio = new GestionGremio();
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, true, 100, 20, "Lobo"));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, true, 12, 30, "Esqueleto"));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, true, 12, 60, 9));
        gremio.agregarMiembro(new Guerrero("Thorin", 9, 400, true, 80, "Hierro" ));
        gremio.mostrarRoster();

        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        Personajes encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null)
            System.out.println("Encontrado: " + encontrado.getNombre());
    
        //Bloque 2 — Cola de espera con LinkedList:
        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();

        gremio.atenderSiguiente();   // atiende a Gandalf (FIFO)
        gremio.mostrarCola();

        //Bloque 3 — Inventario con HashMap:
        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);  // suma → 8

        gremio.mostrarInventario();

        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");    // no existe
        gremio.mostrarInventario();

        //Bloque 4 — Habilidades únicas con HashSet:
        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");    // duplicado — no se agrega

        gremio.mostrarHabilidades();

        System.out.println("¿Tiene flecha? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curación? " + gremio.tieneHabilidad("Curación"));

        //Bloque 5 — Resumen del gremio:
        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }
}
