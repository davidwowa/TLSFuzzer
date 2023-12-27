#!/bin/bash

~/java_env/maven/bin/mvn clean install  
~/java_env/maven/bin/mvn org.cyclonedx:cyclonedx-maven-plugin:makeAggregateBom  
~/java_env/maven/bin/mvn package