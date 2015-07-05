
<div class="menu">
	<ul>
		<li><a href="/Uni_project/controller?command=fac"><fmt:message
					key="usermain.fac_list" bundle="${rb}" /></a></li>
		<c:if test="${application==null}">
			<li><a href="/Uni_project/controller?command=chfac"><fmt:message
						key="usermain.register_fac" bundle="${rb}" /></a></li>
		</c:if>
		<c:if test="${application!=null}">
			<li><a href="/Uni_project/controller?command=applic"><fmt:message
						key="usermain.application" bundle="${rb}" /></a></li>
		</c:if>
	</ul>
</div>
