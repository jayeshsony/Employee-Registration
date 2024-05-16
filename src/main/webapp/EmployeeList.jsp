<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.util.*"%>
<%@ page import="com.entity.*"%>
<%@ page import="com.serviceimpl.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
			crossorigin="anonymous">
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
		<link rel="stylesheet" href="css/EmployeeListStyle.css">
		<title>EmployeeList</title>
	</head>
	<body>

		<!-- Div to display notification if any session contains a value -->
		<div id="notification" class="notification"></div>

		<%
		if (session.getAttribute("updatedRecord") != null) {
		%>
		<script>
			// Function to show notification
			function showNotification(message) {
				var notification = document.getElementById('notification');
				notification.innerHTML = message;
				notification.style.display = 'block'; // Show notification

				setTimeout(function() {
					notification.style.display = 'none'; // Hide notification after 2 seconds
				}	, 2000);
			}

			// Call showNotification function with the message from session attribute
			showNotification("<%=session.getAttribute("updatedRecord")%>");
		</script>
		<%
		}
		// Remove session attribute after displaying message
		session.removeAttribute("updatedRecord");
		%>

		<%
		if (session.getAttribute("registration") != null) {
		%>
		<script>
			// Function to show notification
			function showNotification(message) {
				var notification = document.getElementById('notification');
				notification.innerHTML = message;
				notification.style.display = 'block'; // Show notification

				setTimeout(function() {
					notification.style.display = 'none'; // Hide notification after 2 seconds
				}, 2000);
			}

			// Call showNotification function with the message from session attribute
			showNotification("<%=session.getAttribute("registration")%>");
		</script>
		<%
		}
		// Remove session attribute after displaying message
		session.removeAttribute("registration");
		%>
		<section class="intro">
			<div class="bg-image h-100" style="background-color: #f5f7fa;">
				<div class="mask d-flex align-items-center h-100">
					<div class="container">
						<div class="addbutton" style="mix-blend-mode: multiply;">
							<!-- Add Record button  -->
							<a href="Registration.jsp">
								<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
									<path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6" />
									<path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5" />
								</svg>
								<span>Add Record</span>
							</a>
						</div>
						<!-- Table to display retrived records from database -->
						<div class="row justify-content-center">
							<div class="col-12">
								<div class="card shadow-2-strong">
									<div class="card-body p-0">
										<div class="table-responsive table-scroll" data-mdb-perfect-scrollbar="true" style="position: relative; height: 700px">
											<!-- Responsive table container -->
											<table class="table table-dark mb-0">
												<!-- Table Header to display table column names-->
												<thead style="background-color: #393939;">
													<tr class="text-uppercase text-success">
														<th scope="col">ID</th>
														<th scope="col">Name</th>
														<th scope="col">User Name</th>
														<th scope="col">Email</th>
														<th scope="col">Address</th>
														<th scope="col">Contact Number</th>
														<th scope="col">
															<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
																<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
																<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z" />
															</svg>
															<span>UPDATE</span>
														</th>
														<th scope="col">
															<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
																<path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5" />
															</svg>
															<span>DELETE</span>
														</th>
													</tr>
												</thead>
												<%
												// Create Object and call the retriveUser method to retrieve records
												EmployeeServiceImplementation employeeData = new EmployeeServiceImplementation();
												List<Employee> employeeList = employeeData.retriveUser();
												// Iterate through Employee List 
												for (Employee currentEmployee : employeeList) {
												%>
												<tbody>
													<tr>
														<!-- Employee Data -->
														<td><%=currentEmployee.getId()%></td>
														<td><%=currentEmployee.getFirstName()%> <%=currentEmployee.getLastName()%></td>
														<td><%=currentEmployee.getUserName()%></td>
														<td><%=currentEmployee.getEmail()%></td>
														<td><%=currentEmployee.getAddress()%></td>
														<td><%=currentEmployee.getMobileNumber()%></td>
														<!-- Update Button -->
														<td>
															<a style="display: flex; justify-content: center;" href="EmployeeAction?id=<%=currentEmployee.getId()%>&action=update" class="custom-button-update">
																<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
																	<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
																	<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z" />
																</svg>
															</a>
														</td>
														<!-- Delete Button -->
														<td>
															<a style="display: flex; justify-content: center;" href="EmployeeAction?id=<%=currentEmployee.getId()%>&action=delete" class="custom-button-delete">
																<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
																	<path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5" />
																</svg>
															</a>
														</td>
													</tr>
												<%
												}
												%>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>