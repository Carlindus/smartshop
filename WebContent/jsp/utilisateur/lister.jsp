<!-- TODO a supprimer apres integration template -->
<!-- TODO CSS à integrer -->
<!-- TODO mettre les liens supprimer et modifier : href="voirModifierUtilisateur.do?idParam=${personne.idUtilisateur}" -->
<!-- Caroline -->
<%@ page
	import="presentation.utilisateur.action.VoirListeUtilisateurAction"%>
<%@ include file="../liste-imports.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<h1><bean:message key="listeUtilisateur.titre" /></h1>
<br />
<logic:messagesPresent message="true">
	<html:messages id="supprimerOK" message="true" header="present.header" footer="present.footer">
		<bean:write name="supprimerOK" />
	</html:messages>
</logic:messagesPresent>

<div class="table-responsive w-80">
	<table class="table">
		<thead>
			<tr>
				<th scope="col"><bean:message key="listerUtilisateur.nom" /></th>
				<th scope="col"><bean:message key="listerUtilisateur.login" /></th>
				<th scope="col"><bean:message key="listerUtilisateur.etat" /></th>
				<th scope="col"><bean:message key="listerUtilisateur.modifier" /></th>
				<th scope="col"><bean:message key="listerUtilisateur.supprimer" /></th>
			</tr>
		</thead>
		<tbody>
		<logic:iterate name="<%=VoirListeUtilisateurAction.LISTE_USERS_REQUEST %>" id="personne" >
			<tr onClick="document.location.href='voirDetailUtilisateur.do?idParam=${personne.idUtilisateur}">
				<td><bean:write name="personne" property="prenom" /> <bean:write name="personne" property="nom" /></td>
				<td><bean:write name="personne" property="login" /></td>
				<td><c:choose >
					<c:when test="personne.isAdmin">
					<bean:message key="listerUtilisateur.actif" />
					</c:when>
					<c:otherwise>
					<bean:message key="listerUtilisateur.desactive" />
					</c:otherwise>
				</c:choose></td>
				<td><html:link href="voirModifierUtilisateur.do?idParam=${personne.idUtilisateur}"><i class="fas fa-edit"></i></html:link></td>
				<td><html:link href="supprimerUtilisateur.do?idParam=${personne.idUtilisateur}"><i class="fas fa-trash-alt"></i></html:link></td>
			</tr>
			</logic:iterate>
		</tbody>
	</table>
</div>