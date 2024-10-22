
# Étape 1 : Construction de l'application
FROM node:18 AS builder

# Définit le répertoire de travail
WORKDIR /app

# Copie les fichiers de configuration de package
COPY package*.json ./

# Installe les dépendances
RUN npm install

# Copie tout le reste du code
COPY . .

# Construire l'application pour la production
RUN npm run build --prod

# Étape 2 : Configuration du serveur pour servir les fichiers construits
FROM node:18

# Définit le répertoire de travail
WORKDIR /app

# Copie les fichiers construits depuis l'étape de construction
COPY --from=builder /app/dist/project-labo-front /app

# Installe http-server pour servir les fichiers
RUN npm install -g http-server

# Expose le port 4200
EXPOSE 4200

# Commande pour démarrer le serveur
CMD ["http-server", "-p", "4200", "."]
