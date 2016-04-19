package com.energizeglobal.smsys.entities.converter;

import javax.persistence.AttributeConverter;
import java.io.File;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class UserAvatarConverter implements AttributeConverter<File, String> {

    @Override
    public String convertToDatabaseColumn(File avatar) {
        return avatar.getAbsolutePath();
    }

    @Override
    public File convertToEntityAttribute(String path) {
        return new File(path);
    }

}
