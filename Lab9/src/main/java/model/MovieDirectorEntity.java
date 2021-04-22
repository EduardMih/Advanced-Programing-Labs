package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_directors", schema = "public", catalog = "cinema")
public class MovieDirectorEntity {
    private Long id;
    private Integer movieId;
    private Integer personId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "movie_id")
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "person_id")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDirectorEntity that = (MovieDirectorEntity) o;
        return Objects.equals(movieId, that.movieId) && Objects.equals(personId, that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, personId);
    }
}
