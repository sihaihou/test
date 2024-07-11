pipeline {
    environment {
        registryCredential = 'dockerhub_id'
        dockerImage = ''
    }
    agent any
    stages {
        stage('拉取代码: Checkout Code') {
            steps {
               checkout scmGit(branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: '2893c330-9a16-498f-afd6-d66d37e5f806', url: 'https://github.com/sihaihou/testActions.git']])
            }
        }
        stage('构建子项目: build Sub Project') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('制作Docker镜像：Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build "housihai/testActions:0.0.1"
                }
            }
        }
    }
}
