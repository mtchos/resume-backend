DROP DATABASE IF EXISTS resumebuilder;
CREATE DATABASE resumebuilder;

\c resumebuilder;

CREATE TABLE IF NOT EXISTS person(
    id UUID PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30),
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS resume(
    id UUID PRIMARY KEY,
    person_id UUID NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id),
    name VARCHAR(30) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS section(
    id UUID PRIMARY KEY,
    resume_id UUID NOT NULL,
    FOREIGN KEY (resume_id) REFERENCES resume(id),
    content_type VARCHAR(15) NOT NULL,
    display_order INT
);

CREATE TABLE IF NOT EXISTS content(
    id UUID PRIMARY KEY,
    section_id UUID NOT NULL,
    FOREIGN KEY (section_id) REFERENCES section(id),
    content VARCHAR(200) NOT NULL,
    place VARCHAR(30),
    location VARCHAR(30),
    start_date VARCHAR(20),
    end_date VARCHAR(20)
);
