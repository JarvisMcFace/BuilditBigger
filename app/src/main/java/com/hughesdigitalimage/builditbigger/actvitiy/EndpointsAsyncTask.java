package com.hughesdigitalimage.builditbigger.actvitiy;


import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Created by David on 3/25/17.
 */

class EndpointsAsyncTask extends AsyncTask<Void, Void, Joke> {

    public interface Callback {
        void progressIndicator(boolean enable);
        void callBack(Joke joke);
    }

    private WeakReference<Callback> weakCallback;
    private static MyApi myApiService = null;
    private Context context;

    public EndpointsAsyncTask(WeakReference<Callback> weakCallback) {
        this.weakCallback = weakCallback;
    }

    @Override
    protected Joke doInBackground(Void... params) {

        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.86.162:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            Joke joke = myApiService.fetchJoke().execute().getJoke();
            return joke;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(Joke joke) {
        boolean showProgress = false;
        Callback callback = weakCallback.get();
        callback.progressIndicator(showProgress);

        if (joke != null) {
            callback.callBack(joke);
        }
    }
}