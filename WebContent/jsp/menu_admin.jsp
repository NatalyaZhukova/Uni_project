
<div class="menu">
	<ul>
	<li><a href="index.jsp"><fmt:message
					key="usermain.main" bundle="${rb}" /></a> </li>
		<li><a href="controller?command=fac"><fmt:message
					key="adminmain.faculties" bundle="${rb}" /></a></li>
					
			<li><a href="controller?command=abitur"><fmt:message
						key="adminmain.approved" bundle="${rb}" /></a></li>
			<li><a href="controller?command=abitur&stat=waiting"><fmt:message
						key="adminmain.waiting" bundle="${rb}" /> </a></li>
			<li><a href="controller?command=abitur&stat=denied"><fmt:message
						key="adminmain.denied" bundle="${rb}" /> </a></li>
	</ul>
</div>
