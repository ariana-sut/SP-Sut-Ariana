package books;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paragraph")
@NoArgsConstructor(force = true)
public class Paragraph extends Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    @Transient
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(this, null);
        } else {
            System.out.println("Paragraph: " + text);
        }
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
        visitor.visitParagraph(this);
    }
}