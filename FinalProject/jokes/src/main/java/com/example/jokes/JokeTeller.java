package com.example.jokes;

import java.util.Random;

public class JokeTeller {

    public String getJoke() {
        String[] jokes = new String[] {
          "How does a hurricane see? //With its eye.",
          "What do chemists' dogs do with their bones? //They barium!",
          "What kind of music are balloons afraid of? //Pop Music"
        };

        return jokes[new Random().nextInt(jokes.length)];
    }
}
