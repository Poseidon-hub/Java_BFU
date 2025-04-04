package Lab4;

import java.util.List;

public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();

        // Создаем книги
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("1984", "George Orwell", 1949);
        Book book4 = new Book("Animal Farm", "George Orwell", 1945);
        Book book5 = new Book("Pride and Prejudice", "Jane Austen", 1813);

        // Добавляем книги в библиотеку
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        // Тестируем методы
        System.out.println("=== Initial library state ===");
        library.printAllBooks();
        library.printUniqueAuthors();
        library.printAuthorStatistics();

        System.out.println("\n=== Books by George Orwell ===");
        List<Book> orwellBooks = library.findBooksByAuthor("George Orwell");
        orwellBooks.forEach(System.out::println);

        System.out.println("\n=== Books published in 1945 ===");
        List<Book> books1945 = library.findBooksByYear(1945);
        books1945.forEach(System.out::println);

        // Удаляем книгу и проверяем изменения
        System.out.println("\n=== After removing Animal Farm ===");
        library.removeBook(book4);
        library.printAllBooks();
        library.printAuthorStatistics();

        // Проверяем удаление последней книги автора
        System.out.println("\n=== After removing all Orwell books ===");
        library.removeBook(book3);
        library.printAllBooks();
        library.printUniqueAuthors();
        library.printAuthorStatistics();
    }
}