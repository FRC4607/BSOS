# BSOS  - Becker Summer of Swerve

## Workflow
How do we want to manage our Github workflow? 


## Coding conventions

### Using the Google Java Style Guide in Visual Studio Code

The purpose of implementing a process to use a style guide is to make the code-base easier to read. Without it, style inconsistency can become an issue when several people are actively participating in a shared workspace. Follow the steps below to setup live linting using *Checkstyle for Java*. We will be using a slighly modified version of the Java style guide from Google.

1. Copy *google_checks.xml* to the project's root from https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml
2. Install *Checkstyle for Java* from VS Code extensions
3. Update *settings.json* by adding the following:

    ```
    "[java]": {
        "editor.tabSize": 4,
        "editor.detectIndentation": false,
        "editor.insertSpaces": true
    },
    "editor.formatOnSave": false,
    "java.checkstyle.configuration": "${workspaceFolder}/google_checks.xml",
    "java.checkstyle.version": "10.3",
    ```
4. Apply 4607-specific settings:

    For member naming *m_lowerCamelCase*, replace

        <module name="MemberName">
            <property name="format" value="^[a-z][a-z0-9][a-zA-Z0-9]*$"/>

    with

        <module name="MemberName">
            <property name="format" value="^m_[a-z][a-z0-9][a-zA-Z0-9]*$"/>


For further information, see the following:

- https://code.visualstudio.com/docs/java/java-linting
- https://checkstyle.sourceforge.io/
- https://google.github.io/styleguide/javaguide.html


## Unit testing
rules
