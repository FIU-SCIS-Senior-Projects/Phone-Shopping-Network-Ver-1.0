package com.socialmobile.phoneshopping.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.socialmobile.common.json.JSONObjectFactory;
import com.socialmobile.common.model.Product;
import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.service.api.ProductService;
import com.socialmobile.phoneshopping.service.impl.ProductManager;
import com.socialmobile.phoneshopping.service.impl.UserProfileManager;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class Main  {

    public static void main(String[] as) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationConfig.xml");
        testUserProfileService(context);
//        testProductService(context);
    }

    private static void testProductService(final ApplicationContext pContext) {
        ProductService service = pContext.getAutowireCapableBeanFactory().getBean(ProductService.class);
        System.out.println("Service:: "+service);
        Product product = createProduct();
        try {
            System.out.println(String.format("Product As JSON: (%s)", JSONObjectFactory.getsInstance().objectToString(product)));
            Product created = service.create(product);
            System.out.println("Created Product:: "+created.getProductId());
            created.getAdditionalInfo().put("key4", "value4");
            Product updated = service.update(created.getProductId(), created);
            System.out.println(String.format("Is Equals: %s:::: addition info count: %d", (created == updated), updated.getAdditionalInfo().size()));
            service.delete(updated.getProductId());
        } catch (JsonProcessingException pE) {
            pE.printStackTrace();
        }
    }

    private static Product createProduct() {
        Product product = new Product();
//        product.setProductId(40);
        product.setTitle("Dummy Product");
        product.setDescription("This is a Dummy Product");
        product.setAdditionalInfo(new HashMap<String, String>(){{
            put("key1", "value1");
            put("key2", "value2");
            put("key3", "value3");
        }});
        return product;
    }

    private static void testUserProfileService(ApplicationContext context) {

        UserProfileManager manager = (UserProfileManager) context.getBean("userProfileService");
        try {
//            UserProfile profile1 = manager.create(getUserProfile("first.last"));
//            UserProfile profile = manager.get("first.last");
//            System.out.println("PROFF:: "+(profile == profile1));

            UserProfile profile = manager.get("first_last");
            profile.setPhone("+8801711585600");
            manager.update(profile.getUsername(), profile);
        } catch (Exception pE) {
            pE.printStackTrace();
        }
        System.out.println("manager:: "+ manager);
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
