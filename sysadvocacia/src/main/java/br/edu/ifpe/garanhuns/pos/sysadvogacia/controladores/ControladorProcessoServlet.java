/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.controladores;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Cliente;
import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Historico;
import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Processo;
import br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio.NegocioAdvogado;
import br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio.NegocioCliente;
import br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio.NegocioProcesso;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.Date;

/**
 *
 * @author Gleydson
 */
@WebServlet(name = "ControladorProcessoServlet", urlPatterns = {"/SalvarProcesso", "/ListarProcessos",
    "/RemoverProcesso", "/ListarClientesProcesso", "/AdicionarClienteProcesso",
    "/ListarAdvogadosProcesso", "/AdicionarAdvogadoProcesso"})
public class ControladorProcessoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        NegocioProcesso negocioProcesso = new NegocioProcesso();
        Processo processo;

        if (userPath.equals("/ListarClientesProcesso")) {

            String codProcesso = request.getParameter("codigoProcesso");
            processo = negocioProcesso.processoPorCodigo(Integer.parseInt(codProcesso));

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

            String json = gson.toJson(processo.getClienteList());
            response.getWriter().print(json);
        }

        if (userPath.equals("/ListarAdvogadosProcesso")) {

            processo = negocioProcesso.processoPorCodigo(Integer.parseInt(request.getParameter("codigoProcesso")));

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

            String json = gson.toJson(processo.getAdvogadoList());
            response.getWriter().print(json);
        }
        
        if (userPath.equals("/ListarHistoricosProcesso")) {
            
            processo = negocioProcesso.processoPorCodigo(Integer.parseInt(request.getParameter("codigoProcesso")));

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

            
            String json = new Gson().toJson(processo.getHistoricoList());
            response.getWriter().print(json);
        }


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
                processo = negocioProcesso.processoPorCodigo(Integer.parseInt(request.getParameter("codigo")));
            }

            processo.setDataAbertura(new Date(request.getParameter("dataAbertura")));
            processo.setInstanciaAtual(request.getParameter("instanciaAtual"));
            processo.setStatus(Integer.parseInt(request.getParameter("status")));
            processo.setDecisaoFinal(request.getParameter("decisaoFinal"));
            processo.setDescricao(request.getParameter("descricao"));

            Historico historico = new Historico();
            historico.setCodigo(0);
            historico.setData(new Date());
            historico.setDescricao(processo.getDescricao());
            historico.setStatusanterior(0);
            historico.setProcessoCodigo(processo);
            //new HistoricoDAO().save(historico);
            
            String json = new Gson().toJson(negocioProcesso.salvar(processo));
            response.getWriter().print(json);
        }

        if (userPath.equals("/ListarProcessos")) {
            Gson gson = new GsonBuilder()
                    .setExclusionStrategies(new ExclusionStrategy() {

                        public boolean shouldSkipClass(Class<?> clazz) {
                            return (clazz == Cliente.class);
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
                    .setExclusionStrategies(new ExclusionStrategy() {

                        public boolean shouldSkipClass(Class<?> clazz) {
                            return (clazz == Historico.class);
                        }

                        /**
                         * Custom field exclusion goes here
                         */
                        public boolean shouldSkipField(FieldAttributes f) {
                            return false;
                        }

                    })
                    .serializeNulls()
                    .create();

            String json = gson.toJson(negocioProcesso.listarProcessos());
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

        if (userPath.equals("/AdicionarClienteProcesso")) {
            String codigoProcesso = request.getParameter("codigoProcesso");
            String codigoCliente = request.getParameter("codigoCliente");

            processo = negocioProcesso.processoPorCodigo(Integer.parseInt(codigoProcesso));
            processo.getClienteList().add(new NegocioCliente().clientePorCodigo(Integer.parseInt(codigoCliente)));

            negocioProcesso.salvar(processo);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("success", "true");
            response.getWriter().print(new Gson().toJson(jsonObject));

        }

        if (userPath.equals("/AdicionarAdvogadoProcesso")) {
            String codigoProcesso = request.getParameter("codigoProcesso");
            String codigoAdvogado = request.getParameter("codigoAdvogado");

            processo = negocioProcesso.processoPorCodigo(Integer.parseInt(codigoProcesso));
            processo.getAdvogadoList().add(new NegocioAdvogado().advogadoPorCodigo(Integer.parseInt(codigoAdvogado)));

            negocioProcesso.salvar(processo);
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
