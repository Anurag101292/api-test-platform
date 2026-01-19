package org.example.tests;

import org.example.base.BaseTest;
import org.example.engine.data.DataProviderFactory;
import org.example.engine.data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataEngineSanityTest extends BaseTest {

    @Test
    public void shouldLoadJsonTestData() {

        TestData data = DataProviderFactory.get().get("createBooking");

        Assert.assertEquals(data.getString("firstname"), "John");
        Assert.assertEquals(data.getString("lastname"), "Smith");
        Assert.assertEquals(data.getInt("price"), Integer.valueOf(123));
        Assert.assertEquals(data.getBoolean("paid"), Boolean.TRUE);
    }
}
