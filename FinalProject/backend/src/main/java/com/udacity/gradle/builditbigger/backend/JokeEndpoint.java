package com.udacity.gradle.builditbigger.backend;

import com.example.jokes.JokeTeller;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    @ApiMethod(name = "tellJoke")
    public Joke tellJoke() {
        JokeTeller jokeTeller = new JokeTeller();

        Joke response = new Joke();
        response.setData(jokeTeller.getJoke());

        return response;
    }
}
