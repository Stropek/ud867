package com.example.jokes;

import java.util.Random;

public class JokeTeller {

    public String getJoke() {
        String[] jokes = new String[] {
          "Q: How does a hurricane see? A: With its eye.",
          "Q: What do chemists' dogs do with their bones? A: They barium!",
          "Q: What kind of music are balloons afraid of? A: Pop Music"
        };

        return jokes[new Random().nextInt(jokes.length)];
    }
}
