/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.controladores;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Advogado;
import br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio.NegocioAdvogado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 *
 * @author Gleydson
 */
@WebServlet(name = "ControladorAdvogadoServlet", urlPatterns = {"/SalvarAdvogado", "/ListarAdvogados", "/RemoverAdvogado"})
public class ControladorAdvogadoServlet extends HttpServlet {

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
        NegocioAdvogado negocioAdvogado = new NegocioAdvogado();
        Advogado advogado;

        if (userPath.equals("/SalvarAdvogado")) {
            advogado = new Advogado();
            if (!request.getParameter("codigo").isEmpty()) {
                advogado.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            } else {
                advogado.setCodigo(0);
            }
            advogado.setNome(request.getParameter("nome"));
            advogado.setCpf(request.getParameter("cpf"));
            advogado.setOab(request.getParameter("oab"));
            advogado.setEndereco(request.getParameter("endereco"));
            advogado.setTelefone(request.getParameter("telefone"));

            String json = new Gson().toJson(negocioAdvogado.salvar(advogado));
            response.getWriter().print(json);

        }

        if (userPath.equals("/ListarAdvogados")) {
            String json = new Gson().toJson(negocioAdvogado.listarAdvogados());
            response.getWriter().print(json);
        }

        if (userPath.equals("/RemoverAdvogado")) {
            String id = request.getParameter("id");
            advogado = negocioAdvogado.advogadoPorCodigo(Integer.parseInt(id));
            negocioAdvogado.remover(advogado);
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
