package com.energizeglobal.smsys.entities.lcp;

/**
 * Description for class.
 *
 * @author <a href="mailto:adamm@energizeglobal.com">Adam Madoyan</a>
 */
public enum UserStatus {

    ACTIVE(1),
    INACTIVE(2);

    UserStatus(int value) {
        this.value = value;
    }

    private int value;

    public static UserStatus valueOf(int value) {
        for (UserStatus userType : UserStatus.values()) {
            if (value == userType.value) {
                return userType;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
