# Gen building scripts

## *gradlew*

```bash
$ gradle wrapper --gradle-version 4.9 --distribution-type bin
```

## *build.gradle*

```bash
$ ./gradlew init --type scala-library
```

# UT

By default, the UT of this repo bases on *JUnit* and *scalatest*.

And you can find the sample code "LibrarySuite.scala" under "test/scala"

But I think **specs2** is more fashion, and the sample code is here "LibrarySpecs2Suite"

We have to add some dependency for enabling **specs2**.

>     // https://mvnrepository.com/artifact/org.specs2/specs2-core
>     testCompile group: 'org.specs2', name: 'specs2-core_2.11', version: '4.3.3'

# References

(1) [Code, exercises, answers, and hints to go along with the book "Functional Programming in Scala" on GitHub](https://github.com/fpinscala/fpinscala)

(2) [Building Scala Libraries (Guides of Gradle)](https://guides.gradle.org/building-scala-libraries/)
