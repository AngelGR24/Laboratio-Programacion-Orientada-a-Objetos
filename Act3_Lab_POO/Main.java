package Vehiculos;
/*
¿Cuál es la diferencia entre private y protected?
¿En qué situación usarías cada uno?
 1. private solo permite acceder al atributo desde la clase que lo declara.
    protected permite acceder desde la misma clase, clases del mismo paquete
    y clases hijas. Se usa private para proteger mejor el estado interno y
    protected cuando una subclase necesita trabajar directamente con él.

¿Por qué marca y modelo no tienen setter? ¿Qué implica eso en el diseño?
 2. marca y modelo no tienen setter porque se consideran datos que no deben
    cambiar después de crear el vehículo. Esto refuerza el encapsulamiento y
    evita modificaciones no controladas; el objeto expone getters de lectura.

¿Qué pasaría si un setter no tuviera validación y alguien pusiera un año negativo?
 3. Si un setter aceptara un año negativo, el objeto quedaría con un estado
    inválido. La validación protege la consistencia de los datos y evita que
    otras partes del programa trabajen con información incorrecta.
 */

public class Main {

	public static void main(String[] args) {
		Automovil automovil = new Automovil("Toyota", "Corolla", 2022, 180, 4, "Sí");
		Avion avion = new Avion("Boeing", "737", 2020, 850, 2, 12_500);
		Barco barco = new Barco("Yamaha", "Marine 1", 2019, 45, "Pesquero", 8_000);

        
		System.out.println(automovil.toString());
		System.out.println(avion.toString());
		System.out.println(barco.toString());

		System.out.println("\nPrueba de validaciones:");
		automovil.setNumPuertas(1);
		avion.setNumMotores(0);
		avion.setAltitudMax(-500);
		barco.setTonelajeMaximo(0);
		automovil.setAnio(1800);
		avion.setVelocidadmax(-100);

		System.out.println("\nObjetos después de intentar asignar valores incorrectos:");
		System.out.println(automovil);
		System.out.println(avion);
		System.out.println(barco);
	}
}
