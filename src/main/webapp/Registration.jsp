<%@page import="com.entity.*" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Registration Form</title>
		<!-- Bootstrap CSS -->
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
			crossorigin="anonymous">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<!-- Registration Form CSS -->
			<link href="css/RegistrationStyle.css" rel="stylesheet">
	</head>
	<body>
		<!-- Link to view employee list -->
		<div class="emplistlink">
			<a href="EmployeeList.jsp">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-list-task" viewBox="0 0 16 16">
					<path fill-rule="evenodd" d="M2 2.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5V3a.5.5 0 0 0-.5-.5zM3 3H2v1h1z" />
					<path d="M5 3.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5M5.5 7a.5.5 0 0 0 0 1h9a.5.5 0 0 0 0-1zm0 4a.5.5 0 0 0 0 1h9a.5.5 0 0 0 0-1z" />
					<path fill-rule="evenodd" d="M1.5 7a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5zM2 7h1v1H2zm0 3.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm1 .5H2v1h1z" />
				</svg>
				<span>View Employee List</span>
			</a>
		</div>

		<!-- Registration form container -->
		<%
		// Check if session is not null and user object is available
		if (session != null && session.getAttribute("user") != null) {
			// Retrieve user object from session
			Employee currentEmployee = (Employee) session.getAttribute("user");
			// Remove session attribute after displaying message
			session.removeAttribute("user");
		%>

		<!-- Display registration form with user data for update and retrive current record's data -->
		<div class="container">
			<h2 class="my-2 text-center">Registration Form</h2>
			<!-- Registration form -->
			<form method="post" id="updateRecordForm">

				<div class="row mb-3">
					<div class="col">
						<input name="id" type="hidden" value="<%= currentEmployee.getId()%>">
						<label for="firstName" class="form-label">First Name</label>
						<input type="text" class="form-control" id="firstName" name="firstName" value="<%= currentEmployee.getFirstName()%>" oninput="validateTextField(this)">
						<span id="fnameError" class="error-message"></span>
					</div>
					<div class="col">
						<label for="lastName" class="form-label">Last Name</label>
						<input type="text" class="form-control" id="lastName" name="lastName"  value="<%= currentEmployee.getLastName()%>" oninput="validateTextField(this)">
						<span id="lnameError" class="error-message"></span>
					</div>
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">Email</label>
					<input type="text" class="form-control" id="email" name="email"  value="<%= currentEmployee.getEmail()%>">
					<span id="emailError" class="error-message"></span>
				</div>
				<div class="mb-3">
					<label for="username" class="form-label">User Name</label>
					<input type="text" class="form-control" id="username" name="userName"  value="<%= currentEmployee.getUserName()%>">
					<span id="userNameError" class="error-message"></span>
				</div>
				<div class="row mb-3">
					<div class="col">
						<label for="password" class="form-label">Password</label>
						<input type="password" class="form-control" id="password" name="password" value="<%= currentEmployee.getPassword()%>" oninput="validateInput()">
						<span id="invalidatePasswordError"></span>
						<span id="passwordError" class="error-message"></span>
					</div>
					<div class="col">
						<label for="confirmPassword" class="form-label">Confirm Password</label>
						<input type="password" class="form-control" id="confirmPassword" name="confirmPassword" value="<%= currentEmployee.getPassword()%>" oninput="getPassword()">
						<p id="passwordMismatchError">
						<span id="confirmPasswordError" class="error-message"></span>
					</div>
				</div>
				<div class="mb-3">
					<label for="address" class="form-label">Address</label>
					<input class="form-control" id="address" name="address" value="<%= currentEmployee.getAddress()%>">
					<span id="addressError" class="error-message"></span>
				</div>
				<div class="mb-3">
					<label for="contactNumber" class="form-label">Contact Number</label>
					<input type="tel" class="form-control" id="contactNumber" name="mobileNumber" value="<%= currentEmployee.getMobileNumber()%>" oninput="validateNumberField(this)" maxlength="10">
					<span id="contactNumberError" class="error-message"></span>
				</div>
				<div class="text-center">
					<!-- Submit and reset buttons -->
					<button type="submit" id="submit" class="btn btn-primary">Update</button>
					<button type="reset" class="btn btn-danger">Reset</button>
				</div>

			</form>
		</div>

		<!-- Javascript to check update record validation -->
		<script type="text/javascript" src="javascript/UpdateRecordValidationScript.js"></script>
		<%
		} else {
		%>
		<!-- Display registration form for new registration -->
		<div class="container">
			<h2 class="my-2 text-center">Registration Form</h2>
			<!-- Registration form -->
			<form method="post" id="registrationForm">

				<div class="row mb-3">
					<div class="col">
						<label for="firstName" class="form-label">First Name</label>
						<input type="text" class="form-control" id="firstName" name="firstName" oninput="validateTextField(this)">
						<span id="fnameError" class="error-message"></span>
					</div>
					<div class="col">
						<label for="lastName" class="form-label">Last Name</label>
						<input type="text" class="form-control" id="lastName" name="lastName" oninput="validateTextField(this)">
						<span id="lnameError" class="error-message"></span>
					</div>
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">Email</label>
					<input type="text" class="form-control" id="email" name="email">
					<span id="emailError" class="error-message"></span>
				</div>
				<div class="mb-3">
					<label for="username" class="form-label">User Name</label>
					<input type="text" class="form-control" id="username" name="userName">
					<span id="userNameError" class="error-message"></span>
				</div>
				<div class="row mb-3">
					<div class="col">
						<label for="password" class="form-label">Password</label>
						<input type="password" class="form-control" id="password" name="password" oninput="validateInput()">
						<span id="invalidatePasswordError"></span>
						<span id="passwordError" class="error-message"></span>
					</div>
					<div class="col">
						<label for="confirmPassword" class="form-label">Confirm Password</label>
						<input type="password" class="form-control" id="confirmPassword" name="confirmPassword" oninput="getPassword()">
						<span id="passwordMismatchError"></span>
						<span id="confirmPasswordError" class="error-message"></span>
					</div>
				</div>
				<div class="mb-3">
					<label for="address" class="form-label">Address</label>
					<textarea class="form-control" id="address" name="address"></textarea>
					<span id="addressError" class="error-message"></span>
				</div>
				<div class="mb-3">
					<label for="contactNumber" class="form-label">Contact Number</label>
					<input type="tel" class="form-control" id="contactNumber" name="mobileNumber" oninput="validateNumberField(this)" maxlength="10">
					<span id="contactNumberError" class="error-message"></span>
				</div>
				<div class="text-center">
					<!-- Submit and reset buttons -->
					<button type="submit" id="submit" class="btn btn-primary">Register</button>
					<button type="reset" class="btn btn-danger">Reset</button>
				</div>

			</form>
		</div>

		<!-- Javascript to check insert record validation -->
		<script type="text/javascript" src="javascript/InsertRecordValidationScript.js"></script>
		<%
		}
		%>

		<!-- AJAX JS -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

		<!-- Bootstrap JS -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-wxvxFn7XYvJ3tjz3U+JcdP2Pyt4t62N6tng2LsYfWEXCtvWUv8J8vAVOKP5HKsre"
			crossorigin="anonymous">
		</script>

		<!-- Registration page JS -->
		<script type="text/javascript" src="javascript/RegistrationScript.js"></script>

	</body>
</html>