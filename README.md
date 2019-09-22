# CV-Project
=====

1. Cloner le projet en utilisant la commande `git clone https://github.com/rmrln/CV-Project`


2. Exécuter votre DB mysql. Si vous avez docker, vous pouvez utiliser la commande suivante:
```
docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 -v "`pwd`/initdb:/docker-entrypoint-initdb.d" mariadb
```


3. Importer le projet dans IntelliJ IDEA comme suit : 
![import1](https://user-images.githubusercontent.com/55136814/65386567-c9ce6100-dd3d-11e9-8943-b39625f920c2.JPG)

Puis parcourez vos dossiers et sélectionner le dossier "CV-Project" (son emplacement dépend du dossier dans lequel vous avez lancé la commande 'git clone' du projet)


4. Tous les scripts sql contenus dans le dossier initdb seront exécutés automatiquement lors du premier chargement de la DB.
Si les scripts ne se sont pas éxécutés automatiquement il faudra les éxécuter dans IntelliJ IDEA en faisant un clic droit puis "run" sur chacun des 2 scripts.


5. Lancer l'application en cliquant sur la flèche verte en haut à droite : 
![lancement](https://user-images.githubusercontent.com/55136814/65386612-48c39980-dd3e-11e9-9047-a3efcb6a3113.JPG)


6. Ouvrez votre navigateur et saisissez l'adresse 'localhost:8080', la page d'accueil de l'application va alors s'afficher
