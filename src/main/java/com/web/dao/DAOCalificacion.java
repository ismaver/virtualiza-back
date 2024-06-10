package com.web.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;
import com.web.modelo.Calificacion;

@Stateless
public class DAOCalificacion{

    @PersistenceContext
    private EntityManager em;

    public void create(Calificacion calificacion){
        em.persist(calificacion);
    }

    public Calificacion read(int codigo){
        Calificacion calificacion = em.find(Calificacion.class, codigo);
        return calificacion;
    }

    public void update(Calificacion calificacion){
        em.merge(calificacion);
    }

    public void delete(int codigo){
        Calificacion calificacion = em.find(Calificacion.class, codigo);
        em.remove(calificacion);
    }

    public List<Calificacion> getAll(){
    	String jpql = "SELECT c FROM Calificacion c";
		Query q = em.createQuery(jpql, Calificacion.class);
		return q.getResultList();
    }

}
