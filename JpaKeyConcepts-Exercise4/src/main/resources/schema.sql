DROP SEQUENCE IF EXISTS public.author_sequence;
DROP SEQUENCE IF EXISTS public.book_sequence;
DROP SEQUENCE IF EXISTS public.publisher_sequence;

DROP TABLE IF EXISTS public.book_authors;
DROP TABLE IF EXISTS public.author;
DROP TABLE IF EXISTS public.book;
DROP TABLE IF EXISTS public.publisher;

CREATE SEQUENCE public.author_sequence INCREMENT 50 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;
CREATE SEQUENCE public.book_sequence INCREMENT 50 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;
CREATE SEQUENCE public.publisher_sequence INCREMENT 50 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE public.author (id bigint NOT NULL, first_name character varying(255) COLLATE pg_catalog."default", last_name character varying(255) COLLATE pg_catalog."default", version integer NOT NULL, CONSTRAINT author_pkey PRIMARY KEY (id));
CREATE TABLE public.publisher (id bigint NOT NULL, name character varying(255) COLLATE pg_catalog."default", version integer NOT NULL, CONSTRAINT publisher_pkey PRIMARY KEY (id));
CREATE TABLE public.book (id bigint NOT NULL, publishing_date date, title character varying(255) COLLATE pg_catalog."default", version integer NOT NULL, publisher_id bigint, CONSTRAINT book_pkey PRIMARY KEY (id), CONSTRAINT fkgtvt7p649s4x80y6f4842pnfq FOREIGN KEY (publisher_id) REFERENCES public.publisher (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION);
CREATE TABLE public.book_authors (books_id bigint NOT NULL, authors_id bigint NOT NULL, CONSTRAINT book_authors_pkey PRIMARY KEY (books_id, authors_id), CONSTRAINT fk551i3sllw1wj7ex6nir16blsm FOREIGN KEY (authors_id) REFERENCES public.author (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION, CONSTRAINT fkmuhqocx8etx13u6jrtutnumek FOREIGN KEY (books_id) REFERENCES public.book (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION);