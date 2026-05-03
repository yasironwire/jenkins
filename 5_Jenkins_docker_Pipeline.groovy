// First we need to create "credentials" in Jenkins with Credentials ID: dockerhubcredentials, DockerHub User and Password (personal access token_PAT)


pipeline {
    agent any 

    environment {     
        DOCKERHUB_CREDS = credentials('dockerhubcredentials')
    }   

    stages {

        stage("Clone Code") {
            steps {
                echo "Cloning the code"
                git url: "https://github.com/yasironwire/jenkins_labs.git", branch: "main"
            }
        }

        stage("Build") {
            steps {
                echo "Building the image"
                sh "docker build -t yasirdocker/ow-app:${BUILD_NUMBER} ."
            }
        }

        stage('Login to Docker Hub') {         
            steps {                            
                sh '''
                set -e
                echo $DOCKERHUB_CREDS_PSW | docker login -u $DOCKERHUB_CREDS_USR --password-stdin
                '''
                echo 'Login Completed'                
            }
        }    

        stage("Push to Docker Hub") {
            steps {
                echo "Pushing the image to Docker Hub"
                sh "docker push yasirdocker/ow-app:${BUILD_NUMBER}"
            }
        }

        stage("Deploy") {
            steps {
                echo "Deploying the container"
                sh "docker container ls"
                sh "docker run -d yasirdocker/ow-app:${BUILD_NUMBER}"
            }
        }
    }
}