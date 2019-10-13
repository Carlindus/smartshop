<%@ page import="java.util.Map"%>
<%@ include file="../liste-imports.jsp"%>

<%@ page import="presentation.panier.action.VoirPanierAction"%>
<%@ page import="presentation.panier.bean.PanierDto"%>
<%@ page import="presentation.utilisateur.bean.UtilisateurDto"%>
<%@ page import="presentation.commande.bean.CommandeDto"%>


<html:form action="/validerPanier.do" focus="id">
	
	<h1><bean:message key="validerCommande.titre.validationCommande" /></h1>
	<h2><bean:message key="validerCommande.titre.recapitulatifCommande" /></h2>
	<bean:message key="validerCommande.recapitulatifCommande" arg0="${PanierDto.getMapProduitDto.size()}" arg1="${PanierDto.montantAPayer}" />
	
	
	<h2><bean:message key="validerCommande.titre.infoPersonnelles" /></h2>
	<table border="0" align="center">
		<fieldset>
		<legend><bean:message key="validerCommande.legende.infoLivraison" /></legend>
		<tr>
			<td align="right"><bean:message key="detailUtilisateur.nom" /> :</td>
			<td align="left"><html:text name="utilisateurDto" property="nom" size="25" maxlength="25" readonly="true" /></td>
			<td><ul><html:errors name="utilisateurDto" property="nom" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
		</tr>
		<tr>
			<td align="right"><bean:message key="detailUtilisateur.prenom" /> :</td>
			<td align="left"><html:text name="utilisateurDto" property="prenom" size="25" maxlength="25" readonly="true" /></td>
			<td><ul><html:errors name="utilisateurDto" property="prenom" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
		</tr>
		<tr>
			<td align="right"><bean:message key="detailUtilisateur.email" /> :</td>
			<td align="left"><html:text name="utilisateurDto" property="email" size="25" maxlength="25" readonly="true" /></td>
			<td><ul><html:errors name="utilisateurDto" property="age" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
		</tr>
		<tr>
			<td align="right"><bean:message key="detailUtilisateur.adresseLivraison" /> :</td>
			<td align="left"><html:text name="CommandeDto" property="adresseLivraison" size="50" maxlength="25" /></td>
			<td><ul><html:errors name="CommandeDto" property="adresseLivraison" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
		</tr>
		<tr>
			<td align="right"><bean:message key="detailUtilisateur.adresseFacturation" /> :</td>
			<td align="left"><html:text name="CommandeDto" property="adresseFacturation" size="50" maxlength="25" /></td>
			<td><ul><html:errors name="CommandeDto" property="adresseFacturation" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
		</tr>
		<logic:present name="DetailProduitPanierDto" scope="session"> 
		<html:submit property="submit" titleKey="valider.Commande.submit">
			<bean:message key="valider.Commande.submit"/>
		</html:submit>
		</logic:present>
		
		</fieldset>
	</table>
</html:form>