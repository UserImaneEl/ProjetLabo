# Étape 1 : Utiliser une image de base Node.js pour construire l'application Angular
FROM node:18 as build

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers package.json et package-lock.json
COPY package*.json ./

# Installer les dépendances
RUN npm install

# Copier le reste de l'application
COPY . .

# Construire l'application pour la production
RUN npm run build --prod

# Étape 2 : Utiliser une image Nginx pour servir l'application Angular
FROM nginx:alpine

# Copier les fichiers de build dans le répertoire par défaut de Nginx
COPY --from=build /app/dist/project-labo-front /usr/share/nginx/html

# Exposer le port 80 pour servir l'application
EXPOSE 4200

# Démarrer Nginx (aucun CMD n'est nécessaire car Nginx démarre automatiquement)
