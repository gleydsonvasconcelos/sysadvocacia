/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.controladores;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio.NegocioHistorico;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adriano
 */
@WebServlet(name = "ControladorHistoricoServlet", urlPatterns = {"/ListarHistoricos"})
public class ControladorHistoricoServlet {
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     String userPath = request.getServletPath();
        NegocioHistorico negocioHistorico = new NegocioHistorico();

        if (userPath.equals("/ListarHistoricos")) {
            String json = new Gson().toJson(negocioHistorico.listarHistoricos());
            response.getWriter().print(json);
        }

    }
}
