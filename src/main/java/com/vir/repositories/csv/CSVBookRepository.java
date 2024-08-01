package com.vir.repositories.csv;

import com.vir.models.Book;
import com.vir.repositories.BookRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVBookRepository implements BookRepository {

    private static final String DIRECTORY_PATH = "files/csv";
    private static final String CSV_FILE_PATH = DIRECTORY_PATH + "/books.csv";
    private static final String CSV_HEADER = "Title";

    public CSVBookRepository() {
        // Crear la carpeta si no existe
        try {
            Files.createDirectories(Paths.get(DIRECTORY_PATH));
            // Crear el archivo CSV con cabecera si no existe
            File csvFile = new File(CSV_FILE_PATH);
            if (csvFile.createNewFile()) {
                try (FileWriter csvWriter = new FileWriter(CSV_FILE_PATH, true)) {
                    csvWriter.append(CSV_HEADER).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(Book book) {
        try (FileWriter csvWriter = new FileWriter(CSV_FILE_PATH, true)) {
            csvWriter.append(book.getTitle()).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String row;
            boolean isFirstRow = true;
            while ((row = csvReader.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false; // Skip header row
                    continue;
                }
                Book book = new Book(row);
                books.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void update(String oldTitle, String newTitle) {
        List<Book> books = findAll();
        try (FileWriter csvWriter = new FileWriter(CSV_FILE_PATH)) {
            csvWriter.append(CSV_HEADER).append("\n"); // Write header
            for (Book book : books) {
                if (book.getTitle().equals(oldTitle)) {
                    book.setTitle(newTitle);
                }
                csvWriter.append(book.getTitle()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(String title) {
        List<Book> books = findAll();
        try (FileWriter csvWriter = new FileWriter(CSV_FILE_PATH)) {
            csvWriter.append(CSV_HEADER).append("\n"); // Write header
            for (Book book : books) {
                if (!book.getTitle().equals(title)) {
                    csvWriter.append(book.getTitle()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}