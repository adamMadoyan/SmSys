package com.energizeglobal.smsys.pages.api;

import com.energizeglobal.smsys.pages.BaseAction;
import com.energizeglobal.smsys.pages.Login;
import org.apache.commons.io.FileUtils;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.services.Session;
import org.apache.tapestry5.upload.services.UploadedFile;

import java.io.*;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class Home extends BaseAction {


    public byte [] getTest() {
        try {
            byte [] res = FileUtils.readFileToByteArray(new File("/home/adamm/Music6download.jpg"));
            System.out.println(res.length);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    void onActivate() {

    }

    @OnEvent
    public Object onActionInvalidate() {

        Session session = request.getSession(true);
        if (session != null) {
            session.invalidate();
        }

        return Login.class;
    }

}
