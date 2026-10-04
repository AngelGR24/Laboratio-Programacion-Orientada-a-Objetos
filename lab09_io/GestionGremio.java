package Personaje;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GestionGremio{

    private ArrayList<Personajes> roster;
    private java.util.LinkedList<String> colaTurnos;
    private java.util.HashMap<String, Integer> inventario;
    private java.util.HashSet<String> habilidades;
    
    public GestionGremio() {
        roster      = new ArrayList<>();
        colaTurnos  = new java.util.LinkedList<>();
        inventario  = new java.util.HashMap<>();
        habilidades = new java.util.HashSet<>();
    } 
    
    // ──────────────────────────────────────────
    // SECCIÓN 1 — ArrayList: roster de personajes
    // ──────────────────────────────────────────

    public void agregarMiembro(Personajes p) {
        roster.add(p);
        System.out.println("[Gremio] " + p.getNombre() + " se unió al gremio.");
    }

    public void eliminarMiembro(String nombre) {
        Iterator<Personajes> it = roster.iterator();
        while (it.hasNext()) {
            Personajes p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();   // forma segura de eliminar durante iteración
                System.out.println("[Gremio] " + nombre + " abandonó el gremio.");
                return;
            }
        }
        System.out.println("[Gremio] No se encontró: " + nombre);
    }

    public Personajes buscarPorNombre(String nombre) {
        for (Personajes p : roster) {       // for-each
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarRoster() {
        System.out.println("\n=== Roster del Gremio (" + roster.size() + " miembros) ===");
        for (int i = 0; i < roster.size(); i++) {
            Personajes p = roster.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() +
                               " | Nivel: " + p.getNivel() +
                               " | Vida: " + p.getPuntosVida());
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 2 — LinkedList: cola de turnos
    // ──────────────────────────────────────────

    public void encolarSolicitante(String nombre){
        colaTurnos.addLast(nombre); //Agrega al final
        System.out.println("[Cola]" + nombre + " en posicion " + colaTurnos.size());
    }

    public String atenderSiguiente(){
        if(colaTurnos.isEmpty()){
            System.out.println("[Cola] No hay solicitantes en espera. ");
            return null;
        }
        String atendido = colaTurnos.removeFirst(); //Saca del frente
        System.out.println("[Cola] Atendiendo a: " + atendido);
        return atendido;
    }

    public void mostrarCola(){
        System.out.println("\n=== Cola de Espera (" + colaTurnos.size() + ") ===");
        int pos = 1;
        for (String nombre : colaTurnos){
            System.out.println(pos++ + ". " + nombre);
        }
    }

    //3a — HashMap: inventario de objetos
    public void agregarItem(String item, int cantidad){
        // Con .put añadimos o actualizamos la cantidad del item, ahora, con getOrDefault lo que hacemos es que en
        // caso de que el item no exista nos devuelva el valor que definimos, en este caso 0, y si existe nos 
        // devuelve la cantidad que ya tiene, y asi podemos sumar la cantidad que queramos añadir.
        inventario.put(item, inventario.getOrDefault(item, 0) + cantidad);
        System.out.println("[Inventario] Se agregaron " + cantidad + " " + item + "(s). Total: " + inventario.get(item));
    }

    public void usarItem(String item){
        if(inventario.containsKey(item) && inventario.get(item) > 0){
            inventario.put(item, inventario.get(item) - 1);
            System.out.println("[Inventario] Se usó un " + item + ". Quedan: " + inventario.get(item));
            if(inventario.get(item) == 0){
                inventario.remove(item);
                System.out.println("[Inventario] Se han agotado los " + item + "(s).");
            }
        } else {
            System.out.println("[Inventario] No hay " + item + " disponible para usar.");
        }
    }

    public void mostrarInventario(){
        System.out.println("\n=== Inventario (" + inventario.size() + " tipos de items) ===");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

    //3b — HashSet: habilidades únicas
    public boolean registrarHabilidad(String habilidad){
        if(habilidades.add(habilidad)){
            System.out.println("[Habilidades] Habilidad registrada: " + habilidad);
            return true;
        } else {
            System.out.println("[Habilidades] La habilidad ya estaba registrada: " + habilidad);
            return false;
        }
    }

    public String tieneHabilidad(String habilidad){
        if(habilidades.contains(habilidad)){
            return "[Habilidades] El gremio tiene la habilidad: " + habilidad;
        } else {
            return "[Habilidades] El gremio NO tiene la habilidad: " + habilidad;
        }
    }

    public void mostrarHabilidades(){
        System.out.println("\n=== Habilidades del Gremio (" + habilidades.size() + ") ===");
        for (String habilidad : habilidades) {
            System.out.println("- " + habilidad);
        }
    }
}
