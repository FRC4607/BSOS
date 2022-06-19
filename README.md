# BSOS  - Becker Summer of Swerve

## Workflow
How do we want to manage our Github workflow? 


## Coding conventions

### Using the Google Java Style Guide in Visual Studio Code

The purpose of implementing a process to use a style guide is to make the code-base easier to read. Without it, this can become an issue when several people are actively participating in a shared environment. Follow the steps below to setup automated formatting and live linting based on the style guide from Google.

1. Copy *eclipse-java-google-style.xml* to the project's root from https://github.com/google/styleguide/blob/gh-pages/eclipse-java-google-style.xml
2. Install, verify installation, *Extension Pack for Java*
3. Install, verify installation, *Checkstyle for Java*
4. Update *settings.json* with the following:
    - Instruct the formatter to use the Google style guide by adding *"java.format.settings.url": "eclipse-java-google-style.xml"*
    - Enable format on save by adding *"editor.formatOnSave": true*
    - Instruct Checkstyle us use the Google stye guide by adding *"java.checkstyle.configuration": "/google_checks.xml"* 
5. If desired, run the *Java: Open Java Formatter Settings with Preview* command to change a select few settings
6. If desired, further modify settings in *eclipse-java-google-style.xml*

For further information, see https://code.visualstudio.com/docs/java/java-linting and https://google.github.io/styleguide/javaguide.html


## Unit testing
rules
