<%@page import="java.util.Map"%>
<%@ include file="../liste-imports.jsp"%>
<%@ page import="presentation.cgu.action.VoirCguAction"%>

<div>
	<bean:write name="<%=VoirCguAction.CGU_CONSTANTE %>" scope="request" />
</div>