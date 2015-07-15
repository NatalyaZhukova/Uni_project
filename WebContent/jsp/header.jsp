

	<div class="header">
		<h1>
			<fmt:message key="header.title" bundle="${ rb }" />
		</h1>
		<ctg:locale-switcher />
		
		<div class="lg">
			<c:if test="${user!=null}">
				<br>${user} <a href="controller?command=logout"><fmt:message
						key="header.logout" bundle="${ rb }" /> </a>
			</c:if>

		</div>
	</div>
