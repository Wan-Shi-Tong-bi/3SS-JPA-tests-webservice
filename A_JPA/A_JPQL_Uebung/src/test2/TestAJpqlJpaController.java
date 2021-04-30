/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.TestAJpql;
import test2.exceptions.NonexistentEntityException;
import test2.exceptions.PreexistingEntityException;

/**
 *
 * @author jerem
 */
public class TestAJpqlJpaController implements Serializable {

    public TestAJpqlJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TestAJpql testAJpql) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(testAJpql);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTestAJpql(testAJpql.getId()) != null) {
                throw new PreexistingEntityException("TestAJpql " + testAJpql + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TestAJpql testAJpql) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            testAJpql = em.merge(testAJpql);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = testAJpql.getId();
                if (findTestAJpql(id) == null) {
                    throw new NonexistentEntityException("The testAJpql with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TestAJpql testAJpql;
            try {
                testAJpql = em.getReference(TestAJpql.class, id);
                testAJpql.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The testAJpql with id " + id + " no longer exists.", enfe);
            }
            em.remove(testAJpql);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TestAJpql> findTestAJpqlEntities() {
        return findTestAJpqlEntities(true, -1, -1);
    }

    public List<TestAJpql> findTestAJpqlEntities(int maxResults, int firstResult) {
        return findTestAJpqlEntities(false, maxResults, firstResult);
    }

    private List<TestAJpql> findTestAJpqlEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TestAJpql.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TestAJpql findTestAJpql(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TestAJpql.class, id);
        } finally {
            em.close();
        }
    }

    public int getTestAJpqlCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TestAJpql> rt = cq.from(TestAJpql.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
