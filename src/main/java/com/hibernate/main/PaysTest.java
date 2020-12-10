package com.hibernate.main;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Pays;
import com.hibernate.util.HibernateUtil;

public class PaysTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try
		{
		Transaction tx = session.beginTransaction();
		Query query ;

	 query= session.createQuery("from Pays WHERE continent =:continent");
	 query.setParameter("continent","europe");
		List<Pays> paysList = query.list();
		for(Pays p : paysList){
			//System.out.println("List de pays::"+p.getId()+","+p.getNom()+","+p.getContinent());
			System.out.println(p.toString());
		}
		 query= session.createQuery("SELECT id,nom,population,continent from Pays GROUP BY continent ");
		// query.setParameter("continent","europe");
			List<Pays> paysList2 = query.list();
			for(Pays p : paysList){
				//System.out.println("List de pays::"+p.getId()+","+p.getNom()+","+p.getContinent());
				System.out.println(p.toString());
			}
		}
		catch(Exception ex)
		{
			System.out.println("exception: "+ex);

		}
		sessionFactory.close();
	}

}
