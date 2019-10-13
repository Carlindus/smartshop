<%@ include file="../liste-imports.jsp"%>
<!-- Ahmed -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title><bean:message key="modifier.titre" /></title>
</head>
<body bgcolor="white">
	<h1 style="text-align:center"><bean:message key="modifier.titre" /></h1>
	<br/>

	<html:form action="/modifierUtilisateur.do" focus="nom">
		<table border="0" align="center">
			<tr>
				<td align="right"><bean:message key="modifier.nom" /> :</td>
				<td align="left"><html:text property="nom" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="nom" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="modifier.prenom" /> :</td>
				<td align="left"><html:text property="prenom" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="prenom" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="modifier.dateNaissance" /> :</td>
				<td align="left"><html:text property="dateNaissance" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="dateNaissance" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="modifier.email" /> :</td>
				<td align="left"><html:text property="email" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="email" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="modifier.login" /> :</td>
				<td align="left"><html:text property="login" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="login" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="modifier.motDePasse" /> :</td>
				<td align="left"><html:text property="motDePasse" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="motDePasse" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right">confirmer <bean:message key="modifier.motDePasse" /> :</td>
				<td align="left"><html:text property="confirmerMotDePasse" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="confirmerMotDePasse" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="modifier.adresseLivraison" /> :</td>
				<td align="left"><html:text property="adresseLivraison" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="adresseLivraison" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="modifier.adresseFacturation" /> :</td>
				<td align="left"><html:text property="adresseFacturation" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="adresseFacturation" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="modifier.isAdmin" /> :</td>
				<td align="left"><html:text property="isAdmin" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="isAdmin" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="modifier.isActif" /> :</td>
				<td align="left"><html:text property="isActif" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="isActif" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			<tr>
				<td align="right"><html:submit property="submit" value="enregister" /></td>
				<td align="left"><html:reset /></td>
				<td></td>
			</tr>
			
		</table>
	</html:form>
	
	<%-- permet d'afficher toutes les erreurs --%>
	<html:errors />
	
	<html:link href="lister.do"><bean:message key="modifier.retour" /></html:link>
</body>
</html:html>
