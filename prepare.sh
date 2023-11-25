#!/bin/bash

mvn clean install  
mvn org.cyclonedx:cyclonedx-maven-plugin:makeAggregateBom  
mvn package