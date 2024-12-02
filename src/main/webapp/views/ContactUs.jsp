<jsp:include page="includes/header.jsp" />  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
 body{background-color: #212529;
    color: white;
    font-family: 'Arial', sans-serif;
    
}
</style>
<jsp:include page="includes/homeNav.jsp" />  
  


<section id="contact ">
<div class="container-xl mb-5 p-5">
	<div class="row">
		<div class="col-md-8 mx-auto">
		<div class="message"></div>
			<div class="contact-form">
				<h1>Contact Us</h1>
				<p class="hint-text">We'd love to hear from you, please drop us a line if you've any query.</p>
				<div c:if="${error != null}">
						<p class="text-danger">${error}</p>
					</div>
					<div c:if="${success != null}">
					    <p class="text-success">${success}</p>
					</div>
				<form action="/contactForm" modelAttribute="contactForm" method="POST">
				     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="inputFirstName">First Name</label>
								<input type="text" class="form-control" id="FirstName" name="FirstName" required>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="inputLastName">Last Name</label>
								<input type="text" class="form-control" id="LastName" name="LastName" required>
							</div>
						</div>
					</div>            
					<div class="form-group">
						<label for="inputEmail">Email Address</label>
						<input type="email" class="form-control" id="Email" name="Email" required>
					</div>
					<div class="form-group">
						<label for="inputMessage">Message</label>
						<textarea class="form-control" id="Message" name="Message" rows="5" required></textarea>
					</div>
					<button type="submit" class="btn btn-primary" name = "contact" > Submit </button>
				</form>
				
			</div>
		</div>
	</div>
</section>

<jsp:include page="includes/footer.jsp" />  