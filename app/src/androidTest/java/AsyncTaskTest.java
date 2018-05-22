
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.OnJokeRetrieve;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.SECONDS;
import static junit.framework.Assert.assertNotNull;

public class AsyncTaskTest {

    @Test
    public void testAsyncJokeRetrieve() throws InterruptedException, ExecutionException, TimeoutException {

        String joke;
        EndpointAsyncTask jokeTask = new EndpointAsyncTask(new OnJokeRetrieve() {

            @Override
            public void onJokeRetrieve(String joke) {
            }
        });
        jokeTask.execute();
        joke = jokeTask.get(30, TimeUnit.SECONDS);
        Thread.sleep(SECONDS.toMillis(2));
        assertNotNull(joke);
    }
}
