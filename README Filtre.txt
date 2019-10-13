<<=====================filtre===================================>>


===>Le filtre se positionne avant la servlet : lorsque l'utilisateur demande une page Internet,
    une requête est envoyé au serveur. Elle doit passer par le Filter avant d'arriver à la page demandée.
===> l'objecif est de faire un test avant d'arriver à la page demandée.
===>Dans notre cas, le but est de restreindre l'accès aux invités à des ressources réservées aux utilisateurs connectés et à l'accès aux utilisateurs connectés non admin à des ressources résérvées aux utilisateurs admin 
===> il faut créer une classe filtre qui implémente l'interface Filter. Cette interface définit trois méthodes, 
     nous on va se concentrer sur la méthode principale : doFilter(ServletRequest, ServletResponse, FilterChain)  
===> dans le fichier web.xml, il faut déclarer le nom du filtre, son emplacement et le nom de la servlet sur laquelle le fitre s'applique 
===> pour mettre en place un filtre général, on a définit d'abord la liste des profils qui peuvent interagir avec l'application(Admin, utilisateur non admin, invité)
et toutes les pages de l'application.


<<====================Fonctionnement===================================>>
==> aller voir les commentaires dans la classe Filtrehttp du package presentation.filtre


<<=====================en cas d'ajout d'un nouveau profil===================================>>
==> D'abord, on se positionne dans la classe Filtrehttp du package presentation.filtre
==> S'il y'a un nouveau profil à ajouter, il faut créer une constante profil avec le nom du profil (PROFIL_...) et une constante acces avec le nom du profil (ACCES_....)
==> Ensuite il faut ajouter la constante acces à la map qui est composée des url des pages de l'application pour la clé et les droits d'accès pour valeur

<<=====================en cas d'ajout d'une nouvelle page à l'application===================================>>
==> D'abord, il faut se positionne dans la classe Filtrehttp du package presentation.filtre
==>il faut ajouter l'url à la map et au même temps définir les droits d'accés à cette nouvelle page

