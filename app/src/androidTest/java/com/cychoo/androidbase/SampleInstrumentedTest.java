package com.cychoo.androidbase;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Created by cy.choo on 12/16/2017.
 * Sample test class for SampleActivity
 */

@RunWith(AndroidJUnit4.class)
public class SampleInstrumentedTest {
    @Rule
    public ActivityTestRule<SampleActivity> activityTestRule =
            new ActivityTestRule<>(SampleActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.cychoo.androidbase", appContext.getPackageName());
    }

    @Test
    public void testButton1() throws  Exception {
        // Clicked button 1 will show a toast of text in edittext 1

        // Get activity in order to access the toast
        SampleActivity sample_activity = activityTestRule.getActivity();
        final EditText et_sample_edittext_1 = (EditText)sample_activity.findViewById(R.id.sample_edittext_1);

        // Fill in some text to edittext 1
        sample_activity.runOnUiThread(new Runnable() {
            public void run() {
                et_sample_edittext_1.setText(R.string.sample_test_text1);
            }
        });

        // Click the button 1
        onView(withId(R.id.sample_button_1)).perform(click());

        // Check if toast display the text in edittest 1
        onView(withText(R.string.sample_test_text1))
            .inRoot(withDecorView(not(is(sample_activity.getWindow().getDecorView()))))
            .check(matches(isDisplayed()));
    }

    @Test
    public void testButton2() throws Exception {
        // Clicked button 2 will change the text of textview 1 (id: R.id.sample_textview_1)

        // Check original text of textview 1
        onView(withId(R.id.sample_textview_1)).check(matches(withText(R.string.sample_text2_before)));

        // Perform click on button 2
        onView(withId(R.id.sample_button_2)).perform(click());

        // Check text of textview 1
        onView(withId(R.id.sample_textview_1)).check(matches(withText(R.string.sample_text2_after)));
    }
}
