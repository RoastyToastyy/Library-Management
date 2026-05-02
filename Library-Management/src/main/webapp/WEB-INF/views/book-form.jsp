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
        <h2>Create Book</h2>
    </header>
    <div class="content">
       <a href="/books" class="btn">Back</a>

<form action="/books/save" method="post">

    Title: <input type="text" name="title" required minlength="2" maxlength="100"><br>
    ISBN: <input type="text" name="isbn" required pattern="[0-9-]{10,13}"><br>
    Genre: <input type="text" name="genre" required maxlength="50"><br>
    
    Author:
    <select name="authorId" required>
        <c:forEach var="author" items="${authors}">
           <option value="${author.getAId()}"> 
                ${author.getFname()} ${author.getLname()}
            </option>
        </c:forEach>
    </select>

    <br><br>
    <button type="submit" class="btn">Save</button>
</form>
<p style="color:red">${error}</p>
    </div>
</div>
</body>
</html>


