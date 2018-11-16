# [:] Example Maven Project

An example maven project to demonstrate [srcclr](https://www.srcclr.com) scans.

## Building a fat jar

```
mvn clean package
```

The fat jar will be generated in the `target/` directory. The jar will be generated with the name `*-jar-with-dependencies.jar`.

## Try me!

```
brew tap srcclr/srcclr
brew install srcclr
srcclr activate
srcclr scan --url https://github.com/srcclr/example-java-maven
```

## With SourceClear's Maven Plugin
```
git clone https://github.com/srcclr/example-java-maven
cd example-java-maven
mvn clean compile com.srcclr:srcclr-maven-plugin:scan -DapiToken=<yourSourceClearToken>
```
