package com.cyberinov8.camerafilterapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cyberinov8.camerafilterapp.utils.SharedPrefUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener {
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonConnect;
    private SharedPrefUtils sharedPreferences;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        editTextFirstName = view.findViewById(R.id.et_first_name_sign_up);
        editTextLastName = view.findViewById(R.id.et_last_name_sign_up);
        editTextEmail = view.findViewById(R.id.et_email_sign_up);
        editTextPassword = view.findViewById(R.id.et_password_sign_up);
        buttonConnect = view.findViewById(R.id.btn_connect);
        buttonConnect.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_connect:
                sharedPreferences = new SharedPrefUtils();
                String firstname = editTextFirstName.getText().toString();
                String lastname = editTextLastName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if (firstname.isEmpty() ||
                        lastname.isEmpty() ||
                        email.isEmpty() ||
                        password.isEmpty()) {
                    if (firstname.isEmpty()) {
                        editTextFirstName.setError(getResources().getString(R.string.error_first_name));
                    }
                    if (lastname.isEmpty()) {
                        editTextLastName.setError(getResources().getString(R.string.error_last_name));
                    }
                    if (email.isEmpty()) {
                        editTextEmail.setError(getResources().getString(R.string.error_email));
                    }
                    if (password.isEmpty()) {
                        editTextPassword.setError(getResources().getString(R.string.error_password));
                    }
                } else {
                    sharedPreferences.saveSharedPrefValue(getActivity(), getResources().getString(R.string.first_name), firstname);
                    sharedPreferences.saveSharedPrefValue(getActivity(), getResources().getString(R.string.last_name), lastname);
                    sharedPreferences.saveSharedPrefValue(getActivity(), getResources().getString(R.string.email), email);
                    sharedPreferences.saveSharedPrefValue(getActivity(), getResources().getString(R.string.passowrd), password);
                    Intent intent = new Intent(getActivity() , MainActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }
}
