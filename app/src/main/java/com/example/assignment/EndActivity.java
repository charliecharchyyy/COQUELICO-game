package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.Adapter.ContinueAdapter;
import com.example.assignment.object.playerInfo;

import org.w3c.dom.Text;

public class EndActivity extends AppCompatActivity {

    TextView textLevel;
    int level=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        init();
        findWay();
        setUp();
        setClick();
    }

    private void init(){
        level=getIntent().getIntExtra("level",0);
    }

    private void findWay(){
        textLevel = findViewById(R.id.textLevel);

    }

    private void setUp(){
        textLevel.setText(""+level);
    }

    private void setClick(){

    }

    public void playAgain(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view){
        finish();
    }

    public void leaderBoard(View view) {
        Intent intent = new Intent(this,LeaderboardsActivity.class);
        startActivity(intent);
        finish();
    }

    public void rememberMe(View view) {

        if(level<5){
            toastMessage("Unfortunately, your score is under average.");
        }
        else{
            Intent intent = new Intent(this,recordActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private void toastMessage(String s) {
        Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
    }
}