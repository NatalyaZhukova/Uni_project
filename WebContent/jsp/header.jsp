

	<div class="header">
		<h1>
			<fmt:message key="header.title" bundle="${ rb }" />
		</h1>
		<div class="locale">
			<a href="/Uni_project/controller?command=lang&locale=ru_RU">RU</a> | <a
				href="/Uni_project/controller?command=lang&locale=en_US">EN</a>
		</div>
		<div class="lg">
			<c:if test="${user!=null}">
				<br>${user} <a href="/Uni_project/controller?command=logout"><fmt:message
						key="header.logout" bundle="${ rb }" /> </a>
			</c:if>

		</div>
	</div>