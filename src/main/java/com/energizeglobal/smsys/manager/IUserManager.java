package com.energizeglobal.smsys.manager;

import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.exception.DatabaseException;

import javax.persistence.EntityNotFoundException;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public interface IUserManager {

    void add(User user) throws DatabaseException;

    void edit(User user)  throws DatabaseException;

    User findById(Long id)throws DatabaseException;

    User findByEmailAndPassword(String email, String password) throws EntityNotFoundException, DatabaseException;


}
