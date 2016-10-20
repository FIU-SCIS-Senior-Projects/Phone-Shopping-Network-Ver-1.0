package com.socialmobile.phoneshopping.model;

import com.socialmobile.common.json.JSONObjectFactory;
import com.socialmobile.common.model.UserProfile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class UserProfileTest {
    JSONObjectFactory mObjectFactory = JSONObjectFactory.getsInstance();

    @Before
    public void setUp() {
//        mObjectFactory = JSONObjectFactory.getsInstance();
    }

    @Test
    public void testJSONToObject() {
        UserProfile profile = new UserProfile();
        profile.setUsername("user@example.com");
        profile.setFirstName("First");
        profile.setLastName("Last");
        profile.setEmail(profile.getUsername());
        profile.setPhone("+18888888");

        try {
            String stringRep = mObjectFactory.objectToString(profile);
            System.out.println(stringRep);
            UserProfile profile2 = mObjectFactory.stringToObject(stringRep, UserProfile.class);
            Assert.assertTrue("The constructed information from the string representation does not match", isExactlyEqual(profile, profile2));
        } catch (java.io.IOException pE) {
            pE.printStackTrace();
        }
//        {
//          "lastName":"Last",
//          "phone":"+18888888",
//          "username":"user@example.com",
//          "firstName":"First",
//          "email":"user@example.com",
//          "firstname":"First",
//          "lastname":"Last"}
    }

    private boolean isExactlyEqual(final UserProfile pProfile, final UserProfile pProfile2) {
        return pProfile.getUsername().equals(pProfile2.getUsername()) &&
                pProfile.getFirstName().equals(pProfile2.getFirstName()) &&
                pProfile.getLastName().equals(pProfile2.getLastName()) &&
                pProfile.getEmail().equals(pProfile2.getEmail()) &&
                pProfile.getPhone().equals(pProfile2.getPhone());
    }
}
