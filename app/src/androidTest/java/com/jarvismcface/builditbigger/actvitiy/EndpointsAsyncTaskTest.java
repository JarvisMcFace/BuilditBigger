package com.jarvismcface.builditbigger.actvitiy;

import android.support.test.annotation.UiThreadTest;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import junit.framework.TestCase;

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

    private CountDownLatch signal;

    protected void setUp() throws Exception {
        super.setUp();
        signal = new CountDownLatch(1);
    }

    @UiThreadTest
    public void EndpointsTest() throws InterruptedException {

        WeakReference<EndpointsAsyncTask.Callback> weakReference = new WeakReference<EndpointsAsyncTask.Callback>(this);
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(weakReference);
        endpointsAsyncTask.execute();

        Joke  result = null;
        try {
            result = endpointsAsyncTask.get(10, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Log.d("David", "David: " + "EndpointsTest() called" + result.size());
                Log.d("David", "David: " + "EndpointsTest() called33333 ");

        signal.await(10, TimeUnit.SECONDS);// wait for callback
//                assertNotNull(result);
//                assertTrue(result.length() > 0);

    }

    @Override
    public void progressIndicator(boolean enable) {
        Log.d("David -TEST", "David: " + "progressIndicator() called with: enable = [" + enable + "]");
    }

    @Override
    public void callBack(Joke joke) {
        signal.countDown();
        Log.d("David-TEST", "David: " + "callBack() called with: joke = [" + joke + "]");

    }
}