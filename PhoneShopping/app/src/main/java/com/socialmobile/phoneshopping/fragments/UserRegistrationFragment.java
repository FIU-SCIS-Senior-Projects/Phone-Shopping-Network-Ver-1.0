package com.socialmobile.phoneshopping.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.socialmobile.phoneshopping.R;

import java.util.HashMap;

public class UserRegistrationFragment extends FragmentBase<HashMap> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.user_egistration, container,false);
    }


    @Override
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText firstName= (EditText) view.findViewById(R.id.input_Firstname);
        final EditText lastName = (EditText) view.findViewById(R.id.input_Lastname);
        final EditText Email = (EditText) view.findViewById(R.id.input_Email);

        Button signupButton = (Button) view.findViewById(R.id.signup_btn);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> result = new HashMap<String, String>();
                result.put("firstname", firstName.getEditableText().toString());
                result.put("lastname", lastName.getText().toString());
                result.put("email", Email.getText().toString());
                sendActionResult(result);
            }
        });
    }

}