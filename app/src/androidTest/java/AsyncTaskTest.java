import com.udacity.gradle.builditbigger.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.OnJokeRetrieve;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static junit.framework.Assert.assertNotNull;

public class AsyncTaskTest {

    @Test
    public void testAsyncJokeRetrieve() throws InterruptedException, ExecutionException, TimeoutException {
        final CountDownLatch signal = new CountDownLatch(1);
        EndpointAsyncTask jokeTask = new EndpointAsyncTask(new OnJokeRetrieve() {

            @Override
            public void onJokeRetrieve(String joke) {
                assertNotNull(joke);
                signal.countDown();
            }
        });
        jokeTask.execute();
        signal.await();
    }
}
