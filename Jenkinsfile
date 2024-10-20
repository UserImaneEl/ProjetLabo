pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/UserImaneEl/ProjetLabo.git'
            }
        }


        stage('Build & Test Backend') {
            steps {
                dir('./ProjetLaboBack') {
                    bat 'mvn clean install'
                }
            }
        }

        stage('Build & Test Frontend') {
                  steps {
                      dir('./project-labo-front') {
                          bat 'npm install'
                          bat 'npm run build'
                      }
                  }
              }


        stage('Deploy with Docker Compose') {
            steps {
                bat 'docker-compose -f docker-compose.yml up --build -d'
            }
        }
    }

    post {
        success {
            echo 'Le build, les tests et le déploiement ont réussi !'
        }
        failure {
            echo 'Échec du build, des tests ou du déploiement.'
        }
    }
}
