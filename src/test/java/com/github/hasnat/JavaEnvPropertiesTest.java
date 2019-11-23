package com.github.hasnat;

import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class JavaEnvPropertiesTest {

    @Test
    public void testGeneric() {
        final Map<String, String> envs = new HashMap<String, String>();
        envs.put("JAVA_ENVS_HELLO_THERE", "General Kenobi");
        Properties expected = new Properties();
        expected.put("hello.there", "General Kenobi");

        Properties props = JavaEnvProperties.envToProperties(envs, true, "JAVA_ENVS_", null);

        assertEquals(expected, props);
    }

    @Test
    public void testNoLowerCase() {
        final Map<String, String> envs = new HashMap<String, String>();
        envs.put("JAVA_ENVS_HELLO_THERE", "General Kenobi");
        Properties expected = new Properties();
        expected.put("HELLO.THERE", "General Kenobi");

        Properties props = JavaEnvProperties.envToProperties(envs, false, "JAVA_ENVS_", null);

        assertEquals(expected, props);
    }

    @Test
    public void testNoPrefix() {
        final Map<String, String> envs = new HashMap<String, String>();
        envs.put("JAVA_ENVS_HELLO_THERE", "General Kenobi");
        Properties expected = new Properties();
        expected.put("java.envs.hello.there", "General Kenobi");

        Properties props = JavaEnvProperties.envToProperties(envs, true, null, null);

        assertEquals(expected, props);
    }

    @Test
    public void testMerge() {
        final Map<String, String> envs = new HashMap<String, String>();
        envs.put("JAVA_ENVS_HELLO_THERE", "General Kenobi");

        final Properties propertiesToMerge = new Properties();
        propertiesToMerge.put("hello.there", "General");
        propertiesToMerge.put("hello.there2", "General");

        Properties expected = new Properties();
        expected.put("hello.there", "General Kenobi");
        expected.put("hello.there2", "General");

        Properties props = JavaEnvProperties.envToProperties(envs, true, "JAVA_ENVS_", propertiesToMerge);

        assertEquals(expected, props);
    }

}
