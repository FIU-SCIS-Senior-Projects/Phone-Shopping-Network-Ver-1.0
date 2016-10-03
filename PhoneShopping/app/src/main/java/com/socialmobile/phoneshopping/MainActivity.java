package com.socialmobile.phoneshopping;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.socialmobile.phoneshopping.fragments.AdDetailsFragment;
import com.socialmobile.phoneshopping.fragments.TNCFragment;
import com.socialmobile.phoneshopping.fragments.UserRegistrationFragment;

/**
 *
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class MainActivity extends FragmentActivity implements TNCFragment.ActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isLaunchedForTheFirstTime()) {
            TNCFragment fragment = new TNCFragment();
            fragment.setCallback(this);
            getSupportFragmentManager().beginTransaction().add(fragment, "tnc").commit();
        }
        else {
            if (isRegisteredUser()) {
                UserRegistrationFragment fragment = new UserRegistrationFragment();
//                TODO:: initialize the fragment;
                getSupportFragmentManager().beginTransaction().add(fragment, "registration").commit();
            }
            else {
                AdDetailsFragment fragment = new AdDetailsFragment();
//                TODO:: initialize the fragment;
                getSupportFragmentManager().beginTransaction().add(fragment, "showAdDetails").commit();
            }
        }
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
    public void onTNCActionPerformed(TNCFragment.AcceptTNCResult pResult) {
        System.out.println("TNC Action Performed: "+pResult);
    }
}
