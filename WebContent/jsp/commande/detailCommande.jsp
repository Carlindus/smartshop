<%@ page import="presentation.commande.action.VoirDetailCommandeAction"%>
<%@ include file="../liste-imports.jsp"%>

<!-- Jonathan -->
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><bean:message key="detailCommande.titre" /></title>
</head>
<body>
	<html:link href="voirListeCommande.do">
			retour vers <bean:message key="detailCommande.lienListeCde" />
	</html:link>

	<h2>
		<bean:message key="detailCommande.titreTableau" />
	</h2>
	<bean:define name="<%=VoirDetailCommandeAction.COMMANDE_DETAIL_DTO%>"
		id="commandeDto"></bean:define>

	<bean:message key="detailCommande.userCde" />
	<bean:write name="commandeDto" property="commandeDto.utilisateur.nom" /> <bean:write name="commandeDto" property="commandeDto.utilisateur.prenom" />
	<br />
	<bean:message key="detailCommande.numCde" />
	<bean:write name="commandeDto" property="commandeDto.idCde" />
	<br />
	<bean:message key="detailCommande.dateCde" />
	<bean:write name="commandeDto" property="commandeDto.dateCde" />
	<br />
	<bean:message key="detailCommande.prixCde" />
	<bean:write name="commandeDto" property="commandeDto.montantTotal" />
	<br />

	<table border="1px black solid">
		<tr>
			<th><bean:message key="detailCommande.tabCol.idLigneCde" /></th>
			<th><bean:message key="detailCommande.tabCol.idProduitCde" /></th>
			<th><bean:message key="detailCommande.tabCol.reference" /></th>
			<th><bean:message key="detailCommande.tabCol.prix" /></th>
			<th><bean:message key="detailCommande.tabCol.quantite" /></th>
		</tr>
		<logic:iterate name="commandeDto"
			property="commandeDto.ligneCommandeSet" id="ligneCommande">
			<tr>
				<td><bean:write name="ligneCommande" property="idLigneCde" /></td>
 				<td><bean:write name="ligneCommande" property="produitCdeDo.idProduitCde" /></td>
				<td><bean:write name="ligneCommande" property="produitCdeDo.reference" /></td>
				<td><bean:write name="ligneCommande" property="produitCdeDo.prix" /></td>
		 		<td><bean:write name="ligneCommande" property="quantite" /></td>
			</tr>
		</logic:iterate>
	</table>

</body>
</html:html>