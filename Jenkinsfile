pipeline {
    agent any
    stages {

    stage('Stage#1: Maven version') {
                        steps {
                            script {
                                bat './mvnw.cmd -version'
                            }
                        }
                    }

    stage('Stage#2: clean install') {
                            steps {
                                script {
                                    bat './mvnw.cmd clean install'
                                }
                            }
                        }

    stage('Stage#3: package') {
                                steps {
                                    script {
                                        bat './mvnw.cmd package'
                                    }
                                }
                            }

    stage('Stage#4: capture') {
                                steps {
                                    archiveArtifacts '**/target/*.jar'
                                    jacoco()
                                    junit '**/target/surefire-reports/TEST*.xml'
                                }
                            }

    stage('Stage#5: Build Docker Image') {
                                steps {
                                     script {
                                          // build based on Dockerfile with using io.fabric
                                          bat './mvnw.cmd clean package docker:build'
//                                           bat './mvnw.cmd clean package docker:build docker:push'
//                                           bat 'docker build -t vladbogdadocker/phrases:%BUILD_NUMBER% .'
                                     }
                                }
                            }

        /* stage('Stage#7: Push Docker Image to Docker Hub') {
             steps {
                  script {

                       // Push the latest image
                       bat 'docker push vladbogdadocker/phrases:%BUILD_NUMBER%'
                  }
             }
        } */

        /* stage('Stage#8: Push Image to Docker Hub as latest') {
             steps {
                 script {
                       bat 'docker tag vladbogdadocker/phrases:%BUILD_NUMBER% vladbogdadocker/phrases:latest'
                  }
                 script {
                       bat 'docker push vladbogdadocker/phrases:latest'
                  }
             }
        } */

    }





}

