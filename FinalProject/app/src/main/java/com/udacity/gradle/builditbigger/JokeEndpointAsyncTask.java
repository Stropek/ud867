package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.joker.IntentExtrasKeys;
import com.example.joker.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;

import java.io.IOException;

public class JokeEndpointAsyncTask extends AsyncTask<Context, Void, String> {

    private static JokeApi jokeService;
    private Context context;

    @Override
    protected String doInBackground(Context... contexts) {
        if (jokeService == null) {
            JokeApi.Builder builder =
                    new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("http://10.0.2.2:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            jokeService = builder.build();
        }

        this.context = contexts[0];

        try {
            return jokeService.tellJoke().execute().getData();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent jokeIntent = new Intent(context, JokeActivity.class);
        jokeIntent.putExtra(IntentExtrasKeys.Joke, result);
        context.startActivity(jokeIntent);
    }
}
