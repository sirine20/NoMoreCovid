package com.dsi31.g2.nomorecovid;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Fragment_SignUp extends Fragment
{


    private EditText email, username, password, confirmpassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        email = view.findViewById(R.id.signup_email);
        username = view.findViewById(R.id.signup_username);
        password = view.findViewById(R.id.signup_password);
        confirmpassword = view.findViewById(R.id.signup_confirm_password);


        view.findViewById(R.id.btn_create_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (CheckFields())
                {
                    CreateVisitorAccount(email.getText().toString(), password.getText().toString());
                }            }
        });

        return view;
    }

    public void CreateVisitorAccount(String email, String password)
    {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                FirebaseDatabase database = FirebaseDatabase.getInstance();

                Log.e("email password", email + password);

                if (task.isSuccessful())
                {
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(getContext(),"Connect" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getContext(),"Error" + task.getException().toString(), Toast.LENGTH_SHORT).show();
                    Log.e("ERRRROR", task.getException().toString());
                }
            }
        });

    }

    private boolean CheckFields()
    {
        if (email.length() == 0)
        {
            Toast.makeText(getContext(),"check your email please",Toast.LENGTH_SHORT).show();
            return false;
        }
        else   if (username.length() == 0)
        {
            Toast.makeText(getContext(),"check your username please",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (password.length() == 0)
        {
            Toast.makeText(getContext(),"check your password please",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!password.getText().toString().equals(confirmpassword.getText().toString()))
        {
            Toast.makeText(getContext(),"the passwords entered are not matched",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}