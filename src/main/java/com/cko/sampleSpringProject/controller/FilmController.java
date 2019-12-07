package com.cko.sampleSpringProject.controller;
import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class FilmController {
    @Autowired
    FilmDAO filmDAO;

    @GetMapping("/allFilm")
    public ModelAndView allFilms() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allFilm");
        List<Film> filmsList = filmDAO.findAll();
        modelAndView.addObject("films", filmsList);
        return modelAndView;
    }

    @GetMapping("/createFilm")
    public String crFilms() {
        return "createFilms";
    }

    @PostMapping("/createFilm")
    public RedirectView addNewFilm(Film film) {
        filmDAO.save(film);
        return new RedirectView( "/allFilm");
    }

    @GetMapping("/editFilm")
    public ModelAndView edFilms(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById(id);
        modelAndView.addObject("film", film);
        modelAndView.setViewName("editFilm");
        return modelAndView;
    }

    @PostMapping("/editFilm")
    public RedirectView editFilm(Film film) {
        filmDAO.save(film);
        return new RedirectView( "/allFilm");
    }

    @GetMapping("/tesT")
    public ModelAndView testT(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Film film = filmDAO.findFilmById(id);
        modelAndView.addObject("film", film);
        modelAndView.setViewName("test");
        return modelAndView;
    }
    @GetMapping("/deleteFilm")
    public RedirectView delete(@RequestParam long id){
       filmDAO.deleteById(id);
        return new RedirectView("/allFilm");
    }


}
