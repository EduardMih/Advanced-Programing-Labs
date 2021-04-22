package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "movies", schema = "public", catalog = "cinema")
@NamedQueries({@NamedQuery(name = "MoviesEntity.findByName",
query = "SELECT m FROM MovieEntity m WHERE m.title = :name"),
@NamedQuery(name = "MoviesEntity.findById", query = "SELECT m FROM MovieEntity  m WHERE m.id = :id")})
public class MovieEntity {
    private Integer id;
    private String title;
    private Date releaseDate;
    private Integer duration;
    private Float score;

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "score")
    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(duration, that.duration) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, duration, score);
    }

    @Override
    public String toString()
    {

        return "MoviesEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", score=" + score +
                '}';

    }
}
