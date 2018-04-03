package com.example.programmingknowledge.seekbarapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.net.Uri;


public class MainActivity extends ActionBarActivity {
    // for every bar add a:
    // private static SeekBar (name);
    private static SeekBar happy_bar;
    private static SeekBar sad_bar;
    private static SeekBar angry_bar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // add another assignment for every bar
        happy_bar = (SeekBar)findViewById(R.id.happyBar);
        sad_bar = (SeekBar)findViewById(R.id.sadBar);
        angry_bar = (SeekBar)findViewById(R.id.angryBar);

        button = (Button) findViewById(R.id.button_send);
        button.setOnClickListener(new send_emotion());
    }

    class send_emotion implements OnClickListener{
        @Override
        public void onClick(View v)
        { // TODO Auto-generated method stub
            // Where seek_bar is whatever barname to get the integer
            //seek_bar.getProgress();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendNotification(View view) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this);

        //Create the intent that’ll fire when the user taps the notification//

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.androidauthority.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        mBuilder.setContentIntent(pendingIntent);

        //mBuilder.setSmallIcon(R.drawable.notification_icon);
        mBuilder.setContentTitle("My notification");
        mBuilder.setContentText("Hello World!");

        NotificationManager mNotificationManager =

                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(001, mBuilder.build());
    }
}
