package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity {

    ImageView imageView;
    TextView ID, DATE, TITLE,IMAGE;
    Button LogOut;
    private ProgressBar bar2;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imageView = findViewById(R.id.images);
        ID = findViewById(R.id.id);
        DATE = findViewById(R.id.datecreated);
        TITLE = findViewById(R.id.head);
        LogOut = findViewById(R.id.button);
        bar2 = findViewById(R.id.circle1);
        IMAGE = findViewById(R.id.Imagess);


        auth = FirebaseAuth.getInstance();

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar2.setVisibility(View.VISIBLE);
                auth.getInstance().signOut();

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



        Intent intent = getIntent();
        String Id = intent.getStringExtra("id");
        String Date = intent.getStringExtra("Date");
        String Title = intent.getStringExtra("Title");
        String Images = intent.getStringExtra("image");
        int Image = intent.getIntExtra("image",R.drawable.image_6);


        imageView.setImageResource(Image);
        ID.setText(Id);
        DATE.setText(Date);
        TITLE.setText(Title);
        IMAGE.setText(Images);



    }
}