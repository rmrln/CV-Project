# CV-Project
=====

## Import projet et configuration

1. Cloner le projet en utilisant la commande `git clone https://github.com/rmrln/CV-Project`


2. Importer le projet dans IntelliJ IDEA comme suit : 
![import1](https://user-images.githubusercontent.com/55136814/65386567-c9ce6100-dd3d-11e9-8943-b39625f920c2.JPG)

Puis parcourez vos dossiers et sélectionner le dossier "CV-Project" (son emplacement dépend du dossier dans lequel vous avez lancé la commande 'git clone' du projet)


3. Exécuter votre DB mysql. Si vous avez docker, vous pouvez utiliser la commande suivante:
```
docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 -v "`pwd`/initdb:/docker-entrypoint-initdb.d" mariadb
```


4. Configurer la base de données MariaDB : 
  4.1 Cliquez sur l'onglet 'database' :
  ![db1](https://user-images.githubusercontent.com/55136814/65389804-fb552580-dd59-11e9-8a82-287745a6a5ee.JPG)
  
  4.2 Ajouter une base : 
  ![db2](https://user-images.githubusercontent.com/55136814/65389839-5f77e980-dd5a-11e9-8176-afcb1dce51e4.jpg)
  
  4.3 Configuration base : (mot de passe = toor)
  ![db3](https://user-images.githubusercontent.com/55136814/65389858-8b936a80-dd5a-11e9-8749-d63fa52cf605.JPG)
  
  4.4 Terminer la configuration en cliquant sur ok


5. Tous les scripts sql contenus dans le dossier initdb seront exécutés automatiquement lors du premier chargement de la DB.
Si les scripts ne se sont pas éxécutés automatiquement il faudra les éxécuter dans IntelliJ IDEA en faisant un clic droit puis "run" sur chacun des 2 scripts. 



## Lancement de l'application

1. Ajouter l'extension 'Allow CORS: Access-Control-Allow-Origin' à votre navigateur (affichage des icônes) : 
https://chrome.google.com/webstore/detail/allow-cors-access-control/lhobafahddgcelffkeicbaginigeejlf?hl=fr&fbclid=IwAR2bcyq5pVkrql8D5PjjVM0H-YkoDLLBqJwBvb1xI7vKmqafwpWV2ti_dIQ


2. Lancer l'application en cliquant sur la flèche verte en haut à droite : 
![lancement](https://user-images.githubusercontent.com/55136814/65386612-48c39980-dd3e-11e9-9047-a3efcb6a3113.JPG)


3. Ouvrez votre navigateur et saisissez l'adresse 'localhost:8080', la page d'accueil de l'application va alors s'afficher
