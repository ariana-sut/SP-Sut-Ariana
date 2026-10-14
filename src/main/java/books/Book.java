package books;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        super.add(element);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
        for (Element child : children) {
            child.accept(visitor);
        }
    }
}