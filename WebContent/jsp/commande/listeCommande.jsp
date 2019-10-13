<%@ page import="presentation.commande.action.VoirListeCommandeAction"%>
<%@ include file="../liste-imports.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><bean:message key="listerCommande.titre.ListeCommande" /></title>
</head>
<body>
	<h1><bean:message key="listerCommande.titre.ListeCommande" /></h1>

	<br />
	
	<logic:messagesPresent message="listerCommande.vide">
      <html:messages  id="message" message="listerCommande.vide">
        <bean:write  name="message"/>
       </html:messages>
     </logic:messagesPresent>
	<%-- parcours la liste des Utilisateurs et affiche leur nom --%>
	<logic:messagesNotPresent message="listerCommande.vide">
		<logic:iterate name="<%=VoirListeCommandeAction.LISTE_COMMANDE_REQUEST %>" id="commande">
			<%-- lien avec de EL --%>
			<hr/>
			<div class="listOrders">
			<bean:message key="listerCommande.date.commande"/> : <bean:write name="commande" property="dateCde"/><br/>
			<bean:message key="listerCommande.adresse.facturation"/> : <bean:write name="commande" property="adresseFacturation"/><br/>
			<bean:message key="listerCommande.adresse.livraison"/> : <bean:write name="commande" property="adresseLivraison"/><br/>
			<bean:message key="listerCommande.montant.total"/> : <bean:write name="commande" property="montantTotal"/>€<br/>
			<bean:message key="listerCommande.montant.remise"/> : <bean:write name="commande" property="montantRemise"/>€<br/>
			<html:link href="voirDetailCommande.do?idCde=${commande.idCde}">
				<html:button property="">
					<bean:message key="listerCommande.voirDetail"/>
				</html:button>
			</html:link>
			</div>
			<hr/>
			<br />
		</logic:iterate>

	</logic:messagesNotPresent>
</body>
</html:html>
