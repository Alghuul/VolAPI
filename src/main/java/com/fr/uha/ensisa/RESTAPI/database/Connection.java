package com.fr.uha.ensisa.RESTAPI.database;

import com.fr.uha.ensisa.RESTAPI.model.Vol;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class Connection {
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("RESTAPI");

	public static void addVol(String numVol, String villeDepart, String villeArrivee, int heureDepart) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Vol vol = new Vol();
			vol.setHeureDepart(heureDepart);
			vol.setNumVol(numVol);
			vol.setVilleDepart(villeDepart);
			vol.setVilleArrivee(villeArrivee);
			em.persist(vol);
			et.commit();
		} catch (Exception e) {
			if (et != null)
			{
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		
	
	}
	
	public static Vol getVol(String numVol) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT v FROM Vol v WHERE v.numVol = :numVol ";
		
		TypedQuery<Vol> tq = em.createQuery(query,Vol.class);
		tq.setParameter("numVol", numVol);
		Vol v = null;
		try {
			v = tq.getSingleResult();
			System.out.println(v.getNumVol());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return v;
	}
	
	public static List<Vol> searchVol(String departure, String arrival,int  time){
		
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT v FROM Vol v WHERE v.numVol = :numVol OR v.villeDepart = :departure OR v.villeArrivee = :arrival ";
		
		TypedQuery<Vol> tq = em.createQuery(query,Vol.class);
		tq.setParameter("numVol", time);
		tq.setParameter("departure",departure);
		tq.setParameter("arrival",arrival);
		List<Vol> vols = null;
		try {
			vols = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return vols;
		
	}
	
	public static List<Vol> getAllVols() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT v FROM Vol v";
		
		TypedQuery<Vol> tq = em.createQuery(query,Vol.class);
		List<Vol> vols = null;
		
		try {
			vols = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return vols;
	}
	
	public static void putVol(String numVol,int heureDepart) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Vol vol = null;
		try {
			et = em.getTransaction();
			et.begin();
			vol = em.find(Vol.class, numVol);
			vol.setHeureDepart(heureDepart);
			em.persist(vol);
			et.commit();
		} catch (Exception e) {
			if (et != null)
			{
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	
	}
	
	public static void deleteVol(String numVol) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Vol vol = null;
		try {
			et = em.getTransaction();
			et.begin();
			vol = em.find(Vol.class, numVol);
			em.remove(vol);
			em.persist(vol);
			et.commit();;
		} catch (Exception e) {
			if (et != null)
			{
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	
	}

}
