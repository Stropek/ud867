package com.example.jokes;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JokeTellerTest {

    @Test
    public void getJoke_returnsSingleJoke() {
        // given
        JokeTeller jokeTeller = new JokeTeller();

        // when
        String joke = jokeTeller.getJoke();

        // then
        assertTrue(joke.length() > 0);
    }
}
