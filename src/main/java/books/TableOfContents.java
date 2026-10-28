package books;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "table_of_contents")
@NoArgsConstructor(force = true)
public class TableOfContents extends Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    @Override
    public void print() {
        System.out.println("TableOfContents");
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
        visitor.visitTableOfContents(this);
    }
}