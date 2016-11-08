package com.socialmobile.phoneshopping;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.socialmobile.common.model.UserProfile;

import java.io.IOException;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */


public class ContentManager {
    private static ContentManager cInstance = new ContentManager();

    private CommunicationManager mCommunicationManager = CommunicationManager.instance();

    protected ContentManager() {

    }

    public static ContentManager instance() {
        return cInstance;
    }

    public UserProfile getDefaultUser() {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public UserProfile getUserInfo(final String pUserName) throws IOException {
        String url = URIHelper.getUrlForUser(pUserName);
        return mCommunicationManager.doGet(url, UserProfile.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public boolean registerUser(final UserProfile pUserProfile) throws IOException {
        String url = URIHelper.getUrlForUser();
        mCommunicationManager.doCreate(url, pUserProfile);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public UserProfile updateUser(final UserProfile pCurrentProfile) throws IOException {
        String url = URIHelper.getUrlForUser(pCurrentProfile.getUsername());
        return mCommunicationManager.doUpdate(url, pCurrentProfile);
    }
}
