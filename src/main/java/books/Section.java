package books;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(force = true)
public class Section extends Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    protected String title;

    @OneToMany(cascade = CascadeType.ALL)
    protected List<Element> children = new ArrayList<>();

    public Section(String title) {
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
        System.out.println(title);
        for (Element child : children) {
            child.print();
        }
    }

    @Override
    public void add(Element element) {
        children.add(element);
    }

    @Override
    public void remove(Element element) {
        children.remove(element);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
        for (Element child : children) {
            child.accept(visitor);
        }
    }
}