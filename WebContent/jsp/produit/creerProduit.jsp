<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="../liste-imports.jsp"%>

<!-- Alexy -->

	<html:errors prefix="errors.prefix" suffix="error.suffix" header="" footer="" property="problemeFormProduit"/>
	
	<h1><bean:message key="creerProduit.titre" /></h1>

	<html:form action="creerProduit.do">
		<table border="0" align="center">
		
			<tr>
				<td align="right"><label for="produitReference"><bean:message key="creerProduit.reference" /> :</label></td>
				<td align="left"><html:text property="produitReference" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="produitReference" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			
			<tr>
				<td align="right"><bean:message key="creerProduit.prix" /> :</td>
				<td align="left"><html:text property="produitPrix" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="produitPrenom" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			
			<tr>
				<td align="right"><bean:message key="creerProduit.image" /> :</td>
				<td align="left"><html:file property="produitImage" size="25" maxlength="25" /></td>
				<td><ul><html:errors property="produitImage" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			
			<tr>
				<td align="right"><bean:message key="creerProduit.description" /> :</td>
				<td align="left"><html:textarea property="produitDescription" cols="25" rows="10" /></td>
				<td><ul><html:errors property="produitDescription" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			
			<tr>
				<td align="right"><bean:message key="creerProduit.enVente" /> :</td>
				<td align="left"><html:checkbox property="produitEnVente"></html:checkbox></td>
				<td><ul><html:errors property="produitEnVente" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			
			
			
			<tr>
				<td align="right"><html:submit property="produitSubmit" titleKey="creerProduit.submit"><bean:message key="creerProduit.submit"/></html:submit></td>
				<td align="left"><html:reset /></td>
				<td></td>
			</tr>
			
		</table>
	</html:form>