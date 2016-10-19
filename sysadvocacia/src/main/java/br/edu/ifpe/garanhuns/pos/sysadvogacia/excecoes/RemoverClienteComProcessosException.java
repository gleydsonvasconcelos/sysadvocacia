/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.excecoes;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Cliente;

/**
 *
 * @author Gleydson
 */
public class RemoverClienteComProcessosException extends Exception{
    private Cliente cliente;
    
    public RemoverClienteComProcessosException(Cliente cliente){
        this.cliente = cliente;
    }
    
    public String mensagem(){
        return "O cliente "+cliente.getNome()+" possui "+cliente.getProcessoList().size()+" processos e não pode ser removido.";
    }
    
}
