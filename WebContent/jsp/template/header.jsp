<!-- Laurent -->

<%@ include file="../liste-imports.jsp"%>


<div id="logo" class="flex-row">
	<div>
		<html:link href="listerProduitAccueil.do">
			<html:img src="img/logo.jpg"/>
		</html:link>
	</div>
</div>
<div>
	<h1>Smart Shop</h1>
</div>

<div class="flex-row">
	<div class="flex-row">
	<ul id="navHeader">

<!-- En utilisant les tests logiques de Struts
	<c:choose>
		<c:when test="empty sessionScope.ConnectedUserDto"> 
			<html:link href="voirConnexion.do">
				<li><i class="fas fa-user"></i></li>
			</html:link>
			<html:link href="voirConnexion.do">
				<li><i class="fas fa-shopping-cart"></i></li>
			</html:link>
		</c:when>
		<c:otherwise>
			<html:link href="voirDetailUtilisateur.do">
				<li><i class="fas fa-user"></i></li>
			</html:link>
			<html:link href="listerPanier.do">
				<li><i class="fas fa-shopping-cart"></i></li>
			</html:link>
		</c:otherwise>
	</c:choose>
-->
		<logic:notPresent name="connectedUser" scope="session">
				<html:link href="voirConnexion.do">
					<li><i class="fas fa-user"></i></li>
				</html:link>
				<html:link href="voirConnexion.do">
					<li><i class="fas fa-shopping-cart"></i></li>
				</html:link>
		</logic:notPresent>
		<logic:present name="connectedUser" scope="session">
				<html:link href="voirDetailUtilisateur.do?idParam=${connectedUser.id}">
					<li><i class="fas fa-user"></i></li>
				</html:link>
				<html:link href="listerPanier.do">
					<li><i class="fas fa-shopping-cart"></i></li>
				</html:link>
		</logic:present>
	</ul>
	</div>

	<div class="flex-col">
		<div id="flag" class="flex-col">
			<html:link href="langue.do?lang=FR">
				<html:img src="img/flag-FR.jpg"/>
			</html:link>
			<html:link href="langue.do?lang=EN">
				<html:img src="img/flag-UK.png" />
			</html:link>
		</div>
		
		<logic:present name="connectedUser" scope="session">
		<div>
		<p>
		<logic:present name="connectedUser" scope="session">
			<bean:message key="header.bonjour" arg0="${connectedUser.login}"/>
		</logic:present>
		
		</p>
			<html:link href="deconnexion.do">
				<bean:message key="header.deconnexion"/>
			</html:link>
		</div>
		</logic:present>
		
	</div>
</div>