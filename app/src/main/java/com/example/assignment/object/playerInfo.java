package com.example.assignment.object;

import android.content.Context;
import android.content.SharedPreferences;

public class playerInfo {
    public int coinPlayerInfo = 100;

    private String archiveFileName = "gameInfo";
    private Context ct;

    public playerInfo(Context ct){
        this.ct = ct;
    }


    public void getData(){

        SharedPreferences preferences = ct.getSharedPreferences(archiveFileName,Context.MODE_PRIVATE);
        coinPlayerInfo=preferences.getInt("Player's Coin",100);

    }
    public void setData(){

        SharedPreferences preferences = ct.getSharedPreferences(archiveFileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("Player's Coin",coinPlayerInfo);
        editor.apply();
    }
}
