package com.energizeglobal.smsys.manager.impl;


import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.exception.DatabaseException;
import com.energizeglobal.smsys.manager.IUserManager;
import com.energizeglobal.smsys.repository.IUserRepository;
import org.hibernate.HibernateException;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class UserManager implements IUserManager {

    @Inject
    private IUserRepository userRepository;

    @Override
    public void add(User user) throws DatabaseException {
        try {
            userRepository.add(user);
        } catch (RuntimeException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void edit(User user) throws DatabaseException {
        try {
            userRepository.edit(user);
        } catch (RuntimeException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public User findById(Long id) throws DatabaseException {
        try {
            return userRepository.findById(id);
        } catch (RuntimeException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws EntityNotFoundException, DatabaseException {
        try {
            User user = userRepository.findByEmailAndPassword(email, password);
            System.out.println(user);
            return user;
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }
    }

}
