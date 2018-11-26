# Developer Test Server

This is a simple test service, written in Java with SpringBoot, that queries a backend MySQL instance.

## Running the Service

Within the developer-test-server directory is a DockerCompose file. It starts up a MySQL instance and the Java service that fronts it.

To the start the service run:
```sh
$ cd developer-test-server
$ docker-compose build
$ docker-compose up -d
```

Check the status of the starting service by checking the logs:
```sh
docker-compose logs -f
```

## Querying the service

The service makes the following rest APIs available:

**Get all films:**
```
http://localhost:8080/films
```

**Get films by title substring:**
```
http://localhost:8080/films?titleContains=Dinosaur
```

**Get films by category:**
```
http://localhost:8080/films?category=Classics
```

**Get films by rating:**
```
http://localhost:8080/films?rating=PG
```

**Get films by combination search:**
```
http://localhost:8080/films?titleContains=dinosaur&rating=PG&category=classics
```

**Get a single film:**
```
http://localhost:8080/film/131
```

**Get the description of a film:**
```
http://localhost:8080/film/131/description
```

**Get the actors of a film:**
```
http://localhost:8080/film/131/actors
```

## TODO

The following improvements can still be made to the service:

- **Don't store the database password in source code**: This is just a test database with test data - and a foobar password. However, if this was ever to run in production, the password should be retrieved from a configuration service, rather than being stored in source code.
- **Add pagination for bulk film results**: The REST API method for retrieving all films can be modified to return pages of results. Returning entire contents of DB table does not scale - and can brown out or DOS the backend DB.
- **Entity objects need better attribute validation (nullability, size contraints)**: If the service were ever to accept writes of entities to the database, validating entity attributes for nullability and size constraints would be important, in order to fail sooner than when the MySQL rejects the input with cryptic constraint violation exception.
- **Support better film title searches**: The title currently only supports substring matching (using SQL LIKE query). Better matching can be done using a MySQL dialect for JPA and the MATCH + AGAINST queries that MySQL supports. Alternatively database entities could be indexed in a search/indexing service like Lucene if search load needs to be removed from MySQL.
- **Implement better customer facing error messages**: The service currently outputs raws errors on failure. Better error handling is needed for expected failures related to bad REST parameters and inputs from clients.
