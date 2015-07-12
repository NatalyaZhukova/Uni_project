
<div class="menu">
	<ul>
		<li><a href="index.jsp"><fmt:message
					key="usermain.main" bundle="${rb}" /></a> </li>
		<li><a href="controller?command=fac"><fmt:message
					key="usermain.fac_list" bundle="${rb}" /></a></li>
		<c:if test="${application==null}">
			<li><a href="controller?command=chfac"><fmt:message
						key="usermain.register_fac" bundle="${rb}" /></a></li>
		</c:if>
		<c:if test="${application!=null}">
			<li><a href="controller?command=applic"><fmt:message
						key="usermain.application" bundle="${rb}" /></a></li>
		</c:if>
	</ul>
</div>
