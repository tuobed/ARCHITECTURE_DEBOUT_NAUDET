# ARCHITECTURE_DEBOUT_NAUDET

Projet réalisé par :

Debout Guillaume TCSI2 4A ESIEA 

Naudet Olivier TCSE2 4A ESIEA 


Comment compiler et lancer le projet ?


Tout d'abord, vous devez télécharger le code source du projet en cliquant sur le bouton "Clone or download" > "Download zip". Après avoir lancé l'extration du ".zip", on ouvre un nouveau terminal. Pour compiler et lancer ce projet, vous devez avoir au minimum Java 8 sur votre machine (+ javac). Il vous faudra aussi avoir Maven.

Placez-vous dans le dossier principal (l'endroit ou se trouve le "pom.xml"), et lancez :

'mvn -q compile' pour compiler le programme (le -q permet de rendre Maven un peu moins bavard).
'mvn -q test' pour lancer l'ensemble des tests unitaires
'mvn -q exec:java' pour exécuter le programme.
'mvn -q jxr:jxr && mvn -q pmd:check || xdg-open ./target/site/pmd.html'
 
 
Explication sur l'architecture utilisée
 
Nous avons utilisé 'Maven' pour la gestion du projet. Nous travaillons avec un seul package, fr.esiea.unique.debout.naudet, et l'ensemble du projet est découpé en 11 différentes classes.

"Lettre" : Permets la contruction de l'objet "Lettre", la création du tableau contenant les lettres, de l'attribution d'une lettre au hasard et de la comparaison entre deux lettres.

"ChoixJoueur" : Cette classe permets d'aérer mon code et demande au joueur si il veut passer son tour ou entrer un mot.

"DebutDuJeu" : Cette classe permets le lancement du début du jeu. (choisir qui commence, simuler le premier tour).

"Fichier" : Construit l'objet Fichier. Cette classe va également permettre de vérifier dans le dictionnaire si un mot existe ou non.

"Game" : Cette classe est la plus importante, elle va traiter toutes les fonctions liées au potCommun. Elle va également lancer toute la structure du jeu dans la fonction Main().

"Main" : Classe principale qui lance mon jeu et demande le mode auquel le joueur veut jouer.

"IntelligenceArtificielle" : Cette classe va traiter la partie autonome de mon programme. Celle de l'IA. Le fonctionnement de l'IA est le suivant: L'IA va tester chaque mot du dictionnaire. Si le mot respect les conditions (toutes les lettres dans le pot commun) alors l'IA prend ce mot. Nous avons rajouté 50% de chance que l'IA passe son tour.

"Mots" : Cette classe va traiter la partie "vole de mot".

"Piocher2Lettre" : Cette classe permets également d'aérer mon code et demande simplement au joueur de piocher deux lettres.

"Player" : Cette classe va créer l'objet Player.

"SaisirEtVerifierMot" : Cette classe est très importante, elle va demander au joueur de saisir un mot. Elle évaluera également si le mot est correct (les lettres dans le pot commun, le mot dans le dictionnaire ...) ou alors si la chaine de caratère du mot contient un des mots appartenant au tableau "motsCommuns" c.a.d si la ou les mots trouvés sont contenu.

Un package test est également disponible et permets la réalisation de tests unitaires via JUnit.
Pour le code coverage, nous avons installer le plugin EclEmma.
 
  
 
Exercice sur les principes SOLID/Design Patterns
 
Nous pouvons illustrer 2 Disgn Patterns dans notre projet. 
Le Premier est le Singleton. En effet le letterTab est instancié une seule fois dans notre programme. Il a été déclaré en private et seule la classe Lettre peut l'utiliser. Aucune autre classe n'utilise le tableau de lettre. On garantie donc son unicité.
 
Le second le factory. Nous avons instancier plusieurs fois les lettres appartenant à la classe Lettre. Ceci nous à par exemple permis notamment d'éviter des références entre le potCommun et le potCommunTemp. En effet à chaque itération pour remplir le potCommunTemp nous instancions une nouvelle Lettre avec comme paramètre les valeurs de potCommun. potCommunTemp nous permets de vérifier si toutes les lettres d'un mot sont bien dans le potCommun. 
 
Nous avons également essayé de respecter les principes SOLID. Cependant ayant déjà fait le code il était compliqué de revenir en arrière. Nous avons donc essayer de respecter le fait que chaque méthodes doivent avoir une seule responsabilité. Par exemple la méthode compareLetter de la classe Letter permets uniquement de comparer deux lettres. 
 
 
 
Utilisation de PMD

Nous avons installé le plugin sous Eclipse. Nous pouvons donc faire une analyse statique du code via Eclipse en faisant un clique droit sur le projet -> PMD -> Analyser le code. Je n'ai malheureusement pas réussit à faire marcher l'analyse statique du code en ligne de commande. 






















