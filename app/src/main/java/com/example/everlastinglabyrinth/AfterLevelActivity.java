package com.example.everlastinglabyrinth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterLevelActivity extends AppCompatActivity {
    Button Main_Menu;
    Button Next_Level;
    SharedPreferences settings;
    TextView text;
    int gamemode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        settings = getSharedPreferences("Settings",MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_level);
        Main_Menu = findViewById(R.id.Main_Menu_Button);
        Next_Level = findViewById(R.id.Next_Level_Button);
        text=findViewById(R.id.text_after_level);
        Main_Menu.setText(settings.getString("button_main_menu","Main menu"));
        Next_Level.setText(settings.getString("button_next_level","Next level"));
        gamemode = settings.getInt("game_mode",0);

        Main_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Next_Level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(gamemode){
                    case(1):{
                        SharedPreferences.Editor settings_editor = settings.edit();
                        settings_editor.putBoolean("can_continue",false);
                        settings_editor.putInt("game_mode",1);
                        settings_editor.apply();
                        Intent Level_act =  new Intent(AfterLevelActivity.this,LevelActivity.class);
                        startActivity(Level_act);
                        finish();
                        break;
                    }
                    case(2):{
                        SharedPreferences.Editor settings_editor = settings.edit();
                        settings_editor.putBoolean("can_continue",false);
                        settings_editor.putInt("game_mode",2);
                        settings_editor.putInt("campaign_level",settings.getInt("campaign_level",1)+1);
                        settings_editor.apply();
                        Intent Level_act =  new Intent(AfterLevelActivity.this,LevelActivity.class);
                        startActivity(Level_act);
                        finish();
                        break;
                    }
                    default:{
                        finish();
                    }
                }
            }
        });
    }
}