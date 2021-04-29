package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chart_movies")
public class ChartMovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "movie_id", referencedColumnName = "ID")
    @ManyToOne
    private MovieEntity movie;

    @JoinColumn(name = "chart_id", referencedColumnName = "ID")
    @ManyToOne
    private ChartEntity chart;

    public ChartMovieEntity() {
    }

    public ChartMovieEntity(MovieEntity movie) {
        this.movie = movie;
    }

    public ChartMovieEntity(MovieEntity movie, ChartEntity chart) {
        this.movie = movie;
        this.chart = chart;
    }

    public Integer getId()
    {

        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieEntity getMovie()
    {

        return movie;

    }

    public void setMovie(MovieEntity movie) {
        this.movie = movie;
    }

    public ChartEntity getChart()
    {

        return chart;

    }

    public void setChart(ChartEntity chart) {
        this.chart = chart;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartMovieEntity that = (ChartMovieEntity) o;

        return id.equals(that.id) && movie.equals(that.movie) && chart.equals(that.chart);

    }

    @Override
    public int hashCode()
    {

        return Objects.hash(id, movie, chart);

    }

    @Override
    public String toString()
    {

        return "ChartMovieEntity{" +
                "id=" + id +
                ", movie=" + movie +
                ", chart=" + chart +
                '}';

    }
}
