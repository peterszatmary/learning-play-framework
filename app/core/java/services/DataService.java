package core.java.services;

import models.User;
import org.apache.commons.lang.StringUtils;
import play.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by nue on 31.8.2015.
 *
 * Mongo DB with Kundera = JPA specification on no sql document oriented DB
 *
 *
 */
public class DataService {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("kunderaMongoDb_PU");

    public List<User> usersFindAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM User e");
        List<User> result = query.getResultList();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        em.close();
        return result;
    }


    public void userCreate(User user) {
        EntityManager em = emf.createEntityManager();
        em.persist(user);
        em.close();
    }

    public boolean userAuthentication(String email, String password) {
        boolean result = false;
        if (StringUtils.isNotEmpty(email) && StringUtils.isNotEmpty(password)) {
            EntityManager em = emf.createEntityManager();
            Query q = em.createNamedQuery(User.USER_EXIST, User.class);
            q.setParameter("email", email);
            q.setParameter("password", password);
            List<User> users = (List<User>) q.getResultList();// just single but for now functional. and with one play argued
            result = users != null && !users.isEmpty() && users.get(0) != null;
            Logger.info("userAuthentication = " + result);
        }
        return result;
    }


}
