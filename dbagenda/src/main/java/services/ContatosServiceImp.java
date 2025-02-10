package services;

import entidade.Contato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ContatosServiceImp implements ContatoService{


    @Override
    public Contato save(Contato contato) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-dbagenda");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(contato);
            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }

        return contato;
    }

    @Override
    public List<Contato> getContatos() {

        List<Contato> contatos;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-dbagenda");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            TypedQuery<Contato> query = em.createQuery("Select c  FROM contatos c", Contato.class);
            contatos = query.getResultList();
            em.getTransaction().commit();
        }finally {
            em.close();
            emf.close();
        }

        return contatos;
    }
}
