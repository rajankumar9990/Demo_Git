package com.healthcare.stepdefinitions;

import io.cucumber.java.After;



import com.healthcare.utils.DriverFactory;

public class Hooks {
   

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
