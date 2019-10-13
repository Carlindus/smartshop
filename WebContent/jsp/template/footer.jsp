<!-- Laurent -->

<%@ include file="../liste-imports.jsp"%>

<div class="navFooter">
	<div>
		<ul id="navFooter">
				<html:link href="voirCgu.do">
					<li><bean:message key="footer.cgu" /></li>
				</html:link>
				<!-- 
				La rgpd n'a pas été implémentée pour cette exercice
				 -->
				<html:link href="#">
					<li><bean:message key="footer.rgpd" /></li>
				</html:link>
		</ul>
	</div>
</div>
<div class="logo">
	<html:img src="img/logo.jpg" />
</div>
<div class="resSoc flex-col">
		<html:link href="https://twitter.com/">
			<i class="fab fa-twitter-square"></i>
		</html:link>
		<html:link href="https://fr-fr.facebook.com/">
			<i class="fab fa-facebook-square"></i>
		</html:link>
</div>