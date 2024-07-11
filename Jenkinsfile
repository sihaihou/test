pipeline {
    environment {
        dockerImage = 'housihai/testActions:0.0.1'
        dockerHubCredential = '54925b2c-d4e5-4a09-a7b2-a180656174b5'
    }
    agent any
    stages {
        stage('拉取代码: Checkout Code') {
            steps {
               checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '2893c330-9a16-498f-afd6-d66d37e5f806', url: 'https://github.com/sihaihou/testActions.git']])
            }
        }
        stage('打包构建项目: Build Package Project') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('制作Docker镜像：Build Docker Image') {
            steps {
                script {
                    docker.build dockerImage
                }
            }
        }
        stage('发布镜像: Deploy Image') {
            steps {
                script {
                    docker.withRegistry( '', dockerHubCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('清除本地镜像：Cleaning up') { 
            steps { 
                sh "docker rmi $dockerImage
            }
        }
    }
}
