package com.socialmobile.phoneshopping.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.socialmobile.common.json.JSONObjectFactory;
import com.socialmobile.common.model.*;
import com.socialmobile.phoneshopping.service.api.OrderService;
import com.socialmobile.phoneshopping.service.api.ProductService;
import com.socialmobile.phoneshopping.service.impl.OrderServiceManager;
import com.socialmobile.phoneshopping.service.impl.UserProfileManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class Main  {

    private final ApplicationContext mContext;

    public Main(final ApplicationContext pContext) {
        mContext = pContext;
    }

    public static void main(String[] as) throws JsonProcessingException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationConfig.xml");
//        testUserProfileService(context);
//        testProductService(context);

        Main main = new Main(context);
//        main.testFullWorkflow();
//        main.testExistingOrder(3);
//        main.testExistingOrder(4);
//        main.testExistingOrder(5);
//        main.testExistingOrder(6);
//        main.testExistingOrder(7);
//        main.getAllOrders();

        main.getAllProducts();
    }

    private void getAllProducts() throws JsonProcessingException {
        ProductService service = mContext.getAutowireCapableBeanFactory().getBean(ProductService.class);
        List<Product> products = service.getProducts(0, 100);
        for (Product product : products) {
            System.out.println(JSONObjectFactory.getsInstance().objectToString(product));
        }
    }

    private void getAllOrders() throws JsonProcessingException {
        OrderService service = mContext.getAutowireCapableBeanFactory().getBean(OrderService.class);
        List<Order> orders = service.getOrders(0, 100);
        System.out.println(JSONObjectFactory.getsInstance().objectToString(orders));
    }

    private void testExistingOrder(final int pOrderId) throws JsonProcessingException {
        OrderService service = mContext.getAutowireCapableBeanFactory().getBean(OrderService.class);
        Order order = service.get(pOrderId);
        System.out.println(JSONObjectFactory.getsInstance().objectToString(order));
    }

    private void testFullWorkflow() throws JsonProcessingException {
        UserProfile userProfile = getOrCreateUser("integrator7");
        Product product = createNewProduct();
        Order order = placeOrder(userProfile, product);

        System.out.println(JSONObjectFactory.getsInstance().objectToString(order));
    }

    private UserProfile getOrCreateUser(final String pIntegrator7) {
        UserProfileManager manager = (UserProfileManager) mContext.getBean("userProfileService");
        UserProfile userProfile = manager.get(pIntegrator7);
        if (userProfile == null) {
            userProfile = createUser(pIntegrator7);
        }
        return userProfile;
    }

    private Order placeOrder(final UserProfile pUserProfile, final Product pProduct) {
        OrderService service = mContext.getAutowireCapableBeanFactory().getBean(OrderService.class);

        Order order = initializeAnOrder(pUserProfile, pProduct);
        Order placed = service.create(order);
        return placed;
    }

    private Order initializeAnOrder(final UserProfile pUserProfile, final Product pProduct) {
        Order order = new Order();
        order.setUserName(pUserProfile.getUsername());
        order.setListedProducts(new ArrayList<ProductOrder>(){{
            add(createProductOrder(pProduct.getProductId(), 5, 9.94f));
        }});
        order.setBillingAddress(getAddress("10274 SW 102 Ave suit 201", "Miami", "FL", "33178"));
        order.setShippingAddress(getAddress("10274 SW 103 Ave suit 202", "Miami", "FL", "33178"));

        return order;
    }

    private Address getAddress(final String pStreet, final String pCity, final String pState, final String pZip) {
        Address address = new Address();
        address.setAddressLineOne(pStreet);
        address.setCity(pCity);
        address.setState(pState);
        address.setZipCode(pZip);

        return address;
    }

    private ProductOrder createProductOrder(final int pProductId, final int pCount, final float pUnitPice) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProductId(pProductId);
        productOrder.setCount(pCount);
        productOrder.setUnitPrice(pUnitPice);

        return productOrder;
    }

    private Product createNewProduct() {
        ProductService service = mContext.getAutowireCapableBeanFactory().getBean(ProductService.class);

        Product product = initAProduct();
        Product created = service.create(product);
        return created;
    }

    private Product initAProduct() {
        Product product = new Product();
        product.setTitle("Integration product");
        product.setDescription("This is a product for integration");
        product.setAdditionalInfo(new HashMap<String, String>(){{
            put("Key1", "Value1");
            put("Key2", "Value2");
            put("Key3", "Value3");
        }});

        return product;
    }

    private UserProfile createUser(final String pIntegrator) {
        UserProfileManager manager = (UserProfileManager) mContext.getBean("userProfileService");
        UserProfile profile = getUserProfile(pIntegrator);
        manager.create(profile);

        return manager.get(pIntegrator);
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

    private UserProfile getUserProfile(final String pS) {
        UserProfile profile = new UserProfile();
        profile.setUsername(pS);
        profile.setFirstName("First");
        profile.setLastName("Last");
        profile.setEmail("first_last@example.com");
        profile.setPhone("+17863079294");
        return profile;
    }
}
