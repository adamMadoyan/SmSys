package com.energizeglobal.smsys.entities.converter;

import com.energizeglobal.smsys.entities.lcp.UserType;

import javax.persistence.AttributeConverter;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class UserTypeConverter implements AttributeConverter<UserType,Integer > {

    @Override
    public Integer convertToDatabaseColumn(UserType type) {
        return type.getId();
    }

    @Override
    public UserType convertToEntityAttribute(Integer dbData) {
        return UserType.valueOf(dbData);
    }
}
