package holdhus.developer_test.entity;

import java.math.BigDecimal;

import javax.annotation.Generated;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FID")
    private Integer filmId;

    private String title; // Max 255 chars

    private String category; // Max 25 chars - Nonnull

    private BigDecimal price; // Decimal(4,2)

    private Integer length; // smallint(5) unsigned

    @Convert(converter = RatingConverter.class)
    @JsonSerialize(using = RatingConverter.JsonSerializer.class)
    @JsonDeserialize(using = RatingConverter.JsonDeserializer.class)
    private Rating rating; // enum('G','PG','PG-13','R','NC-17')

    // Provided for JPA bean-initialization
    public Film() {}

    public Film(Integer filmId, String title, String description, String category, BigDecimal price, Integer length,
            Rating rating, String actors) {
        super();
        this.filmId = filmId;
        this.title = title;
        this.category = category;
        this.price = price;
        this.length = length;
        this.rating = rating;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Generated("Eclipse")
    @Override
    public String toString() {
        return "Film [filmId=" + filmId + ", title=" + title + ", category=" + category
                + ", price=" + price + ", length=" + length + ", rating=" + rating + "]";
    }

}
