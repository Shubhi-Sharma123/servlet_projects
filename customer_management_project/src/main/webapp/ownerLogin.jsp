<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OwnerLogin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<section class="h-100 h-custom" style="background-color: #8fc4b7;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-8 col-xl-6">
					<div class="card rounded-3">
						<img
							src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
							class="w-100"
							style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
							alt="Sample photo">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Welcome to
								Owner Login</h3>

							<form class="px-md-2" action="loginowner" method="post">

								<div class="form-outline mb-4">
									<label class="form-label" for="form3Example1q">OwnerId</label>
									<input type="text" name="ownerId" class="form-control"
										placeholder="enter owner id" />

								</div>
								&nbsp;

								<div class="form-outline mb-4">
									<label class="form-label" for="form3Example1q">OwnerPassword</label>
									<input type="text" name="ownerPassword" class="form-control"
										placeholder="enter owner password" />

								</div>
								&nbsp;

								<div class="form-outline mb-4">
									<label class="form-label" for="form3Example1q">OwnerPasscode</label>
									<input type="text" name="ownerPasscode" class="form-control"
										placeholder="enter owner passcode" />

								</div>
								&nbsp;

								<div>
									<button type="submit" class="btn btn-success btn-lg mb-1">Submit</button>
									&nbsp;&nbsp;&nbsp;
									<button type="reset" class="btn btn-success btn-lg mb-1">Reset</button>
									&nbsp;&nbsp;&nbsp; <a href="ownerDisplay" target="blank_"><button
											type="submit" class="btn btn-success btn-lg mb-1">ShowOwners</button></a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div></div>
</body>
</html>