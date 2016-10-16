/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.negocio;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Cliente;
import br.edu.ifpe.pos.garanhuns.sysadvogacia.persistencia.ClienteDAO;
import java.util.List;

/**
 *
 * @author Gleydson
 */
public class NegocioCliente {

    private final ClienteDAO repositorioClientes;

    public NegocioCliente() {
        repositorioClientes = new ClienteDAO();
    }
    
    public Cliente salvar(Cliente cliente){
        return repositorioClientes.save(cliente);
    }
    
    public void remover(Cliente cliente){
        repositorioClientes.remove(cliente);
    }
    
    public List<Cliente> listarClientes(){
        return repositorioClientes.getAll();
    }
    
    public Cliente clientePorCodigo(int codigoCliente){
        return repositorioClientes.getById(codigoCliente);
    } 

}
