<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<form:form action="/login" modelAttribute="loginModel" method="POST">
						<fieldset>
							<legend>Login</legend>
							
							<div class="form-group">
								<form:errors path="*" cssClass="error"/>
							</div>
							<div class="form-group">
	  							<label class="control-label" for="focusedInput">E-mail address</label>
								<form:input path="email" cssClass="form-control" title="E-mail address" />
								
								<label class="control-label" for="focusedInput">Password</label>
								<form:password path="password" cssClass="form-control" title="Password" />
							</div>
														
							<div class="form-group">
								<span class="input-group-btn">
									<input type="submit" class="btn btn-primary btn-block">
								</span>
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>

			<div class="already">
				<p>Don't have an account yet?
					<a href="${pageContext.request.contextPath}/register">Register</a>
				</p>
			</div>
		</div>
	</div>
</div>