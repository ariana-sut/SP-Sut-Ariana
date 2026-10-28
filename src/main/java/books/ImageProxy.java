package books;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image_proxy")
@NoArgsConstructor(force = true)
public class ImageProxy extends Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    @Transient
    private Image realImage;

    public ImageProxy(String url) {
        this.url = url;
    }

    private Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    public Integer getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void print() {
        loadImage().print();
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
        visitor.visitImageProxy(this);
    }
}