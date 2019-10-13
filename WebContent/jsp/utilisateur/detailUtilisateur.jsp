<%@ page
	import="presentation.utilisateur.action.VoirDetailUtilisateurAction"%>
<%@ page import="presentation.utilisateur.action.ConnexionAction"%>
<%@ include file="../liste-imports.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>


<!-- Clément -->

<div class="container centered">

	<h1 class="text-center">
		<bean:message key="consulter.titre" />
	</h1>
	<hr />
	<div class="col">
		<bean:define
			name="<%=VoirDetailUtilisateurAction.UTILISATEUR_REQUEST%>"
			id="utilisateur" scope="request" />
		<div class="col">
			<bean:message key="consulter.id" />
			<bean:write name="utilisateur" property="idUtilisateur" />
			<br />
			<bean:message key="consulter.nom" />
			:
			<bean:write name="utilisateur" property="nom" />
			<br />

			<bean:message key="consulter.prenom" />
			:
			<bean:write name="utilisateur" property="prenom" />
			<br />

			<bean:message key="consulter.dateNaissance" />
			:
			<bean:write name="utilisateur" property="dateNaissance" />
			<br />

			<bean:message key="consulter.adresseFacturation" />
			:
			<bean:write name="utilisateur" property="adresseFacturation" />
			<br />
			<bean:message key="consulter.adresseLivraison" />
			:
			<bean:write name="utilisateur" property="adresseLivraison" />
			<br />
			<bean:message key="consulter.email" />
			:
			<bean:write name="utilisateur" property="email" />
			<br />
			<bean:message key="consulter.login" />
			:
			<bean:write name="utilisateur" property="login" />
			<br />
		</div>
	</div>
</div>
<div class="container">
	<html:errors />
</div>

<div class="container ">
	<div class="row">
		<div class="col">
			<!-- Afficher bouton modifier -->

			<html:link
				href="voirModifierUtilisateur.do?idParam=${utilisateur.getIdUtilisateur()}">
				<button class="viderPanier mt-2">
					<bean:message key="consulter.modifier" />
				</button>

			</html:link>
			<logic:equal name="connectedUser" property="isAdmin" value="false"
				scope="session">
				<a href="" data-toggle="modal"
					data-target="#deleteModal${utilisateur.getIdUtilisateur()} ">
					<button class="viderPanier mt-2">
						<bean:message key="consulter.supprimer" />
					</button>
				</a>
			</logic:equal>
			<html:link href="listerProduitAccueil.do">
				<bean:message key="consulter.retour" />
			</html:link>
			<!-- Modal -->
			<div class="modal fade"
				id="deleteModal${utilisateur.getIdUtilisateur()}" tabindex="-1"
				role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="deleteModalLabel">
								<bean:message key="consulter.supprimer" />
							</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<bean:message key="consulter.supprimerConfirm" />
							<%-- Êtes-vous sûr(e) de vouloir supprimer ${user.nom}
							${personne.prenom} ? --%>
							<br />
							<p class="mt-2 text-right text-danger">
								<small><bean:message key="consulter.avertissement" /> <!-- Attention, l'action ne peut être annulée. --></small>
							</p>
						</div>
						<div class="modal-footer">
							<button class="btn btn-secondary">
								<a href="" data-dismiss="modal"><bean:message
										key="consulter.annuler" /></a>
							</button>
							<html:link
								href="supprimerUtilisateur.do?idParam=${utilisateur.idUtilisateur}">
								<button class="btn btn-danger">
									<bean:message key="consulter.supprimer" />
								</button>
							</html:link>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>






