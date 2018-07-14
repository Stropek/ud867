package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class JokeEndpointAsyncTaskTest {

    private String result = "";

    @Test
    public void execute_returnsNotEmptyJoke() throws InterruptedException {
        // given
        final CountDownLatch signal = new CountDownLatch(1);
        JokeEndpointAsyncTask task = new JokeEndpointAsyncTask()
                .setListener(new JokeEndpointAsyncTask.JokeEndpointAsyncTaskListener() {
                    @Override
                    public void onComplete(String joke) {
                        result = joke;
                        signal.countDown();
                    }
                });

        // when
        task.execute(InstrumentationRegistry.getTargetContext());
        signal.await();

        // then
        assertFalse(result.isEmpty());
    }
}
