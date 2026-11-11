package books.observer;

import books.Book;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class SseObserver implements Observer {
    private final SseEmitter emitter;
    private Book book;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (IOException e) {
            emitter.completeWithError(e);
        }
    }
}