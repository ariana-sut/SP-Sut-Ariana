package books.observer;

import books.Book;

public interface Observer {
    void update(Book book);
}