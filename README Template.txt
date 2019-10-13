Gestion du POC_Template
-----------------------

Le template common-layout.jsp (NOUVEAU) se trouve sur WebContent.jsp (NE PAS MODIFIER !!)

	Les pages JSP
	-------------
	
	WebContent.jsp.template.header.jsp
	WebContent.jsp.template.menu.jsp	
	WebContent.jsp.template.footer.jsp
	WebContent.jsp.common-layout.jsp
	
	
	Le fichier tiles-defs.xml (NOUVEAU)
	-------------------------
	
Ce fichier contient la d�finition des diff�rentes layout. 
Chaque layout se charge d'indiquer l'adresse des pages JSP pour le header, le menu, le footer et le body.
Ce qui diff�renciera les diff�rentes layout, c'est uniquement l'addresse de la JSP du body.

Il faut donc modifier uniquement la value de la ligne body pour y mettre la page jsp � afficher dans le body.

Exemple :

<tiles-definitions>
	<definition name="listerUser" path="/jsp/common-layout.jsp">
		<put name="header" value="/jsp/template/header.jsp" />
		<put name="menu" value="/jsp/template/menu.jsp" />
		<put name="body" value="/jsp/utilisateur/lister.jsp" />       <======
		<put name="footer" value="/jsp/template/footer.jsp" />
	</definition>

...

</tiles-definitions>

	
	
	Le fichier struts-config.xml
	----------------------------
Ce qui change :

	- Ajout de la d�finition du plugin Tiles :
	
	<!-- D�claration du fichier de d�finition de Tiles -->
	<plug-in className="org.apache.struts.tiles.TilesPlugin">
		<set-property property="definitions-config" value="/WEB-INF/tiles-defs.xml" />
		<set-property property="moduleAware" value="true" />
	</plug-in>

	
	- Il n'y a que le "path" de chaque action � modifier. Il ne pointe plus vers une page JSP mais vers un layout du fichier tiles-defs.xml.
	
	exemple :
	
		<!-- Lister Utilisateur -->
		<action path="/listerUtilisateur" scope="request" input=""
			parameter=""
			type="presentation.utilisateur.action.VoirListeUtilisateurAction">
			<forward name="success" path="listerUser"
				redirect="false" />
		</action>
	
		

	La gestion des styles des pages JSP
	-----------------------------------
La gestion des styles est centralis�e dans le fichier layout.css qui se trouve sur WebContent.css
C'est le template qui appliquera tous les styles.
Aucun style ne devra �tre mis en dehors de cette feuille de style.

	
	La gestion des imports
	----------------------
	
	Les imports ont �t� externalis�s des pages JSP. Ils se trouvent dans le fichier WebContent/jsp/liste-imports.jsp.
	Il faut ins�rer la ligne ci-dessous dans la page JSP pour en tenir compte :
	
	<%@ include file="../liste-imports.jsp"%>
	
	Pour de nouveaux imports, il faut les ajouter dans le fichier liste-imports.jsp.
	
	
	<div id="listerPanierDiv1">
	<logic:iterate name="panier" id="contenu"
		property="${ panier.mapProduitDto }">
		<table id="listerPanierTab">
			<tbody id="listerPanierTBody">
				<tr>
					<td class="listerPanierTd1">
						<table>
							<tr>
								<bean:define id="key" name="contenu" property="key"></bean:define>
								<td class="listerPanierTd2" rowspan="2">
									<!--<bean:write name="key" property="image" />--> <html:img
										styleId="listerPanierImg"
										page="/imageServlet?file=${key.image}"></html:img>
								</td>
								<td class="listerPanierTd2"><bean:write name="key"
										property="reference" /></td>
								<td class="listerPanierTd2" rowspan="2"><bean:write
										name="key" property="prix" /> <bean:message key="devise.euro" /></td>
							</tr>
							<tr>
								<td class="listerPanierTd3"><bean:write name="key"
										property="description" /></td>
							</tr>
						</table>
					</td>
					<td class="listerPanierTd4"><bean:define id="val"
							name="contenu" property="value"></bean:define>
						<div id="listerPanierTd4Div1">
							<bean:message key="listerPanier.montantLigne" />
							<bean:write name="val" property="montantLigne" />
						</div>
						<div>
							<html:link href="retirerQttPanier.do?id=${key.idProduit}">
								<img width="20px" src="img/moins.png" alt="icone moins" />
							</html:link>
							<bean:message key="listerPanier.quantite" />
							<bean:write name="val" property="quantite" />
							<html:link href="ajouterQttPanier.do?id=${key.idProduit}">
								<img width="20px" src="img/plus.png" alt="icone plus" />
							</html:link>
						</div>
						<div id="listerPanierTd4Div2">
							<html:link href="supprimerLignePanier.do?id=${key.idProduit}">
								<img width="20px" src="img/poubelle.jpg" alt="icone poubelle" />
							</html:link>
						</div></td>
				</tr>
			</tbody>
		</table>
	</logic:iterate>
</div>
<div id="listerPanierDiv2">
	<bean:size id="beansize" name="panier"
		property="${ panier.mapProduitDto }" />
	<div>
		<bean:message key="listerPanier.nbreProduit" />
		<bean:write name="beansize" />
	</div>
	<bean:define id="val" name="panier"
		type="presentation.panier.bean.PanierDto"></bean:define>
	<div>
		<bean:message key="listerPanier.prixTotal" />
		<bean:write name="val" property="prixTotal" />
	</div>
	<div>
		<bean:message key="listerPanier.remiseAccordee" />
		<bean:write name="val" property="montantRemise" />
	</div>
	<div>
		<bean:message key="listerPanier.montantAPayer" />
		<bean:write name="val" property="montantAPayer" />
	</div>

	<div class="validerPanier">
		<html:link href="valierPanier.do" styleId="validerPanier"><bean:message key="valider.panier" /></html:link>
	</div>
	<div class="viderPanier">
		<html:link href="viderPanier.do" styleId="viderPanier"><bean:message key="vider.panier" /></html:link>
	</div>
</div>
	