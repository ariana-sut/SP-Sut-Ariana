package books;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@jakarta.persistence.Table(name = "book_table")
@NoArgsConstructor(force = true)
public class BookTable extends Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    public BookTable(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void print() {
        System.out.println("Table with title: " + title);
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }
}