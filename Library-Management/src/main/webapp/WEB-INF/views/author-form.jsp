<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Author</title>
    <link rel="stylesheet" href="/css/library.css">
</head>
<body>
<div class="container">
    <header>
        <h2>Create Author</h2>
    </header>
    <div class="content">
        <a href="/authors" class="btn">Back</a>

        <form action="/authors/save" method="post">

            First Name: 
            <input type="text" name="fname" **required** minlength="2"><br><br>
            
            Last Name: 
            <input type="text" name="lname" **required** minlength="2"><br><br>
            
            DOB: 
            <input type="date" name="dob" **required** max="2010-01-01"><br><br>

            <button type="submit" class="btn">Save</button>
        </form>

        <p style="color:red">${error}</p>
    </div>
</div>
</body>
</html>


