package fr.dawan.springmvc.dao;

import java.util.List;

import fr.dawan.springmvc.beans.AbstractEntity;
import fr.dawan.springmvc.beans.User;

/*
 * Amelioration du code : Cr�ation d'une interface G�n�rique
 * Une interface g�n�rique c'est une interface qu'on pourra utiliser pour n'importe quelle entit�
 * 
 */
public interface EntityRepository<T extends AbstractEntity> {
	public void saveAndUpdate(T entity);
	public List<T> findAll();
	public T findOn(Long id);
	public void delete(Long id);	
}
