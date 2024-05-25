package com.example.softwareproject3_1;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

import android.content.Intent;
import android.widget.Button;

import org.junit.Test;
import org.robolectric.shadows.ShadowToast;


public class LoginActivityTest {

    private login_Activity activity;


    @Test
    public void testSignUpTextViewClick() {
        // Mock a click on signUpTextViewId
        activity.findViewById(R.id.signUpTextViewId).performClick();

        // Verify that registration_Activity is started
        Intent expectedIntent = new Intent(activity, registration_Activity.class);
        Intent actualIntent = shadowOf(activity).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());
    }

    @Test
    public void testLoginButtonClick() {
        // Mock a click on loginButtonId
        Button loginButton = activity.findViewById(R.id.loginButtonId);
        loginButton.performClick();

        // Verify that userLogin() method is called
        // Since userLogin() internally handles Firebase authentication and UI updates, you may test those separately.

        // Example: Verify Toast message after clicking login button
        assertEquals("Login button clicked", ShadowToast.getTextOfLatestToast());
    }
}
