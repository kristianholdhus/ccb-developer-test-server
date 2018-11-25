package holdhus.developer_test.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import holdhus.developer_test.entity.Film;

// This will be AUTO IMPLEMENTED by Spring into a Bean called filmRepository

public interface FilmRepository extends JpaRepository<Film, Integer> {

}
