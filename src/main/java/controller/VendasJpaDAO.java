package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Vendas;

public class VendasJpaDAO 
{
    private static VendasJpaDAO instance;
    protected EntityManager entityManager;
    
    public static VendasJpaDAO getInstance() {
    	if(instance == null) {
    		instance = new VendasJpaDAO();
    	}
    	return instance;
    }
    private VendasJpaDAO() {entityManager = getEntityManager();}
    
    private EntityManager getEntityManager() {
    	
    	EntityManagerFactory f = Persistence.createEntityManagerFactory("crudHibernatePU");
    	
    	if(entityManager == null) {entityManager = f.createEntityManager();}
    	
    	return entityManager;
    }
    
    public Vendas getById(final int id) {
    	return entityManager.find(Vendas.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Vendas> findAll(){
    	return entityManager.createQuery("FROM" + Vendas.class.getId_venda()).getResultList();
    }
    
    public void persist(Vendas v) {
    	try {
    		entityManager.getTransaction().begin();
    		entityManager.persist(v);
    		entityManager.getTransaction().commit();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		entityManager.getTransaction().rollback();
    	}
    }
    
    public void merge(Vendas v) {
    	try {
    		entityManager.getTransaction().begin();
    		entityManager.merge(v);
    		entityManager.getTransaction().commit();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		entityManager.getTransaction().rollback();
    	}
    }
    
    public void remove(Vendas v) {
    	try {
    		entityManager.getTransaction().begin();
    		v = entityManager.find(Vendas.class, v.getId_venda());
    		entityManager.remove(v);
    		entityManager.getTransaction().commit();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		entityManager.getTransaction().rollback();
    	}
    }
    
    public void removeById(final int id) {
    	try {
    		Vendas v = getById(id);
    		remove(v);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
