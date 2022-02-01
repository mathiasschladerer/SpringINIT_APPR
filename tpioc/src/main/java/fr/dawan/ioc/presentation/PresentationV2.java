package fr.dawan.ioc.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

import fr.dawan.ioc.dao.IDao;
import fr.dawan.ioc.metier.IMetier;

/*
 * On va utiliser l'instanciation dynamique
 * et un fichier de configuration
 */
public class PresentationV2 {

	public static void main(String[] args) {
		try {
			//new File("config.txt") :
			//	va permettre de lire le fichier config.txt
			Scanner input = new Scanner(new File("config.txt"));
			
			//Lire la classe DaoImpl
			//La m�thode next lit la premi�re ligne
			String daoClassName = input.next();
			
			//Lire la classe MetierImpl
			//La m�thode next lit la ligne suivante
			String metierClassName = input.next();
			
			System.out.println(daoClassName);
			System.out.println(metierClassName);
			
			//Charger dynamiquement la classe DaoImpl en m�moire
			Class cDao = Class.forName(daoClassName);
			
			//Instanciation de la classe DaoImpl : Utilisation de la m�thode newInstance
			IDao dao  = (IDao) cDao.newInstance();
			
			//Pour verifier si �a fonctionne j'apppelle la m�thode getValue
			System.out.println(dao.getValue());
			
			//Charger dynamiquement la class MetierIml en memoire 
			Class cMetier = Class.forName(metierClassName);
			
			//Instanciation de la MetierIml : Utilisataion de la m�thode new Instance
			IMetier metier   = (IMetier) cMetier.newInstance();
			
			//La m�thode setDao, on va l'appeler par reflexon
			//Puis, on va cr�er un objet de type M�thode
			Method m1 = cMetier.getMethod("setDao", new Class[] {IDao.class});
			
			//Execution de la m�thode : appel de la m�thode invoke
			//Premier param�tre la m�thode invoke : L'instance sur laquelle la m�thode doit �tre invoqu�e(m�tier)
			//On fait l'injection de dependance en associant l'objet m�tier et l'objet Dao 
			m1.invoke(metier, new Object[] {dao});
			
			//Afficher le resultat en appelant la m�thode calcul
			
			System.out.println(metier.calcul());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
