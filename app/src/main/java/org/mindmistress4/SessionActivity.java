package org.mindmistress4;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import bitsAndBytes.consoleui.ConsoleUI;

import static org.mindmistress4.SetTime2Activity.TIME_IN_MINUTES;

public class SessionActivity extends AppCompatActivity {
    public final boolean DEBUG_MODE = false; // false debug mode test mode
    boolean homeButtonEnabled = false;
    ImageButton mainMenuBtn;
    TextView tv;
    Timer updateTimer;
    int counter = 0;

    private TextView  textView    = null;
    private ConsoleUI consoleUI   = null;
    private TextView  tvCountDown = null;


    private class updateTask extends TimerTask {
        Handler handler;
        SessionActivity ref;

        public updateTask(Handler handler, SessionActivity ref) {
            super();
            this.handler = handler;
            this.ref = ref;
        }

        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    ref.update();
                }
            });
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        homeButtonEnabled = false;
        updateTimer = new Timer();
        updateTimer.schedule(new updateTask(new Handler(), this), 0, 1000);
    }


    @Override
    protected void onStop() {
        super.onStop();
        updateTimer.cancel();
        updateTimer.purge();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeButtonEnabled = false;

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Make to run your application only in portrait mode

        setContentView(R.layout.activity_session);
        tvCountDown = (TextView) findViewById(R.id.nextPointInTimeActionMin);

        initMainMenuButton();

        String time_string = getIntent().getStringExtra(TIME_IN_MINUTES);
        int time_in_minutes = Integer.parseInt(time_string);

        textView = (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        /*
        String t = "";
        for(int l=0; l<=15; l++){
            t = "Num: " + l;
            addTextLine(t);
        }
        */

        /*
        addTextLine("test text");
        addTextLine("duration " + time_in_minutes);
        */

        consoleUI = new ConsoleUI(this);
        consoleUI.startUI(time_in_minutes, DEBUG_MODE);
    }

    //! TODO: 19.02.2017 text should start in the first row, not in the last row

    public void addTextLine(String text) {
        textView.append(text + "\n");
        int scroll_amount = textView.getBottom();
        // System.out.println("scroll-amount: " + scroll_amount);
        // textView.scrollTo(0, scroll_amount);
    }


    public void updateRemainingTime(String remainingTime) {
        this.tvCountDown.setText(remainingTime);
    }


    public void update() {
        // This is where the UI calls go
        // tv.setText(String.valueOf(++counter));
        // addTextLine(String.valueOf(++counter));
        this.consoleUI.update();
    }


    public void endOfSession() {
        updateTimer.cancel();
        updateTimer.purge();

        System.out.println("endOfSession()");
        addTextLine("Sessionende");

        enableHomeButton();
    }


    public void playSound() {
        try {
            playSound(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void playSound(Context context) throws IllegalArgumentException,
            SecurityException,
            IllegalStateException,
            IOException {

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        MediaPlayer mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setDataSource(context, soundUri);
        final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) != 0) {
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_ALARM);
            mMediaPlayer.setLooping(false);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        }
    }

    public void enableHomeButton() {
        System.out.println("enableHomeButton()");
        Log.d("SGE_DEBUG","enableHomeButton()");

        homeButtonEnabled = true;
        mainMenuBtn.setImageResource(R.drawable.door_purple_small);
    }

    public void initMainMenuButton() {
        mainMenuBtn = (ImageButton) findViewById(R.id.imageButtonGoMainMenu);
        mainMenuBtn.setImageResource(R.drawable.door_purple_small_grey);

        mainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("on click listener main menu button");
                Log.d("SGE_DEBUG","on click listener main menu button");
                if(homeButtonEnabled) {
                    Intent goToMainMenuPage = new Intent(SessionActivity.this, MainMenuActivity.class);
                    startActivity(goToMainMenuPage);
                    // mainMenuBtn.setImageResource(R.drawable.door_purple_small);
                }
            }
        });
    }
}
