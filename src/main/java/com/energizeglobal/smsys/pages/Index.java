package com.energizeglobal.smsys.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public class Index {


    Object onActivate() {
        return Login.class;
    }

    @Property @Persist
    private int count;

    public String getHello() {
        return "Hello our great team :)";
    }


    void onActionFromTest() {
        count++;
    }
}
