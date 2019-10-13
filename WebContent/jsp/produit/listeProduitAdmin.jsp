<%@ page import="presentation.produit.action.VoirListeProduitAdminAction"%>
<%@ include file="../liste-imports.jsp"%>
<!-- Ian -->
<div id="listeProdAccueilDiv1">
    <table id="listeProdAccueilTab1" class="table">
        <thead>
            <tr>
                <td scope="col"><bean:message key="adminProduit.id" /></td>
                <td scope="col"><bean:message key="adminProduit.image" /></td>
                <td scope="col"><bean:message key="adminProduit.reference" /></td>
                <td scope="col"><bean:message key="adminProduit.prix" /></td>
                <td scope="col"><bean:message key="produit.enVente" /></td>
                <td scope="col"><bean:message key="modifier.produit.admin" /></td>
                <td scope="col"><bean:message key="supprimer.produit.admin" /></td>
            </tr>
        </thead>
        <tbody id="listeProdAccueilTBody">
	        <logic:iterate name="<%=VoirListeProduitAdminAction.LISTE_PRODUIT_ADMIN_DTO%>" id="produit" scope="request">
		        <html:link href="voirDetailProduit.do?id=${produit.idProduit}">
		            <tr>
		                <td scope="row">${produit.idProduit}</td>
		                <td scope="row"><html:img src="imageServlet?file=${produit.image}" styleId="detailProduitImg"/></td>
		                <td scope="row">${produit.reference}</td>
		                <td scope="row">${produit.prix}</td>
		                <td scope="row">${produit.etat}</td>
						<td scope="row"><html:link href="voirModifierProduit.do?idParam=${produit.idProduit}">
						<i class="fas fa-edit"></i></html:link></td>
						<td scope="row"><html:link href="supprimerProduit.do?idParam=${produit.idProduit}">
						<i class="fas fa-trash-alt"></i></html:link></td>
		            </tr>
		            <tr>
		            	<td colspan="7">Description : ${produit.description}</td>
		            </tr>
		         </html:link>
	         </logic:iterate>
		</tbody>
	</table>
		<br />
	<div class="floatright mr-5 mb-5">
	<html:link href="ajouterProduitPanier.do?id=${produit.idProduit}&nb=2" >
		<html:button property="submit">
			<bean:message key="ajouter.produit.admin" />
		</html:button>
	</html:link>
	</div>
</div>