<nav
	class="navbar navbar-toggleable-md navbar-inverse bg-primary custom-navbar">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarNavDropdown"
		aria-controls="navbarNavDropdown" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="#"><img
		src="../assets/images/logo.png" width="60" height="60" alt=""></a>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">

			<li class="nav-item active"><a class="nav-link" href="frontpage">Home</a></li>
			<li class="nav-item active"><a class="nav-link" href="accounts">Accounts</a></li>
			<li class="nav-item active"><a class="nav-link" href="payments">Payments</a></li>
			<li class="nav-item active"><a class="nav-link" href="contact">Contact</a></li>

		</ul>
	</div>
	<p class="col-2" style="color: white">Logged in as: <br>${user.fullName}</p>
	<div>
		<form class="form-inline my-2 my-lg-0" action="LogOutServlet"
			method="post">
			
			<button class="btn btn-primary my-2 my-sm-0" type="submit">Log
				Out</button>
		</form>
	</div>
</nav>