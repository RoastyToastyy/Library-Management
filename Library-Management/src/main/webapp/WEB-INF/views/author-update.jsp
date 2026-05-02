<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Management</title>
    <link rel="stylesheet" href="/css/library.css">
</head>
<body>
<div class="container">
    <header>
        <h2>Update Author</h2>
    </header>
    <div class="content">
       <a href="/authors">Back</a>

<form action="/authors/update" method="post">

    <input type="hidden" name="aId" value="${author.getAId()}">  

    First Name: <input type="text" name="fname" value="${author.getFname()}"><br><br>  
    Last Name: <input type="text" name="lname" value="${author.getLname()}"><br><br>   
    DOB: <input type="date" name="dob" value="${author.getDob()}"><br><br>         

    <button type="submit">Update</button>
</form>
    </div>
</div>
</body>
</html>


