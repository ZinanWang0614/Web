/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.dao.MovieDAO;
import com.me.pojo.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author zinanwang
 */
public class MovieController extends AbstractController {

    public MovieController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action.equals("add")) {
            return new ModelAndView("addmovie");
        } else {
            ArrayList<Movie> movieList = new MovieDAO().getMovies();
            Map<String, Object> map = new HashMap<>();

            map.put("action", action);
            map.put("movieList", movieList);
            return new ModelAndView("movie", "map", map);
        }

    }

}
