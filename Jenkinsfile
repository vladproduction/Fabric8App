pipeline {
    agent any
    stages {
        stage('Stage#1: Checkout') {
            steps {
                script {
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: '*/main']],
                        userRemoteConfigs: [[url: 'https://github.com/vladproduction/Fabric8App']]
                    ])
                }
            }
        }
        stage('Stage#2: Build Docker Image') {
            steps {
                script {
                    // Building Docker image using Fabric8 with Maven
                    bat "./mvnw.cmd clean package docker:build -Ddocker.tag=${env.BUILD_NUMBER} -DskipTests"
                }
            }
        }
        stage('Stage#3: Push Docker Image to Docker Hub') {
            steps {
                script {
                    // Pushing Docker image to Docker Hub using Fabric8 with Maven
                    bat "./mvnw.cmd docker:push -Ddocker.tag=${env.BUILD_NUMBER} -DskipTests"
                }
            }
        }
    }
}

