package com.energizeglobal.smsys.pages.api;

import com.energizeglobal.smsys.exception.DatabaseException;
import com.energizeglobal.smsys.pages.BaseAction;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.upload.services.UploadedFile;

import java.io.File;
import java.util.Random;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class EditProfile extends BaseAction {

    Random rand = new Random();

    @Property
    private UploadedFile avatar;

    @InjectComponent
    private BeanEditForm editForm;


    public Object onSuccess() {

        String dir = messages.get("application.image.path")  + user.getId();

        try {
            int value = rand.nextInt(900) + 100;
            File targetFile = new File(dir);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            File pic = new File(dir + File.separator + value + avatar.getFileName());

            user.setAvatar(pic);
            userManager.edit(user);

            avatar.write(pic);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        return Home.class;

    }


}
