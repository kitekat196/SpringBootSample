package com.cko.sampleSpringProject.controller;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;


@Controller
public class FilmController {
    @Autowired
    FilmDAO filmDAO;

    @GetMapping("/allFilm")
    public String allFilms(){

        return "allFilm";
    }
    @GetMapping("/createFilm")
    public String crFilms(){
        return "createFilms";
    }

    @PostMapping("/createFilm")
    public String addNewFilm(Film film){
        filmDAO.save(film);
        return "allFilm";
    }

    @GetMapping("/editFilm")
    public ModelAndView edFilms(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById(id);
        modelAndView.addObject("film", film);
        modelAndView.setViewName("editFilm");
        return modelAndView;
    }
    @PostMapping("/editFilm")
    public String editFilm(Film film){
        filmDAO.save(film);
        return "allFilm";
    }
}
