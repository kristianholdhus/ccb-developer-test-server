package holdhus.developer_test.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class FilmDescription {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "film_id")
    private Integer filmId;

    private String description; // DB type: Text

    // Provided for JPA bean-initialization
    @SuppressWarnings("unused")
    private FilmDescription() {}

    public FilmDescription(Integer filmId, String description) {
        this.filmId = filmId;
        this.description = description;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public String getDescription() {
        return description;
    }

    @Generated("Eclipse")
    @Override
    public String toString() {
        return "FilmDescription [filmId=" + filmId + ", description=" + description + "]";
    }

}
