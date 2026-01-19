package org.example.tests;

import org.example.base.BaseTest;
import org.example.util.FileUtils;
import org.example.util.JsonUtils;
import org.example.util.RandomDataUtils;
import org.example.util.TimeUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class UtilitySanityTest extends BaseTest {

    @Test
    public void utilitiesShouldWork() {

        String s = RandomDataUtils.randomString(10);
        Assert.assertEquals(s.length(), 10);

        String json = "{\"a\":1}";
        Map<String, Object> map = JsonUtils.fromJson(json, Map.class);
        Assert.assertEquals(map.get("a"), 1);

        String text = FileUtils.readResourceAsString("config.yaml");
        Assert.assertTrue(text.length() > 0);

        long t1 = TimeUtils.nowMillis();
        TimeUtils.sleepMillis(10);
        long t2 = TimeUtils.nowMillis();
        Assert.assertTrue(t2 > t1);
    }
}
