package kz.spring.movie_notes.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "films")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    @GenericGenerator(
            name = "movie_sequence",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "movie_sequence", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "5"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "link")
    private String link;

    public Film(String title) {
        this.title = title;
    }

    public Film(String title, String link) {
        this.title = title;
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
