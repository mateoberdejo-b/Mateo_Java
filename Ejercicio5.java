package Ejerciocios;

public class Ejercicio5 {
     public static void main(String[] args) {
    	 Persona p = new Persona("Laura", 28);
    	 System.out.println("Nombre: "+ p.nombre + ", Edad: " + p.edad);
    	 
     }
}

class Personaa{
	String nombre;
	int edad;
	
	
	public Personaa(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	
	}
}
