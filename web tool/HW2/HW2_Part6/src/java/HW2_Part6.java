/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zinanwang
 */
public class HW2_Part6 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("button");
        String number = request.getParameter("chidern");
        HttpSession session = request.getSession();
        
        if(action.equals("Next")){
            session.setAttribute("number", number);
            response.sendRedirect("index.jsp");
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
        
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Page 1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form>");
            out.println("<p>Question 1: Which many chidern do you have:</p>");
            out.println("<input type='text' name='chidern' id='number'><br/><br/>");
            out.println("<input type='submit' value='Next' name='button'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            
            
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
        
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            HttpSession session = request.getSession();
            
            String number = (String)session.getAttribute("number");
            int x = Integer.parseInt(number);
            
            String [] names = new String[x];
            
            for(int i=0; i<names.length;i++){
                names[i] = request.getParameter(String.valueOf(i));
            }
            
            
            out.println("Your chidern's names are:");
            out.println("<br>");
            for(int i=0; i<names.length;i++){
                out.println("<b><font color='red'>"+ names[i] + "</font></b><br/>");
                out.println("<br>");
            }
            
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
