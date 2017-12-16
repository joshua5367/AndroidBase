package com.cychoo.androidbase;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by cy.choo on 12/16/2017.
 * Test for MainActivity
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.cychoo.androidbase", appContext.getPackageName());
    }
}
