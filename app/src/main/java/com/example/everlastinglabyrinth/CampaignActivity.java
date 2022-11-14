package com.example.everlastinglabyrinth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CampaignActivity extends AppCompatActivity {
    Button level_1;
    Button level_2;
    Button level_3;
    Button level_4;
    Button level_5;
    Button level_6;
    Button level_7;
    Button level_8;
    Button level_9;
    Button level_10;
    Button level_11;
    Button level_12;
    Button level_13;
    Button level_14;
    Button level_15;
    Button level_16;
    Button level_17;
    Button level_18;
    public SharedPreferences settings;
    int levels_opened;
    MediaPlayer theme = new MediaPlayer();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        settings = getSharedPreferences("Settings",MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compaign);
        level_1 = findViewById(R.id.level_1);
        level_2 = findViewById(R.id.level_2);
        level_3 = findViewById(R.id.level_3);
        level_4 = findViewById(R.id.level_4);
        level_5 = findViewById(R.id.level_5);
        level_6 = findViewById(R.id.level_6);
        level_7 = findViewById(R.id.level_7);
        level_8 = findViewById(R.id.level_8);
        level_9 = findViewById(R.id.level_9);
        level_10 = findViewById(R.id.level_10);
        level_11 = findViewById(R.id.level_11);
        level_12 = findViewById(R.id.level_12);
        level_13 = findViewById(R.id.level_13);
        level_14 = findViewById(R.id.level_14);
        level_15 = findViewById(R.id.level_15);
        level_16 = findViewById(R.id.level_16);
        level_17 = findViewById(R.id.level_17);
        level_18 = findViewById(R.id.level_18);

        levels_opened = settings.getInt("levels_opened",1);
        switch (levels_opened){
            case (18):{
                level_18.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_18.setClickable(true);
                level_18.setText((String)"18");
            }
            case (17):{
                level_17.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_17.setClickable(true);
                level_17.setText((String)"17");
            }
            case (16):{
                level_16.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_16.setClickable(true);
                level_16.setText((String)"16");

            }
            case (15):{
                level_15.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_15.setClickable(true);
                level_15.setText((String)"15");
            }
            case (14):{
                level_14.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_14.setClickable(true);
                level_14.setText((String)"14");
            }
            case (13):{
                level_13.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_13.setClickable(true);
                level_13.setText((String)"13");
            }
            case (12):{
                level_12.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_12.setClickable(true);
                level_12.setText((String)"12");
            }
            case (11):{
                level_11.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_11.setClickable(true);
                level_11.setText((String)"11");
            }
            case (10):{
                level_10.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_10.setClickable(true);
                level_10.setText((String)"10");
            }
            case (9):{
                level_9.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_9.setClickable(true);
                level_9.setText((String)"9");
            }
            case (8):{
                level_8.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_8.setClickable(true);
                level_8.setText((String)"8");
            }
            case (7):{
                level_7.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_7.setClickable(true);
                level_7.setText((String)"7");
            }
            case (6):{
                level_6.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_6.setClickable(true);
                level_6.setText((String)"6");
            }
            case (5):{
                level_5.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_5.setClickable(true);
                level_5.setText((String)"5");
            }
            case (4):{
                level_4.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_4.setClickable(true);
                level_4.setText((String)"4");
            }
            case (3):{
                level_3.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_3.setClickable(true);
                level_3.setText((String)"3");
            }
            case (2):{
                level_2.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_2.setClickable(true);
                level_2.setText((String)"2");
            }
            case (1):{
                level_1.setForeground(getDrawable(R.drawable.pixel_foreground_1_1));
                level_1.setClickable(true);
                level_1.setText((String)"1");
            }
        }
        switch (levels_opened+1){
            case (2):{
               level_2.setForeground(getDrawable(R.drawable.lock_green));
               level_2.setClickable(false);
            }
            case (3):{
                level_3.setForeground(getDrawable(R.drawable.lock_green));
                level_3.setClickable(false);
            }
            case (4):{
                level_4.setForeground(getDrawable(R.drawable.lock_green));
                level_4.setClickable(false);
            }
            case (5):{
                level_5.setForeground(getDrawable(R.drawable.lock_green));
                level_5.setClickable(false);
            }
            case (6):{
                level_6.setForeground(getDrawable(R.drawable.lock_green));
                level_6.setClickable(false);
            }
            case (7):{
                level_7.setForeground(getDrawable(R.drawable.lock_green));
                level_7.setClickable(false);
            }
            case (8):{
                level_8.setForeground(getDrawable(R.drawable.lock_green));
                level_8.setClickable(false);
            }
            case (9):{
                level_9.setForeground(getDrawable(R.drawable.lock_green));
                level_9.setClickable(false);
            }
            case (10):{
                level_10.setForeground(getDrawable(R.drawable.lock_green));
                level_10.setClickable(false);
            }
            case (11):{
                level_11.setForeground(getDrawable(R.drawable.lock_green));
                level_11.setClickable(false);
            }
            case (12):{
                level_12.setForeground(getDrawable(R.drawable.lock_green));
                level_12.setClickable(false);
            }
            case (13):{
                level_13.setForeground(getDrawable(R.drawable.lock_green));
                level_13.setClickable(false);
            }
            case (14):{
                level_14.setForeground(getDrawable(R.drawable.lock_green));
                level_14.setClickable(false);
            }
            case (15):{
                level_15.setForeground(getDrawable(R.drawable.lock_green));
                level_15.setClickable(false);
            }
            case (16):{
                level_16.setForeground(getDrawable(R.drawable.lock_green));
                level_16.setClickable(false);
            }
            case (17):{
                level_17.setForeground(getDrawable(R.drawable.lock_green));
                level_17.setClickable(false);
            }
            case (18):{
                level_18.setForeground(getDrawable(R.drawable.lock_green));
                level_18.setClickable(false);
            }
        }
        if(level_1.isClickable()){
            level_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Levelactiv = new Intent(CampaignActivity.this, LevelActivity.class);
                    SharedPreferences.Editor Setting_Editor =settings.edit();
                    Setting_Editor.putInt("game_mode",2);
                    Setting_Editor.putInt("campaign_level",1);
                    Setting_Editor.putBoolean("can_continue",false);
                    Setting_Editor.apply();
                    startActivity(Levelactiv);
                    finish();
                }
            });
        }
        if(level_2.isClickable()){
            level_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Levelactiv = new Intent(CampaignActivity.this, LevelActivity.class);
                    SharedPreferences.Editor Setting_Editor =settings.edit();
                    Setting_Editor.putInt("game_mode",2);
                    Setting_Editor.putInt("campaign_level",2);
                    Setting_Editor.putBoolean("can_continue",false);
                    Setting_Editor.apply();
                    startActivity(Levelactiv);
                    finish();
                }
            });
        }
        if(level_3.isClickable()){
            level_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Levelactiv = new Intent(CampaignActivity.this, LevelActivity.class);
                    SharedPreferences.Editor Setting_Editor =settings.edit();
                    Setting_Editor.putInt("game_mode",2);
                    Setting_Editor.putInt("campaign_level",3);
                    Setting_Editor.putBoolean("can_continue",false);
                    Setting_Editor.apply();
                    startActivity(Levelactiv);
                    finish();
                }
            });
        }
        if(level_4.isClickable()){
            level_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Levelactiv = new Intent(CampaignActivity.this, LevelActivity.class);
                    SharedPreferences.Editor Setting_Editor =settings.edit();
                    Setting_Editor.putInt("game_mode",2);
                    Setting_Editor.putInt("campaign_level",4);
                    Setting_Editor.putBoolean("can_continue",false);
                    Setting_Editor.apply();
                    startActivity(Levelactiv);
                    finish();
                }
            });
        }
        if(level_5.isClickable()){
            level_5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Levelactiv = new Intent(CampaignActivity.this, LevelActivity.class);
                    SharedPreferences.Editor Setting_Editor =settings.edit();
                    Setting_Editor.putInt("game_mode",2);
                    Setting_Editor.putInt("campaign_level",5);
                    Setting_Editor.putBoolean("can_continue",false);
                    Setting_Editor.apply();
                    startActivity(Levelactiv);
                    finish();
                }
            });
        }
        if(level_6.isClickable()){
            level_6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Levelactiv = new Intent(CampaignActivity.this, LevelActivity.class);
                    SharedPreferences.Editor Setting_Editor =settings.edit();
                    Setting_Editor.putInt("game_mode",2);
                    Setting_Editor.putInt("campaign_level",6);
                    Setting_Editor.putBoolean("can_continue",false);
                    Setting_Editor.apply();
                    startActivity(Levelactiv);
                    finish();
                }
            });
        }



    }

}
