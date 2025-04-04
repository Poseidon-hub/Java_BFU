package Lab4;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();
    private Set<String> uniqueAuthors = new HashSet<>();
    private Map<String, Integer> authorStatistics = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        uniqueAuthors.add(book.getAuthor());
        authorStatistics.merge(book.getAuthor(), 1, Integer::sum);
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            // Проверяем, есть ли еще книги этого автора
            boolean authorHasMoreBooks = books.stream()
                    .anyMatch(b -> b.getAuthor().equals(book.getAuthor()));

            if (!authorHasMoreBooks) {
                uniqueAuthors.remove(book.getAuthor());
            }

            authorStatistics.computeIfPresent(book.getAuthor(), (key, count) -> count > 1 ? count - 1 : null);
        }
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());
    }

    public void printAllBooks() {
        System.out.println("All books in the library:");
        books.forEach(System.out::println);
    }

    public void printUniqueAuthors() {
        System.out.println("Unique authors in the library:");
        uniqueAuthors.forEach(System.out::println);
    }

    public void printAuthorStatistics() {
        System.out.println("Author statistics (number of books per author):");
        authorStatistics.forEach((author, count) ->
                System.out.println(author + ": " + count + " book(s)"));
    }
}