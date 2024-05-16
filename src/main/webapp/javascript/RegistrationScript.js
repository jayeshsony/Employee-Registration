// Function to validate text fields, allowing only alphabets
function validateTextField(input) {
	input.value = input.value.replace(/[^a-zA-Z]/g, '');
}

// Function to check if passwords match
function getPassword() {
	var confirmPassword = document.getElementById('confirmPassword').value;
	var password = document.getElementById('password').value;
	var error = document.getElementById("passwordMismatchError");
	error.innerHTML = "";
	
	if (password !== confirmPassword) {
		error.innerHTML = "Password doesn't match!";
	} else {
		error.innerHTML = "";
	}
}

// Function to validate password input length
function validateInput() {
	var password = document.getElementById('password');
	var invalidatePasswordError = document.getElementById('invalidatePasswordError');
	invalidatePasswordError.innerHTML = "";

	if (password.value.length == 0 || password.value.length == 8 ) {
		invalidatePasswordError.innerHTML = "";
	} else {
		invalidatePasswordError.innerHTML = "Password must be 8 characters long.";
	}
}

// Function to validate number fields, allowing only digits
function validateNumberField(input) {
	input.value = input.value.replace(/\D/g, '');
}

// Function checks each field of the form if it's null or not whenever a user enters input value 
document.addEventListener('DOMContentLoaded', function() {
	var form = document.getElementById('registrationForm');
	var inputs = form.querySelectorAll('input');

	inputs.forEach(function(input) {
		input.addEventListener('input', function(event) {
			var firstName = document.getElementById("firstName").value;
			var lastName = document.getElementById("lastName").value;
			var email = document.getElementById("email").value;
			var password = document.getElementById("password").value;
			var confirmPassword = document.getElementById("confirmPassword").value;
			var address = document.getElementById("address").value;
			var contactNumber = document.getElementById("contactNumber").value;
			var userName = document.getElementById("username").value;

			if (firstName !== "") {
				document.getElementById("fnameError").textContent = "";
			}

			if (lastName !== "") {
				document.getElementById("lnameError").textContent = "";
			}

			if (email !== "") {
				document.getElementById("emailError").textContent = "";
			}

			if (password !== "") {
				document.getElementById("passwordError").textContent = "";
			}

			if (confirmPassword !== "") {
				document.getElementById("confirmPasswordError").textContent = "";
			}

			if (address !== "") {
				document.getElementById("addressError").textContent = "";
			}

			if (contactNumber !== "") {
				document.getElementById("contactNumberError").textContent = "";
			}

			if (userName !== "") {
				document.getElementById("userNameError").textContent = "";
			}
		});
	});
});