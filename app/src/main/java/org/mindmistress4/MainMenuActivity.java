package org.mindmistress4;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Make to run your application only in portrait mode
        setContentView(R.layout.activity_main_menu);

        initExitButton();
        initSettingsButton();
        initSetTimeButton();
    }


    public void initSetTimeButton() {
        ImageButton settingsBtn = (ImageButton) findViewById(R.id.imageButton5);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSettingsPage = new Intent(MainMenuActivity.this, SetTime2Activity.class);
                startActivity(goToSettingsPage);
            }
        });
    }


    public void initSettingsButton() {
        ImageButton settingsBtn = (ImageButton) findViewById(R.id.imageButton4);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSettingsPage = new Intent(MainMenuActivity.this, Settings3Activity.class);
                startActivity(goToSettingsPage);
            }
        });
    }


    public void initExitButton() {
        ImageButton exitBtn = (ImageButton) findViewById(R.id.imageButton6);


        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // android.os.Process.killProcess(MainActivity.processId);
                // android.os.Process.killProcess(android.os.Process.myPid());

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                // finish all activities
                finish();
                //System.exit(0);
            }
        });

        /*
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                //System.exit(0);

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        */
    }

}


