/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Lei;
import br.edu.ifpe.pos.garanhuns.sysadvogacia.persistencia.LeiDAO;
import java.util.List;

/**
 *
 * @author Ewerton
 */
public class NegocioLei{
    
    private final LeiDAO repositorioLei;
    
    public  NegocioLei(){
        repositorioLei = new LeiDAO(); 
    }
    
    public Lei salvar(Lei lei){
        return repositorioLei.save(lei);
    }
    
    public void remover(Lei lei){
        repositorioLei.remove(lei);
    }
    
    public List<Lei> listarLeis(){
        return repositorioLei.getAll();
    }
    
    public Lei LeiPorCodigo(){
        return repositorioLei.getById(Integer.SIZE);
    }    
        
}
