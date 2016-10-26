package com.socialmobile.phoneshopping.service.dao;

import com.socialmobile.common.model.UserProfile;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class DummyuserProfileDAO implements UserProfileDAO {

    private final HashMap<String, UserProfile> mUsersMap = new HashMap<>();

    @Override
    public boolean exists(final String pIdToCheck) {
        return mUsersMap.containsKey(pIdToCheck);
    }

    @Override
    public UserProfile get(final String pIdToGet) {
        return mUsersMap.get(pIdToGet);
    }

    @Override
    public UserProfile create(final Optional<UserProfile> pObjectToCreate) {
        UserProfile profile = pObjectToCreate.get();
        mUsersMap.put(profile.getUsername(), profile);
        return profile;
    }

    @Override
    public UserProfile update(final String pTargetObjectId, final Optional<UserProfile> pUpdateWith) {
        UserProfile oldProfile = mUsersMap.get(pTargetObjectId);
        if (oldProfile == null) {
            return null;
        }
        else {
            UserProfile newProfile = pUpdateWith.get();
            UserProfile profile = new UserProfile();
            profile.setUsername(pTargetObjectId);
            profile.setFirstName(newProfile.getFirstName());
            profile.setLastName(newProfile.getLastName());
            profile.setEmail(newProfile.getEmail());
            profile.setPhone(newProfile.getPhone());
            mUsersMap.put(pTargetObjectId, profile);

            return profile;
        }
    }

    @Override
    public boolean delete(final String pIdToDelete) {
        UserProfile profile = mUsersMap.get(pIdToDelete);
        if (mUsersMap.containsKey(pIdToDelete)) {
            return mUsersMap.remove(pIdToDelete, mUsersMap.get(pIdToDelete));
        }

        return false;
    }
}
