<%@ include file="../liste-imports.jsp"%>

<!-- David -->
<html:form action="/connexion.do">
	<div>
	<table id="conTab">
		<tr>
			<td class="tdRight"><label for="login"><bean:message key="connexion.login" /> :</label></td>
			<td class="tdLeft"><html:text property="login" size="20"
					maxlength="20" /></td>
			<td><ul>
					<html:errors property="login" prefix="errors.prefix"
						suffix="errors.suffix" header="" footer="" />
				</ul></td>
		</tr>
		<tr>
			<td class="tdRight"><label for="mdp"><bean:message key="connexion.mdp" /> :</label></td>
			<td class="tdLeft"><html:password property="mdp" size="20"
					maxlength="20" /></td>
			<td><ul>
					<html:errors property="mdp" prefix="errors.prefix"
						suffix="errors.suffix" header="" footer="" />
				</ul></td>
		</tr>
		<tr>
			<td class="tdRight"><html:submit property="submit"
					titleKey="connexion">
					<bean:message key="connexion" />
				</html:submit></td>
			<td align="left"><html:reset /></td>
			<td></td>
		</tr>
	</table>
	</div>
</html:form>
<html:link href="inscription.do"><bean:message key="connexion.inscription" /></html:link>
<%-- Permet d'afficher les messages si present --%>
<logic:messagesPresent message="true">
	<html:messages id="userCreated" message="true" header="present.header"
		footer="present.footer">
		<bean:write name="userCreated" />
	</html:messages>
</logic:messagesPresent>
<%-- permet d'afficher toutes les erreurs --%>
<html:errors></html:errors>

