/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Bean.CatalogBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zinanwang
 */
public class Catalog extends HttpServlet {
    
    ArrayList<CatalogBean> booksList;
    ArrayList<CatalogBean> musicList;
    ArrayList<CatalogBean> computerList;
    
    @Override
    public void init(){
        
        booksList = new ArrayList<CatalogBean>();
        CatalogBean b1 = new CatalogBean();
        b1.setName("Java Servlet Programming");
        b1.setPrice((float) 29.95);
        
        CatalogBean b2 = new CatalogBean();
        b2.setName("Oracle Database Programming");
        b2.setPrice((float) 48.95);
        
        CatalogBean b3 = new CatalogBean();
        b3.setName("System Analysis and Design with UML");
        b3.setPrice((float) 14.95);
        
        CatalogBean b4 = new CatalogBean();
        b4.setName("Object Oritented Software Engineering");
        b4.setPrice((float) 35.99);
        
        CatalogBean b5 = new CatalogBean();
        b5.setName("Java Web Services");
        b5.setPrice((float) 27.99);
        
        booksList.add(b1);
        booksList.add(b2);
        booksList.add(b3);
        booksList.add(b4);
        booksList.add(b5);
        
        musicList = new ArrayList<CatalogBean>();
        CatalogBean m1 = new CatalogBean();
        m1.setName("I am Going to tell your a serect by Madonna");
        m1.setPrice((float) 26.99);
        
        CatalogBean m2 = new CatalogBean();
        m2.setName("Baby One More Time by Bntney Spears");
        m2.setPrice((float) 10.95);
        
        CatalogBean m3 = new CatalogBean();
        m3.setName("Justified by Justin Timberlake");
        m3.setPrice((float) 9.97);
        
        CatalogBean m4 = new CatalogBean();
        m4.setName("Loose by Nelly Furtado");
        m4.setPrice((float) 13.98);
        
        CatalogBean m5 = new CatalogBean();
        m5.setName("Gold Digger by Kanye West");
        m5.setPrice((float) 13.98);
        
        musicList.add(m1);
        musicList.add(m2);
        musicList.add(m3);
        musicList.add(m4);
        musicList.add(m5);
        
        computerList = new ArrayList<CatalogBean>();
        CatalogBean c1 = new CatalogBean();
        c1.setName("Apple Macbooks Pro with 13.3* Display");
        c1.setPrice((float) 1299.99);
        
        CatalogBean c2 = new CatalogBean();
        c2.setName("Arus Laptop with Centrino 2 Black");
        c2.setPrice((float) 949.95);
        
        CatalogBean c3 = new CatalogBean();
        c3.setName("HP Pavmos Laptop with Centrino 2 DV7");
        c3.setPrice((float) 1199.99);
        
        CatalogBean c4 = new CatalogBean();
        c4.setName("Toshiba Satellite Laptop with Cenrino 2 -Copper");
        c4.setPrice((float) 899.99);
        
        CatalogBean c5 = new CatalogBean();
        c5.setName("Sony VAIO Laptop with Core 2 Duo Cosmopolitan Pink");
        c5.setPrice((float) 779.99);
        
        computerList.add(c1);
        computerList.add(c2);
        computerList.add(c3);
        computerList.add(c4);
        computerList.add(c5);
        
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        HttpSession session = request.getSession();
        
        Set<CatalogBean> cart;
        if (null !=(Set<CatalogBean>)session.getAttribute("cart")) {
            cart = (Set<CatalogBean>) session.getAttribute("cart");
        }else{
            cart = new HashSet<CatalogBean>();
        }
        
        Set<CatalogBean> store;
        if (null !=(Set<CatalogBean>)session.getAttribute("store")) {
            store = (Set<CatalogBean>) session.getAttribute("store");
        }else{
            store = new HashSet<CatalogBean>();
        }
        
        
       
        String action = request.getParameter("action");
        if (action.equals("books")) {
            request.setAttribute("List", booksList);
            RequestDispatcher rd = request.getRequestDispatcher("/Catalog.jsp");
            rd.forward(request, response);
        }else if(action.equals("music")){
            request.setAttribute("List", musicList);
            RequestDispatcher rd = request.getRequestDispatcher("/Catalog.jsp");
            rd.forward(request, response);
        }else if (action.equals("computers")) {
            request.setAttribute("List", computerList);
            RequestDispatcher rd = request.getRequestDispatcher("/Catalog.jsp");
            rd.forward(request, response);
        }else if(action.equals("add")){
            
            String[] names = request.getParameterValues("content");
            
            for(String name:names){
                
                for(CatalogBean c:booksList){
                    if (c.getName().equals(name)) {
                        cart.add(c);
                        store.add(c);
                    }
                }
                
                for(CatalogBean c:musicList){
                    if (c.getName().equals(name)) {
                        cart.add(c);
                        store.add(c);
                    }
                }
                
                for(CatalogBean c:computerList){
                    if (c.getName().equals(name)) {
                        cart.add(c);
                        store.add(c);
                    }
                }
                
            }
            
            session.setAttribute("cart", cart);
            request.setAttribute("store", store);
            RequestDispatcher rd = request.getRequestDispatcher("/Added.jsp");
            rd.forward(request, response); 
            
        }else if (action.equals("view")) {
            RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
            rd.forward(request, response); 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
