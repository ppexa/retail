<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Hello</title>
	<%-- Bootstrap --%>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<div class="container">
	<h2>Create Product</h2>
	<form method="post" action="createFromForm">
		Name: <input type="text" name="name"/><br/><br/>
		Price: <input type="text" name="price"><br/><br/>
		Currency <input type="text" name="currency"><br/><br/>
		Department:
		<select name="department">
			<option>Entertainment</option>
			<option>Outdoor</option>
			<option>Apparel</option>
			<option>Home</option>
			<option>Misc</option>
		</select><br/><br/>
		<button type="submit">Add Product</button>
	</form>

</div>

</body>
</html>