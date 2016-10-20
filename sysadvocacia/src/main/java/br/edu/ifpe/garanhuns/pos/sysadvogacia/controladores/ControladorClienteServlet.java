/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.controladores;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Cliente;
import br.edu.ifpe.garanhuns.pos.sysadvogacia.excecoes.RemoverClienteComProcessosException;
import br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio.NegocioCliente;
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
@WebServlet(name = "ControladorClienteServlet", urlPatterns = {"/SalvarCliente", "/ListarClientes", "/RemoverCliente"})
public class ControladorClienteServlet extends HttpServlet {

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
        NegocioCliente negocioCliente = new NegocioCliente();
        Cliente cliente;

        if (userPath.equals("/SalvarCliente")) {
            cliente = new Cliente();
            if (!request.getParameter("codigo").isEmpty()) {
                cliente.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            } else {
                cliente.setCodigo(0);
            }
            cliente.setNome(request.getParameter("nome"));
            cliente.setCpfCnpj(request.getParameter("cpfCnpj"));
            cliente.setEndereco(request.getParameter("endereco"));
            cliente.setTelefone(request.getParameter("telefone"));

            String json = new Gson().toJson(negocioCliente.salvar(cliente));
            response.getWriter().print(json);

        }

        if (userPath.equals("/ListarClientes")) {
            String json = new Gson().toJson(negocioCliente.listarClientes());
            response.getWriter().print(json);
        }

        if (userPath.equals("/RemoverCliente")) {
            JsonObject jsonObject = new JsonObject();
            try {
                String id = request.getParameter("id");
                cliente = negocioCliente.clientePorCodigo(Integer.parseInt(id));
                negocioCliente.remover(cliente);
                jsonObject.addProperty("success", "true");
                response.getWriter().print(new Gson().toJson(jsonObject));
            } catch (RemoverClienteComProcessosException e) {
                jsonObject.addProperty("errorMsg", e.mensagem());
                response.getWriter().print(new Gson().toJson(jsonObject));
            }

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
