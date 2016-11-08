package com.socialmobile.phoneshopping.service.api;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public enum RoleNames {
    USER("user"),
    ADMIN("admin");

    private final String mName;

    RoleNames(final String pName) {
        mName = pName;
    }

    public String getName() {
        return mName;
    }
}
