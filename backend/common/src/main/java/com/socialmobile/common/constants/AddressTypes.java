package com.socialmobile.common.constants;


/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public enum AddressTypes {
    HOME("home"),
    WORK("work"),
    BILLING("billing"),
    SHIPPING("shipping");


    private final String mName;

    AddressTypes(final String pName) {
        mName = pName;
    }

    public String getName() {
        return mName;
    }
}
