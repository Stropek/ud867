package com.example.android.clickcounter;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ClickCounterTests {

    @Test
    public void getCount_initialValue_is0() {
        // given
        ClickCounter counter = new ClickCounter();

        // when
        int count = counter.getCount();

        // then
        assertEquals(0, count);
    }

    @Test
    public void increment_incrementsCountBy1() {
        // given
        ClickCounter counter = new ClickCounter();

        // when
        counter.increment();

        // then
        assertEquals(1, counter.getCount());
    }
}
