package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private TextInputLayout Email,Password;
    private Button login, Register;
    FirebaseAuth mAuth;
    private CheckBox checkBox;
    private ProgressBar bar;

    private final String SHARED_PREF = "sharedpref";
    private final String KEY_EMAILL = "email";
    private final String KEY_PASSWORDD = "password";
    private final String KEY_CHECK_BOX = "checkbox";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        checkBox = findViewById(R.id.checkbox);
        Register = findViewById(R.id.but1);
        login = findViewById(R.id.login);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        bar = findViewById(R.id.circle2);

        mAuth = FirebaseAuth.getInstance();


        //sharedpreferences
        sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        final String email = sharedPreferences.getString(KEY_EMAILL,null);
        final String password = sharedPreferences.getString(KEY_PASSWORDD,null);
        final String checkbox= sharedPreferences.getString(KEY_CHECK_BOX,"False");

        Email.getEditText().setText(email);
        Password.getEditText().setText(password);

        if(checkbox.equals("True")){
            checkBox.setChecked(true);
        }
        else {
            checkBox.setChecked(false);
        }



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.setVisibility(View.VISIBLE);
                // sharedpreference
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(checkBox.isChecked()){
                    editor.putString(KEY_EMAILL,Email.getEditText().getText().toString());
                    editor.putString(KEY_PASSWORDD,Password.getEditText().getText().toString());
                    checkBox.setChecked(true);
                    editor.apply();

                }
                else{
                    editor.putString(KEY_EMAILL,"");
                    editor.putString(KEY_PASSWORDD,"");
                    editor.apply();

                }


                final String EMAIL = Email.getEditText().getText().toString().trim();
                final String PASSWORD = Password.getEditText().getText().toString().trim();

                mAuth.signInWithEmailAndPassword(EMAIL,PASSWORD)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Email.setErrorEnabled(false);
                                    Email.setError(null);
                                    Password.setErrorEnabled(false);
                                    Password.setError(null);

                                    Toast.makeText(login.this,"LOGIN SUCCESSFUL!!",Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), retrofit.class);
                                    startActivity(intent);

                                }
                                else {
                                    Toast.makeText(login.this,"Incorrect credential",Toast.LENGTH_SHORT).show();
                                    Email.setError("Incorrect Email or Password");
                                    Email.requestFocus();
                                    Password.setError("Incorrect Email or Password");
                                    Password.requestFocus();

                                }
                            }
                        });



            }


        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(getApplicationContext(),registration.class);
                startActivity(intent);
            }
        });






    }
}