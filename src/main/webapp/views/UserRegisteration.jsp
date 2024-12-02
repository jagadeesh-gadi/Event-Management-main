<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/header.jsp" />
<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
	<div class="container">

		<a class="navbar-brand fw-bold" href="/" style="font-size: 1.5rem;">EventVista</a>
		<button class="navbar-toggler ms-auto" type="button"
			data-bs-toggle="collapse" data-bs-target="#navbarToggler"
			aria-controls="navbarToggler" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<style>
.navbar-nav .nav-link i {
	margin-right: 8px;
	font-size: 1.1rem;
}

.navbar-nav .nav-link:hover i {
	color: #ffc107;
}
</style>
</div>
</nav>


<style>
 body{background-color: #212529;
    color: white;
    font-family: 'Arial', sans-serif;
    
}
</style>

<section class="container">
	<div class="container">
		<div class="row align-items-center my-5">
			<div class="col-md-12 col-lg-6 col-sm-12 mb-5">
				<h1>Create an Account</h1>
				<p class="font-italic text-muted mb-0">Fill out the Information to sign up</p>
				<c:if test="${not empty reg_error}">
					<p class="text-danger">${reg_error}</p>
				</c:if>
			</div>

			<!-- Registration Form -->
			<div class="col-md-12 col-lg-6 col-sm-12 mt-3">
				<form action="/registerForm" modelAttribute="registerForm" method="POST">
					
					

					<div class="row">
						<!-- First Name -->
						<div class="input-group col-lg-6 mb-4">
							<div class="input-group-prepend">
								<span class="input-group-text bg-white px-4 border-md border-right-0">
									<i class="fa fa-user text-muted"></i>
								</span>
							</div>
							<input id="firstName" type="text" name="firstName" placeholder="First Name" class="form-control bg-white border-left-0 border-md" required>
						</div>

						<!-- Last Name -->
						<div class="input-group col-lg-6 mb-4">
							<div class="input-group-prepend">
								<span class="input-group-text bg-white px-4 border-md border-right-0">
									<i class="fa fa-user text-muted"></i>
								</span>
							</div>
							<input id="lastName" type="text" name="lastName" placeholder="Last Name" class="form-control bg-white border-left-0 border-md" required>
						</div>

						<!-- Email Address -->
						<div class="input-group col-lg-12 mb-4">
							<div class="input-group-prepend">
								<span class="input-group-text bg-white px-4 border-md border-right-0">
									<i class="fa fa-envelope text-muted"></i>
								</span>
							</div>
							<input id="email" type="email" name="email" placeholder="Email Address" class="form-control bg-white border-left-0 border-md" required>
						</div>

						<!-- Phone Number -->
						<div class="input-group col-lg-12 mb-4">
							<div class="input-group-prepend">
								<span class="input-group-text bg-white px-4 border-md border-right-0">
									<i class="fa fa-phone-square text-muted"></i>
								</span>
							</div>
							<input id="phoneNumber" type="tel" name="contactno" pattern="[6789][0-9]{9}" placeholder="Phone Number" class="form-control bg-white border-md border-left-0 pl-3" required>
						</div>

						<!-- Address -->
						<div class="input-group col-lg-12 mb-4">
							<div class="input-group-prepend">
								<span class="input-group-text bg-white px-4 border-md border-right-0">
									<i class="fas fa-map-marker-alt text-muted"></i>
								</span>
							</div>
							<textarea class="form-control" name="address" placeholder="Address" id="floatingTextarea"></textarea>
						</div>

						<!-- Gender -->
						<div class="input-group col-lg-12 mb-4">
							<div class="input-group-prepend">
								<span class="input-group-text bg-white px-4 border-md border-right-0">
									<i class="fas fa-venus-mars text-muted"></i>
								</span>
							</div>
							<select id="gender" name="gender" class="form-control custom-select bg-white border-left-0 border-md" required>
								<option value="">Choose your Gender</option>
								<option value="male">Male</option>
								<option value="female">Female</option>
							</select>
						</div>

						<!-- Password -->
						<div class="input-group col-lg-6 mb-4">
							<div class="input-group-prepend">
								<span class="input-group-text bg-white px-4 border-md border-right-0">
									<i class="fa fa-lock text-muted" id="pass_icon"></i>
								</span>
							</div>
							<input id="password" type="password" name="password" oninput="checkInputs();" placeholder="Password" class="form-control bg-white border-left-0 border-md" required>
						</div>

						<!-- Confirm Password -->
						<div class="input-group col-lg-6 mb-4">
							<div class="input-group-prepend">
								<span class="input-group-text bg-white px-4 border-md border-right-0">
									<i class="fa fa-lock text-muted" id="c_pass_icon"></i>
								</span>
							</div>
							<input id="confirm_password" type="password" oninput="checkInputs();" name="confirmPassword" placeholder="Confirm Password" class="form-control bg-white border-left-0 border-md" required>
						</div>

						<!-- Role -->
						<div class="input-group col-lg-12 mb-4">
							<div class="input-group-prepend">
								<span class="input-group-text bg-white px-4 border-md border-right-0">
									<i class="fas fa-user-cog text-muted"></i>
								</span>
							</div>
							<select id="role" name="role" class="form-control custom-select bg-white border-left-0 border-md" required>
								<option value="">Select Role</option>
								<option value="User">User</option>
							</select>
						</div>

						<!-- Submit Button -->
						<div class="form-group col-lg-12 mx-auto mb-0">
							<button type="submit" class="btn btn-primary btn-block py-2" name="adduser">
								<span class="font-weight-bold">Create your account</span>
							</button>
						</div>

						<!-- Divider Text -->
						<div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
							<div class="border-bottom w-100 ml-5"></div>
							<span class="px-2 small text-muted font-weight-bold text-muted">OR</span>
							<div class="border-bottom w-100 mr-5"></div>
						</div>

						<!-- Social Login -->
						<div class="form-group col-lg-12 mx-auto">
							<a href="#" class="btn btn-danger btn-block py-2 btn-facebook">
								<i class="fa fa-facebook-f mr-2"></i> <span class="font-weight-bold">Continue with Google</span>
							</a>
							<a href="#" class="btn btn-primary btn-block py-2 btn-twitter">
								<i class="fa fa-twitter mr-2"></i> <span class="font-weight-bold">Continue with Facebook</span>
							</a>
						</div>

						<!-- Already Registered -->
						<div class="text-center w-100">
							<p class="text-muted font-weight-bold">
								Already Registered? <a href="signin" class="text-primary ml-2">Login</a>
							</p>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>

<script>
	var password = document.getElementById("password"), confirm_password = document.getElementById("confirm_password");

	function checkInputs() {
		if (password.value != confirm_password.value) {
			confirm_password.setCustomValidity("Passwords Don't Match");
		} else {
			confirm_password.setCustomValidity('');
		}
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
</script>

<jsp:include page="includes/footer.jsp" />
