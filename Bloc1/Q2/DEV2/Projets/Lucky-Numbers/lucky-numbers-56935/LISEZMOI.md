
# Table des matières

1.  Projet et étudiant
2.  Choix de la variante (étape 4)
    1.  Controller{}
    2.  Game.getFourTiles()
    3.  MyView.askFourTiles(int player, ArrayList<Tile> fourTiles)
    4.  Game.canFourTilesBePut(int player, Position position)
    5.  Board.canFourTilesBePut(position)
    6.  Game.putFourTiles(int player, ArrayList<Tile> fourTiles, Position position)
    7.  View{} and Model{}
3.  Multiple winners and draw (step 3)




# Projet et étudiant

Projet: `Lucky Numbers`

Étudiant: `g56935`



# Choix de la variante (étape 4)

Je ne savais pas si on devait écrire ce fichier en anglais ou en français, donc j'ai fait les deux dans REAMDE.md et LISEZMOI.md.

Pour le commencement du jeu, j'ai choisi de coder la troisième variante: `Version officielle`

Pour pouvoir faire ceci, j'ai du modifier quelques parties de mon programme, et en ajouter d'autres.



## Controller{}

Tout d'abord, j'ai modifié ma classe `Controller` pour ajouter une liste de Tuiles dans le bloc `case NOT_STARTED`.

Ensuite j'ai créé une boucle `for` qui va de 0 jusqu'au nombre de joueurs (2 à 4).

Dans cette boucle `for`, j'ai commencé par ajouter quatre Tuiles aléatoires dans la liste de Tuiles, en utilisant la méthode `Game.getFourTiles()`.

Puis j'ai écrit une boucle `while` qui s'exécutera tant qu'il y aura encore au moins une Tuile dans la liste des quatre Tuiles aléatoires.

Dans cette boucle `while`, j'ai d'abord affiché les plateaux des joueurs en utilisant la méthode `MyView.displayGame()`, ensuite j'ai demandé au joueur actuel (le premier de la boucle `for`) d'entrer la position à laquelle il veut placer la première Tuile de la liste des Tuiles aléatoires (`MyView.askFourTiles()`).

Après cela, je mets la Tuile dans son plateau et je la retire de la liste des Tuiles aléatoires (`Game.putFourTiles()`), et je recommence tout ceci jusqu'à ce qu'il n'y ait plus de Tuiles aléatoires restantes (`while`), et cela se répétera pour chaque joueur (`for`) jusqu'à ce que toutes les Tuiles aléatoires de tous les joueurs soient placées sur les plateaux.

Enfin, le jeu peut commencer.



## Game.getFourTiles()

Cette méthode ne fait que créer quatre Tuiles aléatoires, pour ensuite retourner une liste avec celles-ci.



## MyView.askFourTiles(int player, ArrayList<Tile> fourTiles)

Cette méthode prend en compte deux paramètres:

-   Un entier, le numéro du joueur actuel avec lequel on est en train de travailler (le `i` de la boucle `for`)
-   Une liste de Tuiles, la liste des quatre Tuiles aléatoires que l'on vient de créer

C'est important de savoir quel joueur est concerné, et quelles Tuiles il va pouvoir ajouter sur son plateau.

Cette méthode va d'abord afficher les quatre Tuiles aléatoires du joueur, et lui demander où veut-il placer la première.
On va demander une ligne, mais pas une colonne, car la colonne est égale à la ligne (il doit les placer sur la diagonale). Cette méthode continue de demander jusqu'à ce que le joueur entre une ligne valide (1 à 4), et jusqu'à ce que la place qu'il choisit est libre, car on ne peut pas mettre deux Tuiles au même endroit à ce moment là du jeu. Pour réaliser ceci, j'utilise la méthode `Game.canFourTilesBePut()` que j'ai écrit pour vérifier que l'utilisateur n'a pas choisi une place non valide.



## Game.canFourTilesBePut(int player, Position position)

Cette méthode utilise la méthode `Board.canFourTilesBePut()`.



## Board.canFourTilesBePut(position)

Cette méthode retourne vrai uniquement si la position est libre, à l'intérieur du plateau et dans la diagonale.



## Game.putFourTiles(int player, ArrayList<Tile> fourTiles, Position position)

Maintenant que nous connaissons le joueur, la liste des Tuiles aléatoires et la position (valide) à laquelle le joueur veut placer la Tuile, on peut l'ajouter sur son plateau et la supprimer de la liste des Tuiles aléatoires.

Comme expliqué auparavant, cette méthode va uniquement ajouter la Tuile sur le plateau du joueur à la position choisie, et ensuite supprimer la Tuile de la liste des Tuiles aléatoires.



## View{} and Model{}

J'ai ajouté 1 méthode abstraite à `View` et 3 méthodes abstraites à `Model`, car j'ai estimé qu'elles étaient essentielles au bon fonctionnement du jeu.

`View:`

-   `askFourTiles();`

`Model:`

-   `getFourTiles();`
-   `canFourTilesBePut();`
-   `putFourTiles();`



# Multiple winners and draw (step 3)

J'ai pensé que c'était une bonne idée d'expliquer ici comment fonctionne mon système de multiple gagnants.

Lorsque j'ai voulu écrire ma méthode `getWinner()`, j'ai d'abord pensé retourner une liste de joueurs, ce que je pensais être la meilleur solution.

Ensuite j'ai relu l'énoncé plusieurs fois, et j'ai réalisé qu'il était écrit que la seule solution à faire à la méthode `getWinner()`, était seulement de lui ajouter un "s".

Alors j'ai cherché un moyen d'être capable de connaître les différents gagnants en utilisant uniquement un entier, et j'ai trouvé une solution qui me semble être tout à fait acceptable.

J'ai décidé d'utiliser un procédé similaire à celui utilisé pour gérer les permissions dans les systèmes Linux, basé sur les puissances de deux.

En effet: `Read=4`, `Write=2` et `eXecute=1`. Ceci nous permet de déterminer toutes les permissions d'un fichier en utilisant uniquement un entier décimal. Donc, si on a `rwx`, alors l'entier sera `4+2+1 = 7`, et si on a `r-x` alors ce sera `4+1 = 5`. Ceci nous permet de trouver les valeurs en effectuant des modulos sur le nombre total.

Donc j'ai décidé que `joueur0=1`, `joueur1=2`, `joueur2=4` et `joueur3=8`. Ceci peut être facilement trouvé en effectuant `2^playerNb`.

Alors, si par exemple le nombre de `gagnants=10`, alors on peut retrouver aisément les gagnants grâce à ces étapes:

-   (10%8 < 10)? oui alors joueur3 est un gagnant et (gagnants=gagnants&#x2013;2<sup>3</sup>) = 2
-   (2%4 < 2)? non alors joueur2 n'est pas un gagnant
-   (2%2 < 2)? oui alors joueur1 est un gagnant (gagnants=gagnants&#x2013;2<sup>1</sup>) = 0
-   (0% 1 <0)? non alors joueur0 n'est pas un gagnant

Ainsi, avec `gagnants=10`, les gagnants sont joueur4 et joueur2.

Bien entendu, je n'ai pas écrit toutes ces lignes, mais j'ai plutôt écrit celle-ci dans une boucle:

-   `(gagnants%2^joueurNb < gagnants) ? oui alors print("joueurNb est un gagnant") et (gagnants-=2^joueurNb)`

Je dois également préciser que j'ai choisit d'utiliser des modulos afind de m'entraîner avec cette opération qui m'était alors encore inconnue jusqu'à cette année. Mais en réalité il me semble que cette méthode pourrait très bien fonctionner en vérifiant si (gagnants&#x2013;8 >= 0) ensuite (gagnants&#x2013;4 >= 4) etc &#x2026;

J'ai également ajouté un moyen de déterminer si une partie est nulle ou pas. Donc j'ai créé une méthode privée (`MyView.calcDraw()`) qui retourne la valeur de gagnants si tous les joueurs ont gagné, et lorsque j'affiche les gagnants, je compare cette valeur avec la vraie valeur des gagnants de la partie actuelle. Ainsi, si les deux valeurs sont égales, alors tous les joueurs ont le même score et j'affiche que la partie est nulle.

J'ai préféré préciser ceci afin que mon code ne soit pas incompréhensible lors de sa lecture par une autre personne.

Merci pour votre attention.

