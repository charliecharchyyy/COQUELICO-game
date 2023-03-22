package com.example.assignment;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class recordActivity extends AppCompatActivity {


    DatabaseHelper mDatabaseHelper;
    private EditText editText,editScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        editText = findViewById(R.id.playerName);
        editScore = findViewById(R.id.score);
        mDatabaseHelper = new DatabaseHelper(this);

    }

    public void saveResult(View view){

        String newEntry = "PLAYER NAME: " + editText.getText().toString()
                            +"\nSCORE: "
                            +editScore.getText().toString();
        if (editText.length() != 0) {
            AddData(newEntry);
            editText.setText("");
        } else {
            toastMessage("You must put something in the text field!");
        }

        Intent intent = new Intent(this,LeaderboardsActivity.class);
        startActivity(intent);
        finish();

    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}