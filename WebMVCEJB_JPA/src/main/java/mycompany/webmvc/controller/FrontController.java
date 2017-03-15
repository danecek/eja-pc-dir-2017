/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.webmvc.controller;

import java.io.IOException;
import java.rmi.ServerException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mycompany.webmvc.business.Facade;
import mycompany.webmvc.model.Customer;

@WebServlet(name = "FrontController", urlPatterns = {"*.do"})
public class FrontController extends HttpServlet {

    @Inject
    Facade facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();
        switch (servletPath) {
            case "/login.do":
                facade.login(request.getParameter("user"));
//                RequestDispatcher rd = request.getRequestDispatcher("");
//                rd.forward(request, response);
                break;
            case "/add.do":
                String item = request.getParameter("item");
                if (item.length() >= 2) {
                    facade.add(new Customer(item));
                } else {
                    request.setAttribute("error", "too short");
                    request.setAttribute("errorValue", item);
                }
                break;
            case "/delete.do": {
                facade.delete(Long.parseLong(request.getParameter("id")));
                break;
            }
            case "/addOrder.do": {
                facade.addOrder(Long.parseLong(request.getParameter("custId")),
                        request.getParameter("description"));
                break;
            }
            
            default:
                throw new ServerException("invalid command:" + servletPath);
        }
        response.sendRedirect("");

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
