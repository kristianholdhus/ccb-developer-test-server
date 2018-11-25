package holdhus.developer_test.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import holdhus.developer_test.entity.Film;
import holdhus.developer_test.entity.FilmDescription;
import holdhus.developer_test.repository.FilmDescriptionRepository;
import holdhus.developer_test.repository.FilmRepository;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmDescriptionRepository filmDescriptionRepository;

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/{id}")
    public @ResponseBody Optional<Film> getFilm(@PathVariable("id") int filmId) {
        return filmRepository.findById(filmId);
    }

    @GetMapping("/{id}/description")
    public @ResponseBody Optional<FilmDescription> getFilmDescription(@PathVariable("id") int filmId) {
        return filmDescriptionRepository.findById(filmId);
    }

}
