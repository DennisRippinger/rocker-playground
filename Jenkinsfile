#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'Maven 3.5.0'
    }

    stages {

        stage('checkout') {
            steps {
                checkout scm
                }
        }

        stage('check java') {
            steps {
                sh "java -version"
                }
        }

        stage('clean') {
            steps {
                sh "mvn clean"
                }
        }

        stage('tests') {
            steps {
                    sh "mvn test -Dmaven.test.failure.ignore=true"
                }
                post {
                    success{
                        junit '**/target/surefire-reports/TEST-*.xml'
                    }
                }
            }


        stage('packaging') {
            steps {
                sh "mvn package -DskipTests"
                archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
            }
        }
    }
}
