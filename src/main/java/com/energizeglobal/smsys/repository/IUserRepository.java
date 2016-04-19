package com.energizeglobal.smsys.repository;


import com.energizeglobal.smsys.entities.User;
import com.energizeglobal.smsys.exception.DatabaseException;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public interface IUserRepository {

    void add(User user);

    void edit(User user);

    User findById(Long id);

    User findByEmailAndPassword(String email, String password);

}
