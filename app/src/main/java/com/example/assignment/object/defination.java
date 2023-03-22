package com.example.assignment.object;

import java.util.Random;

public class defination {
    public int numCol = 8;
    public int numAll = 7;
    public String normal = "#5a6445";
    public String highlighted = "#798265";
    private String arrNormal[]=new String[]{
            "#5a6445",
            "#c4661f",
            "#95a0c9",
            "#bad0c2",
            "#dbe4ac",
            "#ed759f",
            "#ff8d65"
    };
    private String arrHighlighted[]=new String[]{
            "#798265",
            "#c77244",
            "#a4b2c4",
            "#d1e3d7",
            "#e8edce",
            "#ffa7c6",
            "#ffb465"
    };

    public int level=1;
    public int totalTime=5;
    public int runningTime=totalTime*1000;
    public int publicTime = 300;

    public boolean endGame = false;

    public void generateSampleColor(){
        Random r = new Random();
        int vt = r.nextInt(arrNormal.length);
        normal = arrNormal[vt];
        highlighted = arrHighlighted[vt];
    }

    public void setLevel(){
        if(level<2){
            numCol=2;
        }
        else if(level<3){
            numCol=3;
        }
        else if(level<4){
            numCol=4;
        }
        else if(level<5){
            numCol=5;
        }
        else if(level<6){
            numCol=6;
        }
        else if(level<7){
            numCol=7;
        }
        else{
            numCol=8;
        }
        numAll = numCol*numCol;
    }
}
