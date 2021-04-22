//Hamza Eduard-Mihail, 2A4
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {
    private Integer id;
    private String title;
    private Date releaseDate;
    private Integer duration;
    private Float score;
    private List<Genre> genres = new ArrayList<>();
    private List<Person> actors = new ArrayList<>();
    private List<Person> directors = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title, Date releaseDate, Integer duration, Float score, List<Genre> genres) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
        this.genres = genres;
    }

    public Movie(String title, Date releaseDate, Integer duration, Float score, List<Genre> genres, List<Person> actors, List<Person> directors) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.score = score;
        this.genres = genres;
        this.actors = actors;
        this.directors = directors;
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

    public Float getScore() {

        return score;

    }

    public void setScore(Float score) {
        this.score = score;
    }

    public List<Genre> getGenres()
    {

        return genres;

    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Person> getActors()
    {

        return actors;

    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
    }

    public List<Person> getDirectors()
    {

        return directors;

    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    @Override
    public String toString()
    {

        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", score=" + score +
                ", genres=" + genres +
                ", actors=" + actors +
                ", directors=" + directors +
                '}';

    }
}
