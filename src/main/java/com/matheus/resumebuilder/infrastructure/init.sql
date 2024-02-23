DROP DATABASE IF EXISTS resumebuilder;
CREATE DATABASE resumebuilder;

\c resumebuilder;

CREATE TABLE IF NOT EXISTS resume(
    id UUID PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS sentence(
    id UUID PRIMARY KEY,
    resume_id UUID,
    FOREIGN KEY (resume_id) REFERENCES resume(id),
    text VARCHAR(1000),
    sentence_type VARCHAR(20)
);
