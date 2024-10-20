# Étape 1 : Utiliser une image de base Node.js
FROM node:18 as build

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers package.json et package-lock.json
COPY package*.json ./

# Installer les dépendances
RUN npm install

# Copier le reste de l'application
COPY . .

# Construire l'application
RUN npm run build

# Étape 2 : Utiliser le serveur de développement
# Exposer le port
EXPOSE 3000

# Démarrer le serveur de développement
CMD ["npm", "start"]
