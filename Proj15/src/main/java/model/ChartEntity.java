package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "charts", schema = "public", catalog = "cinema")
public class ChartEntity {
    private Integer id;
    private String name;
    private LocalDate creationDate;
    private List<ChartMovieEntity> movies = new ArrayList<>();

    public ChartEntity() {
    }

    public ChartEntity(String name, LocalDate creationDate, List<ChartMovieEntity> movies) {
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    public List<ChartMovieEntity> getMovies()
    {

        return movies;

    }

    public void setMovies(List<ChartMovieEntity> movies) {
        this.movies = movies;
    }

    public void addMovie(ChartMovieEntity chartMovieEntity)
    {
        this.movies.add(chartMovieEntity);
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
