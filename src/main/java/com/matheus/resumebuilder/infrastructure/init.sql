ALTER USER postgres PASSWORD 'postgres';

DROP DATABASE IF EXISTS resumebuilder;
CREATE DATABASE resumebuilder;

\c resumebuilder;

CREATE TYPE titled_contents AS
(
    title    VARCHAR(50),
    contents VARCHAR(300)[]
);

CREATE TYPE titled_keywords AS
(
    title    VARCHAR(50),
    keywords VARCHAR(50)[]
);

CREATE TABLE IF NOT EXISTS person
(
    id         UUID PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE,
    username   VARCHAR(50) NOT NULL,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    email      VARCHAR(255),
    password   VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS resume
(
    id         UUID PRIMARY KEY,
    person_id  UUID NOT NULL REFERENCES person (id),
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE,
    code       VARCHAR(50),
    header     VARCHAR(50),
    role       VARCHAR(50),
    is_active  BOOLEAN DEFAULT TRUE
);


CREATE TABLE IF NOT EXISTS info
(
    id         UUID PRIMARY KEY,
    resume_id  UUID NOT NULL REFERENCES resume (id),
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE,
    header     VARCHAR(50),
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
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE,
    header     VARCHAR(50) NOT NULL,
    content    VARCHAR(1200)
);

CREATE TABLE IF NOT EXISTS skill
(
    id         UUID PRIMARY KEY,
    resume_id  UUID        NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE,
    header     VARCHAR(50) NOT NULL,
    content    titled_contents
);

CREATE TABLE IF NOT EXISTS experience
(
    id            UUID PRIMARY KEY,
    resume_id     UUID        NOT NULL REFERENCES resume (id),
    created_at    TIMESTAMP WITH TIME ZONE,
    updated_at    TIMESTAMP WITH TIME ZONE,
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
    created_at    TIMESTAMP WITH TIME ZONE,
    updated_at    TIMESTAMP WITH TIME ZONE,
    header        VARCHAR(50) NOT NULL,
    course        VARCHAR(50),
    institution   VARCHAR(50),
    location      VARCHAR(50),
    start_date    DATE,
    end_date      DATE,
    bullet_points VARCHAR(300)[],
    courses       titled_contents
);

CREATE TABLE IF NOT EXISTS course
(
    id          UUID PRIMARY KEY,
    resume_id   UUID        NOT NULL REFERENCES resume (id),
    created_at  TIMESTAMP WITH TIME ZONE,
    updated_at  TIMESTAMP WITH TIME ZONE,
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
    created_at TIMESTAMP WITH TIME ZONE,
    updated_at TIMESTAMP WITH TIME ZONE,
    languages  titled_keywords
);
