package com.hughesdigitalimage.builditbigger.actvitiy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.Joke;
import com.hughesdigitalimage.builditbigger.R;
import com.hughesdigitalimage.builditbigger.actvitiy.consants.IntentConsents;
import com.udacity.gradle.builditbigger.library.activity.JokeTellerActivity;

import java.lang.ref.WeakReference;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.Callback {

    public static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    public void progressIndicator(boolean enable) {
        Log.d(TAG, "David: " + "progressIndicator() called with: enable = [" + enable + "]");
    }

    @Override
    public void callBack(Joke joke) {
        Intent intent = new Intent(this, JokeTellerActivity.class);
        intent.putExtra(IntentConsents.EXTRA_TELL_JOKE, joke.getQuestion());
        intent.putExtra(IntentConsents.EXTRA_TELL_ANSWER, joke.getAnswer());
        startActivity(intent);
    }

    public void tellJoke(View view) {
        WeakReference<EndpointsAsyncTask.Callback> weakReference = new WeakReference<EndpointsAsyncTask.Callback>(this);
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(weakReference);
        endpointsAsyncTask.execute();
    }
}
