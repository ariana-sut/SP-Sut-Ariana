package books;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import books.persistence.BooksRepository;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner init(BooksRepository booksRepository) {
        return args -> {
            Book book = new Book("Design Patterns");
            Section cap1 = new Section("Capitolul 1");
            Paragraph p1 = new Paragraph("Paragraph 1");
            cap1.add(p1);
            Paragraph p2 = new Paragraph("Paragraph 2");
            cap1.add(p2);
            cap1.add(new ImageProxy("ImageOne"));
            cap1.add(new Image("ImageTwo"));
            cap1.add(new BookTable("Table 1"));

            book.addContent(cap1);
            book.addAuthor(new Author("Erich Gamma"));

            booksRepository.save(book);
            System.out.println("Cartea a fost salvată cu succes în baza de date H2!");

            BookStatistics stats = new BookStatistics();
            book.accept(stats);
            stats.printStatistics();
        };
    }
}