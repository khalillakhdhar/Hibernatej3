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
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); //initialisation unique
		Session session = sessionFactory.getCurrentSession(); //pointer sur la session actuelle
		Pays p1=new Pays("Qatar", "Asie", 64000, 6800000);
		Pays p2=new Pays("USA", "Amérique",100000, 420000000);
		Pays p3=new Pays("France","Europe", 643801, 68809000);
		Pays p4 =new Pays("Tunisie", "Afrique", 410000, 12200000);
	
		try
		{
		Transaction tx = session.beginTransaction();
		Query query ;
		/*
	session.save(p1);
	session.save(p2);
	session.save(p3);
	session.save(p4);
	*/
		query = session.createQuery("update Pays set nom= :name where id= :id");
				query.setParameter("name", "Etat Unis");
				query.setLong("id", 2);
				int result = query.executeUpdate();
				System.out.println("Pays mis à jour="+result);
		
				
				query = session.createQuery("delete from Pays where id= :id");
				query.setLong("id", 2);
				result = query.executeUpdate();
				System.out.println("Pays supprimé="+result);
		 query= session.createQuery("from Pays  ");
		// query.setParameter("continent","europe");
			List<Pays> paysList = query.list();
			for(Pays p : paysList){
				//System.out.println("List de pays::"+p.getId()+","+p.getNom()+","+p.getContinent());
				System.out.println(p.toString());
			}
		
			session.flush();
			session.getTransaction().commit();

		}
		
		catch(Exception ex)
		{
			System.out.println("exception: "+ex);
		}
		sessionFactory.close();

	}

}
