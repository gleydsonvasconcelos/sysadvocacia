/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.pos.garanhuns.sysadvogacia.persistencia;

/**
 *
 * @author Gleydson
 */

 
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
 
public interface DAO<T, I extends Serializable>{
 
 public T save(T entity);
           
 public void remove(T entity);
  
 public T getById(I pk);
  
 public List<T> getAll();
  
 public EntityManager getEntityManager();
}
