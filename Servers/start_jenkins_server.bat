@echo off
set JENKINS_HOME=%CD%\.jenkins
setx JENKINS_HOME %JENKINS_HOME%
start java -jar jenkins.war