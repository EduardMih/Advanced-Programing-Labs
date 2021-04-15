CREATE TABLE public.movies
(
    id serial NOT NULL,
    title text NOT NULL,
    release_date date,
    duration integer,
    score smallint,
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
