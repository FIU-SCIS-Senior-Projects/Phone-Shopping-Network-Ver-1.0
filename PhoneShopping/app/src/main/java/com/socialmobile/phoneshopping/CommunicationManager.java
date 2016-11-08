package com.socialmobile.phoneshopping;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.socialmobile.common.json.JSONObjectFactory;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * The main responsibility of this class is to provide a uniform way to accessing the resources and
 * maintain communication between the server and this client applicaiton.
 *
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */


public class CommunicationManager {
    private static final CommunicationManager cInstance = new CommunicationManager();

    private CommunicationManager() {

    }

    public static CommunicationManager instance() {
        return cInstance;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public <T> T doGet(final String pUrl, final Class<T> pType) throws IOException {
        String responseString = makeConnection(pUrl, "GET", 200, null);
        return JSONObjectFactory.getsInstance().stringToObject(responseString, pType);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String makeConnection(final String pUrl, final String pMethod, int pExpectedReturnCode, final Object pInput) throws IOException {
        HttpURLConnection connection = initConnection(pUrl, pMethod);

        connection.setDoInput(true);
        if (pInput != null) {
            connection.setDoOutput(true);
            try(OutputStream outputStream = connection.getOutputStream()) {
                writeData(outputStream, pInput);
            }
        }

        connection.connect();
        int response = connection.getResponseCode();
        if (response != pExpectedReturnCode) {
            String message = String.format("Connection to %s failed with status %d. Reason %s",
                    pUrl, response, IOUtils.toString(connection.getErrorStream(), "UTF-8"));
            throw new IOException(message);
        }

        String responseString = "";
        try(InputStream inputStream = connection.getInputStream()) {
            responseString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        finally {
            connection.disconnect();
        }

        return responseString;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public <T> String doCreate(final String pUrl, final T pObject) throws IOException {
        return makeConnection(pUrl, "POST", 201, pObject);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public <T> T doUpdate(final String pUrl, final T pObject) throws IOException {
        String responseString = makeConnection(pUrl, "PUT", 200, pObject);
        return (T) JSONObjectFactory.getsInstance().stringToObject(responseString, pObject.getClass());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private <T> void writeData(final OutputStream outputStream, final T pObject) throws IOException {
        String objectAsString = JSONObjectFactory.getsInstance().objectToString(pObject);
        IOUtils.write(objectAsString, outputStream, StandardCharsets.UTF_8);
    }

    private HttpURLConnection initConnection(final String pUrl, final String pMethod) throws IOException {
        URL url = new URL(pUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(10000);
        connection.setConnectTimeout(15000);
        connection.setRequestMethod(pMethod);
        connection.setDoInput(true);
        return connection;
    }
}
