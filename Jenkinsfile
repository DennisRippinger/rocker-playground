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
                try {
                    sh "mvn test"
                } catch(err) {
                    throw err
                } finally {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('packaging') {
            steps {
                sh "./mvnw package -DskipTests"
                archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
            }
        }

    }
}