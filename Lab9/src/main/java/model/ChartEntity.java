package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "charts", schema = "public", catalog = "cinema")
@NamedQueries({@NamedQuery(name = "ChartEntity.findByName",
        query = "SELECT c FROM ChartEntity c WHERE c.name = :name"),
@NamedQuery(name = "ChartEntity.findById", query = "SELECT c FROM ChartEntity c WHERE c.id = :id")})
public class ChartEntity {
    private Integer id;
    private String name;
    private LocalDate creationDate;
    private List<MovieEntity> movies = new ArrayList<>();

    public ChartEntity() {
    }

    public ChartEntity(String name, LocalDate creationDate, List<MovieEntity> movies) {
        this.name = name;
        this.creationDate = creationDate;
        this.movies = movies;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId()
    {

        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName()
    {

        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "creation_date")
    public LocalDate getCreationDate()
    {

        return creationDate;

    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @ManyToMany
    @JoinTable(name = "chart_movies",
    joinColumns = @JoinColumn(name = "chart_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id"))
    public List<MovieEntity> getMovies()
    {

        return movies;

    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }

    public void addMovie(MovieEntity movie)
    {
        this.movies.add(movie);
    }

    @Override
    public String toString()
    {

        return "ChartEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", movies=" + movies +
                '}';

    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartEntity that = (ChartEntity) o;

        return id.equals(that.id) && name.equals(that.name) && Objects.equals(creationDate, that.creationDate) && Objects.equals(movies, that.movies);

    }

    @Override
    public int hashCode()
    {

        return Objects.hash(id, name, creationDate, movies);

    }
}
