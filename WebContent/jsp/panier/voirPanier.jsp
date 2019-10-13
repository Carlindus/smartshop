<%@page import="java.util.Map"%>
<%@ include file="../liste-imports.jsp"%>

<%@ page import="presentation.panier.action.ViderPanierAction"%>
<%@ page import="presentation.panier.action.VoirPanierAction"%>
<%@ page import="presentation.panier.bean.PanierDto"%>
<h1>
	<bean:message key="listerPanier.titre" />
</h1>

<br />
<%-- parcours le panier et affiche son contenu --%>
<logic:empty name="panier" property="mapProduitDto">
	<h2>
		<bean:message key="listerPanier.panierVide" />
	</h2>
</logic:empty>

<logic:notEmpty name="panier" property="mapProduitDto">
<div id="listerPanierDiv1">
	<logic:iterate name="panier" id="contenu"
		property="mapProduitDto">
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
							<html:link href="retirerQttPanier.do?idProduit=${key.idProduit}">
								<i class="fas fa-minus"></i>
							</html:link>
							<bean:message key="listerPanier.quantite" />
							<bean:write name="val" property="quantite" />
							<html:link href="ajouterQttPanier.do?idProduit=${key.idProduit}">
								<i class="fas fa-plus"></i>
							</html:link>
						</div>
						<div id="listerPanierTd4Div2">
							<html:link href="supprimerLignePanier.do?idProduit=${key.idProduit}">
								<i class="fas fa-trash-alt"></i>
							</html:link>
						</div></td>
				</tr>
			</tbody>
		</table>
	</logic:iterate>
</div>
<div id="listerPanierDiv2">
	<bean:size id="beansize" name="panier"
		property="mapProduitDto" />
	<div>
		<bean:message key="listerPanier.nbreProduit" />
		<bean:write name="beansize" />
	</div>
	<bean:define name="panier" id="val"
		type="presentation.panier.bean.PanierDto">
	</bean:define>
	<div>
		<bean:message key="listerPanier.prixTotal" />
		<bean:write name="val" property="montantTotal" />
	</div>
	<div>
		<bean:message key="listerPanier.remiseAccordee" />
		<bean:write name="val" property="montantRemise" />
	</div>
	<div>
		<bean:message key="listerPanier.montantAPayer" />
		<bean:write name="val" property="montantAPayer" />
	</div>

	<div class="viderPanier">
		<html:link href="valierPanier.do" styleId="viderPanier"><bean:message key="valider.panier" /></html:link>
	</div>
	<div class="viderPanier">
		<html:link href="viderPanier.do" styleId="viderPanier"><bean:message key="vider.panier" /></html:link>
	</div>
</div>
</logic:notEmpty>
