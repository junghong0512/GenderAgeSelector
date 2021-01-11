package com.example.genderageselect;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intent = getIntent();
        String gender = intent.getExtras().getString("selected_gender");
        String age = intent.getExtras().getString("selected_age");

        TextView genderTextView = findViewById(R.id.sGender);
        TextView ageTextView = findViewById(R.id.sAge);

        genderTextView.setText(gender);
        ageTextView.setText(age);

    }
}
