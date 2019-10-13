<%@ page import="presentation.produit.action.VoirListeProduitAccueilAction"%>
<%@ include file="../liste-imports.jsp"%>

<!-- Audrey -->
<div class="listeProdAccueilDiv1">
	<table id="listeProdAccueilTab1" class="table">
		<thead>
			<tr>
				<td scope="col"><bean:message key="accueilProduit.idProduit" /></td>
				<td scope="col"><bean:message key="accueilProduit.reference" /></td>
				<td scope="col"><bean:message key="accueilProduit.image" /></td>
				<td scope="col"><bean:message key="accueilProduit.prix" /></td>
				<td scope="col"><bean:message key="accueilProduit.achat" /></td>
				<td scope="col"></td>
				<td scope="col"></td>
			</tr>
		</thead>
		<tbody id="listeProdAccueilTBody">
			<logic:iterate name="<%=VoirListeProduitAccueilAction.LISTE_PRODUIT_DTO%>" id="produit" scope="request">
			<tr>
				<td scope="row"><bean:write name="produit" property="idProduit" /></td>
				<td scope="row"><bean:write name="produit" property="reference" /></td>
				<td scope="row"><html:img src="imageServlet?file=${produit.image}"
						styleId="detailProduitImg"></html:img></td>
				<td scope="row"><bean:write name="produit" property="prix" /></td>
				<td scope="row"><bean:write name="produit" property="etat" /></td>
				<td scope="row"><html:link href="voirDetailProduit.do?id=${produit.idProduit}">
							VOIR DETAIL
					</html:link></td>
				<td scope="row"><html:link href="ajouterProduitPanier.do?idProduit=${produit.idProduit}&nb=2">
					<html:button property="submit">
					<bean:message key="ajouter.panier" />
							</html:button>
					</html:link></td>
			</tr>
		</logic:iterate>
				</tbody>
			</table>
</div>