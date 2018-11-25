package holdhus.developer_test.repository;


import org.springframework.data.repository.CrudRepository;

import holdhus.developer_test.entity.FilmDescription;

// This will be AUTO IMPLEMENTED by Spring into a Bean called filmDescriptionRepository

public interface FilmDescriptionRepository extends CrudRepository<FilmDescription, Integer> {

}
