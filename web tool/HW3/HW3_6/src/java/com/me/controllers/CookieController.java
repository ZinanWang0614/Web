/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author zinanwang
 */
public class CookieController extends AbstractController {

    public CookieController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {

            if (c.getName().equals("username1")) {
                return new ModelAndView("searchCourse");
            }

        }
        return new ModelAndView("login");
    }

}
