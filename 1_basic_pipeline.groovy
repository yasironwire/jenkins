pipeline {
    agent any

    stages {
        stage('create folder') {
            steps {
                sh 'mkdir data'
            }
        }
    }
}
