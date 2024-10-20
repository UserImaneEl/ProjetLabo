# Utilise une image de base Node.js
FROM node:20.11.1 as build

# Définit le répertoire de travail
WORKDIR /app

# Copie les fichiers de package et installe les dépendances
COPY package*.json ./
RUN npm install

# Copie le reste des fichiers de l'application
COPY . .

# Construire l'application
RUN npm run build

# Utilise une image Nginx pour servir l'application
FROM nginx:alpine

# Copie les fichiers de build vers le répertoire de Nginx
COPY --from=build /app/build /usr/share/nginx/html

# Expose le port de Nginx
EXPOSE 80

# Commande pour démarrer Nginx
CMD ["nginx", "-g", "daemon off;"]
