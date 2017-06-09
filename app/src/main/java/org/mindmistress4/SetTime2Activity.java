package org.mindmistress4;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TimePicker;

public class SetTime2Activity extends AppCompatActivity {
    public final static String TIME_IN_MINUTES = "TIME_IN_MINUTES";
    public final static int DEFAULT_DURATION_SESSION_IN_HOURS = 1;
    private TimePicker timePicker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Make to run your application only in portrait mode
        setContentView(R.layout.activity_set_time2);

        initGoButton();
        initTimePicker();
    }


    private void initTimePicker() {
        timePicker = (TimePicker) findViewById(R.id.timePicker2);

        Calendar c = Calendar.getInstance();
        timePicker.setCurrentHour(c.get(Calendar.HOUR) + DEFAULT_DURATION_SESSION_IN_HOURS);
        timePicker.setCurrentMinute(c.get(Calendar.MINUTE));
    }

    private int getMinutes(int hourEndPoint, int minuteEndPoint) {
        hourEndPoint    = hourEndPoint   % 24;

        Calendar c = Calendar.getInstance();
        int h_now = c.get(Calendar.HOUR) % 24;
        int m_now = c.get(Calendar.MINUTE);

        int h = hourEndPoint - h_now;
        if(h < 0) h = h + 12;
        if(h < 0) h = h + 12;

        int m = minuteEndPoint - m_now;
        if(m<0) {
            m = m + 60;
            h = h - 1;
            if(h<0) h=0;
        }

        return m + 60 * h;
    }

    public void initGoButton() {
        ImageButton settingsBtn = (ImageButton) findViewById(R.id.imageButton2);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSettingsPage = new Intent(SetTime2Activity.this, SessionActivity.class);
                // int duration = getMinutes(timePicker.getCurrentHour(), timePicker.getCurrentMinute());
                int duration = getMinutes(timePicker.getCurrentHour(), timePicker.getCurrentMinute());
                System.out.println("hour: " + timePicker.getCurrentHour() + "   minute: " + timePicker.getCurrentMinute());
                System.out.println("duration from timePicker: " + duration);
                goToSettingsPage.putExtra(TIME_IN_MINUTES, "" + duration);
                startActivity(goToSettingsPage);
            }
        });
    }
}
