package fr.dawan.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.springmvc.beans.User;

/*
 * @Repository : C'est pour dire que c'est une doit �tre instancier par Spring 
 * 				Sinon Spring ne traitera pas cette classe au demarrage de l'application
 * 				C'est un composant qui est fait pour la couche DAO, pour le Mapping
 * 				Objet Relationnel
 */
@Repository
public class UserDaoImpl implements IUserDAO{

	
	/*
	 * Pour g�rer la gestion des entit�s j'aurais besoin de cr�er un variable 
	 * de type EntityManager
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public void saveAndUpdate(User user) {
		if(user.getId() ==null || user.getId() == 0) {
			entityManager.persist(user);
		} else {
			entityManager.merge(user);
		}
	}

	/*
	 * Par defaut, les transactions Spring sont en lecture-ecriture, mais on peut configuter 
	 * explicitement pour qu'elles soients ex�cut�es dans un contexte de lecture seule
	 * 
	 * Les m�thodes permettant la lecture en base de donn�es sont en lecture seul 
	 * Les autres m�thodes sont en lecture/ecriture qui est le mode par defaut
	 */
	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
		String sql = "SELECT u from User u";
		Query req = entityManager.createQuery(sql);
		return req.getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public User findOn(Long id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	@Transactional
	@Override
	public void delete(Long id) {
		User user = entityManager.find(User.class, id);
		if(user != null) {
			entityManager.remove(user);
		} else {
			//TODO Logger
		}
		
	}

	@Override
	public User getUserByPasswordAndUEmail(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
