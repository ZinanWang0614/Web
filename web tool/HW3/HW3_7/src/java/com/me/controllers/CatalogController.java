/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.dao.ItemDAO;
import com.me.pojo.Item;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author zinanwang
 */
public class CatalogController extends AbstractController {

    public CatalogController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        //shopping 
        Set<Item> cart;
        if (null != (Set<Item>) session.getAttribute("cart")) {
            cart = (Set<Item>) session.getAttribute("cart");
        } else {
            cart = new HashSet<Item>();
        }

        Set<Item> store;
        if (null != (Set<Item>) request.getAttribute("store")) {
            store = (Set<Item>) request.getAttribute("store");
        } else {
            store = new HashSet<Item>();
        }

        if (action.equals("books")) {
            request.setAttribute("List", new ItemDAO().getBookItems());
            request.setAttribute("type", "books");
            return new ModelAndView("catalogview");
        } else if (action.equals("music")) {
            request.setAttribute("List", new ItemDAO().getMusicItems());
            request.setAttribute("type", "music");
            return new ModelAndView("catalogview");
        } else if (action.equals("computers")) {
            request.setAttribute("List", new ItemDAO().getComputerItems());
            request.setAttribute("type", "computers");
            return new ModelAndView("catalogview");
        } else if (action.equals("add")) {

            String[] names = request.getParameterValues("content");

            if (names != null) {
                for (String name : names) {

                    for (Item item : new ItemDAO().getBookItems()) {
                        if (name.equals(item.getName())) {
                            cart.add(item);
                            store.add(item);
                        }
                    }

                    for (Item item : new ItemDAO().getMusicItems()) {
                        if (name.equals(item.getName())) {
                            cart.add(item);
                            store.add(item);
                        }
                    }

                    for (Item item : new ItemDAO().getComputerItems()) {
                        if (name.equals(item.getName())) {
                            cart.add(item);
                            store.add(item);
                        }
                    }

                }
            }else{
                return new ModelAndView("Added");
            }

            session.setAttribute("cart", cart);
            request.setAttribute("store", store);
            return new ModelAndView("Added");
        }else if (action.equals("view")) {
            return new ModelAndView("cart");
        }

        return new ModelAndView("index");
    }

}
