# Resume Builder

A website that assists you in writing crispy resumes that will eventually make you rich.

## How to run

The project is divided in three parts.

- The database runs inside a [Docker](https://www.docker.com/) image.

- The backend is a [Spring Boot](https://spring.io/projects/spring-boot/) project managed by **Maven**.

- The frontend is [React](https://react.dev/) project managed by **npm**.

- When in doubt run in the order the commands appears.

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