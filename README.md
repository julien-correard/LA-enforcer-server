# LA Enforcer – Score Server

## Présentation

Ce serveur fournit une API REST permettant de stocker, gérer et exposer les scores du jeu rétro DOS *LA Enforcer*.

## Fonctionnalités

- Réception des scores via requêtes HTTP POST
- Stockage en base de données (H2)
- Récupération des scores via endpoint GET
- Tri des scores (leaderboard)

## API

### POST /scores

Enregistre un nouveau score.

Exemple de payload :

```json
{
  "score": 420,
  "date": "2026-04-06",
  "playerName": "Julien",
  "gameVersion": "1.0"
}
```

### GET /scores

Retourne la liste des scores triés (score décroissant).

## Détails techniques

Le serveur est développé avec Spring Boot et utilise Spring Data JPA pour la persistance.

Il s’intègre dans un système complet :

jeu en C → génère les scores
client Go → envoie les scores
serveur → stocke et expose les données
frontend web → affiche le classement

## Technologies utilisées

Java
Spring Boot
Spring Data JPA
H2 Database

## Auteur

Julien CORREARD

## Licence

Ce projet est sous licence MIT. Voir le fichier LICENSE.
