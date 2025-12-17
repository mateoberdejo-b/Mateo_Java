package bibliteca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE BIBLIOTECA ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    System.out.println("Género disponible:");
                    for (Genero g : Genero.values()) {
                        System.out.println("- " + g);
                    }

                    System.out.print("Seleccione género: ");
                    Genero genero = Genero.valueOf(scanner.nextLine().toUpperCase());

                    Libro libro = new Libro(titulo, autor, genero);
                    biblioteca.agregarLibro(libro);

                    System.out.println("Libro agregado correctamente.");
                    break;

                case 2:
                    biblioteca.listarLibros();
                    break;

                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 3);

        scanner.close();
    }
}





