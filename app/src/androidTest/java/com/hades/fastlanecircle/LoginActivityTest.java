package com.hades.fastlanecircle;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.hades.fastlanecircle.login.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mLoginRule = new ActivityTestRule<>(LoginActivity.class);

    public String mUsername = "Abcxyz";
    public String mPassword = "Aa@123456";


    @Test
    public void clickSubmitButton() {

        Espresso.onView(ViewMatchers.withId(R.id.et_username)).perform(ViewActions.typeText(mUsername));

        Espresso.onView(ViewMatchers.withId(R.id.et_password)).perform(ViewActions.typeText(mPassword));

        Espresso.onView(ViewMatchers.withId(R.id.btn_submit)).perform(ViewActions.scrollTo(), ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.tv_login)).check(ViewAssertions.matches(ViewMatchers.withText("Success")));

    }


}
