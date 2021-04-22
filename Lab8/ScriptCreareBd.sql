DROP TABLE movies;
DROP TABLE genres;
DROP TABLE persons;
DROP TABLE movie_actors;
DROP TABLE movie_directors;
DROP TABLE movie_genre;
CREATE TABLE public.movies
(
    id serial NOT NULL,
    title text NOT NULL,
    release_date date,
    duration integer,
    score real,
    PRIMARY KEY (id)
);

ALTER TABLE public.movies
    OWNER to postgres;

CREATE TABLE public.genres
(
    id serial NOT NULL,
    name text NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.genres
    OWNER to postgres;

CREATE TABLE public.movie_genre
(
    movie_id integer NOT NULL,
    genre_id integer NOT NULL
);

ALTER TABLE public.movie_genre
    OWNER to postgres;

CREATE TABLE public.persons
(
    id serial NOT NULL,
    name text NOT NULL,
    birth_name text,
    spouses_string text,
    PRIMARY KEY (id)
);

ALTER TABLE public.persons
    OWNER to postgres;

CREATE TABLE public.movie_directors
(
    movie_id integer NOT NULL,
    person_id integer NOT NULL
);

ALTER TABLE public.movie_directors
    OWNER to postgres;

CREATE TABLE public.movie_actors
(
    movie_id integer NOT NULL,
    person_id integer NOT NULL
);

ALTER TABLE public.movie_actors
    OWNER to postgres;
