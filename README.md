# SpaceInvaders

## Sommaire
- [Semaine n°1 : du 30 au 05 avril](#semaine1)  
- [Semaine n°2 : du 06 au 12 avril](#semaine2)  
- [Semaine n°3 : du 13 au 19 avril](#semaine3)  
- [Glossaire](#glossaire)

## Semaine n°1 : du 30 au 05 avril <a id="semaine1"></a>


### Sprints et fonctionnalités réalisées 

#### Fonctionnalité n°1 : Déplacer un vaisseau dans l'espace de jeu (fini)

- Story n°1 : Créer un espace de jeu  
Un espace de jeu est créé aux dimensions données (2D) 
Cet espace de jeu est vide

-  Story n°2 : Positionner un nouveau vaisseau dans l’espace de jeu  
Un nouveau vaisseau est créé
Le vaisseau est positionné aux coordonnées transmises
Si un nouveau vaisseau essaye d’être positionné en dehors des limites de l’espace jeu, alors une exception devra être levée.
 Contraintes :
La position souhaitée est transmise par ses coordonnées x et y.
Le coin supérieur gauche de l’espace jeu (point en haut à gauche) a pour coordonnées (0,0)
La taille du vaisseau est réduite pour l'instant à son minimum (1 seul point)    

- Story n°3 : Déplacer le vaisseau vers la droite dans l'espace de jeu  
Le vaisseau se déplace d'un pas vers la droite 
Si le vaisseau se trouve sur la bordure droite de l'espace de jeu, le vaisseau doit rester immobile (aucun déplacement, aucune exception levée : le vaisseau reste juste à sa position actuelle).


- Story n°4 : Déplacer le vaisseau vers la gauche dans l'espace de jeu  
Le vaisseau se déplace d'un pas vers la gauche 
Si le vaisseau se trouve sur la bordure gauche de l'espace de jeu, le vaisseau doit rester immobile (aucun déplacement, aucune exception levée : le vaisseau reste juste à sa position actuelle).

### Fonctionnalité en cours d’implémentation : 
Aucune


### Diagramme de classes 

![Diagrammes de classes de la semaine 1](images/DiagrammeClasses_Semaine1.png)

### Nuage de mots du projet spaceinvaders (séance n°1)  
(généré à l’aide de Source Code Word Cloud Generator avec la liste JavaBlacklist.txt fournie en annexe)
 
![Nuage de mots de la semaine 1](images/NuageDeMots_Semaine1.png)


### Difficultés rencontrées 
Aucune

### Remarques diverses
 Pour pouvoir, mettre en place les tests, il a été nécessaire d’ajouter une fonctionnalité supplémentaire qui permet de représenter l’espace de jeu dans une chaîne ASCII.

-------------

## Semaine n°2 : du 06 au 12 avril <a id="semaine2"></a>


### Sprints et fonctionnalités réalisées 

- Story n°1 :  Positionner un nouveau vaisseau avec une dimension donnée   
Un nouveau vaisseau avec une dimension donnée est créé à une position donnée.

-  Story n°2 : Faire en sorte qu'il soit impossible de positionner un nouveau vaisseau qui déborde de l'espace de jeu  
Un nouveau vaisseau est créé  
Si un nouveau vaisseau essaye d’être positionné en dehors des limites de l’espace jeu, alors une exception devra être levée.  
 Contraintes :  
La position souhaitée est transmise par ses coordonnées x et y.  
Le coin supérieur gauche de l’espace jeu (point en haut à gauche) a pour coordonnées (0,0)  
La taille du vaisseau est déterminée par une hauteur et une longueur   

- Story n°3 : Déplacer un vaisseau vers la droite en tenant compte de sa dimension  
Le vaisseau se déplace d'un pas vers la droite   
Si le vaisseau se trouve sur la bordure droite de l'espace de jeu, le vaisseau doit rester immobile (aucun déplacement, aucune exception levée : le vaisseau reste juste à sa position actuelle).  

- Story n°4 : Déplacer un vaisseau vers la gauche en tenant compte de sa dimension   
Le vaisseau se déplace d'un pas vers la gauche   
Si le vaisseau se trouve sur la bordure gauche de l'espace de jeu, le vaisseau doit rester immobile (aucun déplacement, aucune exception levée : le vaisseau reste juste à sa position actuelle).  

### Fonctionnalité en cours d’implémentation : 

Aucune

### Diagramme de classes

![Diagrammes de classes de la semaine 2](images/DiagrammeClasses_Semaine2.png)

### Nuage de mots du projet spaceinvaders (séance n°2) 

![Nuage de mots de la semaine 2](images/NuageDeMots_Semaine2.png)

### Difficultés rencontrées   

Aucune.  

### Remarques diverses

Aucune

-------------
## Semaine n°3 : du 13 au 19 avril <a id="semaine3"></a>


### Sprints et fonctionnalités réalisées 

- Story n°1 :  Faire en sorte que le déplacement se fasse correctement pour une vitesse quelconque.   
Le vaisseau se déplace d'un pas vers la droite ou vers la gauche à une vitesse choisi au préalable    

- Story n°2 : Intégration d'un moteur graphique  
Lors du lancement du jeu une fenêtre d'une dimension choisie s'ouvre contenant un vaisseau placé à une certaine position choisie au préalable.  
Le vaisseau peut se déplacer à gauche et à droite dans la fenêtre.

### Fonctionnalité en cours d’implémentation : 

Aucune    

### Diagramme de classes

![Diagrammes de classes de la semaine 3](images/DiagrammeClasses_Semaine3.png)

### Nuage de mots du projet spaceinvaders (séance n°3) 

![Nuage de mots de la semaine 3](images/NuageDeMots_Semaine3.png)

### Difficultés rencontrées   

Aucune.  

### Remarques diverses

Aucune

-------------

## Glossaire <a id="glossaire"></a>

* **Vaisseau** :  véhicule commandé par le joueur, pouvant se déplacer de droite à gauche et ayant la possibilité de lancer des missiles destinés à détruire le(s) envahisseurs.

* **Envahisseur**  :  ennemi qui apparaît à l'écran, se déplace automatiquement et qui doit être détruit par un missile lancé depuis le vaisseau du joueur.

* **Missile** :  projectile envoyé à la verticale par le vaisseau vers l'envahisseur dans le but de le détruire.

* **Sprite** : élément graphique qui peut se déplacer sur l'écran.  