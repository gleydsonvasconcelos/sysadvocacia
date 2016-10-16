/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.pos.garanhuns.sysadvogacia.persistencia;

import br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades.Processo;



/**
 *
 * @author Gleydson
 */
public class ProcessoDAO extends DAOImpl<Processo, Integer> {

    public ProcessoDAO() {
        super(Processo.class);
    }

}
