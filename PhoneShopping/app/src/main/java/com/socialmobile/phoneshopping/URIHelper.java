package com.socialmobile.phoneshopping;

/**
 * A temporary class for generating the urls to accessing the resources from the server. Ideally the
 * client app should not assume anything about these. For now, this approach is being used to keep
 * things simple. In later version this should be replaced by a dynamic relocation approach. In that
 * approach all the available resources to this application client for this particular user should
 * come from the server.
 *
 * TODO: Consider replacing this with a proper relocation strategy.
 *
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class URIHelper {
    public static final String CONTENT_BASE_URL = "http://52.45.13.112:8080/phoneshopping-webapp/";
//    public static final String CONTENT_BASE_URL = "http://localhost:8080/phoneshopping-webapp/";

    public static final String SERVICE_BASE_URL = CONTENT_BASE_URL + "service/";

    /**
     * The base url for accessing the resource for user. It is suitable for POST request only.
     * @return The base url for accessing the resource for user.
     */
    public static String getUrlForUser() {
        return String.format("%suser/", SERVICE_BASE_URL);
    }

    /**
     * The Url suitable for addressing a specific user.  This can be used for retrieving the user
     * information or updating it or even deleting the user.
     * @param pUserName The Identifier of the user
     * @return The suitable url for accessing the specific user.
     */
    public static String getUrlForUser(final String pUserName) {
        return String.format("%s%s/", getUrlForUser(), pUserName);
    }
}
