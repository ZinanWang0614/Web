/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controllers;

import com.me.dao.CourseDAO;
import com.me.pojo.Course;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
public class CourseController extends AbstractController {

    ArrayList<Course> courseList = new CourseDAO().getCourse();

    public CourseController() {
    }

    @RequestMapping(value = "course", method = RequestMethod.GET)
    public ModelAndView searchCourse(HttpServletRequest request,
            HttpServletResponse response) {

        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);

        //my course list
        Set<Course> myCourses;
        if (null != (Set<Course>) session.getAttribute("myCourseSet")) {
            myCourses = (Set<Course>) session.getAttribute("myCourseSet");
        } else {
            myCourses = new HashSet<Course>();
        }
        // action   
        if (action.equals("search")) {

            String searchType = request.getParameter("searchType");
            String searchQuery = request.getParameter("query");

            ArrayList<Course> searchResults = new ArrayList<Course>();

            if (searchType.equals("crn")) {
                for (Course course : courseList) {
                    if (course.getCrn().equals(searchQuery)) {
                        searchResults.add(course);
                        break;
                    }
                }
            } else if (searchType.equals("title")) {
                for (Course course : courseList) {
                    if (course.getName().contains(searchQuery) || course.getInstructor().contains(searchQuery) || course.getCourseDescription().contains(searchQuery)) {
                        searchResults.add(course);
                    }
                }
            }
            request.setAttribute("searchResults", searchResults);
            return new ModelAndView("courseview");

        } else if (action.equals("add")) {
            String[] crn = request.getParameterValues("crn");

            if (crn != null) {
                for (String coursecrn : crn) {

                    for (Course course : courseList) {
                        if (course.getCrn().equals(coursecrn)) {

                            myCourses.add(course);

                        }
                    }

                }
                session.setAttribute("myCourseSet", myCourses);
                return new ModelAndView("mycourse");
            }else{
                return new ModelAndView("error");
            }

        } else if (action.equals("remove")) {
            String[] crn = request.getParameterValues("crn");

            for (String coursecrn : crn) {

                for (Course course : courseList) {
                    if (course.getCrn().equals(coursecrn)) {

                        myCourses.remove(course);

                    }
                }

            }
            session.setAttribute("myCourseSet", myCourses);

            return new ModelAndView("mycourse");

        } else if (action.equals("goSearch")) {
            return new ModelAndView("searchCourse");
        } else if (action.equals("mycourse")) {
            return new ModelAndView("mycourse");
        }

        // return
        return new ModelAndView("index");
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        return searchCourse(request, response);
    }

}
