package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class registration extends AppCompatActivity {
    private TextInputLayout Username,Email,Password;
    private Button Register,Button2;
    private ProgressBar bar1;

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Username = findViewById(R.id.name);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        Register = findViewById(R.id.Register);
        Button2 = findViewById(R.id.but2);
        bar1 = findViewById(R.id.circle3);



        mAuth = FirebaseAuth.getInstance();


        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar1.setVisibility(View.VISIBLE);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar1.setVisibility(View.VISIBLE);
                // ASSIGN CONTENT TO A final STRING

                final String userName = Username.getEditText().getText().toString();
                final String email = Email.getEditText().getText().toString();
                final String passWord= Password.getEditText().getText().toString();

                //create users using email and password

                mAuth.createUserWithEmailAndPassword(email,passWord)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    //create an instance of your model and assign your final string to it
                                    SignUp signUp = new SignUp(userName,email,passWord);

                                    //create your firebase
                                    FirebaseDatabase.getInstance().getReference("Customers")
                                            .child(mAuth.getCurrentUser().getUid())
                                            .setValue(signUp).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(registration.this,"registration successful",Toast.LENGTH_SHORT).show();

                                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                                startActivity(intent);

                                            }
                                            else{
                                                Toast.makeText(registration.this,"registration unsuccessful",Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(),registration.class);
                                                startActivity(intent);

                                            }

                                        }
                                    });



                                }
                                else {
                                    Toast.makeText(registration.this,"registration unsuccessful",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),registration.class);
                                    startActivity(intent);
                                }
                            }
                        });


            }
        });







    }
}