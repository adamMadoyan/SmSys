package com.energizeglobal.smsys.entities.lcp;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public enum UserType {

    ADMIN(1, "Adminstrator"),
    USER(2, "USER");

    UserType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    private int id;
    private String type;

    public static UserType valueOf(int id) {
        for (UserType userType : UserType.values()) {
            if (id == userType.id) {
                return userType;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
