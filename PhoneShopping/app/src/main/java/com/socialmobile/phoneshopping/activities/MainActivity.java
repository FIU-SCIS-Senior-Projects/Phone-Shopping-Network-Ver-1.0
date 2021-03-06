package com.socialmobile.phoneshopping.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.socialmobile.common.json.JSONObjectFactory;
import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.AppUtil;
import com.socialmobile.phoneshopping.ContentManager;
import com.socialmobile.phoneshopping.R;
import com.socialmobile.phoneshopping.fragments.AdDetailsFragment;
import com.socialmobile.phoneshopping.fragments.FragmentBase;
import com.socialmobile.phoneshopping.fragments.TNCFragment;
import com.socialmobile.phoneshopping.fragments.UserRegistrationFragment;
import com.socialmobile.phoneshopping.model.ActionResult;

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class MainActivity extends FragmentActivity implements TNCFragment.ActionListener {
    private static final int TNCAction = 100;
    private static final int AdDetailsAction = 200;
    private static final int RegistrationAction = 300;

    private ContentManager mContentManager = ContentManager.instance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentBase fragmentBase =  getLandingFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, fragmentBase).commit();

    }

    private FragmentBase getLandingFragment() {
        FragmentBase fragmentBase;
        if (isLaunchedForTheFirstTime()) {
            fragmentBase = getragmentForTNC();
        }
        else {
            if (isRegisteredUser()) {
                fragmentBase = getFragmentForAdDetails();
            }
            else {
                fragmentBase = getFragmentForUserRegistration();
            }
        }

        return fragmentBase;
    }

    private TNCFragment getragmentForTNC() {
        TNCFragment fragment = new TNCFragment();
        fragment.setActionCallback(TNCAction, this);

        return fragment;
    }

    private AdDetailsFragment getFragmentForAdDetails() {
        AdDetailsFragment fragment = new AdDetailsFragment();
        fragment.setActionCallback(AdDetailsAction, this);

        return fragment;
    }

    private UserRegistrationFragment getFragmentForUserRegistration() {
        UserRegistrationFragment fragment = new UserRegistrationFragment();
        fragment.setActionCallback(RegistrationAction, this);

        return fragment;
    }

    private boolean isLaunchedForTheFirstTime() {
        return AppUtil.isLaunchedForTheFirstTime(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.action_show_tnc) {
            getSupportFragmentManager().popBackStack();
            FragmentBase fragmentBase = getragmentForTNC();
            getSupportFragmentManager().beginTransaction()
                    .addToBackStack("action_show_tnc")
                    .replace(R.id.frame_container, fragmentBase)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isRegisteredUser() {
//        TODO:: add proper implementation to determine if the user is registered
        return AppUtil.isUserAlreadyRegistered(this);
    }

    @Override
    public void onActionPerformed(int pId, ActionResult pResult) {
        if (pId == TNCAction) {
            onTNCActionPerformed((TNCFragment.TNCResult)pResult.get());
        }
        else if (pId == RegistrationAction) {
              onRegistrationActionPerformed ((UserProfile) pResult.get());
        }
        else if (pId == AdDetailsAction) {
//         TODO: Show what
        }
    }

    private void onRegistrationActionPerformed(final UserProfile pResult){
        if (pResult != null) {
            new RegistrationActionTask(pResult).execute();
        }
    }

    private void changeFragment() {
        Fragment fragment = getPreviousFragment();
        if (fragment == null) {
            fragment = getLandingFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
    }

    private void onTNCActionPerformed(final TNCFragment.TNCResult pResult) {
        if (pResult != TNCFragment.TNCResult.NONE) {
            boolean oldValue = AppUtil.isAcceptedTNC(this);
            boolean newValue = pResult == TNCFragment.TNCResult.ACCEPT;
            if (oldValue != newValue) {
                AppUtil.storeAcceptanceOfTNC(newValue, this);
            }
        }

        changeFragment();
    }

    private Fragment getPreviousFragment() {
        int index = getFragmentManager().getBackStackEntryCount() - 1;
        Fragment fragment = null;
        if (index >= 0) {
            FragmentManager.BackStackEntry backEntry = getSupportFragmentManager().getBackStackEntryAt(index);
            String tag = backEntry.getName();
            fragment = getSupportFragmentManager().findFragmentByTag(tag);
        }

        return fragment;
    }

    class RegistrationActionTask extends AsyncTask<Void, Void, Boolean> {

        private final UserProfile mUserProfile;
        private String mErrorMessage = "";

        public RegistrationActionTask(final UserProfile pProfile) {
            mUserProfile = pProfile;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                mContentManager.registerUser(mUserProfile);
                return true;
            } catch (IOException e) {
                mErrorMessage = e.getLocalizedMessage();
                e.printStackTrace();
            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (aBoolean == false || mErrorMessage != null || mErrorMessage.length() != 0)
            {
                System.out.println("ERROR:"+mErrorMessage);
                //todo:: Show error messages
            }
            try {
                AppUtil.setStringPreference(MainActivity.this, AppUtil.USER_REGISTERED_KEY, JSONObjectFactory.getsInstance().objectToString(mUserProfile));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            changeFragment();
        }
    }

}
