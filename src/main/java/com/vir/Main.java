package com.vir;

import com.vir.models.Book;
import com.vir.repositories.BookRepository;
import com.vir.repositories.csv.CSVBookRepository;
import com.vir.services.BookService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void clearConsole() {
        // Imprimir varias líneas en blanco para "borrar" la consola
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void main(String[] args) {
        // Crear una instancia del repositorio y del servicio de libros
        BookRepository repository = new CSVBookRepository();
        BookService bookService = new BookService(repository);

        // Bandera para salir del bucle principal
        boolean salir = false;

        // Crear una única instancia de Scanner
        Scanner scanner = new Scanner(System.in);

        // Bucle principal del programa
        while (!salir) {
            // Limpiar la consola antes de mostrar el menú
            clearConsole();

            // Mostrar el menú
            System.out.println("////////// Menú //////////");
            System.out.println("Pulse 0 para salir del programa");
            System.out.println("Pulse 1 para ver los libros");
            System.out.println("Pulse 2 para añadir un libro");
            System.out.print("/////////// Opción ///////////////\n");

            // Leer la opción del usuario
            int option = -1;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido");
                System.out.println("Presiona Enter para continuar...");
                scanner.nextLine(); // Espera a que el usuario presione Enter
                continue;
            }

            // Ejecutar la acción correspondiente según la opción seleccionada
            switch (option) {
                case 0:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
                case 1:
                    List<Book> bookList = bookService.getBooks();
                    for (Book book : bookList) {
                        System.out.println(book.getTitle());
                    }
                    System.out.println("Presiona Enter para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione Enter
                    break;
                case 2:
                    System.out.println("Introduce el título del libro:");
                    String title = scanner.nextLine();
                    bookService.create(title);
                    System.out.println("Libro añadido: " + title);
                    System.out.println("Presiona Enter para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione Enter
                    break;
                default:
                    System.out.println("Opción no válida");
                    System.out.println("Presiona Enter para continuar...");
                    scanner.nextLine(); // Espera a que el usuario presione Enter
                    break;
            }
        }

        // Cerrar el scanner
        scanner.close();
    }
}
