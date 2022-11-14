package com.example.everlastinglabyrinth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class DifficultChooseActivity extends AppCompatActivity {
    Button Easy;
    Button Medium;
    Button Hard;


    public SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        settings = getSharedPreferences("Settings",MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficult_choose);
        Easy = findViewById(R.id.button_easy_difficultity);
        Medium = findViewById(R.id.button_medium_difficulty);
        Hard = findViewById(R.id.button_hard_difficulty);

        Easy.setText(settings.getString("button_easy","Easy"));
        Medium.setText(settings.getString("button_medium","Medium"));
        Hard.setText(settings.getString("button_hard","Hard"));




        Easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Levelactiv = new Intent(DifficultChooseActivity.this, LevelActivity.class);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Setting_Editor.putInt("difficulty",1);
                Setting_Editor.putInt("game_mode",1);
                Setting_Editor.putBoolean("game_continue",false);
                Setting_Editor.apply();
                startActivity(Levelactiv);
                finish();
            }
        });
        Medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Levelactiv = new Intent(DifficultChooseActivity.this, LevelActivity.class);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Setting_Editor.putInt("difficulty",2);
                Setting_Editor.putInt("game_mode",1);
                Setting_Editor.putBoolean("game_continue",false);
                Setting_Editor.apply();
                startActivity(Levelactiv);
                finish();
            }
        });
        Hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Levelactiv = new Intent(DifficultChooseActivity.this, LevelActivity.class);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Setting_Editor.putInt("difficulty",3);
                Setting_Editor.putInt("game_mode",1);
                Setting_Editor.putBoolean("game_continue",false);
                Setting_Editor.apply();
                startActivity(Levelactiv);
                finish();
            }
        });

    }
    protected void onResume(){

        super.onResume();

        Easy.setText(settings.getString("button_easy","Easy"));
        Medium.setText(settings.getString("button_medium","Medium"));
        Hard.setText(settings.getString("button_hard","Hard"));

    }
}
