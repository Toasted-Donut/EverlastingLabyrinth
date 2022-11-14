package com.example.everlastinglabyrinth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public MediaPlayer theme = new MediaPlayer();
    Button Y_alert;
    Button N_alert;
    TextView Title_alert;
    TextView Confirm_alert;
    Button Play;
    Button Settings;
    Button Campaign;
    Button Continue_play;
    TextView Helpers_text;
    ImageView Name_image;
    final int MAX_VOLUME = 100;
    final int soundVolume = 50;
    public String[] rus_helpers={"Третий уровень кампании - это самый первый тестовый уровень","Случайные уровни могу быть ограниченно большими, но неограниченно маленькими","Игра сохраняется автоматически после каждого хода","Первые текстуры были такие же, как лабиринт на иконке"};
    public String[] eng_helpers={"The third level of the campaign is the first test level","Random levels can be limitedly large, but unlimitedly small","The game automatically saves after each move","The first textures were the same as the labyrinth on the icon"};
    public int language;

    public SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        settings = getSharedPreferences("Settings",MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final float volume = (float) (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME)));
        theme = MediaPlayer.create(this, R.raw.theme);
        theme.setLooping(true);
        theme.setVolume(volume,volume);
        theme.start();
        Play = findViewById(R.id.play);

        Settings = findViewById(R.id.setting);
        Campaign = findViewById(R.id.Campaign);
        Continue_play = findViewById(R.id.Continue_game);
        Helpers_text = findViewById(R.id.Helpers_text);
        Name_image = findViewById(R.id.image_name);
        Name_image.setImageResource(R.drawable.name);
        



        Continue_play.setClickable(false);
        Continue_play.setVisibility(View.INVISIBLE);

        if (settings.getBoolean("can_continue",false)){
            Continue_play.setClickable(true);
            Continue_play.setVisibility(View.VISIBLE);
        }

        language=settings.getInt("helpers_lang",0);
        if (language==0){
            Helpers_text.setText(eng_helpers[(int)(Math.random()*eng_helpers.length)]);
        }
        else {
            Helpers_text.setText(rus_helpers[(int)(Math.random()*rus_helpers.length)]);
        }
        Play.setText(settings.getString("button_play_name","Play"));
        Continue_play.setText(settings.getString("button_continue","Continue"));
        Campaign.setText(settings.getString("button_campaign","Campaign"));
        Settings.setText(settings.getString("button_settings","Settings"));

        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  DiffChooseActiv = new Intent(MainActivity.this, DifficultChooseActivity.class);
                startActivity(DiffChooseActiv);
            }
        });
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SettingActiv = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(SettingActiv);
            }
        });
        Campaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent CampaignActiv = new Intent(MainActivity.this,CampaignActivity.class);
                startActivity(CampaignActiv);
            }
        });
        Continue_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  LevelActiv = new Intent(MainActivity.this, LevelActivity.class);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Setting_Editor.putBoolean("do_continue",true);
                Setting_Editor.apply();
                startActivity(LevelActiv);
            }
        });

    }
    protected void onResume(){
        super.onResume();
        theme.start();
        Play.setText(settings.getString("button_play_name","Play"));
        Continue_play.setText(settings.getString("button_continue","Continue"));
        Campaign.setText(settings.getString("button_campaign","Campaign"));
        Settings.setText(settings.getString("button_settings","Settings"));
        language=settings.getInt("helpers_lang",0);
        if (language==0){
            Helpers_text.setText(eng_helpers[(int)(Math.random()*eng_helpers.length)]);
        }
        else {
            Helpers_text.setText(rus_helpers[(int)(Math.random()*rus_helpers.length)]);
        }
        if (settings.getBoolean("can_continue",false)){
            Continue_play.setClickable(true);
            Continue_play.setVisibility(View.VISIBLE);
        }
        else{
            Continue_play.setClickable(false);
            Continue_play.setVisibility(View.INVISIBLE);
        }
    }

    protected void onPause(){
        super.onPause();
        theme.setVolume(settings.getInt("music_volume",5),10);
    }
    protected void onDestroy(){
        super.onDestroy();
        theme.pause();

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder alert_build = new AlertDialog.Builder(MainActivity.this);
            View view = (ConstraintLayout) getLayoutInflater()
                    .inflate(R.layout.dialog, null);
            alert_build.setView(view);
            final AlertDialog alert = alert_build.create();
            alert.show();
            Y_alert = alert.findViewById(R.id.button_yes);
            N_alert = alert.findViewById(R.id.button_no);
            Title_alert = alert.findViewById(R.id.Title);
            Confirm_alert = alert.findViewById(R.id.Confirm);
            Y_alert.setText(settings.getString("alert_ybutton1","Yes"));
            N_alert.setText(settings.getString("alert_nbutton1","No"));
            Title_alert.setText(settings.getString("alert_title1","Exit"));
            Confirm_alert.setText(settings.getString("alert_confirm1","Are you sure you want to quit the game?"));

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


}
