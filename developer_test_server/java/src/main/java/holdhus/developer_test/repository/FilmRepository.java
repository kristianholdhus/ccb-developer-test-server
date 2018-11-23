package holdhus.developer_test.repository;

import org.springframework.data.repository.CrudRepository;

import holdhus.developer_test.entity.Film;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FilmRepository extends CrudRepository<Film, Integer> {

}