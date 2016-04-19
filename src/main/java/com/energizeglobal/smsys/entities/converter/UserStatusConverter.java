package com.energizeglobal.smsys.entities.converter;

import com.energizeglobal.smsys.entities.lcp.UserStatus;

import javax.persistence.AttributeConverter;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class UserStatusConverter implements AttributeConverter<UserStatus, Integer > {

    @Override
    public Integer convertToDatabaseColumn(UserStatus status) {
        return status.getValue();
    }

    @Override
    public UserStatus convertToEntityAttribute(Integer dbData) {
        return UserStatus.valueOf(dbData);
    }
}
