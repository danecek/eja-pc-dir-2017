/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.webmvc.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mycompany.webmvc.model.Data;

@WebServlet(name = "ViewServlet", urlPatterns = {""})
public class ViewServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>View</h1>");
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user == null) {
                out.println("user: anonymus");
                out.print("<form action=\"login.do\"  method=\"POST\">");
                out.print("<input type=\"text\" name=\"user\" />");
                out.print("<input type=\"submit\" value=\"Login\" />");
                out.print("</form>");
            } else {
                out.print("user: " + user + "<br>");
                Object error = request.getAttribute("error");
                String errorValue = "";
                if (error != null) {
                    out.print("Error:" + error);
                    errorValue = (String) request.getAttribute("errorValue");
                }
                out.print("<form action=\"add.do\"  method=\"POST\">");
                out.print("<input type=\"text\" name=\"item\" value=\""
                        + errorValue + "\" />");
                out.print("<input type=\"submit\" value=\"Add\" />");
                out.print("</form>");
            }
            out.print("<table border=\"1\">");
            for (String it : Data.inst.getAll()) {
                out.print("<tr>");
                out.print("<td>");
                out.print(it);
                out.print("</td>");
                out.print("</tr>");
            }
            out.print("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
