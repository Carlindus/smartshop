<%@ page import="presentation.commande.action.VoirDetailCommandeAction"%>
<%@ include file="../liste-imports.jsp"%>
	
	<!-- Jonathan -->
<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title><bean:message key="detailCommande.titre" /></title>
	</head>
	<body>
		<html:link href="/voirListeCommande">
			retour vers <bean:message key="detailCommande.lienListeCde" />
		</html:link>
		
		<h2><bean:message key="detailCommande.titreTableau" /></h2>
		<bean:define name="<%=VoirDetailCommandeAction.COMMANDE_DETAIL_DTO %>" id="commandeDto"></bean:define>
		<bean:message key="detailCommande.numCde" /><bean:write name="commandeDto" property="commandeDto.idCde" /><br />
		<bean:message key="detailCommande.dateCde" /><bean:write name="commandeDto" property="commandeDto.dateCde" /><br />
		<bean:message key="detailCommande.prixCde" /><bean:write name="commandeDto" property="commandeDto.montantTotal" /><br />
		
		<table border="1px;solid">
			<tr>
				<th><bean:message key="detailCommande.tabCol1" /></th>
				<th><bean:message key="detailCommande.tabCol2" /></th>
				<th><bean:message key="detailCommande.tabCol3" /></th>
				<th><bean:message key="detailCommande.tabCol4" /></th>
				<th><bean:message key="detailCommande.tabCol5" /></th>
			</tr>
			<logic:iterate name="<%=VoirDetailCommandeAction.COMMANDE_DETAIL_DTO%>" id="produit">
				<tr>
					<td><html:img src="imageServlet?file=${produit.key.image}" styleId="detailProduitImg"></html:img></td>
					<td>${produit.key.reference}</td>
					<td>${produit.value.montantLigne} <bean:message key="detailCommande.euro" /></td>
					<td>${produit.value.quantite}</td>
					<td>
						<html:link href="/voirDetailProduit.do?backsave=LC&back=DC&id=${produit.key.idProduit}&idCde=${commandeDto.idCde}">
							<bean:message key="Voir détails produitdetailCommande.lienDetailProduit" />
						</html:link>
					</td>
				</tr>
			</logic:iterate>
		</table>

	</body>
</html:html>