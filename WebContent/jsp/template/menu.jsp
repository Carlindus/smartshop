<!-- Laurent -->

<%@ include file="../liste-imports.jsp"%>

<logic:notPresent name="connectedUser" scope="session">
	<ul id="menuGuest">
		<li><html:link href="listerProduitAccueil.do">
			<html:button styleId="buttonClient" property="">
				<bean:message key="menu.client.listerProduits"/>
			</html:button>
		</html:link></li>

	</ul>
</logic:notPresent>

<logic:present name="connectedUser" scope="session">
	<logic:equal name="connectedUser" property="isAdmin" value="false" scope="session">
		<ul id="menuClient">
			<li><html:link href="listerProduitAccueil.do">
				<html:button styleId="buttonClient" property="">
					<bean:message key="menu.client.listerProduits"/>
				</html:button>
			</html:link></li>
			<li><html:link href="voirListeCommande.do">
				<html:button styleId="buttonClient" property="">
					<bean:message key="menu.client.listerCommande"/>
				</html:button>
			</html:link></li>
		</ul>
	</logic:equal>

	<logic:equal name="connectedUser" property="isAdmin" value="true" scope="session">		
		<ul id="menuAdmin">
			<li><html:link href="listerProduitAdmin.do">
				<html:button styleId="buttonAdmin" property="">
					<bean:message key="menu.admin.gestion.produits"/>
				</html:button>
			</html:link></li>
			<li><html:link href="voirListeCommande.do">
				<html:button styleId="buttonAdmin" property="">
					<bean:message key="menu.admin.gestion.commandes"/>
				</html:button>
			</html:link></li>
			<li><html:link href="listerUtilisateur.do">
				<html:button styleId="buttonAdmin" property="">
					<bean:message key="menu.admin.gestion.utilisateurs"/>
				</html:button>		
			</html:link></li>
		</ul>
	</logic:equal>
</logic:present>