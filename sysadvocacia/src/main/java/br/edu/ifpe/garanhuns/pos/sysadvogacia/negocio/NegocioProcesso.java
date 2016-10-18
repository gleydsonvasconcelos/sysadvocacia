/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Processo;
import br.edu.ifpe.pos.garanhuns.sysadvogacia.persistencia.ProcessoDAO;
import java.util.List;

/**
 *
 * @author Gleydson
 */
public class NegocioProcesso {

    private final ProcessoDAO repositorioProcessos;

    public NegocioProcesso() {
        repositorioProcessos = new ProcessoDAO();
    }
    
    public Processo salvar(Processo processo){
        return repositorioProcessos.save(processo);
    }
    
    public void remover(Processo processo){
        repositorioProcessos.remove(processo);
    }
    
    public List<Processo> listarProcessos(){
        return repositorioProcessos.getAll();
    }
    
    public Processo processoPorCodigo(int codigoProcesso){
        return repositorioProcessos.getById(codigoProcesso);
    } 

}
