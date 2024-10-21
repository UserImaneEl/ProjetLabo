pipeline {
    agent any

    stages {
        // Checkout stage
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/UserImaneEl/ProjetLabo.git'
            }
        }

        // Backend Build & Test stage
        stage('Build & Test Backend') {
            steps {
                dir('./ProjetLaboBack') {
                    bat 'mvn clean install -DskipTests'
                }
            }
        }

        // Frontend Build & Test stage (for Angular)
        stage('Build & Test Frontend') {
            steps {
                dir('./project-labo-front') {
                    // Install npm packages
                    bat 'npm install'
                    // Run Angular build
                    bat 'npm run build --prod'  // Ensure production build
                    // Optional: run tests
                   // bat 'npm run test -- --watch=false'
                    // Optional: linting
                   // bat 'npm run lint'
                }
            }
        }

        // Deploy using Docker Compose
        stage('Deploy with Docker Compose') {
            steps {
                bat 'docker-compose -f docker-compose.yml up --build -d'
            }
        }
    }

    post {
        // If the pipeline succeeds
        success {
            echo 'Le build, les tests et le déploiement ont réussi !'
        }
        // If the pipeline fails
        failure {
            echo 'Échec du build, des tests ou du déploiement.'
        }
    }
}
