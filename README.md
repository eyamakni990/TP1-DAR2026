## COMPTE RENDU DU TP N°1 :  Les sockets en mode connecté TCP

**Établissement :** Faculté des Sciences de Sfax  
**Département :** Informatique et des Communications  
**Formation :** LSI 3  
**Matière :** Développement d’applications réparties  
**Année universitaire :** 2026–2027  

**Responsable du cours :** Amal ABID  
**Encadrante du TP :** Zeineb DAOUD  

**Réalisé par :** Eya Makni
---

# Introduction

Les applications réparties permettent à plusieurs programmes de communiquer et d’échanger des données à travers un réseau. En Java, les sockets constituent un mécanisme permettant d’établir une communication entre deux applications.

Ce TP a pour objectif de découvrir les sockets en mode connecté TCP, en réalisant une communication entre un client et un serveur. Nous allons ensuite développer un service de calcul permettant au serveur de recevoir un entier, de calculer son produit par cinq et de renvoyer le résultat au client.

Enfin, nous allons améliorer cette application afin de permettre plusieurs échanges successifs et de réaliser des opérations arithmétiques.

# Activité 1-1 : Première connexion client/serveur TCP

## 1. Objectif

L’objectif de cette activité est d’établir une première connexion TCP entre un client et un serveur à l’aide des classes `Socket` et `ServerSocket` de Java.

## 2. Principe de fonctionnement

Le serveur crée un objet `ServerSocket` associé au port 1234, puis attend la connexion d’un client grâce à la méthode `accept()`.

Le client utilise la classe `Socket` pour se connecter au serveur. Une fois la connexion établie, les deux applications peuvent communiquer à travers la socket.

## 3. Étapes de réalisation

1. Créer un projet Java.
2. Créer une classe `Server` dans le package `serverPackage`.
3. Créer une classe `Client` dans le package `clientPackage`.
4. Exécuter le serveur en premier.
5. Exécuter ensuite le client.
6. Vérifier les messages affichés dans la console.

## 4. Résultat attendu

Du côté serveur, un message indique que le serveur attend une connexion. Lorsque le client se connecte, un autre message confirme la connexion.
<img width="945" height="147" alt="image" src="https://github.com/user-attachments/assets/0a3adfa5-d404-4680-803f-e0d35b7687f4" />

Du côté client, un message indique que la connexion avec le serveur est établie.
<img width="945" height="214" alt="image" src="https://github.com/user-attachments/assets/b4fd57d6-5804-4b3c-8f1d-3639dabfd56b" />


** cette activité permet de comprendre le principe de connexion TCP. Le serveur doit être lancé avant le client afin que celui-ci puisse se connecter au port d’écoute.


# Activité 1-2 : Réalisation d’un service de calculatrice

## 1. Objectif

Cette activité consiste à développer une application client/serveur dans laquelle le client envoie un entier au serveur. Le serveur multiplie cet entier par cinq et renvoie le résultat au client.

## 2. Principe de fonctionnement

La communication utilise les flux `DataInputStream` et `DataOutputStream`, qui permettent d’échanger des données de type primitif, notamment des entiers.

Le client envoie un entier à l’aide de la méthode `writeInt()`. Le serveur le récupère avec `readInt()`, effectue le calcul, puis transmet le résultat au client.


## 3. Test de l’application

x=5
<img width="738" height="550" alt="image" src="https://github.com/user-attachments/assets/a85fc5f0-05b6-485f-bc31-2b334ec6ecb9" />
x=-5
<img width="698" height="559" alt="image" src="https://github.com/user-attachments/assets/73ee24a4-e7c8-4551-8f31-076b90563a00" />
x=0
<img width="625" height="572" alt="image" src="https://github.com/user-attachments/assets/069ae452-120c-444f-a3d8-a4be75091fdc" />



## 4. Interprétation :
** cette activité montre comment échanger un entier entre deux applications grâce aux flux de données TCP.

## 5. Amélioration : échanges successifs

L’application est ensuite modifiée pour permettre au client de saisir plusieurs entiers successivement. Après chaque saisie, le client envoie l’entier au serveur et reçoit le résultat de la multiplication par cinq.

Le traitement continue tant que l’entier saisi est différent de zéro. Lorsque le client saisit `0`, il envoie cette valeur au serveur afin de mettre fin à la communication.

Le serveur utilise une boucle `while` pour recevoir les entiers successifs. Si l’entier reçu est égal à zéro, il quitte la boucle. Sinon, il calcule le résultat et le renvoie au client.

Cette amélioration permet de réaliser plusieurs opérations au cours d’une même connexion TCP.

<img width="691" height="825" alt="image" src="https://github.com/user-attachments/assets/2c4cb53a-12c4-411b-ad1e-27346f7d6436" />


