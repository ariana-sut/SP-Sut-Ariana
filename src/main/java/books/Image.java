package books;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "image")
@NoArgsConstructor(force = true)
public class Image extends Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imageName;

    public Image(String name) {
        this.imageName = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return id;
    }

    public String getImageName() {
        return imageName;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + imageName);
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
        visitor.visitImage(this);
    }
}