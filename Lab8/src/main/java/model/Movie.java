//Hamza Eduard-Mihail, 2A4
package model;

import java.time.LocalDate;
import java.util.Date;

public class Movie {
    private Integer id;
    private String title;
    private Date releaseDate;
    private Integer duration;
    private Short score;

    public Movie() {
    }

    public Movie(String title, Date releaseDate, Integer duration, Short score) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {

        return title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {

        return releaseDate;

    }

    public void setReleaseDate(Date releaseDate) {

        this.releaseDate = releaseDate;

    }

    public Integer getDuration() {

        return duration;

    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Short getScore() {

        return score;

    }

    public void setScore(Short score) {
        this.score = score;
    }

    @Override
    public String toString() {

        return "model.Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", score=" + score +
                '}';

    }
}
