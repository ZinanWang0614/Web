/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author zinanwang
 */
public class LoginController extends AbstractController {

    public LoginController() {
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(true);

        String action = request.getParameter("action");

        if (action.equals("login")) {
            String rem = request.getParameter("rememberMe");

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            String valid = getUser(username, password);

            if (valid != null) {

                if (rem != null) {

                    Cookie username1 = new Cookie("username1", username);
                    response.addCookie(username1);

                }

                session.setAttribute("username", valid);
                return new ModelAndView("searchCourse");
            } else {
                return new ModelAndView("login");
            }
        }else if (action.equals("logout")) {
            session.invalidate();
            return new ModelAndView("login");
        }
        
        return new ModelAndView("login");
    }

    public String getUser(String username, String password) {

        if (username.equals("admin") && password.equals("admin")) {
            return username;
        } else {
            return null;
        }

    }

}
