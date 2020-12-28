package com.dsi31.g2.nomorecovid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Fragment_SignIn extends Fragment
{
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private EditText email, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        email = view.findViewById(R.id.signin_email);
        password = view.findViewById(R.id.signin_password);

        view.findViewById(R.id.btn_signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (CheckFields())
                {
                    LogIn(email.getText().toString(), password.getText().toString());
                }
            }
        });
        return view;

    }

    public boolean CheckFields()
    {
        if (email.length() == 0)
        {
            Toast.makeText(getContext(),"enter your email please", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (password.getText().toString().equals(""))
        {
            Toast.makeText(getContext(),"enter your password please",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void LogIn(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                FirebaseDatabase database = FirebaseDatabase.getInstance();

                if (task.isSuccessful())
                {
                    startActivity(new Intent(getContext(), WelcomeActivity.class));
                    Toast.makeText(getContext(), "Signed In " , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getContext(), "Error: " + task.getException().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}