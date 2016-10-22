/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.controladores;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Processo;
import br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio.NegocioHistorico;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new ExclusionStrategy() {

                        public boolean shouldSkipClass(Class<?> clazz) {
                            return (clazz == Processo.class);
                        }

                        /**
                         * Custom field exclusion goes here
                         */
                        public boolean shouldSkipField(FieldAttributes f) {
                            return false;
                        }

                    })
                    /**
                     * Use serializeNulls method if you want To serialize null
                     * values By default, Gson does not serialize null values
                     */
                    .serializeNulls()
                    .create();

            String json = new Gson().toJson(negocioHistorico.listarHistoricos());
            response.getWriter().print(json);
        }

    }
}
