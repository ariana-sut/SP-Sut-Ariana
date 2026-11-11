package books.observer;

import books.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject implements Subject {
    private final List<Observer> observerCollection = new ArrayList<>();
    private Book book;

    @Override
    public void registerObserver(Observer observer) {
        observerCollection.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observerCollection.remove(observer);
    }

    @Override
    public void notifyObservers() {
        List<Observer> failedObservers = new ArrayList<>();
        for (Observer observer : observerCollection) {
            try {
                if (observer instanceof SseObserver) {
                    ((SseObserver) observer).setBook(book);
                }
                observer.update(book);
            } catch (Exception e) {
                failedObservers.add(observer);
            }
        }
        observerCollection.removeAll(failedObservers);
    }

    public void add(Book book) {
        this.book = book;
        notifyObservers();
    }
}