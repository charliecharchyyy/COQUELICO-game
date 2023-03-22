package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment.Adapter.ContinueAdapter;
import com.example.assignment.dialog.EndGameDialog;
import com.example.assignment.object.Continue;
import com.example.assignment.object.defination;
import com.example.assignment.object.playerInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    defination defination = new defination();

    ArrayList<Continue> arrCont = new ArrayList<>();

    GridView gdvLisCont;
    ContinueAdapter adapter;

    TextView textLevel;
    TextView textTime;
    CountDownTimer downTime;

    TextView textCoin;
    playerInfo player;

    ImageView imageLogo;
    int icon = R.drawable.space;
    boolean dino = true;

    boolean isPaused = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        findWay();
        setUp();
        setClick();
    }

    private void init(){
        player = new playerInfo(this);
        player.getData();
        createNew();
        adapter=new ContinueAdapter(this,0,arrCont);
    }

    private void findWay(){
        gdvLisCont=findViewById(R.id.gdvLisCont);
        textLevel = findViewById(R.id.textLevel);
        textTime = findViewById(R.id.textTime);
        imageLogo = findViewById(R.id.imageLogo);
        textCoin = findViewById(R.id.textCoin);
        View imageButton = findViewById(R.id.imageButton);
    }

    private void setUp(){
        textCoin.setText(""+player.coinPlayerInfo);
        gdvLisCont.setNumColumns(defination.numCol);
        gdvLisCont.setAdapter(adapter);
        textLevel.setText(""+defination.level);
        updateTime();

        new CountDownTimer(3000,200){

            @Override
            public void onTick(long l) {
                if(dino==true){
                    if(icon == R.drawable.space2){
                        icon = R.drawable.space;
                    }
                    else{
                        icon = R.drawable.space2;
                    }
                    imageLogo.setImageResource(icon);
                }
            }

            @Override
            public void onFinish() {
                dino = false;
                if(defination.endGame==false){
                    start();
                }

            }
        }.start();
    }

    private void setClick(){
        gdvLisCont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                checkColor(arrCont.get(i));
            }
        });
    }

    private void checkColor(Continue c){
        if(c.message.equals(defination.highlighted)){
            defination.level++;
            createNew();
            upDate();
            defination.runningTime=defination.runningTime+defination.publicTime;
            downTime.cancel();
            updateTime();
            dino=true;

            player.coinPlayerInfo=player.coinPlayerInfo+2;
            textCoin.setText(""+player.coinPlayerInfo);
            player.setData();
        }
        else{
            Toast.makeText(this,"false",Toast.LENGTH_SHORT).show();
        }
    }

    private void createNew(){
        defination.setLevel();
        defination.generateSampleColor();
        arrCont.clear();
        while (arrCont.size()<defination.numAll){
            arrCont.add(new Continue(defination.normal));
        }

        Random r = new Random();
        arrCont.get(r.nextInt(arrCont.size())).message=defination.highlighted;
    }

    private void upDate(){
        adapter.upDate(arrCont);
        gdvLisCont.setNumColumns(defination.numCol);
        textLevel.setText(""+defination.level);
    }

    private void updateTime(){
        downTime = new CountDownTimer(5000,1){

            @Override
            public void onTick(long l) {
                defination.runningTime = (int) l;
                if(defination.runningTime>=0){
                    int showSeconds = defination.runningTime/1000;
                   String times = showSeconds+"";
                    textTime.setText(times);
                }
                else{
                    textTime.setText("Times Out!");
                }

            }

            @Override
            public void onFinish() {
                textTime.setText("Times Out!");
                timesOut();
            }
        }.start();
    }

    private void timesOut(){
        defination.endGame=true;
        gdvLisCont.setOnItemClickListener(null);

        Intent intent = new Intent(this,EndActivity.class);
        intent.putExtra("level",defination.level);
        startActivity(intent);
        finish();
    }

    public void pauseGame(View view){
        if(!isPaused){
            isPaused = true;

            downTime.cancel();
            gdvLisCont.setOnItemClickListener(null);
        }
        else{
            isPaused=false;
            updateTime();
            gdvLisCont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    checkColor(arrCont.get(position));
                }
            });
        }
    }

}