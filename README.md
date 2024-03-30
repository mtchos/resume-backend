# Resume Builder

A website that assists you in writing crispy resumes that will eventually make you rich.

## How to run

The project is divided in three parts.

- The database runs inside a **Docker** image.

- The backend is a **Spring Boot** project managed by **Maven**.

- The frontend is **Next.js** project managed by **npm**.

## The database

Create the docker image:

```bash
$ docker build -t resume-database-image -f src/main/java/com/matheus/resumebuilder/infrastructure/Dockerfile .
```

Run the container:

```bash
$ docker run --rm --name resume-database-container -p 5432:5432 resume-database-image
```

Run the database initialization script:

```bash
docker exec -i resume-database-container psql -U postgres < src/main/java/com/matheus/resumebuilder/infrastructure/init.sql
```

## License

[MIT](https://choosealicense.com/licenses/mit/)