package com.example.everlastinglabyrinth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {
    String language="English";
    String play_button_main;
    String continue_button_main;
    String campaign_button_main;
    String settings_button_main;
    int helpers_language_main;
    String exit_button_level;
    String easy_button_difficult;
    String medium_button_difficult;
    String hard_button_difficult;
    String everlasting_button_difficult;
    String alert_ybutton1;
    String alert_nbutton1;
    String alert_title1;
    String alert_confirm1;
    String alert_ybutton2;
    String alert_nbutton2;
    String alert_title2;
    String alert_confirm2;
    String language_text ="Language";

    int item_spinner;
    String after_level_button_MAIN_MENU;
    String after_level_button_NEXT_LEVEL;

   TextView Text_language;
   TextView Settings_text;






    String[] languages ={"English","Русский"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences settings = getSharedPreferences("Settings",MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);



        Text_language = findViewById(R.id.text_language);
        Settings_text = findViewById(R.id.Settings_text);
        Text_language.setText(language_text);
        Settings_text.setText(settings.getString("button_settings","Settings"));
        Spinner Languages_spinner = (Spinner) findViewById(R.id.Languages);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Languages_spinner.setAdapter(adapter);
        Languages_spinner.setSelection(settings.getInt("item_spinner",0));
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                language = item;
                ((TextView) parent.getChildAt(0)).setTextColor(getResources().getColor(R.color.colorAccent_2));
                ((TextView) parent.getChildAt(0)).setTextSize(20);

                if (language.equals("English")){
                    play_button_main = "Free mode";
                    continue_button_main = "Continue";
                    campaign_button_main = "Campaign";
                    settings_button_main = "Settings";
                    helpers_language_main = 0;
                    exit_button_level="Exit";
                    easy_button_difficult="Easy";
                    medium_button_difficult="Medium";
                    hard_button_difficult="Hard";
                    item_spinner=0;
                    language_text ="Language:";
                    Text_language.setText(language_text);
                    Settings_text.setText(settings_button_main);
                    alert_nbutton1="No";
                    alert_ybutton1="Yes";
                    alert_confirm1="Are you sure you want to quit the game?";
                    alert_title1="Exit";


                    alert_nbutton2="Continue";
                    alert_ybutton2="Main menu";
                    alert_confirm2="";
                    alert_title2="Pause";

                    after_level_button_MAIN_MENU="Main menu";
                    after_level_button_NEXT_LEVEL="Next Level";


                }
                else if (language.equals("Русский")){
                    play_button_main = "Случайный";
                    continue_button_main = "Продолжить";
                    campaign_button_main = "Кампания";
                    settings_button_main = "Настройки";
                    helpers_language_main = 1;
                    exit_button_level="Выход";
                    easy_button_difficult="Легкий";
                    medium_button_difficult="Средний";
                    hard_button_difficult="Сложный";
                    item_spinner=1;
                    language_text ="Язык:";
                    Text_language.setText(language_text);
                    Settings_text.setText(settings_button_main);
                    alert_nbutton1="Нет";
                    alert_ybutton1="Да";
                    alert_confirm1="Вы уверены что хотите выйти из игры?";
                    alert_title1="Выход";



                    alert_nbutton2="Продолжить";
                    alert_ybutton2="Главное меню";
                    alert_confirm2="";
                    alert_title2="Пауза";

                    after_level_button_MAIN_MENU="Главное меню";
                    after_level_button_NEXT_LEVEL="Следующий уровень";
                }

                SharedPreferences settings = getSharedPreferences("Settings",MODE_PRIVATE);
                SharedPreferences.Editor Setting_Editor =settings.edit();
                Setting_Editor.putString("button_play_name",play_button_main);
                Setting_Editor.putString("button_continue",continue_button_main);
                Setting_Editor.putString("button_campaign",campaign_button_main);
                Setting_Editor.putString("button_settings",settings_button_main);
                Setting_Editor.putInt("helpers_lang",helpers_language_main);
                Setting_Editor.putString("button_exit",exit_button_level);
                Setting_Editor.putString("button_easy",easy_button_difficult);
                Setting_Editor.putString("button_medium",medium_button_difficult);
                Setting_Editor.putString("button_hard",hard_button_difficult);
                Setting_Editor.putString("button_everlasting",everlasting_button_difficult);
                Setting_Editor.putInt("item_spinner",item_spinner);
                Setting_Editor.putString("alert_nbutton1",alert_nbutton1);
                Setting_Editor.putString("alert_ybutton1",alert_ybutton1);
                Setting_Editor.putString("alert_confirm1",alert_confirm1);
                Setting_Editor.putString("alert_title1",alert_title1);
                Setting_Editor.putString("alert_nbutton2",alert_nbutton2);
                Setting_Editor.putString("alert_ybutton2",alert_ybutton2);
                Setting_Editor.putString("alert_confirm2",alert_confirm2);
                Setting_Editor.putString("alert_title2",alert_title2);
                Setting_Editor.putString("button_main_menu",after_level_button_MAIN_MENU);
                Setting_Editor.putString("button_next_level",after_level_button_NEXT_LEVEL);
                Setting_Editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        Languages_spinner.setOnItemSelectedListener(itemSelectedListener);


    }
    protected void onResume(){
        super.onResume();
        Text_language.setText(language_text);
    }
}
