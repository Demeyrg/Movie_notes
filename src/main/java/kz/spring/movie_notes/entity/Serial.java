package kz.spring.movie_notes.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "serials")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Serial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "link")
    private String link;

    public Serial(String title) {
        this.title = title;
    }

    public Serial(String title, String link) {
        this.title = title;
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serial serial = (Serial) o;
        return Objects.equals(id, serial.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
