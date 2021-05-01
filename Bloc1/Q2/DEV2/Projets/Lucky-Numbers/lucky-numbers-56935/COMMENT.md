# Commentaires itération 1

* Dans le constructeur de ta classe Board, pas besoin de faire une boucle qui met les éléments à null dans ton tableau 2D car c'est la valeur par défaut.
* Pourquoi avoir laissé ce commentaire dans ton canBePut():

```
        /*if (this.tiles[position.getRow()][position.getColumn()] != null) {
            return false;
        } IF I UNCOMMENT THIS, USERS CAN'T PLAY A FULL GAME*/
```
* Tu pourrais écrire le canBePut() plus simplement avec juste une boucle for.
* Il y a un test qui ne passe pas et qui reflète un problème au niveau de ton canBePut(). Tu vérifies la contrainte avec la tuile qui est précédemment à la position demandée. Toutefois cette tuile sera remplacée quand tu en places une nouvelle. Donc il ne faut pas la considérer quand tu testes si les valeurs sont < ou >.
* Pour ton énumération State, les commentaires sur les états devraient être sur les cas de l'énumération (càd dans le enum) plutôt qu'au dessus.
* Il ne faut pas oublier de supprimer les méthodes main que tu utilises pour rapidement tester certaines classes.
* Pour nextPlayer(), tu pourrais utiliser un modulo comme ceci currentPlayerNumber = (currentPlayerNumber + 1) % playerCount;
* Il ne faut pas oublier d'enlever les System.out.println() de tes tests.
* Ton Controller ne devrait pas utiliser de System.out.println() mais juste utiliser les méthodes de la vue.



