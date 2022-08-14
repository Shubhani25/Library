-- Table: public.reader

-- DROP TABLE IF EXISTS public.reader;

CREATE TABLE IF NOT EXISTS public.reader
(
    id integer NOT NULL ,
    reader_id integer NOT NULL,
    book_id integer NOT NULL,
    reader_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    reader_email character varying(25) COLLATE pg_catalog."default" NOT NULL,
    reader_phone character varying(25) COLLATE pg_catalog."default" NOT NULL,
    issue_date date NOT NULL,
    return_date date NOT NULL,
    CONSTRAINT reader_pkey PRIMARY KEY (id),
    CONSTRAINT reader_book_id UNIQUE (reader_id, book_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.reader
    OWNER to postgres;

-- Table: public.book

-- DROP TABLE IF EXISTS public.book;

CREATE TABLE IF NOT EXISTS public.book
(
    id integer NOT NULL ,
    book_id integer NOT NULL,
    book_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    book_author character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT book_pkey PRIMARY KEY (id),
    CONSTRAINT book_id FOREIGN KEY (book_id)
        REFERENCES public.reader (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.book
    OWNER to postgres;