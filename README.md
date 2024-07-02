Bienvenue dans la documentation de l'application e-bank Backend développée par talfana. Cette application vise à fournir une plateforme sécurisée et intuitive permettant aux utilisateurs de gérer leurs comptes bancaires et d'effectuer des opérations financières en ligne.

User Stories
Gestion des comptes
Création de comptes bancaires
En tant qu'utilisateur, je peux créer un nouveau compte bancaire avec un type de compte spécifique, un solde initial et une date de création.

Consultation des soldes et historiques de transactions
En tant qu'utilisateur, je peux consulter le solde actuel de mes comptes ainsi que l'historique détaillé de toutes les transactions effectuées.

Fermeture de comptes
En tant qu'utilisateur, je peux fermer un compte bancaire en spécifiant la raison de la fermeture.

Gestion des cartes bancaires
Consultation des informations de la carte
En tant qu'utilisateur, je peux consulter les détails de ma carte bancaire, y compris le numéro et la date d'expiration.

Activation et désactivation de la carte
En tant qu'utilisateur, je peux activer ou désactiver ma carte bancaire pour sécuriser mes transactions.

Blocage en cas de perte ou de vol
En tant qu'utilisateur, je peux bloquer ma carte bancaire en cas de perte ou de vol en spécifiant la raison du blocage.

Transferts d'argent
Transferts internes
En tant qu'utilisateur, je peux transférer de l'argent entre mes comptes bancaires personnels.

Transferts externes
En tant qu'utilisateur, je peux transférer de l'argent vers des comptes externes en spécifiant les détails du compte destinataire.

Gestion des bénéficiaires
En tant qu'utilisateur, je peux gérer ma liste de bénéficiaires pour faciliter les transferts externes.

Exigences techniques
Structuration du projet
Ce projet est structuré selon les bonnes pratiques recommandées pour une application Spring Boot. Il utilise une architecture MVC (Modèle-Vue-Contrôleur) pour assurer la séparation des préoccupations et la maintenabilité du code.

Documentation du Code
Chaque classe et méthode est documentée pour expliquer sa responsabilité, les paramètres attendus, et les valeurs de retour. Les commentaires sont utilisés pour clarifier la logique métier et les points complexes.

Logique métier des opérations bancaires
Validation des données
Les opérations comme la création de compte et la fermeture de compte sont validées pour s'assurer que les données sont complètes et cohérentes.

Gestion des exceptions
Des mécanismes de gestion des exceptions sont mis en place pour gérer les situations illégales telles que les tentatives de transaction à partir d'un compte fermé.

Validation des montants
Avant chaque transfert d'argent, une validation est effectuée pour s'assurer que le montant est positif et que le solde du compte source est suffisant.
