package com.socialmobile.phoneshopping.service;

import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.service.impl.UserProfileManager;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class Main  {

    public static void main(String[] as) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationConfig.xml");
        UserProfileManager manager = (UserProfileManager) context.getBean("userProfileService");
        try {
            UserProfile profile1 = manager.create(getUserProfile("first.last"));
            UserProfile profile = manager.get("first.last");
            System.out.println("PROFF:: "+(profile == profile1));
        } catch (Exception pE) {
            pE.printStackTrace();
        }
        System.out.println("manager:: "+ manager);
//        System.out.println("Exists: "+manager.exists("first.last"));
    }

    private static UserProfile getUserProfile(final String pS) {
        UserProfile profile = new UserProfile();
        profile.setUsername(pS);
        profile.setFirstName("First");
        profile.setLastName("Last");
        profile.setEmail(pS);
        profile.setPhone("+18888888");
        return profile;
    }
}
