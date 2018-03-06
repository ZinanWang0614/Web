/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Movie;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zinanwang
 */
public class MovieDAO {
    
    public ArrayList<Movie> getMovies(){
        java.sql.Connection connection = null;
        Statement stmt = null;
        ArrayList<Movie> movieList = new ArrayList<Movie>();
            
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root");
            stmt = connection.createStatement();
            
            String query = "SELECT * FROM moviestable";
            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setTitle(rs.getString("title"));
                movie.setActor(rs.getString("actor"));
                movie.setActress(rs.getString("actress"));
                movie.setGenre(rs.getString("genre"));
                movie.setYear(rs.getInt("year"));
                movieList.add(movie);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }
        return movieList;
    }
    
}
