package holdhus.developer_test.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import holdhus.developer_test.converter.RatingConverter;

@Entity
@Table(name = "film_list")
public class Film {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "FID")
    private Integer id;

    private String title; // Max 255 chars

    private String description; // Text

    private String category; // Max 25 chars - Nonnull

    private BigDecimal price; // Decimal(4,2)

    private int length; // smallint(5) unsigned

    @Convert(converter = RatingConverter.class)
    @JsonSerialize(using = RatingConverter.JsonSerializer.class)
    @JsonDeserialize(using = RatingConverter.JsonDeserializer.class)
    private Rating rating; // enum('G','PG','PG-13','R','NC-17')

    private String actors; // Text

    // Provided for JPA bean-initialization
    @SuppressWarnings("unused")
    private Film() {}

    public Film(Integer id, String title, String description, String category, BigDecimal price, int length,
            Rating rating, String actors) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.length = length;
        this.rating = rating;
        this.actors = actors;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getLength() {
        return length;
    }

    public Rating getRating() {
        return rating;
    }

    public String getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Film [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
                + ", price=" + price + ", length=" + length + ", rating=" + rating + ", actors=" + actors + "]";
    }

}