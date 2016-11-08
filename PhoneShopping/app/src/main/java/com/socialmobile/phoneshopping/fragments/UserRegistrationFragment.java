package com.socialmobile.phoneshopping.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.R;

import java.util.HashMap;

public class UserRegistrationFragment extends FragmentBase<UserProfile> {

    private EditText mFirstNameEditor;
    private EditText mLastNameEditor;
    private EditText mUsernameEditor;
    private EditText mEmailEditor;
    private EditText mPhoneEditor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.user_egistration, container,false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFirstNameEditor = (EditText) view.findViewById(R.id.input_firstname);
        mLastNameEditor = (EditText) view.findViewById(R.id.input_lastname);
        mUsernameEditor = (EditText) view.findViewById(R.id.input_username);
        mEmailEditor = (EditText) view.findViewById(R.id.input_email);
        mPhoneEditor = (EditText) view.findViewById(R.id.input_phone);

        Button signupButton = (Button) view.findViewById(R.id.signup_btn);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserProfile profile = new UserProfile();
                profile.setFirstName(mFirstNameEditor.getText().toString());
                profile.setLastName(mLastNameEditor.getText().toString());
                profile.setUsername(mUsernameEditor.getText().toString());
                profile.setEmail(mEmailEditor.getText().toString());
                profile.setPhone(mPhoneEditor.getText().toString());

                sendActionResult(profile);
            }
        });
    }

}