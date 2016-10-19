/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.controladores;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Processo;
import br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio.NegocioProcesso;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Date;

/**
 *
 * @author Gleydson
 */
@WebServlet(name = "ControladorProcessoServlet", urlPatterns = {"/SalvarProcesso", "/ListarProcessos", "/RemoverProcesso"})
public class ControladorProcessoServlet extends HttpServlet {

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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        NegocioProcesso negocioProcesso = new NegocioProcesso();
        Processo processo;

        if (userPath.equals("/SalvarProcesso")) {
            processo = new Processo();
            if (!request.getParameter("codigo").isEmpty()) {
                processo.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            } 
            
            processo.setDataAbertura(new Date(request.getParameter("dataAbertura")));
            processo.setInstanciaAtual(request.getParameter("instanciaAtual"));
            processo.setStatus(Integer.parseInt(request.getParameter("status")));
            processo.setDecisaoFinal(request.getParameter("decisaoFinal"));
            processo.setDescricao(request.getParameter("descricao"));

            String json = new Gson().toJson(negocioProcesso.salvar(processo));
            response.getWriter().print(json);

        }

        if (userPath.equals("/ListarProcessos")) {
            String json = new Gson().toJson(negocioProcesso.listarProcessos());
            response.getWriter().print(json);
        }

        if (userPath.equals("/RemoverProcesso")) {
            String id = request.getParameter("id");
            processo = negocioProcesso.processoPorCodigo(Integer.parseInt(id));
            negocioProcesso.remover(processo);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("success", "true");
            response.getWriter().print(new Gson().toJson(jsonObject));
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
