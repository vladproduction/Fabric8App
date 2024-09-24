pipeline {
    agent any
    stages {
        stage('Stage#1: Maven version') {
            steps {
                script {
                    bat "./mvnw --version"
                }
            }
        }
        stage('Stage#2: clean package') {
                    steps {
                        script {
                            bat './mvnw.cmd clean package'
                        }
                    }
                }
        stage('Stage#3: Capture') {
            steps {
                archiveArtifacts '**/target/*.jar'
                jacoco()
                junit '**/target/surefire-reports/TEST*.xml'
            }
        }
        stage('Stage#4: Build Docker Image') {
            steps {
                script {
                    // Building Docker image using Fabric8 with Maven
                    bat "./mvnw.cmd docker:build -Ddocker.tag=${env.BUILD_NUMBER} -DskipTests"
                }
            }
        }
        stage('Stage#5: Push Docker Image to Docker Hub') {
            steps {
                script {
                    // Pushing Docker image to Docker Hub using Fabric8 with Maven
                    bat "./mvnw.cmd docker:push -Ddocker.tag=${env.BUILD_NUMBER} -DskipTests"
                }
            }
        }
    }
}

