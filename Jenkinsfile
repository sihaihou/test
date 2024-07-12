pipeline {
    agent any
    environment{
        harbor_url = '192.168.83.33:80'
        repo_name = 'housihai'
        project_name = 'actions'
        tag = 'latest'
        port = '8080'
    }
    stages {
        stage('拉取代码：Checkout Code') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'aaee6791-9a89-4c67-aef5-00bf0e36ff96', url: 'https://github.com/sihaihou/testActions.git']])
            }
        }
        stage('打包构建项目: Build Package Project') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build and Push Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: '6ec4aacf-9598-4126-821e-970f77e3ad22', passwordVariable: 'password', usernameVariable: 'username')]) {
                    sh 'docker build -t ${repo_name}/${project_name}:${tag} .'
                    sh 'docker tag ${repo_name}/${project_name}:${tag} ${harbor_url}/${repo_name}/${project_name}:${tag}'
                    sh 'docker login -u $username -p $password http://$harbor_url'
                    sh 'docker push $harbor_url/${repo_name}/${project_name}:${tag}'
                    sh 'docker rmi -f ${repo_name}/${project_name}:${tag} $harbor_url/${repo_name}/${project_name}:${tag}'
                 }
            }
        }
        stage('部署服务'){
            steps{
                sshPublisher(publishers: [sshPublisherDesc(configName: 'action-server', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '/usr/local/shell/publish.sh ${harbor_url} ${repo_name} ${project_name} ${tag} ${port}', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
        }
    }
}
