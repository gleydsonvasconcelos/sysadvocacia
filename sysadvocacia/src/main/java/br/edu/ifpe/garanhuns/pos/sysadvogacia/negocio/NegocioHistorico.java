/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Historico;
import br.edu.ifpe.pos.garanhuns.sysadvogacia.persistencia.HistoricoDAO;
import java.util.List;

/**
 *
 * @author Adriano
 */
public class NegocioHistorico {
    private final HistoricoDAO repositorioHistoricos;

    public NegocioHistorico() {
        repositorioHistoricos = new HistoricoDAO();
    }
    
    public Historico salvar(Historico historico){
        return repositorioHistoricos.save(historico);
    }
    
    public void remover (Historico historico){
        repositorioHistoricos.remove(historico);
    }
    
    public List<Historico> listarHistoricos(){
        return repositorioHistoricos.getAll();
    }
    
    public Historico historicoPorCodigo(int codigoHistorico){
        return repositorioHistoricos.getById(codigoHistorico);
    } 
}
