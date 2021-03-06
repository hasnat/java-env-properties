# java-env-properties

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.hasnat/java-env-properties/badge.svg)](https://mvnrepository.com/artifact/com.github.hasnat/java-env-properties)

Add environment variables to java properties.

---
Merges environment variables to java properties object

### Maven

```xml
<dependency>
    <groupId>com.github.hasnat</groupId>
    <artifactId>java-env-properties</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```groovy
compile 'com.github.hasnat:java-env-properties:1.0.0'
```

### Usage
```java
// Function Definition
// Properties envToProperties(Map<String, String> envVars, boolean lowerCaseKeys, String envPrefix, Properties mergeToProperties)

Properties props = JavaEnvProperties.envToProperties(
    System.getenv(),
    true,
    "JAVA_ENVS_",
    System.getProperties()
);

// Envs
// JAVA_ENVS_HELLO_THERE=General Kenobi
// Output (Properties)
// hello.there=General Kenobi
```
