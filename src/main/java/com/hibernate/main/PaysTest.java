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
		Transaction tx = session.beginTransaction();
		Query query ;

	 query= session.createQuery("from Pays");
		List<Pays> empList = query.list();
		for(Pays p : empList){
			System.out.println("List de pays::"+p.getId()+","+p.getNom()+","+p.getContinent());
		}
		sessionFactory.close();
	}

}
