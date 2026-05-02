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
        <h2>Authors List</h2>
    </header>
    <div class="content">
    
    <div class="buttons">
    <a href="/authors/new" class="btn"> Add Author</a>
    <a href="/" class="btn">Back Home</a>
    </div>

    <br><br>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>DOB</th>
            <th>Action</th>
        </tr>

        <c:forEach var="author" items="${authors}">
            <tr>
                <td>${author.getAId()} </td>      
                <td>${author.getFname()}</td>    
                <td>${author.getLname()}</td>    
                <td>${author.getDob()}</td>    
                <td>
                    <a href="/authors/edit/${author.getAId()}" class="btn btn-sm">Edit</a> 
                </td>
            </tr>
        </c:forEach>
    </table>
        </div>
</div>
</body>
</html>
