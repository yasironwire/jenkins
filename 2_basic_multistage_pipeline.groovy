Create a declarative pipeline

## Pipeline formats
Jenkins support two pipeline formats: Scripted and declarative.

For the rest of this course, we’ll be using the declarative format.

Declarative pipelines start with the word pipeline followed by curly braces and instructions for Jenkins.

## Required sections in the pipeline configuration
A pipeline configuration has three required sections.

- `agent`
- `stages`
- at least one `stage` and at least one `step`

## A multi-stage pipeline
Create a pipeline job and paste in the following code to create a multi-stage pipeline.

Run the job and examine the output.
##################
```Jenkinsfile
##################

pipeline {
    agent any   // Run on any available agent

    stages {
        stage('Hello') {
            steps {
                echo 'Hello, Jenkins!'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
            }
        }
    }
}