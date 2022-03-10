# Générateur de Label Encoding pour une topologie donnée

Ce programme prend en entrée une topologie de réseau donnée, sous la forme une matrice d'adjacence. 
Ensuite, il permet de générer des chemins stricts et les encode par LEA et LEA-A afin de mettre en valeur la réduction de la taille de la pile d’entete.<br/>
Le résultat prend la forme d’un tableau CSV avec les titres suivants :<br/>
« Dijstra;Strict Path;Taille MSD;LEA;Taille LEA MSD;LEA-A;Taille LEA-A MSD; ».<br/>
Par défaut, il traite la topologie du réseau Abilene qui est la dorsale Internet II des Etats-Unis.
