package books;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    public abstract void print();
    public abstract void add(Element element);
    public abstract void remove(Element element);
    public abstract Element get(int index);
    public abstract void accept(Visitor visitor);
}