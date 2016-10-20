package com.socialmobile.common.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmobile.common.model.UserProfile;

import java.io.IOException;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class JSONObjectFactory {

    private static final JSONObjectFactory sInstance = new JSONObjectFactory();
    private ObjectMapper mObjectMapper;

    private JSONObjectFactory() {

    }

    public static JSONObjectFactory getsInstance() {
        return sInstance;
    }

    public ObjectMapper getObjectMapper() {
        if (mObjectMapper == null) {
            mObjectMapper = new ObjectMapper();
            mObjectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
            mObjectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        }
        return mObjectMapper;
    }

    public <T> String objectToString(final T pObject) throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(pObject);
    }

    public <T> T stringToObject(final String pString, final Class<T> pType) throws IOException {
        return getObjectMapper().readValue(pString, pType);
    }

//    public String userProfileToString(final UserProfile pUserProfile) throws JsonProcessingException {
//        return getObjectMapper().writeValueAsString(pUserProfile);
//    }
//
//    public UserProfile stringToUserProfile(final String pUserProfile) throws IOException {
//        return getObjectMapper().readValue(pUserProfile, UserProfile.class);
//    }
}
