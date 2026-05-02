<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h2>Update Book</h2>
    </header>
    <div class="content">
        <a href="/books">Back</a>

<form action="/books/update" method="post">

    <input type="hidden" name="id" value="${book.getId()}"> 

    Title: <input type="text" name="title" value="${book.getTitle()}"><br><br>  
    ISBN: <input type="text" name="isbn" value="${book.getIsbn()}"><br><br>     
    Genre: <input type="text" name="genre" value="${book.getGenre()}"><br><br>  

    Author:
    <select name="authorId">
        <c:forEach var="author" items="${authors}">
            <option value="${author.getAId()}">  
                ${author.getFname()} ${author.getLname()}  
            </option>
        </c:forEach>
    </select>

    <br><br>
    <button type="submit">Update</button>
</form>
    </div>
</div>
</body>
</html>


