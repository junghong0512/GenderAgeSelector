package com.example.genderageselect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import me.mutasem.booleanselection.BooleanSelectionView;

public class MainActivity extends AppCompatActivity {

    BooleanSelectionView gender;
    String sGender="남자;
    String sAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Gender selector
        gender = findViewById(R.id.gender);
        gender.setSelection(BooleanSelectionView.Selection.Start);
        gender.setSelectionListener(new BooleanSelectionView.SelectionListener() {
            @Override
            public void onSelectionChanged(int selection, String selectedText) {
                sGender = selectedText;
            }
        });


        // Spinner
        Spinner spinner = (Spinner) findViewById(R.id.ages);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ages, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        // 제출 Button
        button = (Button) findViewById(R.id.next_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sAge = spinner.getSelectedItem().toString();
                openNewActivity();
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra("selected_gender", sGender);
        intent.putExtra("selected_age", sAge);
        startActivity(intent);
    }
}
