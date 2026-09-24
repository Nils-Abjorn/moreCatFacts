# moreCatFacts

Petite API de démonstration Spring Boot qui récupère un fait aléatoire sur les chats depuis [catfact.ninja](https://catfact.ninja/).

## Utilisation

Lancer l'application avec Gradle :

```bash
./gradlew bootRun
```

Puis appeler l'endpoint :

```http
GET http://localhost:8080/catfact
```

Le paramètre optionnel `htmlErrResponse=true` permet de demander une réponse d'erreur au format HTML lorsqu'une exception est déclenchée par l'application.
