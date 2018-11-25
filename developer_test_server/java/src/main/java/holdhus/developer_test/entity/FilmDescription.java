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
    private Integer id;

    private String description; // DB type: Text

    // Provided for JPA bean-initialization
    @SuppressWarnings("unused")
    private FilmDescription() {}

    public FilmDescription(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Generated("Eclipse")
    @Override
    public String toString() {
        return "FilmDescription [id=" + id + ", description=" + description + "]";
    }

}
