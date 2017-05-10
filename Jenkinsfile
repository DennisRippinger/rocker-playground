#!/usr/bin/env groovy

node {

    tools {
        maven 'Maven 3.5.0'
    }

    stage('checkout') {
        checkout scm
    }

    stage('check java') {
        sh "java -version"
    }

    stage('clean') {
        sh "mvn clean"
    }

    stage('tests') {
        try {
            sh "mvn test"
        } catch(err) {
            throw err
        } finally {
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }

    stage('packaging') {
        sh "./mvnw package -DskipTests"
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }

}