<%@ page import="presentation.produit.action.VoirListeProduitAdminAction"%>
<%@ include file="../liste-imports.jsp"%>
<!-- Ian -->

<div id="listeProdAccueilDiv1">
    <div class="w-100">
	    <div class="floatright mb-2">
			<br/>
			<html:link href="voirCreerProduit.do" >
				<html:button property="submit">
					<bean:message key="ajouter.produit.admin" />
				</html:button>
			</html:link>
			<br/>
		</div>
	</div>
	
<logic:messagesPresent message="true">
	<div class="confirmMessageUser">
		<html:messages id="aMsg" message="true">
			<logic:present name="aMsg">
				<!-- Messages -->
				<p class="p-2"><bean:write name="aMsg" filter="false" /></p>
			</logic:present>
		</html:messages>
	</div>
</logic:messagesPresent>	

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
		        
		            <tr>
		                <td scope="row">${produit.idProduit}</td>
		                <td scope="row">
		                	<html:link href="voirDetailProduit.do?id=${produit.idProduit}">
		                		<html:img src="imageServlet?file=${produit.image}" styleId="detailProduitImg"/>
		                	</html:link>
		                </td>
		                <td scope="row">${produit.reference}</td>
		                <td scope="row">${produit.prix}</td>
		                <td scope="row">${produit.etat}</td>
						<td scope="row">
<%-- 							<html:link href="voirModifierProduit.do?id=${produit.idProduit}">
								<i class="fas fa-edit"></i>
							</html:link>
 --%>						
 							<html:link href="voirModifierProduit.do?id=${produit.idProduit}" >
								<html:button property="submit">
									<bean:message key="modifier.produit.admin" />
								</html:button>
							</html:link>
						 </td>
						<td scope="row">
							<html:link href="supprimerProduit.do?id=${produit.idProduit}">
								<i class="fas fa-trash-alt"></i>
							</html:link>
						</td>
		            </tr>
		            <tr>
		            	<td colspan="7">Description : ${produit.description}</td>
		            </tr>
		         
	         </logic:iterate>
		</tbody>
	</table>
	
</div>