/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.pos.garanhuns.sysadvogacia.persistencia;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Historico;

/**
 *
 * @author Adriano
 */
public class HistoricoDAO extends DAOImpl<Historico, Integer>{
    
    public HistoricoDAO() {
        super(Historico.class);
    }
    
}
