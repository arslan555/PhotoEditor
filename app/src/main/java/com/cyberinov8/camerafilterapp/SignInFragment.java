package com.cyberinov8.camerafilterapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cyberinov8.camerafilterapp.utils.SharedPrefUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment implements View.OnClickListener {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignIn;
    private Button buttonFacebookLogin;
    private SharedPrefUtils sharedPrefUtils;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sharedPrefUtils = new SharedPrefUtils();
        String email = sharedPrefUtils.getSharedPrefValue(getActivity(), getResources().getString(R.string.email));
        String password = sharedPrefUtils.getSharedPrefValue(getActivity(), getResources().getString(R.string.passowrd));
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        editTextEmail = view.findViewById(R.id.et_email_sign_in);
        editTextPassword = view.findViewById(R.id.et_password_sign_in);
        buttonSignIn = view.findViewById(R.id.btn_sign_in);
        buttonFacebookLogin = view.findViewById(R.id.btn_fb_sign_in);
        editTextEmail.setText(email);
        editTextPassword.setText(password);
        buttonSignIn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_in:
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {
                    if (email.isEmpty()) {
                        editTextEmail.setError(getResources().getString(R.string.error_email));
                    }
                    if (password.isEmpty()) {
                        editTextPassword.setError(getResources().getString(R.string.error_password));
                    }
                } else {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
