/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Advogado;
import br.edu.ifpe.pos.garanhuns.sysadvogacia.persistencia.AdvogadoDAO;
import java.util.List;

/**
 *
 * @author Gleydson
 */
public class NegocioAdvogado {

    private final AdvogadoDAO repositorioAdvogados;

    public NegocioAdvogado() {
        repositorioAdvogados = new AdvogadoDAO();
    }
    
    public Advogado salvar(Advogado advogado){
        return repositorioAdvogados.save(advogado);
    }
    
    public void remover(Advogado advogado){
        repositorioAdvogados.remove(advogado);
    }
    
    public List<Advogado> listarAdvogados(){
        return repositorioAdvogados.getAll();
    }
    
    public Advogado advogadoPorCodigo(int codigoAdvogado){
        return repositorioAdvogados.getById(codigoAdvogado);
    } 

}
