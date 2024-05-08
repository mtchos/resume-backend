ALTER USER postgres PASSWORD 'postgres';

DROP DATABASE IF EXISTS resumebuilder;
CREATE DATABASE resumebuilder;

\c resumebuilder;

CREATE TYPE title_content AS
(
    title   VARCHAR(50),
    content VARCHAR(300)
);

CREATE TYPE title_contents AS
(
    title    VARCHAR(50),
    contents VARCHAR(50)[]
);

CREATE TABLE IF NOT EXISTS person
(
    id         UUID PRIMARY KEY,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    username   VARCHAR(50) NOT NULL,
    first_name  VARCHAR(50),
    last_name   VARCHAR(50),
    email      VARCHAR(255),
    password   VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS resume
(
    id         UUID PRIMARY KEY,
    person_id  UUID        NOT NULL REFERENCES person (id),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    code       VARCHAR(50) NOT NULL,
    header     VARCHAR(50) NOT NULL,
    role       VARCHAR(50) NOT NULL,
    is_active  BOOLEAN DEFAULT TRUE
);


CREATE TABLE IF NOT EXISTS info
(
    id         UUID PRIMARY KEY,
    resume_id  UUID        NOT NULL REFERENCES resume (id),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    header     VARCHAR(50) NOT NULL,
    phone      VARCHAR(50),
    location   VARCHAR(50),
    email      VARCHAR(50),
    linkedin   VARCHAR(50),
    website    VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS summary
(
    id         UUID PRIMARY KEY,
    resume_id  UUID        NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    header     VARCHAR(50) NOT NULL,
    content    VARCHAR(1200)
);

CREATE TABLE IF NOT EXISTS skill
(
    id         UUID PRIMARY KEY,
    resume_id  UUID        NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    header     VARCHAR(50) NOT NULL,
    content    title_contents
);

CREATE TABLE IF NOT EXISTS experience
(
    id            UUID PRIMARY KEY,
    resume_id     UUID        NOT NULL REFERENCES resume (id),
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    updated_at    TIMESTAMP WITHOUT TIME ZONE,
    header        VARCHAR(50) NOT NULL,
    role          VARCHAR(50),
    company       VARCHAR(50),
    location      VARCHAR(50),
    start_date    DATE,
    end_date      DATE,
    bullet_points VARCHAR(300)[],
    skills        VARCHAR(50)[]
);

CREATE TABLE IF NOT EXISTS education
(
    id            UUID PRIMARY KEY,
    resume_id     UUID        NOT NULL REFERENCES resume (id),
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    updated_at    TIMESTAMP WITHOUT TIME ZONE,
    header        VARCHAR(50) NOT NULL,
    course        VARCHAR(50),
    institution   VARCHAR(50),
    location      VARCHAR(50),
    start_date    DATE,
    end_date      DATE,
    bullet_points VARCHAR(300)[],
    courses       title_contents
);

CREATE TABLE IF NOT EXISTS course
(
    id          UUID PRIMARY KEY,
    resume_id   UUID        NOT NULL REFERENCES resume (id),
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    header      VARCHAR(50) NOT NULL,
    course      VARCHAR(50),
    institution VARCHAR(50),
    location    VARCHAR(50),
    end_date    DATE
);

CREATE TABLE IF NOT EXISTS language
(
    id         UUID PRIMARY KEY,
    resume_id  UUID NOT NULL REFERENCES resume (id),
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    languages  title_content
);
