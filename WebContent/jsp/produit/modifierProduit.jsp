<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="../liste-imports.jsp"%>

<!-- Alexy -->

	<html:errors prefix="errors.prefix" suffix="error.suffix" header="" footer="" property="problemeFormProduit"/>
	
	<h1><bean:message key="modifierProduit.titre" /></h1>

	<html:form action="modifierProduit.do">
		<table border="0" align="center">
		
			<tr>
				<td align="right"><bean:message key="modifierProduit.id" /></td>
				<td align="left"><html:text property="idProduit" size="25" maxlength="25" value="${produit.idProduit}" readonly="true"/></td>
				<td><ul><html:errors property="idProduit" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>

			<tr>
				<td align="right"><bean:message key="creerProduit.reference" /></td>
				<td align="left"><html:text property="reference" size="25" maxlength="25" value="${produit.reference}" /></td>
				<td><ul><html:errors property="reference" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			
			<tr>
				<td align="right"><bean:message key="creerProduit.prix" /></td>
				<td align="left"><html:text property="prix" size="25" maxlength="25" value="${produit.prix}"/></td>
				<td><ul><html:errors property="prix" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			
			<tr>
				<td align="right"><bean:message key="creerProduit.image" /></td>
				<td align="left">
				<%-- <html:file property="image" /> --%>
				</td>
				<td><ul><html:errors property="image" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>
			
			<tr>
				<td align="right"><bean:message key="creerProduit.description" /></td>
				<td align="left"><html:textarea property="description" cols="25" rows="10" value="${produit.description}"/></td>
				<td><ul><html:errors property="description" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul></td>
			</tr>


			<tr>
				<td align="right"><bean:message key="creerProduit.enVente" /></td>
				<td align="left">
					<html:checkbox name="produitForm" property="enVente"></html:checkbox>
				</td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td align="left">
					<html:submit property="submit" ><bean:message key='modifierProduit.submit' />" </html:submit>
					<html:reset ><bean:message key='btn.reset'/></html:reset>
				</td>
				<td align="right" >
				</td>
			</tr>
			
		</table>
	</html:form>