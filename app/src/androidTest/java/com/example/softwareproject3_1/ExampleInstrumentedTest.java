package com.example.softwareproject3_1;

import android.view.View;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Before
    public void setUp() {
        ActivityScenario.launch(NotificationActivity.class);
    }

    @Test
    public void testNotificationDisplayed() {
        Espresso.onView(withId(R.id.notificationTitleTextView))
                .check(matches(withText("New Blog Post")));

        Espresso.onView(withId(R.id.notificationMessageTextView))
                .check(matches(withText("A new blog post has been added. Check it out!")));
    }

    @Test
    public void testDismissNotification() {

        Espresso.onView(withText("Dismiss"))
                .perform(ViewActions.click());


        Espresso.onView(withId(R.id.notificationTitleTextView))
                .check(matches(withText("")));

        Espresso.onView(withId(R.id.notificationMessageTextView))
                .check(matches(withText("")));
    }
}
