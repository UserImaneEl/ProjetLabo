# Étape 1 : Construction de l'application
FROM node:18 AS builder

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

RUN npm run build --prod

# Utilisation de http-server pour servir directement les fichiers construits
FROM node:18

WORKDIR /app

COPY --from=builder /app/dist/project-labo-front /app

RUN npm install -g http-server

EXPOSE 4200

CMD ["http-server", "-p", "4200", "."]
