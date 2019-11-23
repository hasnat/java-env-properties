package com.github.hasnat;

import java.util.Properties;
import java.util.Map;

public class JavaEnvProperties {

    public static Properties envToProperties(Map<String, String> envVars, boolean lowerCaseKeys, String envPrefix, Properties mergeToProperties) {

        if (mergeToProperties == null) {
            mergeToProperties = new Properties();
        }
        if (envVars == null) {
            return mergeToProperties;
        }
        String blank = "";
        if (envPrefix == null) {
            envPrefix = blank;
        }

        String propertyKey = null;
        String envKey = null;
        for (final Map.Entry<String, String> envVar : envVars.entrySet()) {
            envKey = envVar.getKey();
            if (envKey.startsWith(envPrefix)) {
                propertyKey = envKey.replaceFirst(envPrefix, blank).replaceAll("_", ".");
                if (lowerCaseKeys) {
                    propertyKey = propertyKey.toLowerCase();
                }
                mergeToProperties.put(propertyKey, envVar.getValue());
            }
        }

        return mergeToProperties;
    }
}
