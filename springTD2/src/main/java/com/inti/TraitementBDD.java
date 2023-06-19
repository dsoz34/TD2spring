package com.inti;


import java.util.ArrayList;
import java.time.LocalDate;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;


public class TraitementBDD {
	
    private Session session;
	

    private Logger logger = LogManager.getLogger();

	public TraitementBDD() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public Produit chercherProduit(String nomP) {
		Produit P = null;
		
		try {
			

		
		session.beginTransaction();	
		P = session.createNativeQuery("select * from Produit where nom = '"+ nomP +"'", Produit.class).list().get(0);

		session.getTransaction().commit();
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return P;
	}
	
	

}
