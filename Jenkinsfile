pipeline {
    agent any
    tools {
        maven '3.9.8'
    }
    
    environment {
        DOCKER_IMAGE = 'arjuncdockerhub/springboot_app'  // Docker Hub repository name
        WORKSPACE = '/var/lib/jenkins/workspace/SpringBoot-CICD/'
    }

    stages {
        stage('1. Code Checkout and Build') {
            steps {
                echo "Checking out code and building Maven project"
                git url: "https://github.com/jackmalhotra/SpringDemo.git", branch: "master"
                sh "mvn clean install"
            }
        }
        
        stage('2. Build Docker Image') {
            steps {
                echo "Building Docker image"
                dir("${WORKSPACE}") {
                    sh "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }
        
        stage('3.Docker Login'){
            steps{
                withCredentials([usernamePassword(credentialsId: 'docker-cred', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh "docker logout"
                    sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"
                }
            }
        }
        
        stage('4. Push to Docker Hub') {
            steps {
                echo 'Pushing Docker image to Docker Hub...'
                script {
                    sh "docker push ${DOCKER_IMAGE}"
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded! Docker image pushed to Docker Hub.'
        }
        failure {
            echo 'Pipeline failed. Deployment unsuccessful.'
        }
    }
}
