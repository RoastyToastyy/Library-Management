<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Books List</title>
    <link rel="stylesheet" href="/css/library.css">
</head>
<body>
<div class="container">
    <header>
        <h2>Books List</h2>
    </header>
    <div class="content">
        <div class="buttons">
       <a href="/books/new" class="btn"> Add Book</a>
        <a href="/" class="btn">Back Home</a>
        </div>
        <br><br>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>ISBN</th>
                <th>Genre</th>
                <th>Author</th>
                <th>Action</th>
            </tr>

            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.getId()}</td>             
                    <td>${book.getTitle()}</td>           
                    <td>${book.getIsbn()}</td>            
                    <td>${book.getGenre()}</td>           
                    <td>${book.getAuthor().getFname()} ${book.getAuthor().getLname()}</td> 
                    <td>
                        <a href="/books/edit/${book.getId()}" class="btn btn-sm">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
            </div>
</div>
</body>
</html>


