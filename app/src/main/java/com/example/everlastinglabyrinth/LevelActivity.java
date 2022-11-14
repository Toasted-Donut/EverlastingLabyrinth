package com.example.everlastinglabyrinth;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

public class LevelActivity extends AppCompatActivity {
    public static class Map_Save{
        Node[][]Map_to_save;
        Node[][] Return(){
           return Map_to_save;}
    }
    MediaPlayer steps = new MediaPlayer();
    public Node[][] Map;
    public ImageView CORR;
    public ImageView CORR_UP;
    public ImageView CORR_DOWN;
    public ImageView CORR_LEFT;
    public ImageView CORR_RIGHT;
    public ImageView CHARACTER;
    Button b_Up;
    Button b_Down;
    Button b_Left;
    Button b_Right;
    Button b_Exit;
    public int X;
    public int Y;
    public int Count_anomaly;
    Button Y_alert;
    Button N_alert;
    TextView Title_alert;
    TextView Confirm_alert;

    public Node[][]Continue_map;
    public boolean can_continue=false;

    public boolean Up_click;
    public boolean Down_click;
    public boolean Left_click;
    public boolean Right_click;
    public boolean Exit_click;

    public AnimationDrawable character_anim;

    public TranslateAnimation Up_anim = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT, 0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,-1.0f);
    public TranslateAnimation Down_anim = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,1.0f);
    public TranslateAnimation Left_anim = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,-1.0f,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0);
    public TranslateAnimation Right_anim = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,1.0f,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0);

    public TranslateAnimation Up_anim_quick0 = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT, 0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,1.0f,
            Animation.RELATIVE_TO_PARENT,0);
    public TranslateAnimation Down_anim_quick0 = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,-1.0f,
            Animation.RELATIVE_TO_PARENT,0);
    public TranslateAnimation Left_anim_quick0 = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT,1.0f,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0);
    public TranslateAnimation Right_anim_quick0 = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT,-1.0f,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0);
    public TranslateAnimation Up_anim_quick1 = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT, 0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,1.0f,
            Animation.RELATIVE_TO_PARENT,0);
    public TranslateAnimation Down_anim_quick1 = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,-1.0f,
            Animation.RELATIVE_TO_PARENT,0);
    public TranslateAnimation Left_anim_quick1 = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT,1.0f,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0);
    public TranslateAnimation Right_anim_quick1 = new TranslateAnimation(
            Animation.RELATIVE_TO_PARENT,-1.0f,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0,
            Animation.RELATIVE_TO_PARENT,0);

    public int gamemode;



    public  SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int map_size;

        settings = getSharedPreferences("Settings",MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        steps = MediaPlayer.create(this, R.raw.footsteps);
        CORR = findViewById(R.id.CORRIDOR);
        CORR_UP = findViewById(R.id.CORRIDOR_UP);
        CORR_DOWN = findViewById(R.id.CORRIDOR_DOWN);
        CORR_LEFT = findViewById(R.id.CORRIDOR_LEFT);
        CORR_RIGHT = findViewById(R.id.CORRIDOR_RIGHT);
        CHARACTER = findViewById(R.id.CHARACTER);

        character_anim = (AnimationDrawable) CHARACTER.getDrawable();
        character_anim.start();

        Up_anim.setDuration(2200);
        Up_anim.setFillAfter(true);
        Down_anim.setDuration(2200);
        Down_anim.setFillAfter(true);
        Left_anim.setDuration(2200);
        Left_anim.setFillAfter(true);
        Right_anim.setDuration(2200);
        Right_anim.setFillAfter(true);

        Up_anim_quick0.setDuration(0);
        Up_anim_quick0.setFillAfter(true);
        Down_anim_quick0.setDuration(0);
        Down_anim_quick0.setFillAfter(true);
        Left_anim_quick0.setDuration(0);
        Left_anim_quick0.setFillAfter(true);
        Right_anim_quick0.setDuration(0);
        Right_anim_quick0.setFillAfter(true);

        Up_anim_quick1.setDuration(1);
        Up_anim_quick1.setFillAfter(true);
        Down_anim_quick1.setDuration(1);
        Down_anim_quick1.setFillAfter(true);
        Left_anim_quick1.setDuration(1);
        Left_anim_quick1.setFillAfter(true);
        Right_anim_quick1.setDuration(1);
        Right_anim_quick1.setFillAfter(true);

        b_Up = findViewById(R.id.button_Up);
        b_Down = findViewById(R.id.button_Down);
        b_Left = findViewById(R.id.button_Left);
        b_Right = findViewById(R.id.button_Right);
        b_Exit = findViewById(R.id.button_Exit);

//
        Count_anomaly = settings.getInt("count_anomaly",0);
        gamemode = settings.getInt("game_mode",1);
        int difficulty = settings.getInt("difficulty",1);
        boolean do_continue = settings.getBoolean("do_continue",false);
        if (do_continue){
            SharedPreferences.Editor set_edit = settings.edit();
            set_edit.putBoolean("do_continue",false);
            set_edit.apply();
            can_continue=true;
            Gson gson = new Gson();
            String json = settings.getString("Map_continue", "");
            Map_Save map_reload = gson.fromJson(json, Map_Save.class);
            Map=map_reload.Return();
            gamemode = settings.getInt("game_mode",1);
            X=settings.getInt("X",1);
            Y=settings.getInt("Y",1);
        }
        else {
            if (gamemode==1){
                can_continue=true;
                if (difficulty==1){
                    map_size=7;
                }
                else if (difficulty==2){
                    map_size=11;
                }
                else if (difficulty==3){
                    map_size=15;
                }
                else{map_size=7;}
                Map = Node.New_Map(map_size);
                Map = Generation(map_size);

            }
            else if (gamemode==2){
                can_continue=true;
                int campaign_level = settings.getInt("campaign_level",1);
                switch (campaign_level){
                    case(1):{
                        final byte[][] LevelMap_1 = {
                                {8,5,5,30,9},
                                {10,6,10,3,11},
                                {34,10,9,0,0},
                                {2,8,6,0,0},
                                {10,11,22,0,0},
                        };
                        Map=Node.Import_Byte_Map(LevelMap_1);
                        X = 4;
                        Y = 2;
                        break;
                    }
                    case(2):{
                        final byte[][] LevelMap_2 = {
                                {34,8,9,23,9},
                                {2,2,10,5,6},
                                {7,11,8,4,11},
                                {20,8,6,0,0},
                                {10,11,22,0,0},
                        };
                        Map=Node.Import_Byte_Map(LevelMap_2);
                        X = 4;
                        Y = 2;
                        break;
                    }
                    case(3):{
                        final byte[][] LevelMap_3 = {
                                {8,-30,3,9,24},
                                {7,31,8,6,2},
                                {2,8,1,1,6},
                                {2,7,6,2,2},
                                {10,11,22,10,11},
                        };
                        Map=Node.Import_Byte_Map(LevelMap_3);
                        X = 4;
                        Y = 2;
                        break;
                    }
                    case(4):{
                        final byte[][] LevelMap_4 = {
                                {34,8,9,8,9},
                                {7,6,7,4,6},
                                {20,7,11,8,6},
                                {7,11,24,2,2},
                                {10,3,11,22,22},
                        };
                        Map=Node.Import_Byte_Map(LevelMap_4);
                        X = 4;
                        Y = 3;
                        break;
                    }
                    case(5):{
                        final byte[][] LevelMap_5 = {
                                {8,3,3,9,34},
                                {2,8,30,4,6},
                                {7,11,8,9,20},
                                {10,9,2,7,11},
                                {23,4,11,22,0},
                        };
                        Map=Node.Import_Byte_Map(LevelMap_5);
                        X = 4;
                        Y = 3;
                        break;
                    }
                    case(6):{
                        final byte[][] LevelMap_6 = {
                                {34,8,5,3,21},
                                {2,7,1,5,9},
                                {2,2,-20,7,11},
                                {2,10,6,2,0},
                                {10,3,11,22,0},
                        };
                        Map=Node.Import_Byte_Map(LevelMap_6);
                        X = 4;
                        Y = 3;
                        break;
                    }
                    case(7):{
                        final byte[][] LevelMap_7 = {
                                {8,5,9,0,8,3,9},
                                {10,1,6,8,6,34,2},
                                {0,2,2,2,2,7,11},
                                {8,1,1,11,20,20,0},
                                {7,1,4,5,4,11,0},
                                {2,10,9,10,9,0,0},
                                {10,3,11,0,22,0,0}
                        };
                        Map=Node.Import_Byte_Map(LevelMap_7);
                        X = 6;
                        Y = 4;
                        break;
                    }
                    case(8):{
                        final byte[][] LevelMap_8 = {
                                {8,9,33,3,9,8,9},
                                {10,1,3,5,1,6,2},
                                {8,4,5,4,11,10,6},
                                {7,21,20,8,5,9,20},
                                {7,3,6,10,1,4,11},
                                {2,24,2,8,6,0,0},
                                {10,11,10,11,22,0,0}
                        };
                        Map=Node.Import_Byte_Map(LevelMap_8);
                        X = 6;
                        Y = 4;
                        break;
                    }
                    case(9):{
                        final byte[][] LevelMap_9 = {
                                {8,5,9,8,3,9,24},
                                {2,2,20,10,9,7,6},
                                {2,32,7,9,2,10,11},
                                {10,5,6,7,6,8,9},
                                {8,6,10,11,20,2,22},
                                {7,11,8,5,1,4,9},
                                {10,3,4,11,22,23,11}
                        };
                        Map=Node.Import_Byte_Map(LevelMap_9);
                        X = 6;
                        Y = 4;
                        break;
                    }
                    case(10):{
                        final byte[][] LevelMap_10 = {
                                {8,3,3,9,8,3,31,8,9},
                                {10,5,5,11,10,5,9,7,6},
                                {8,11,10,3,3,11,20,-20,2},
                                {10,9,23,5,5,21,7,11,2},
                                {23,4,3,6,22,8,4,21,2},
                                {8,5,9,10,5,4,3,3,6},
                                {10,1,1,9,10,5,9,23,11},
                                {23,2,10,11,8,1,1,5,9},
                                {10,4,3,3,11,22,22,10,11}
                        };
                        Map=Node.Import_Byte_Map(LevelMap_10);
                        X = 8;
                        Y = 5;
                        break;
                    }
                    case(11):{
                        final byte[][] LevelMap_11 = {
                                {34,8,3,9,8,3,9,8,9},
                                {7,6,0,2,7,9,7,4,11},
                                {2,7,5,4,1,6,2,0,0},
                                {10,4,4,5,11,7,4,3,9},
                                {8,5,9,20,0,2,23,5,6},
                                {-20,2,7,6,8,4,3,6,2},
                                {10,11,10,4,4,5,5,6,2},
                                {0,0,0,0,0,2,10,6,2},
                                {0,0,0,0,0,22,23,4,11}
                        };
                        Map=Node.Import_Byte_Map(LevelMap_11);
                        X = 8;
                        Y = 5;
                        break;
                    }
                    case(12):{
                        final byte[][] LevelMap_12 = {
                                {24,8,5,30,3,9,8,3,3},
                                {2,7,4,9,8,6,2,8,9},
                                {10,1,3,1,4,1,4,6,20},
                                {8,4,5,4,9,10,3,11,2},
                                {2,8,4,5,1,5,3,5,11},
                                {10,4,5,6,2,7,5,6,24},
                                {8,3,11,2,7,6,2,7,6},
                                {7,5,9,2,2,2,2,2,2},
                                {10,11,10,4,11,22,10,11,22}
                        };
                        Map=Node.Import_Byte_Map(LevelMap_12);
                        X = 8;
                        Y = 5;
                        break;
                    }
                    case(13):{
                        final byte[][] LevelMap_13 = {
                                {8,3,21,8,30,3,5,9,8,3,9},
                                {7,5,3,6,8,5,1,6,2,8,6},
                                {7,1,21,2,7,4,4,1,1,4,11},
                                {22,10,3,6,10,3,3,11,2,23,9},
                                {8,5,3,4,9,8,5,3,1,5,6},
                                {10,4,3,5,4,11,7,5,4,11,2},
                                {0,0,0,10,5,3,1,4,9,8,11},
                                {8,9,8,3,4,3,4,9,2,10,21},
                                {2,7,11,8,-30,3,5,1,1,5,9},
                                {2,7,5,1,3,9,2,7,6,10,6},
                                {10,11,10,11,33,11,22,10,11,23,11}
                        };
                        Map=Node.Import_Byte_Map(LevelMap_13);
                        X = 10;
                        Y = 6;
                        break;
                    }
                    case(14):{
                        final byte[][] LevelMap_14 = {
                                {8,3,3,5,3,-30,3,5,9,8,9},
                                {2,8,21,7,5,5,9,2,2,10,6},
                                {7,11,8,1,1,6,10,6,7,9,20},
                                {2,8,11,10,1,4,9,10,6,10,6},
                                {10,6,24,8,11,8,1,9,2,8,11},
                                {34,2,2,7,3,1,4,4,4,1,9},
                                {10,11,10,1,9,10,5,9,8,6,2},
                                {8,3,3,11,10,9,7,4,11,2,2},
                                {7,3,9,8,5,11,20,8,5,6,2},
                                {10,9,2,7,4,9,7,6,2,2,2},
                                {0,10,11,10,3,11,22,10,11,10,11}
                        };
                        Map=Node.Import_Byte_Map(LevelMap_14);
                        X = 10;
                        Y = 6;
                        break;
                    }
                    case(15):{
                        final byte[][] LevelMap_15 = {
                                {8,3,9,8,5,3,5,5,3,30,9},
                                {7,5,1,1,11,8,11,7,5,9,2},
                                {2,2,10,6,24,10,5,11,7,4,6},
                                {7,4,21,10,1,5,6,24,7,9,2},
                                {10,9,8,9,2,7,4,1,1,11,2},
                                {0,10,1,1,1,11,8,1,6,8,11},
                                {0,0,2,7,4,9,10,1,11,7,9},
                                {0,0,7,4,9,20,23,11,8,6,2},
                                {0,8,6,0,7,4,3,9,7,11,2},
                                {0,7,6,0,10,3,5,11,-20,8,11},
                                {0,10,11,0,0,0,22,0,10,4,31}
                        };
                        Map=Node.Import_Byte_Map(LevelMap_15);
                        X = 10;
                        Y = 6;
                        break;
                    }


                }

            }
            else{
                finish();
            }
        }

        Continue_map=Map;
        Map_Save Map_contin = new Map_Save();
        Map_contin.Map_to_save=Continue_map;
        Gson gson = new Gson();
        String json = gson.toJson(Map_contin);
        SharedPreferences.Editor Setting_Editor =settings.edit();
        Setting_Editor.putString("Map_continue", json);
        Setting_Editor.putBoolean("can_continue",true);
        Setting_Editor.putInt("X",X);
        Setting_Editor.putInt("Y",Y);
        Setting_Editor.apply();



        try {
            SwitchImage(Map[X][Y].corr, CORR);
        }
        catch (NullPointerException ex) {
            Setting_Editor.putBoolean("can_continue",false);
            Setting_Editor.apply();
            finish();
        }
        b_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Map[X][Y].corr==20){
                    Count_anomaly++;
                    if(Count_anomaly%4==0){
                        Count_anomaly=Count_anomaly-3;
                    }
                }
                else{
                    X=X-1;
                }
                SwitchImage(Map[X][Y].corr,CORR_UP);
                CORR_UP.startAnimation(Down_anim);
                CORR.startAnimation(Down_anim);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Setting_Editor.putInt("X",X);
                Setting_Editor.putInt("Y",Y);
                Setting_Editor.putInt("count_anomaly",Count_anomaly);
                Setting_Editor.apply();

            }
        });
        b_Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Map[X][Y].corr==-20){
                    Count_anomaly++;
                    if(Count_anomaly%4==0){
                        Count_anomaly=Count_anomaly-3;
                    }
                }
                else{
                    X=X+1;
                }
                SwitchImage(Map[X][Y].corr,CORR_DOWN);
                CORR_DOWN.startAnimation(Up_anim);
                CORR.startAnimation(Up_anim);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Setting_Editor.putInt("X",X);
                Setting_Editor.putInt("Y",Y);
                Setting_Editor.putInt("count_anomaly",Count_anomaly);
                Setting_Editor.apply();

            }
        });
        b_Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Map[X][Y].corr==30){
                    Count_anomaly++;
                    if(Count_anomaly%4==0){
                        Count_anomaly=Count_anomaly-3;
                    }
                }
                else{
                    Y=Y+1;
                }
                SwitchImage(Map[X][Y].corr,CORR_RIGHT);
                CORR_RIGHT.startAnimation(Left_anim);
                CORR.startAnimation(Left_anim);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Setting_Editor.putInt("X",X);
                Setting_Editor.putInt("Y",Y);
                Setting_Editor.putInt("count_anomaly",Count_anomaly);
                Setting_Editor.apply();

            }
        });
        b_Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Map[X][Y].corr==-30){
                    Count_anomaly++;
                    if(Count_anomaly%4==0){
                        Count_anomaly=Count_anomaly-3;
                    }
                }
                else {
                    Y=Y-1;
                }
                SwitchImage(Map[X][Y].corr,CORR_LEFT);
                CORR_LEFT.startAnimation(Right_anim);
                CORR.startAnimation(Right_anim);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Setting_Editor.putInt("X",X);
                Setting_Editor.putInt("Y",Y);
                Setting_Editor.putInt("count_anomaly",Count_anomaly);
                Setting_Editor.apply();

            }
        });
        b_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                can_continue=false;
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Setting_Editor.putBoolean("can_continue",can_continue);
                Setting_Editor.putBoolean("do_continue",false);
                if(gamemode==2){
                    int current_level = settings.getInt("campaign_level",1);
                    int highest_opened_level = settings.getInt("levels_opened",1);
                    if(current_level==highest_opened_level){
                        highest_opened_level++;
                    }
                    Setting_Editor.putInt("levels_opened",highest_opened_level);
                }
                Setting_Editor.apply();
                Intent After_level_act = new Intent(LevelActivity.this,AfterLevelActivity.class);
                startActivity(After_level_act);
                finish();
            }
        });
        Up_anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                character_anim.stop();
                CHARACTER.setImageDrawable(getDrawable(R.drawable.character_going_right_animation));
                character_anim = (AnimationDrawable) CHARACTER.getDrawable();
                character_anim.start();
                steps.start();
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                steps.pause();
                steps.seekTo(0);
                character_anim.stop();
                CHARACTER.setImageDrawable(getDrawable(R.drawable.character_standing_right_animation));
                character_anim = (AnimationDrawable) CHARACTER.getDrawable();
                character_anim.start();

                SwitchImage(Map[X][Y].corr,CORR);
                CORR.startAnimation(Down_anim_quick0);
                CORR_DOWN.startAnimation(Down_anim_quick1);

                b_Up.setClickable(settings.getBoolean("up_click",false));
                b_Down.setClickable(settings.getBoolean("down_click",false));
                b_Left.setClickable(settings.getBoolean("left_click",false));
                b_Right.setClickable(settings.getBoolean("right_click",false));
                b_Exit.setClickable(settings.getBoolean("exit_click",false));
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        Down_anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                character_anim.stop();
                CHARACTER.setImageDrawable(getDrawable(R.drawable.character_going_left_animation));
                character_anim = (AnimationDrawable) CHARACTER.getDrawable();
                character_anim.start();
                steps.start();
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                steps.pause();
                steps.seekTo(0);
                character_anim.stop();
                CHARACTER.setImageDrawable(getDrawable(R.drawable.character_standing_left_animation));
                character_anim = (AnimationDrawable) CHARACTER.getDrawable();
                character_anim.start();

                SwitchImage(Map[X][Y].corr,CORR);
                CORR.startAnimation(Up_anim_quick0);
                CORR_UP.startAnimation(Up_anim_quick1);

                b_Up.setClickable(settings.getBoolean("up_click",false));
                b_Down.setClickable(settings.getBoolean("down_click",false));
                b_Left.setClickable(settings.getBoolean("left_click",false));
                b_Right.setClickable(settings.getBoolean("right_click",false));
                b_Exit.setClickable(settings.getBoolean("exit_click",false));
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        Left_anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                character_anim.stop();
                CHARACTER.setImageDrawable(getDrawable(R.drawable.character_going_right_animation));
                character_anim = (AnimationDrawable) CHARACTER.getDrawable();
                character_anim.start();
                steps.start();
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                steps.pause();
                steps.seekTo(0);
                character_anim.stop();
                CHARACTER.setImageDrawable(getDrawable(R.drawable.character_standing_right_animation));
                character_anim = (AnimationDrawable) CHARACTER.getDrawable();
                character_anim.start();

                SwitchImage(Map[X][Y].corr,CORR);
                CORR.startAnimation(Right_anim_quick0);
                CORR_RIGHT.startAnimation(Right_anim_quick1);

                b_Up.setClickable(settings.getBoolean("up_click",false));
                b_Down.setClickable(settings.getBoolean("down_click",false));
                b_Left.setClickable(settings.getBoolean("left_click",false));
                b_Right.setClickable(settings.getBoolean("right_click",false));
                b_Exit.setClickable(settings.getBoolean("exit_click",false));
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        Right_anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                character_anim.stop();
                CHARACTER.setImageDrawable(getDrawable(R.drawable.character_going_left_animation));
                character_anim = (AnimationDrawable) CHARACTER.getDrawable();
                character_anim.start();
                steps.start();
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                steps.pause();
                steps.seekTo(0);
                character_anim.stop();
                CHARACTER.setImageDrawable(getDrawable(R.drawable.character_standing_left_animation));
                character_anim = (AnimationDrawable) CHARACTER.getDrawable();
                character_anim.start();

                SwitchImage(Map[X][Y].corr,CORR);
                CORR.startAnimation(Left_anim_quick0);
                CORR_LEFT.startAnimation(Left_anim_quick1);

                b_Up.setClickable(settings.getBoolean("up_click",false));
                b_Down.setClickable(settings.getBoolean("down_click",false));
                b_Left.setClickable(settings.getBoolean("left_click",false));
                b_Right.setClickable(settings.getBoolean("right_click",false));
                b_Exit.setClickable(settings.getBoolean("exit_click",false));
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
    protected void onResume(){
        super.onResume();
        b_Exit.setText(settings.getString("button_exit","Exit"));
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder alert_build = new AlertDialog.Builder(LevelActivity.this);
            View view = (ConstraintLayout) getLayoutInflater()
                    .inflate(R.layout.dialog, null);
            alert_build.setView(view);
            final AlertDialog alert = alert_build.create();
            alert.show();
            Y_alert = alert.findViewById(R.id.button_yes);
            N_alert = alert.findViewById(R.id.button_no);
            Title_alert = alert.findViewById(R.id.Title);
            Confirm_alert = alert.findViewById(R.id.Confirm);
            Y_alert.setText(settings.getString("alert_ybutton2","Main menu"));
            N_alert.setText(settings.getString("alert_nbutton2","Continue"));
            Title_alert.setText(settings.getString("alert_title2","Pause"));

            Y_alert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            N_alert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alert.cancel();
                }
            });
            return true;
        }
        return false;
    }



    public  void SwitchImage(byte idLevel, ImageView corridor){
        b_Up.setVisibility(View.INVISIBLE);b_Down.setVisibility(View.INVISIBLE);
        b_Right.setVisibility(View.INVISIBLE);b_Left.setVisibility(View.INVISIBLE);
        b_Exit.setVisibility(View.INVISIBLE); b_Exit.setClickable(false);
        b_Up.setClickable(false);b_Down.setClickable(false);b_Right.setClickable(false);b_Left.setClickable(false);
        Up_click=false; Down_click=false; Left_click=false; Right_click=false; Exit_click=false;
        switch (idLevel){
            case(1):{
                corridor.setImageResource(R.drawable.corridor_1);

                b_Up.setVisibility(View.VISIBLE);b_Down.setVisibility(View.VISIBLE);
                b_Right.setVisibility(View.VISIBLE);b_Left.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Up_click=true; Down_click=true; Left_click=true; Right_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(2):{
                corridor.setImageResource(R.drawable.corridor_2);

                b_Up.setVisibility(View.VISIBLE);b_Down.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Up_click=true; Down_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(3):{
                corridor.setImageResource(R.drawable.corridor_3);

                b_Right.setVisibility(View.VISIBLE);b_Left.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Left_click=true; Right_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(4):{
                corridor.setImageResource(R.drawable.corridor_4);

                b_Up.setVisibility(View.VISIBLE);
                b_Right.setVisibility(View.VISIBLE);b_Left.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Up_click=true; Left_click=true; Right_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(5):{
                corridor.setImageResource(R.drawable.corridor_5);

                b_Down.setVisibility(View.VISIBLE);
                b_Right.setVisibility(View.VISIBLE);b_Left.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Down_click=true; Left_click=true; Right_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(6):{
                corridor.setImageResource(R.drawable.corridor_6);

                b_Up.setVisibility(View.VISIBLE);b_Down.setVisibility(View.VISIBLE);
                b_Left.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Up_click=true; Down_click=true; Left_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(7):{
                corridor.setImageResource(R.drawable.corridor_7);

                b_Up.setVisibility(View.VISIBLE);b_Down.setVisibility(View.VISIBLE);
                b_Right.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Up_click=true; Down_click=true;  Right_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(8):{
                corridor.setImageResource(R.drawable.corridor_8);
                b_Down.setVisibility(View.VISIBLE);b_Right.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Down_click=true;  Right_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(9):{
                corridor.setImageResource(R.drawable.corridor_9);

                b_Down.setVisibility(View.VISIBLE);b_Left.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Down_click=true; Left_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(10):{
                corridor.setImageResource(R.drawable.corridor_10);

                b_Up.setVisibility(View.VISIBLE);b_Right.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Up_click=true;  Right_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(11):{
                corridor.setImageResource(R.drawable.corridor_11);

                b_Up.setVisibility(View.VISIBLE);b_Left.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Up_click=true;  Left_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(21):{
                corridor.setImageResource(R.drawable.end_1);

                b_Left.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Left_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(22):{
                corridor.setImageResource(R.drawable.end_2);

                b_Up.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Up_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(23):{
                corridor.setImageResource(R.drawable.end_3);

                b_Right.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Right_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(24):{
                corridor.setImageResource(R.drawable.end_4);

                b_Down.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Down_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(31):{
                corridor.setImageResource(R.drawable.exit_1);
                b_Left.setVisibility(View.VISIBLE); b_Exit.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Left_click=true; Exit_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(32):{
                corridor.setImageResource(R.drawable.exit_2);
                b_Up.setVisibility(View.VISIBLE);  b_Exit.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Up_click=true; Exit_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(33):{
                corridor.setImageResource(R.drawable.exit_3);
                b_Right.setVisibility(View.VISIBLE); b_Exit.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Right_click=true; Exit_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(34):{
                corridor.setImageResource(R.drawable.exit_4);
                b_Down.setVisibility(View.VISIBLE); b_Exit.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Down_click=true; Exit_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(20):{
            }
            case(-20):{ //vertical magic
                corridor.setImageResource(R.drawable.corridor_2_cursed);

                b_Up.setVisibility(View.VISIBLE);b_Down.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Up_click=true; Down_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }
            case(30):{
            }
            case(-30):{ //horizontal magic
                corridor.setImageResource(R.drawable.corridor_3_cursed);

                b_Right.setVisibility(View.VISIBLE);b_Left.setVisibility(View.VISIBLE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Left_click=true; Right_click=true;
                Setting_Editor.putBoolean("up_click",Up_click);
                Setting_Editor.putBoolean("down_click",Down_click);
                Setting_Editor.putBoolean("left_click",Left_click);
                Setting_Editor.putBoolean("right_click",Right_click);
                Setting_Editor.putBoolean("exit_click",Exit_click);
                Setting_Editor.apply();
                break;
            }

            default:{
                corridor.setImageResource(R.drawable.corridor_empty);
                break;}

        }

    }


    Node[][]  Generation (int map_size){
        Node[][] map = Node.New_Map(map_size);
        int start_x = map_size-2;
        int start_y = map_size/2+1;
        map[start_x][start_y].corr=22;
        map[start_x][start_y].up_fit=true;
        map[start_x][start_y].down_fit=false;
        map[start_x][start_y].left_fit=false;
        map[start_x][start_y].right_fit=false;
        for (int i=0;i<map_size;i++){
            map[0][i].up_fit=false;map[0][i].down_fit=false;map[0][i].left_fit=false;map[0][i].right_fit=false;
            map[map_size-1][i].up_fit=false;map[map_size-1][i].down_fit=false;map[map_size-1][i].left_fit=false;map[map_size-1][i].right_fit=false;
            map[i][0].up_fit=false;map[i][0].down_fit=false;map[i][0].left_fit=false;map[i][0].right_fit=false;
            map[i][map_size-1].up_fit=false;map[i][map_size-1].down_fit=false;map[i][map_size-1].left_fit=false;map[i][map_size-1].right_fit=false;
            map[0][i].corr=-1;map[map_size-1][i].corr=-1;map[i][0].corr=-1;map[i][map_size-1].corr=-1;

        }

        X=start_x;
        Y=start_y;
        int x = start_x;
        int y = start_y;
        int corr=0;
        int direction=0;
        boolean IsFit;
        int n1;
        int n2;
        int n3;
        int n4;
        int num_of_ends=0;
        boolean stop;
        boolean map_is_built=false;
        boolean map_is_completed = false;
        boolean isEnd=false;
        while (!map_is_completed){
            map_is_built=false;
            while(!isEnd){
                n1=0;
                n2=0;
                n3=0;
                n4=0;
                IsFit=false;
                while (!IsFit){
                    direction=(int)(Math.random()*4);
                    if (direction==0){
                        if (map[x][y].up_fit!=null && map[x-1][y].corr==0&&map[x][y].up_fit){
                            IsFit=true;
                        }
                        else n1=1;
                    }
                    else if (direction==1){
                        if (map[x][y].down_fit!=null && map[x+1][y].corr==0&&map[x][y].down_fit){
                            IsFit=true;
                        }
                        else n2=1;
                    }
                    else if (direction==2){
                        if (map[x][y].left_fit!=null && map[x][y-1].corr==0&&map[x][y].left_fit){
                            IsFit=true;
                        }
                        else n3=1;
                    }
                    else if (direction==3){
                        if (map[x][y].right_fit!=null && map[x][y+1].corr==0&&map[x][y].right_fit){
                            IsFit=true;
                        }
                        else n4=1;
                    }
                    if (n1+n2+n3+n4==4){
                        isEnd=true;
                        break;
                    }
                }
                if (isEnd)break;
                if(direction==0){
                    x=x-1;
                }
                else if(direction==1){
                    x=x+1;
                }
                else if(direction==2){
                    y=y-1;
                }
                else if(direction==3){
                    y=y+1;
                }
                map=choose_corridor(x,y,map);
                corr=map[x][y].corr;
                if (corr==21){break;}
                if(corr==22){break;}
                if(corr==23){break;}
                if(corr==24){break;}
            }
            map_is_built=false;

            stop=false;
            for (int i=1;i<map_size-1;i++){
                for (int j=1;j<map_size-1;j++){
                    if (map[i][j].corr!=0){
                        if (map[i][j].up_fit!=null && map[i][j].up_fit&&map[i-1][j].down_fit==null){
                            x=i; y=j; stop=true;  isEnd=false; break;
                        }
                        else if (map[i][j].down_fit!=null && map[i][j].down_fit&&map[i+1][j].up_fit==null){
                            x=i; y=j; stop=true;  isEnd=false; break;
                        }
                        else if (map[i][j].left_fit!=null && map[i][j].left_fit&&map[i][j-1].right_fit==null){
                            x=i; y=j; stop=true;  isEnd=false; break;
                        }
                        else if (map[i][j].right_fit!=null && map[i][j].right_fit&&map[i][j+1].left_fit==null){
                            x=i; y=j; stop=true;  isEnd=false; break;
                        }
                        else {x=x; y=y;}
                    }
                }
                if (stop){break;}
            }
            if (!stop){
                map_is_built=true;
            }
            if (map_is_built){
                num_of_ends=0;
                for (int i=1;i<map_size-1;i++){
                    for (int j=1;j<map_size-1;j++){
                        if (map[i][j].corr==21||map[i][j].corr==22||map[i][j].corr==23||map[i][j].corr==24){
                            num_of_ends=num_of_ends+1;
                        }
                    }
                }
            }
            if (map_is_built&&num_of_ends>1){
                map_is_completed=true;
            }
            else if (map_is_built&&num_of_ends==1){
                for (int i=1;i<map_size-1;i++){
                    for (int j=1;j<map_size-1;j++){
                        map[i][j].corr=0;
                        map[i][j].up_fit=null;map[i][j].down_fit=null;map[i][j].left_fit=null;map[i][j].right_fit=null;
                    }
                }
                map[start_x][start_y].corr=22;
                map[start_x][start_y].up_fit=true;
                map[start_x][start_y].down_fit=false;
                map[start_x][start_y].left_fit=false;
                map[start_x][start_y].right_fit=false;
                x=start_x; y=start_y;
                map_is_built=false;
                map_is_completed=false;
            }
        }



            boolean exit=false;
            for (int i=1;i<map_size-1;i++){
                for (int j=1;j<map_size-1;j++){
                    if (map[i][j].corr==21){
                        if (i==start_x&&j==start_y){
                            exit=false;
                        }
                        else {
                            map[i][j].corr=31;
                            exit=true;
                        }
                    }
                    else if (map[i][j].corr==22){
                        if (i==start_x&&j==start_y){
                            exit=false;
                        }
                        else {
                            map[i][j].corr=32;
                            exit=true;
                        }
                    }
                    else if (map[i][j].corr==23){
                        if (i==start_x&&j==start_y){
                            exit=false;
                        }
                        else {
                            map[i][j].corr=33;
                            exit=true;
                        }
                    }
                    else if (map[i][j].corr==24){
                        if (i==start_x&&j==start_y){
                            exit=false;
                        }
                        else {
                            map[i][j].corr=34;
                            exit=true;
                        }
                    }

                    if (exit)break;
                }
                if (exit)break;
            }



        return map;
    }
    public Node[][] choose_corridor( int x, int y, Node[][] map) {
        Boolean up = map[x - 1][y].down_fit;
        Boolean down = map[x + 1][y].up_fit;
        Boolean left = map[x][y - 1].right_fit;
        Boolean right = map[x][y + 1].left_fit;
        byte chosen_corridor=0;

        byte[] Up_fit = {1, 2, 4, 6, 7, 10, 11};
        byte[] Up_with_NotLeft_fit = {2, 7, 10};
        byte[] Up_with_NotDown_fit = {4, 10, 11};
        byte[] Up_with_NotRight_fit = {2, 6, 11};
        byte Up_with_NotLeft_and_NotRight_fit = 2;
        byte Up_with_NotLeft_and_NotDown_fit = 10;
        byte Up_with_NotDown_and_NotRight_fit = 11;
        byte Up_with_NotAny_fit = 22;
        byte[] Down_fit = {1, 2, 5, 6, 7, 8, 9};
        byte[] Down_with_NotLeft_fit = {2, 7, 8};
        byte[] Down_with_NotUp_fit = {5, 8, 9};
        byte[] Down_with_NotRight_fit = {2, 6, 9};
        byte Down_with_NotLeft_and_NotRight_fit = 2;
        byte Down_with_NotLeft_and_NotUp_fit = 8;
        byte Down_with_NotUp_and_NotRight_fit = 9;
        byte Down_with_NotAny_fit = 24;
        byte[] Left_fit = {1, 3, 4, 5, 6, 9, 11};
        byte[] Left_with_NotUp_fit = {3, 5, 9};
        byte[] Left_with_NotDown_fit = {3, 4, 11};
        byte[] Left_with_NotRight_fit = {6, 9, 11};
        byte Left_with_NotUp_and_NotRight_fit = 9;
        byte Left_with_NotUp_and_NotDown_fit = 3;
        byte Left_with_NotDown_and_NotRight_fit = 11;
        byte Left_with_NotAny_fit = 21;
        byte[] Right_fit = {1, 3, 4, 5, 7, 8, 10};
        byte[] Right_with_NotLeft_fit = {7, 8, 10};
        byte[] Right_with_NotDown_fit = {3, 4, 10};
        byte[] Right_with_NotUp_fit = {3, 5, 8};
        byte Right_with_NotLeft_and_NotUp_fit = 8;
        byte Right_with_NotLeft_and_NotDown_fit = 10;
        byte Right_with_NotDown_and_NotUp_fit = 3;
        byte Right_with_NotAny_fit = 23;

        byte[] Up_and_Down_fit = {1, 2, 6, 7};
        byte[] Up_and_Down_with_NotLeft_fit = {2, 7};
        byte[] Up_and_Down_with_NotRight_fit = {2, 6};
        byte Up_and_Down_with_NotAny_fit = 2;
        byte[] Up_and_Left_fit = {1, 4, 6, 11};
        byte[] Up_and_Left_with_NotRight_fit = {6, 11};
        byte[] Up_and_Left_with_NotDown_fit = {4, 11};
        byte Up_and_Left_with_NotAny_fit = 11;
        byte[] Up_and_Right_fit = {1, 4, 7, 10};
        byte[] Up_and_Right_with_NotLeft_fit = {7, 10};
        byte[] Up_and_Right_with_NotDown_fit = {4, 10};
        byte Up_and_Right_with_NotAny_fit = 10;
        byte[] Down_and_Left_fit = {1, 5, 6, 9};
        byte[] Down_and_Left_with_NotUp_fit = {5, 9};
        byte[] Down_and_Left_with_NotRight_fit = {6, 9};
        byte Down_and_Left_with_NotAny_fit = 9;
        byte[] Down_and_Right_fit = {1, 5, 7, 8};
        byte[] Down_and_Right_with_NotUp_fit = {5, 8};
        byte[] Down_and_Right_with_NotLeft_fit = {7, 8};
        byte Down_and_Right_with_NotAny_fit = 8;
        byte[] Right_and_Left_fit = {1, 3, 4, 5};
        byte[] Right_and_Left_with_NotUp_fit = {3, 5};
        byte[] Right_and_Left_with_NotDown_fit = {3, 4};
        byte Right_and_Left_with_NotAny_fit = 3;

        byte[] Up_and_Down_and_Right_fit = {1, 7};
        byte Up_and_Down_and_Right_with_NotAny_fit = 7;
        byte[] Up_and_Down_and_Left_fit = {1, 6};
        byte Up_and_Down_and_Left_with_NotAny_fit = 6;
        byte[] Up_and_Left_and_Right_fit = {1, 4};
        byte Up_and_Left_and_Right_with_NotAny_fit = 4;
        byte[] Down_and_Left_and_Right_fit = {1, 5};
        byte Down_and_Left_and_Right_with_NotAny_fit = 5;

        byte Cross = 1;


        if(up==null){
            if(down==null){
                if(left==null){
                    if(right!=null && right){
                        chosen_corridor = Right_fit[(int) (Math.random() * 7)];
                    }
                }
                else if(left){
                    if(right==null){
                        chosen_corridor = Left_fit[(int) (Math.random() * 7)];
                    }
                    else if(right){
                        chosen_corridor = Right_and_Left_fit[(int) (Math.random() * 4)];
                    }
                    else { //!right
                        chosen_corridor = Left_with_NotRight_fit[(int) (Math.random() * 3)];
                    }
                }
                else { //!left
                    if(right!=null && right){
                        chosen_corridor = Right_with_NotLeft_fit[(int) (Math.random() * 3)];
                    }

                }
            }
            else if(down){
                if(left==null){
                    if(right==null){
                        chosen_corridor = Down_fit[(int) (Math.random() * 7)];
                    }
                    else if(right){
                        chosen_corridor = Down_and_Right_fit[(int) (Math.random() * 4)];
                    }
                    else { //!right
                        chosen_corridor = Down_with_NotRight_fit[(int) (Math.random() * 3)];
                    }
                }
                else if(left){
                    if(right==null){
                        chosen_corridor = Down_and_Left_fit[(int) (Math.random() * 4)];
                    }
                    else if(right){
                        chosen_corridor = Down_and_Left_and_Right_fit[(int) (Math.random() * 2)];
                    }
                    else { //!right
                        chosen_corridor = Down_and_Left_with_NotRight_fit[(int) (Math.random() * 2)];
                    }
                }
                else { //!left
                    if(right==null){
                        chosen_corridor = Down_with_NotLeft_fit[(int) (Math.random() * 3)];
                    }
                    else if(right){
                        chosen_corridor = Down_and_Right_with_NotLeft_fit[(int) (Math.random() * 2)];
                    }
                    else { //!right
                        chosen_corridor = Down_with_NotLeft_and_NotRight_fit;
                    }
                }
            }
            else { //!down
                if(left==null){
                    if(right!=null && right){
                        chosen_corridor = Right_with_NotDown_fit[(int) (Math.random() * 3)];
                    }

                }
                else if(left){
                    if(right==null){
                        chosen_corridor = Left_with_NotDown_fit[(int) (Math.random() * 3)];
                    }
                    else if(right){
                        chosen_corridor = Right_and_Left_with_NotDown_fit[(int) (Math.random() * 2)];
                    }
                    else { //!right
                        chosen_corridor = Left_with_NotDown_and_NotRight_fit;
                    }
                }
                else { //!left
                    if(right!=null && right){
                        chosen_corridor = Right_with_NotLeft_and_NotDown_fit;
                    }

                }
            }
        }
        else if(up){
            if(down==null){
                if(left==null){
                    if(right==null){
                        chosen_corridor = Up_fit[(int) (Math.random() * 7)];
                    }
                    else if(right){
                        chosen_corridor = Up_and_Right_fit[(int) (Math.random() * 4)];
                    }
                    else { //!right
                        chosen_corridor = Up_with_NotRight_fit[(int) (Math.random() * 3)];
                    }
                }
                else if(left){
                    if(right==null){
                        chosen_corridor = Up_and_Left_fit[(int) (Math.random() * 4)];
                    }
                    else if(right){
                        chosen_corridor = Up_and_Left_and_Right_fit[(int) (Math.random() * 2)];
                    }
                    else { //!right
                        chosen_corridor = Up_and_Left_with_NotRight_fit[(int) (Math.random() * 2)];
                    }
                }
                else { //!left
                    if(right==null){
                        chosen_corridor = Up_with_NotLeft_fit[(int) (Math.random() * 3)];
                    }
                    else if(right){
                        chosen_corridor = Up_and_Right_with_NotLeft_fit[(int) (Math.random() * 2)];
                    }
                    else { //!right
                        chosen_corridor = Up_with_NotLeft_and_NotRight_fit;
                    }
                }
            }
            else if(down){
                if(left==null){
                    if(right==null){
                        chosen_corridor = Up_and_Down_fit[(int) (Math.random() * 4)];
                    }
                    else if(right){
                        chosen_corridor = Up_and_Down_and_Right_fit[(int) (Math.random() * 2)];
                    }
                    else { //!right
                        chosen_corridor = Up_and_Down_with_NotRight_fit[(int) (Math.random() * 2)];
                    }
                }
                else if(left){
                    if(right==null){
                        chosen_corridor = Up_and_Down_and_Left_fit[(int) (Math.random() * 2)];
                    }
                    else if(right){
                        chosen_corridor = Cross;
                    }
                    else { //!right
                        chosen_corridor = Up_and_Down_and_Left_with_NotAny_fit;
                    }
                }
                else { //!left
                    if(right==null){
                        chosen_corridor = Up_and_Down_with_NotLeft_fit[(int) (Math.random() * 2)];
                    }
                    else if(right){
                        chosen_corridor = Up_and_Down_and_Right_with_NotAny_fit;
                    }
                    else { //!right
                        chosen_corridor = Up_and_Down_with_NotAny_fit;
                    }
                }
            }
            else { //!down
                if(left==null){
                    if(right==null){
                        chosen_corridor = Up_with_NotDown_fit[(int) (Math.random() * 3)];
                    }
                    else if(right){
                        chosen_corridor = Up_and_Right_with_NotDown_fit[(int) (Math.random() * 2)];
                    }
                    else { //!right
                        chosen_corridor = Up_with_NotDown_and_NotRight_fit;
                    }
                }
                else if(left){
                    if(right==null){
                        chosen_corridor = Up_and_Left_with_NotDown_fit[(int) (Math.random() * 2)];
                    }
                    else if(right){
                        chosen_corridor = Up_and_Left_and_Right_with_NotAny_fit;
                    }
                    else { //!right
                        chosen_corridor = Up_and_Left_with_NotAny_fit;
                    }
                }
                else { //!left
                    if(right==null){
                        chosen_corridor = Up_with_NotLeft_and_NotDown_fit;
                    }
                    else if(right){
                        chosen_corridor = Up_and_Right_with_NotAny_fit;
                    }
                    else { //!right
                        chosen_corridor = Up_with_NotAny_fit;
                    }
                }
            }
        }
        else { //!up
            if(down==null){
                if(left==null){
                    if(right!=null && right){
                        chosen_corridor = Right_with_NotUp_fit[(int) (Math.random() * 3)];
                    }

                }
                else if(left){
                    if(right==null){
                        chosen_corridor = Left_with_NotUp_fit[(int) (Math.random() * 3)];
                    }
                    else if(right){
                        chosen_corridor = Right_and_Left_with_NotUp_fit[(int) (Math.random() * 2)];
                    }
                    else { //!right
                        chosen_corridor = Left_with_NotUp_and_NotRight_fit;
                    }
                }
                else { //!left
                    if(right!=null && right){
                        chosen_corridor = Right_with_NotLeft_and_NotUp_fit;
                    }

                }
            }
            else if(down){
                if(left==null){
                    if(right==null){
                        chosen_corridor = Down_with_NotUp_fit[(int) (Math.random() * 3)];
                    }
                    else if(right){
                        chosen_corridor = Down_and_Right_with_NotUp_fit[(int) (Math.random() * 2)];
                    }
                    else { //!right
                        chosen_corridor = Down_with_NotUp_and_NotRight_fit;
                    }
                }
                else if(left){
                    if(right==null){
                        chosen_corridor = Down_and_Left_with_NotUp_fit[(int) (Math.random() * 2)];
                    }
                    else if(right){
                        chosen_corridor = Down_and_Left_and_Right_with_NotAny_fit;
                    }
                    else { //!right
                        chosen_corridor = Down_and_Left_with_NotAny_fit;
                    }
                }
                else { //!left
                    if(right==null){
                        chosen_corridor = Down_with_NotLeft_and_NotUp_fit;
                    }
                    else if(right){
                        chosen_corridor = Down_and_Right_with_NotAny_fit;
                    }
                    else { //!right
                        chosen_corridor = Down_with_NotAny_fit;
                    }
                }
            }
            else { //!down
                if(left==null){
                    if(right!=null && right){
                        chosen_corridor = Right_with_NotDown_and_NotUp_fit;
                    }
                }
                else if(left){
                    if(right==null){
                        chosen_corridor = Left_with_NotUp_and_NotDown_fit;
                    }
                    else if(right){
                        chosen_corridor = Right_and_Left_with_NotAny_fit;
                    }
                    else { //!right
                        chosen_corridor = Left_with_NotAny_fit;
                    }
                }
                else { //!left
                    if(right!=null && right){
                        chosen_corridor = Right_with_NotAny_fit;
                    }
                }
            }
        }

        if(chosen_corridor==1){map[x][y].up_fit=true;map[x][y].down_fit=true;map[x][y].left_fit=true;map[x][y].right_fit=true;}
        else if(chosen_corridor==2){map[x][y].up_fit=true;map[x][y].down_fit=true;map[x][y].left_fit=false;map[x][y].right_fit=false;}
        else if(chosen_corridor==3){map[x][y].up_fit=false;map[x][y].down_fit=false;map[x][y].left_fit=true;map[x][y].right_fit=true;}
        else if(chosen_corridor==4){map[x][y].up_fit=true;map[x][y].down_fit=false;map[x][y].left_fit=true;map[x][y].right_fit=true;}
        else if(chosen_corridor==5){map[x][y].up_fit=false;map[x][y].down_fit=true;map[x][y].left_fit=true;map[x][y].right_fit=true;}
        else if(chosen_corridor==6){map[x][y].up_fit=true;map[x][y].down_fit=true;map[x][y].left_fit=true;map[x][y].right_fit=false;}
        else if(chosen_corridor==7){map[x][y].up_fit=true;map[x][y].down_fit=true;map[x][y].left_fit=false;map[x][y].right_fit=true;}
        else if(chosen_corridor==8){map[x][y].up_fit=false;map[x][y].down_fit=true;map[x][y].left_fit=false;map[x][y].right_fit=true;}
        else if(chosen_corridor==9){map[x][y].up_fit=false;map[x][y].down_fit=true;map[x][y].left_fit=true;map[x][y].right_fit=false;}
        else if(chosen_corridor==10){map[x][y].up_fit=true;map[x][y].down_fit=false;map[x][y].left_fit=false;map[x][y].right_fit=true;}
        else if(chosen_corridor==11){map[x][y].up_fit=true;map[x][y].down_fit=false;map[x][y].left_fit=true;map[x][y].right_fit=false;}
        else if(chosen_corridor==21){map[x][y].up_fit=false;map[x][y].down_fit=false;map[x][y].left_fit=true;map[x][y].right_fit=false;}
        else if(chosen_corridor==22){map[x][y].up_fit=true;map[x][y].down_fit=false;map[x][y].left_fit=false;map[x][y].right_fit=false;}
        else if(chosen_corridor==23){map[x][y].up_fit=false;map[x][y].down_fit=false;map[x][y].left_fit=false;map[x][y].right_fit=true;}
        else if(chosen_corridor==24){map[x][y].up_fit=false;map[x][y].down_fit=true;map[x][y].left_fit=false;map[x][y].right_fit=false;}

        map[x][y].corr = chosen_corridor;
        return map;
    }

}
