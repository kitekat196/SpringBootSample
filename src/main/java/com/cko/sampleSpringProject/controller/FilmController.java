package com.cko.sampleSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class FilmController {

    @GetMapping("/allFilms")
    public String allFilms(){
        return "allFilm";
    }
    @GetMapping("/allFilm/createFilm")
    public String crFilms(){
        return "createFilms";
    }
    @GetMapping("/allFilm/editFilm")
    public String edFilms(){
        return "editFilm";
    }
}
