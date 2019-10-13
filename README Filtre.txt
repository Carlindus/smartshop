<<=====================filtre===================================>>


===>Le filtre se positionne avant la servlet : lorsque l'utilisateur demande une page Internet,
    une requ�te est envoy� au serveur. Elle doit passer par le Filter avant d'arriver � la page demand�e.
===> l'objecif est de faire un test avant d'arriver � la page demand�e.
===>Dans notre cas, le but est de restreindre l'acc�s aux invit�s � des ressources r�serv�es aux utilisateurs connect�s et � l'acc�s aux utilisateurs connect�s non admin � des ressources r�s�rv�es aux utilisateurs admin 
===> il faut cr�er une classe filtre qui impl�mente l'interface Filter. Cette interface d�finit trois m�thodes, 
     nous on va se concentrer sur la m�thode principale : doFilter(ServletRequest, ServletResponse, FilterChain)  
===> dans le fichier web.xml, il faut d�clarer le nom du filtre, son emplacement et le nom de la servlet sur laquelle le fitre s'applique 
===> pour mettre en place un filtre g�n�ral, on a d�finit d'abord la liste des profils qui peuvent interagir avec l'application(Admin, utilisateur non admin, invit�)
et toutes les pages de l'application.


<<====================Fonctionnement===================================>>
==> aller voir les commentaires dans la classe Filtrehttp du package presentation.filtre


<<=====================en cas d'ajout d'un nouveau profil===================================>>
==> D'abord, on se positionne dans la classe Filtrehttp du package presentation.filtre
==> S'il y'a un nouveau profil � ajouter, il faut cr�er une constante profil avec le nom du profil (PROFIL_...) et une constante acces avec le nom du profil (ACCES_....)
==> Ensuite il faut ajouter la constante acces � la map qui est compos�e des url des pages de l'application pour la cl� et les droits d'acc�s pour valeur

<<=====================en cas d'ajout d'une nouvelle page � l'application===================================>>
==> D'abord, il faut se positionne dans la classe Filtrehttp du package presentation.filtre
==>il faut ajouter l'url � la map et au m�me temps d�finir les droits d'acc�s � cette nouvelle page

