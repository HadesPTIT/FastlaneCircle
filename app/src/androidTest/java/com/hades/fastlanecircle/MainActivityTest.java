package com.hades.fastlanecircle;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickLoginButton_openLoginScreen() {

        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.tv_login)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

}
