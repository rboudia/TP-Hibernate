# TP-Hibernate

## Prérequis

Avant de démarrer l'application, assurez-vous d'avoir installé :

- Docker (et qu'il soit en cours d'exécution)
- Un serveur [Apache Tomcat](https://tomcat.apache.org/) version 9 pour déployer l'application

## Cloner le projet

Pour récupérer le projet en local, utilisez la commande suivante :

```sh
git clone https://github.com/rboudia/TP-Hibernate.git
```

Puis, accédez au dossier du projet :

```sh
cd TP-Hibernate
```

## Démarrage de la base de données avec Docker

L'application repose sur une base de données qui doit être lancée via Docker.
Pour ce faire, ouvrez un terminal, placez-vous dans le dossier `docker` du projet et exécutez la commande suivante :

```sh
docker compose up -d
```

Cette commande démarre la base de données en arrière-plan.

Pour arrêter le conteneur de la base de données, utilisez la commande suivante :

```sh
docker compose down
```

## Déployer l'application sur Tomcat

Une fois la base de données en cours d'exécution, vous devez déployer l'application sur un serveur Tomcat.
