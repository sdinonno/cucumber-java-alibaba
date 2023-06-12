package com.cucumber;

import com.managers.PageObjectManager;
import com.managers.DriverManager;


public class TestContext {
    private final DriverManager webDriverManager;
    private final PageObjectManager pageObjectManager;
    public ScenarioContext scenarioContext;

    public TestContext(){
        webDriverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(DriverManager.getDriver());
        scenarioContext = new ScenarioContext();
    }

    public DriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
