package com.energizeglobal.smsys.repository.impl;

import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.repository.IUserRepository;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class UserRepository implements IUserRepository {


    @Inject
    private Session session;

    @Override
    public void add(User user) {
        session.save(user);
    }

    @Override
    public void edit(User user) {
        session.merge(user);
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
//        Query query = session.createSQLQuery("SELECT u.* FROM user u WHERE u.email = :email AND u.password = :password");
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password));
//        query.setParameter("email", email);
//        query.setParameter("password", password);


        List<Object> d = criteria.list();

        if (d.size() > 0) {
            return (User) d.get(0);
        }
        throw new EntityNotFoundException("User not found");
    }

    @Override
    public List<User> getAllUser() {
        List list = null;
        try {
            Query query = session.createQuery("FROM User");
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        return list;
    }

}
