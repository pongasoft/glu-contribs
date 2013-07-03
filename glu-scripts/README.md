Introduction
============
This project contains a set of glu scripts that have been contributed by the community. It also
serves as an example on how to write and test glu scripts. Checkout the
[glu project](https://github.com/pongasoft/glu) for more details about glu.

How to write and test a glu script
----------------------------------
First, you should check the documentation which gives some information about 
[glu scripts](http://pongasoft.github.io/glu/docs/latest/html/glu-script.html).

Next, you should check the sample glu script checked in with this project which demonstrates
how to use some basic features as well as how to write a unit test for your glu script. The javadoc
is fairly extensive and should allow you to bootstrap pretty quickly.

You may also want to check a real-life glu script for more details about advanced features by
checking the [jetty glu script](https://github.com/pongasoft/glu/blob/master/scripts/org.linkedin.glu.script-jetty/src/main/groovy/JettyGluScript.groovy)
as well as its [unit test](https://github.com/pongasoft/glu/blob/master/scripts/org.linkedin.glu.script-jetty/src/test/groovy/test/script/jetty/TestJettyGluScript.groovy).

Forking this project
--------------------
You can simply fork this project and add a new project under `scripts`. You can then run:

    ./gradlew clean test release

to run the tests and generate the jar file. You can also run:

    ./gradlew glu-script-uri -PbaseUrl=http://acme.com/repository

which will generate the uri needed in the glu model for deploying your script.


Embedding in your build lifecycle
---------------------------------
If you want to embed glu scripts in your own build lifecycle, the critical piece is the dependencies 
section in the `scripts/build.gradle` file:

    configurations {
      provided
    }

    sourceSets {
      main { compileClasspath += configurations.provided }
    }

    idea {
      module {
        scopes.PROVIDED.plus += configurations.provided
      }
    }

    dependencies {
      provided spec.external.utilsMiscGroovy
      provided spec.external.gluAgentAPI
      compile spec.external.groovy

      testCompile spec.external.gluScriptsTestFwk
      testCompile spec.external.junit
    }

which looks like this expanded (`spec.external` refers to the map defined in `project-spect.groovy`):

    dependencies {
      provided "org.pongasoft:org.linkedin.util-groovy:2.0.0"
      provided "org.pongasoft:org.linkedin.glu.agent-api:5.0.0"
      compile  "org.codehaus.groovy:groovy-all:2.0.7"

      testCompile "org.pongasoft:org.linkedin.glu.scripts-test-fwk:5.0.0"
      testCompile "junit:junit:4.10"
    }

Build configuration
===================
The project uses the [`org.linkedin.userConfig`](https://github.com/pongasoft/gradle-plugins/blob/master/README.md#3-plugins) plugin and as such can be configured

    Example:
    ~/.userConfig.properties
    top.build.dir="/Volumes/Disk2/deployment/${userConfig.project.name}"
    top.install.dir="/export/content/${userConfig.project.name}"
    top.release.dir="/export/content/repositories/release"
    top.publish.dir="/export/content/repositories/publish"