pipeline {
    agent any

    environment {
        PROJECT_NAME = "MyApp"
        VERSION = "1.0"
    }

    stages {
        stage('Print Variables') {
            steps {
                echo "Project: ${env.PROJECT_NAME}"
                echo "Version: ${env.VERSION}"
            }
        }

        stage('Local Variable Example') {
            steps {
                script {
                    def buildNumber = 1
                    echo "Build Number: ${buildNumber}"
                }
            }
        }

        stage('Use Variables in Shell') {
            steps {
                sh '''
                echo "Project is $PROJECT_NAME"
                echo "Version is $VERSION"
                '''
            }
        }
    }
}