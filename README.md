# BSOS  - Becker Summer of Swerve

## Workflow
How do we want to manage our Github workflow? 


## Coding conventions

### Using the Google Java Style Guide in Visual Studio Code

The purpose of implementing a process to use a style guide is to make the codebase easier to read. Without it, this can become an issue when several people are actively participating in a shared code-base. Follow the steps below to setup automated formatting based on the style guide from Google.

1. Copy *eclipse-java-google-style.xml* to the project's root from https://github.com/google/styleguide/blob/gh-pages/eclipse-java-google-style.xml
2. Instruct the formatter to use this file by adding *"java.format.settings.url": "eclipse-java-google-style.xml"* to *settings.json*
3. Install, verify installation, *Extension Pack for Java*
4. If desired, run the *Java: Open Java Formatter Settings with Preview* command to change a select few settings
5. If desired, modify further settings in *eclipse-java-google-style.xml*
6. Enable format on save by adding *"editor.formatOnSave": true* to *settings.json*

For further information, see https://code.visualstudio.com/docs/java/java-linting and https://google.github.io/styleguide/javaguide.html


## Unit testing
rules
