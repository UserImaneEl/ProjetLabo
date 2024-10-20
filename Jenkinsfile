pipeline {
    agent any

    stages {

        // Étape pour récupérer le code source depuis le dépôt Git
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/UserImaneEl/ProjetLabo.git'
            }
        }

        // Compilation et tests du Back-end (Spring Boot avec Maven)
        stage('Build & Test Backend') {
            steps {
                dir('ProjetLaboBack') { // Se déplacer dans le répertoire backend
                    bat 'mvn clean install' // Compiler et tester le back-end
                }
            }
        }

        // Compilation et tests du Front-end (Angular ou React avec npm/yarn)
        stage('Build & Test Frontend') {
            steps {
                dir('projet-labo-front') { // Se déplacer dans le répertoire frontend
                    bat 'npm install'  // Installer les dépendances front-end
                    bat 'npm run build' // Compiler le front-end
                    // Si vous avez des tests, ajoutez la ligne ci-dessous
                    // bat 'npm run test' // Lancer les tests du front-end
                }
            }
        }

        // Déploiement des deux applications (backend et frontend) avec Docker Compose
        stage('Deploy with Docker Compose') {
            steps {
                bat 'docker-compose -f docker-compose.yml up --build -d' // Lancer Docker Compose
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

/*pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/UserImaneEl/ProjetLabo.git'
            }
        }


        stage('Build') {
            steps {
                bat 'mvn clean install' // Changer sh par bat
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package' // Changer sh par bat
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t mon-app-springboot:latest .' // Changer sh par bat
            }
        }

        stage('Deploy Docker Container') {
            steps {
                bat 'docker run -d --name springboot-app -p 8080:8080 mon-app-springboot:latest' // Changer sh par bat
            }
        }
    }

    post {
        success {
            echo 'Le build et le déploiement ont réussi !'
        }
        failure {
            echo 'Échec du build ou du déploiement.'
        }
    }
}
*/