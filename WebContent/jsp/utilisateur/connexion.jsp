<%@ include file="../liste-imports.jsp"%>

<!-- David -->
<div id="conTab">
	<html:form action="/connexion.do">

		<div>
			<logic:messagesPresent message="true">
				<html:messages id="userCreated" message="true" header="present.header"
					footer="present.footer">
					<bean:write name="userCreated" />
				</html:messages>
			</logic:messagesPresent>
		</div>
	
		<div>
				<span>
				<label for="login"><bean:message key="connexion.login" /> : </label>
				<html:text property="login" size="20"
							maxlength="20" value="admin"/>
				</span>
				<ul>
					<html:errors property="login" prefix="errors.prefix"
					suffix="errors.suffix" header="" footer="" />
				</ul>
	
				<span>
					<label for="mdp"><bean:message key="connexion.mdp" /> : </label>
					<html:password property="mdp" size="20"
							maxlength="20" value="pass"/>
				</span>
				
				<ul>
					<html:errors property="mdp" prefix="errors.prefix"
						suffix="errors.suffix" header="" footer="" />
				</ul>
		</div>
		<div >
			<html:submit property="submit"
					titleKey="connexion"
					styleClass="btn">
					<bean:message key="connexion" />
			</html:submit>
			<html:reset styleClass="btn">
				<bean:message key="connexion.reinitialiser" />
			</html:reset>
		</div>
		<html:link href="voirInscription.do"><bean:message key="connexion.inscription" /></html:link>
	</html:form>
</div>
<%-- Permet d'afficher les messages si present --%>

<%-- permet d'afficher toutes les erreurs --%>
<html:errors></html:errors>

