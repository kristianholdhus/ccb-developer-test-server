package holdhus.developer_test.entity;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class FilmActors {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "film_id")
    private Integer filmId;

    @OneToMany
    @JoinTable(name="film_actor",
               joinColumns = @JoinColumn(name = "film_id", referencedColumnName="film_id"),
               inverseJoinColumns= @JoinColumn(name="actor_id", referencedColumnName="actor_id"))
    private Set<Actor> actors;

    // Provided for JPA bean-initialization
    public FilmActors() {}

    public FilmActors(Integer filmId, Set<Actor> actors) {
        super();
        this.filmId = filmId;
        this.actors = actors;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Generated("Eclipse")
    @Override
    public String toString() {
        return "FilmActors [filmId=" + filmId + ", actors=" + actors + "]";
    }


}
