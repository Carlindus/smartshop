<%@ page import="presentation.produit.action.VoirDetailProduitAction"%>
<%@ include file="../liste-imports.jsp"%>
<!-- Michelle -->


<div id="detailProduitDiv1">
		
		<bean:define id="produit"
			name="<%=VoirDetailProduitAction.FIND_PRODUIT%>" scope="request" />
		
		
		<div id="detailProduitDiv2">
			<html:img src="imageServlet?file=${produit.image}" class="detailProduitImg"></html:img>
		</div>
	
	
		<div id="detailProduitDiv3">
			<p>
				<bean:message key="affichage.reference"/>
				<bean:write name="produit" property="reference"/>
			</p>
			<p>
				<bean:message key="affichage.prix"/>
				<bean:write name="produit" property="prix"/>
				<bean:message key="devise.euro"/>
			</p>
				<html:link href="ajouterProduitPanier.do?idProduit=${produit.idProduit}&nb=1">
					<html:button property="submit">
						<bean:message key="affichage.ajouter.panier"/>
					</html:button>
				</html:link>
		</div>
		
		
		<div id="detailProduitDiv4"></div>

			<p>
				<bean:message key="affichage.description" />
				<bean:write name="produit" property="description" />
			</p>


</div>