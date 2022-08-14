CREATE TABLE IF NOT EXISTS reader
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
);

CREATE TABLE IF NOT EXISTS book
(
    id integer NOT NULL ,
    book_id integer NOT NULL,
    book_name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    book_author character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT book_pkey PRIMARY KEY (id),
    CONSTRAINT book_id FOREIGN KEY (book_id)
        REFERENCES reader (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);