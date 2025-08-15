@echo off
@rem Gradle start up script for Windows
java -Xmx64m -Xms64m -cp "%~dp0\gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
