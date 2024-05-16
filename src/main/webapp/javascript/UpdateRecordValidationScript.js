// Get the data of form when submit button is clicked
$(document).ready(function() {
	$('#updateRecordForm').submit(function(e) {

		e.preventDefault(); // Prevent default form submission

			// Serialize form data
			var formData = $(this).serialize();
			var firstName = $("#firstName").val();
			var lastName = $("#lastName").val();
			var userName = $("#username").val();
			var email = $("#email").val();
			var password = $("#password").val();
			var confirmPassword = $("#confirmPassword").val();
			var address = $("#address").val();
			var contactNumber = $("#contactNumber").val();
			var isValid = true;

			// Validation for first name
			if (firstName === "") {
				$("#fnameError").text("First name is required.");
				isValid = false;
			} else if(firstName.length < 2) {
				$("#fnameError").text("First Name must be at least 2 characters long.");
				isValid = false;
			} else if(firstName.length > 50){
				$("#fnameError").text("First Name must not be longer than 50 characters.");
				isValid = false;
			} else {
				$("#fnameError").text("");
			}

			// Validation for last name
			if (lastName === "") {
				$("#lnameError").text("Last name is required.");
				isValid = false;
			} else if(lastName.length < 2) {
				$("#lnameError").text("Last Name must be at least 2 characters long.");
				isValid = false;
			} else if(lastName.length > 50){
				$("#lnameError").text("Last Name must not be longer than 50 characters.");
				isValid = false;
			} else {
				$("#lnameError").text("");
			}

			// Function to check email format
			function validateEmail(email) {
				// Email validation regex
				var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
				return emailRegex.test(email);
			}

			// Validation for email
			if (email === "") {
				$("#emailError").text("Email is required.");
				isValid = false;
			} else if (!validateEmail(email)) {
				$("#emailError").text("Email format is invalid.");
				isValid = false;
			} else {
				$("#emailError").text("");
			}		

			// Validation for user name
			if (userName === "") {
				$("#userNameError").text("User name is required.");
				isValid = false;
			} else if(userName.length < 2) {
				$("#userNameError").text("Username must be at least 2 characters long.");
				isValid = false;
			} else if(userName.length > 30){
				$("#userNameError").text("Username must not be longer than 30 characters.");
				isValid = false;
			}else {
				$("#userNameError").text("");
			}

			// Validations for password
			if (password === "") {
				$("#passwordError").text("Password is required.");
				isValid = false;
			} else if (password.length < 8) {
				isValid = false;
			}else {
				$("#passwordError").text("");
			}

			// Validation for confirm password
			if (confirmPassword === "") {
				$("#confirmPasswordError").text("Confirm password is required.");
				isValid = false;
			} else if (password !== confirmPassword) {
				isValid = false;
			} else {
				$("#confirmPasswordError").text("");
			}

			// Validation for address
			if (address === "") {
				$("#addressError").text("Address is required.");
				isValid = false;
			}else if (address.length < 2){
				$("#addressError").text("Address must be at least 2 characters long.");
				isValid = false;
			} else if (address.length > 255){
				$("#addressError").text("Address must not be longer than 255 characters.");
				isValid = false;
			} else {
				$("#addressError").text("");
			}

			// Validation for contact number
			if (contactNumber === "") {
				$("#contactNumberError").text("Contact number is required.");
				isValid = false;
			} else if(contactNumber.length !== 10 ) {
				$("#contactNumberError").text("Contact number must have 10 digits.");
				isValid = false;
			} else {
				$("#contactNumberError").text("");
			}

			// Validation to check if password and confirm password are equal or not 
			if (password !== confirmPassword) {
				isValid = false;
			}

			// If form is not valid, stop execution
			if (!isValid) {
				return;
			}

			// AJAX calls to check if email, username, and mobile number already exist
			$.ajax({
				type: 'POST',
				url: 'CheckUpdatedEmailServlet',
				data:formData,
				success: 
					function(response) {
						if ( response == "exists") {
							$('#emailError').text("Email already exists.");
						}
					}
			});

			$.ajax({
				type: 'POST',
				url: 'CheckUpdatedUserNameServlet',
				data:formData,
				success: 
					function(response) {
						if ( response == "exists") {
							$('#userNameError').text("Username already exists.");
						}
					}
			});

			$.ajax({
				type: 'POST',
				url: 'CheckUpdatedMobileNumberServlet',
				data:formData,
				success: 
					function(response) {
						if ( response == "exists") {
							$('#contactNumberError').text("Contact number already exists.");
						}
					}
			});

			// AJAX call to submit form data
			$.ajax({
				type: 'POST',
				url: 'UpdateRecordServlet',
				data: formData,
				success: 
						function(response) {
						// Check the response 
						if ( response == "success") {
							window.location.href = 'EmployeeList.jsp'; // Redirect to EmployeeList page
						}
					}
			});
	});
});

// Reset the form when reset button is clicked
$('button[type="reset"]').click(function() {
			$('#updateRecordForm')[0].reset(); // Reset the form with ID 'registrationForm'
});