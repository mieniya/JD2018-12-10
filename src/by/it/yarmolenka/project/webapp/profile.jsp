<html>
	<%@ include file="include/head.jsp" %>
	<body>
		<div class="container">
			<%@ include file="include/menu.jsp" %>
			<p>Cmd Profile: ${user}</p>
			<table class="table table-striped">
				<thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Date</th>
                        <th scope="col">Race description</th>
                        <th scope="col">Event description</th>
                        <th scope="col">Bet Amount</th>
                        <th scope="col">Odds</th>
                        <th scope="col">Payout</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userBets}" var="bet">
						<th scope="row">${bet.id}</th>
						<td>
							<c:forEach items="${events}" var="event">
								<c:if test="${bet.fk_events == event.id}">
									<c:forEach items="${races}" var="race">
										<c:if test="${event.fk_races == race.id}">
											${race.date}
										</c:if>
									</c:forEach>
								</c:if>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${events}" var="event">
								<c:if test="${bet.fk_events == event.id}">
									<c:forEach items="${races}" var="race">
										<c:if test="${event.fk_races == race.id}">
											${race.description}
										</c:if>
									</c:forEach>
								</c:if>
							</c:forEach>
						</td>
						<td>
							<c:forEach items="${events}" var="event">
								<c:if test="${bet.fk_events == event.id}">
									${event.description}
								</c:if>
							</c:forEach>
						</td>
						<td>${bet.amount}</td>
						<td>
							<c:forEach items="${events}" var="event">
								<c:if test="${bet.fk_events == event.id}">
									${event.odds}
								</c:if>
							</c:forEach>
						</td>
						<td>${bet.payout}</td>
					</c:forEach>
				</tbody>
            </table>
		</div>
	</body>
</html>
