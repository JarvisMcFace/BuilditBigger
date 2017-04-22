package com.jarvismcface.builditbigger.actvitiy;

import android.support.test.annotation.UiThreadTest;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by David on 4/14/17.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class EndpointsAsyncTaskTest extends TestCase implements EndpointsAsyncTask.Callback {

    private CountDownLatch signal = new CountDownLatch(1);
    private EndpointsAsyncTask endpointsAsyncTask;

    @UiThreadTest
    @Test
    public void EndpointsTest() throws InterruptedException {

        WeakReference<EndpointsAsyncTask.Callback> weakReference = new WeakReference<EndpointsAsyncTask.Callback>(this);
        endpointsAsyncTask = new EndpointsAsyncTask(weakReference);
        endpointsAsyncTask.execute();

        Joke result = null;
        try {
            result = endpointsAsyncTask.get(30, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        signal.await(5, TimeUnit.SECONDS);// wait for callback
        assertNotNull(result);
        assertTrue(result.size() == 2);

    }

    @Override
    public void progressIndicator(boolean enable) {
       //intentionally blank
    }

    @Override
    public void callBack(Joke joke) {
        signal.countDown();
    }
}