package books.persistence;

import books.Book;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class BooksJpaAdapter implements CrudRepository<Book, Integer> {

    private final BooksRepository booksRepository;

    public BooksJpaAdapter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return booksRepository.findById(id);
    }

    @Override
    public Book save(Book entity) {
        return booksRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        booksRepository.deleteById(id);
    }
}