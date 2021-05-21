CREATE TABLE BOOK(
id bigint NOT NULL,
publishingdate date,
title character varying(255),
author character varying(255),
price double precision,
version integer,
CONSTRAINT book_pkey PRIMARY KEY(id)
);

CREATE SEQUENCE book_seq INCREMENT 1 MINVALUE 100 MAXVALUE 9223372036854775807 START 100 CACHE 1;

--INSERT INTO book VALUES (1, '2017-04-04', 'Hibernate Tips - More than 70 solutions to common Hibernate problems', 'Janssen, Thorben', 9.99, 0);