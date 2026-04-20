# LA Enforcer – Score Server

## Présentation

Ce serveur développé avec Spring Boot fournit une API REST permettant de stocker, gérer et exposer les scores du jeu rétro DOS *LA Enforcer*.

## Fonctionnalités

- Réception des scores via requêtes HTTP POST
- Récupération des scores via endpoint GET
- Stockage des scores dans une base PostgreSQL hébergée sur Supabase
- Accès aux données via Spring Data JPA
- Endpoint `/health` pour vérifier l’état du serveur (utile pour les environnements avec mise en veille)

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

### GET /health

Retourne un statut HTTP 200 avec le corps "OK" si le serveur est opérationnel.

## Ecosystème du projet

Ce projet complète un système global comprenant :
- un [jeu en C](https://github.com/julien-correard/LA-enforcer-game) (génération des scores)
- un [client en Go](https://github.com/julien-correard/LA-enforcer-client) (envoi des scores)
- un [serveur Spring Boot](https://github.com/julien-correard/LA-enforcer-server) (stockage des scores)
- une [interface web en JavaScript](https://github.com/julien-correard/LA-enforcer-web) (consultation des scores, disponible [ici](https://julien-correard.github.io/LA-enforcer-web/))

## Auteur

Julien CORREARD

## Licence

Ce projet est sous licence MIT. Voir le fichier LICENSE.
