package books;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "author")
@NoArgsConstructor(force = true)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Author(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("Author: " + name);
    }
}