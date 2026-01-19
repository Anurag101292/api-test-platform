package org.example.tests;

import org.example.base.BaseTest;
import org.example.core.context.TestExecutionContext;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlatformSanityTest extends BaseTest {

    @Test
    public void frameworkContextShouldBeInitialized() {

        String env = TestExecutionContext.getEnv();
        Assert.assertNotNull(env, "Env should be present in TestExecutionContext");

        Object baseUrl = TestExecutionContext.getConfig().get("baseUrl");
        Assert.assertNotNull(baseUrl, "BaseUrl should be present in TestExecutionContext");

        Assert.assertTrue(true, "TestExecutionContext is working");
    }
}
