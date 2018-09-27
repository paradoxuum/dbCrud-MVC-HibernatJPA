package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;

/**
 * Hello world!
 *
 */
public class ClJpaDAO 
{
    private static ClJpaDAO instance;
    protected EntityManager entityManager;
    
    public static ClJpaDAO getInstance() {
    	if(instance == null) {
    		instance = new ClJpaDAO();
    	}
    	return instance;
    }
    private ClJpaDAO() {entityManager = getEntityManager();}
    
    private EntityManager getEntityManager() {
    	
    	EntityManagerFactory f = Persistence.createEntityManagerFactory("crudHibernatePU");
    	
    	if(entityManager == null) {entityManager = f.createEntityManager();}
    	
    	return entityManager;
    }
    
    public Cliente getById(final int id) {
    	return entityManager.find(Cliente.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Cliente> findAll(){
    	return entityManager.createQuery("FROM" + Cliente.class.getName()).getResultList();
    }
    
    public void persist(Cliente c) {
    	try {
    		entityManager.getTransaction().begin();
    		entityManager.persist(c);
    		entityManager.getTransaction().commit();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		entityManager.getTransaction().rollback();
    	}
    }
    
    public void merge(Cliente c) {
    	try {
    		entityManager.getTransaction().begin();
    		entityManager.merge(c);
    		entityManager.getTransaction().commit();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		entityManager.getTransaction().rollback();
    	}
    }
    
    public void remove(Cliente c) {
    	try {
    		entityManager.getTransaction().begin();
    		c = entityManager.find(Cliente.class, c.getId());
    		entityManager.remove(c);
    		entityManager.getTransaction().commit();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		entityManager.getTransaction().rollback();
    	}
    }
    
    public void removeById(final int id) {
    	try {
    		Cliente c = getById(id);
    		remove(c);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }
}
