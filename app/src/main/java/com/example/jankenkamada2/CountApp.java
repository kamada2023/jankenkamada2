package com.example.jankenkamada2;

import android.app.Application;


public class CountApp extends Application {
    private static int Count = 0;
    private static int AddCount = 0;
    private static int WinCount = 0;
    private static int LoseCount = 0;
    private static int DrawCount = 0;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public int getCount(){
        return Count;
    }

    public void setCount(int count){
        Count = count;
    }

    public int getAddCount(){
        return AddCount;
    }

    public void setAddCount(int addCount){
        AddCount += addCount;
    }

    public int getWinCount() {
        return WinCount;
    }

    public void setWinCount(int winCount) {
        WinCount += winCount;
    }

    public int getLoseCount() {
        return LoseCount;
    }

    public void setLoseCount(int loseCount) {
        LoseCount += loseCount;
    }

    public int getDrawCount() {
        return DrawCount;
    }

    public void setDrawCount(int drawCount) {
        DrawCount += drawCount;
    }

    public void clearCount(){
        Count = 0;
        AddCount = 0;
        WinCount = 0;
        LoseCount = 0;
        DrawCount = 0;
    }
}
