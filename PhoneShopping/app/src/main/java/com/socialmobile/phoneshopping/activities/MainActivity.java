package com.socialmobile.phoneshopping.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.socialmobile.phoneshopping.R;
import com.socialmobile.phoneshopping.fragments.AdDetailsFragment;
import com.socialmobile.phoneshopping.fragments.FragmentBase;
import com.socialmobile.phoneshopping.fragments.TNCFragment;
import com.socialmobile.phoneshopping.fragments.UserRegistrationFragment;
import com.socialmobile.phoneshopping.model.ActionResult;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentBase fragmentBase = getLandingFragment();
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
//        TODO:: implement proper way to store and retrieve something to determine the first time.
        return true;
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

        return super.onOptionsItemSelected(item);
    }

    public boolean isRegisteredUser() {
//        TODO:: add proper implementation to determine if the user is registered
        return false;
    }

    @Override
    public void onActionPerformed(int pId, ActionResult pResult) {

    }
}
