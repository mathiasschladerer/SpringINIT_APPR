package fr.dawan.ioc.presentation;

import fr.dawan.ioc.dao.DaoImpl;
import fr.dawan.ioc.dao.extensions.DaoImplV2;
import fr.dawan.ioc.metier.MetierImpl;

/*
 * Mauvaise m�thode : Utilisation de l'instanciation statique
 * 
 */
public class PresentationV1 {

	public static void main(String[] args) {
		
		//Cr�ation d'un objet dao
		DaoImpl dao = new DaoImpl();
		
		//Creation d'un objet daoV2 (deuxi�me version)
		DaoImplV2 daoV2 = new DaoImplV2();
		
		//Cr�ation d'un objet m�tier
		MetierImpl metier = new MetierImpl();
		

		/*
		 * 	L'association entre l'objet metier et l'objet dao 
		 *  ===> Injection de dependance
		 */
		metier.setDao(daoV2);
		
		System.out.println(metier.calcul());
	}

}
