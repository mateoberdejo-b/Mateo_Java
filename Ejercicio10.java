package Ejerciocios;

public class Ejercicio10 {
    public static void main(String[] args) {
    	Calculadora calc = new Calculadora();
    	System.out.println("Suma int: " + calc.sumar(5, 3));
    	System.out.println("Suma double: " + calc.sumar(4.2, 2.8));
    	
    }
}

class Calculadora {
	public int sumar(int a, int b) {
		return a + b;
	}
public double sumar(double a, double b) {
	    return a + b;
    }
}
