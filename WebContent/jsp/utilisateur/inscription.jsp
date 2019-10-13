<%@ include file="../liste-imports.jsp"%>
<!-- Clément -->
<div class="container">
	<h1 class="text-center"><bean:message key="creer.titre" /></h1>
	<hr/>

	<html:form action="/inscription.do" focus="id">
			
				<bean:message key="creer.nom" /> :
				<html:text  property="nom"/>
				<ul><html:errors property="nom" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul>
			
			 	<bean:message key="creer.prenom" />
				<html:text property="prenom"/>
				<ul><html:errors property="prenom" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul>
				
				<bean:message key="creer.adresseLivraison" />
				<html:text   property="adresseLivraison"/>
				<ul><html:errors property="adresseLivraison" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul>
				
				<bean:message key="creer.adresseFacturation" />
				<html:text   property="adresseFacturation"/>
				<ul><html:errors property="adresseFacturation" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul>
				
				<bean:message key="creer.email" />
				<html:text   property="email"/>
				<ul><html:errors property="email" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul>
				
				<bean:message key="creer.login" />
				<html:text   property="login"/>
				<ul><html:errors property="login" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul>
				
				<bean:message key="creer.motDePasse" />
				<html:password   property="motDePasse"/>
				<ul><html:errors property="motDePasse" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul>
				
				<bean:message key="creer.confirmerMotDePasse" />
				<html:password   property="confirmerMotDePasse"/>
				<ul><html:errors property="confirmerMotDePasse" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul>
				
				<bean:message key="creer.dateNaissance" />
				<html:text   property="dateNaissance" />
				<ul><html:errors property="dateNaissance" prefix="errors.prefix" suffix="errors.suffix" header="" footer=""/></ul>
			
				<html:submit property="submit" titleKey="creer.submit"><bean:message key="creer.submit"/></html:submit>
				<html:reset />
	</html:form>
	
	<%-- Permet d'afficher les messages si present --%>
	<logic:messagesPresent message="true">
		
		<html:messages id="userCreated" message="true" header="myForm.header" footer="myForm.footer" >
			<bean:write name="userCreated" />
		</html:messages>
		 
	</logic:messagesPresent>
	
	<%-- permet d'afficher toutes les erreurs --%>
	<html:errors />
	<html:link href="lister.do"><bean:message key="creer.retour" /></html:link>
</div>
