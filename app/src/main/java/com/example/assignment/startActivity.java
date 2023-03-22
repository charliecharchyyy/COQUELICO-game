package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class startActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

    }

    public void startNow(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void showLeaderboard(View view){
        Intent intent = new Intent(this,LeaderboardsActivity.class);
        startActivity(intent);
        finish();
    }

    public void showRules(View view){
        Intent intent = new Intent(this,GameRulesActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit_app(View view){
        finish();
    }
}
