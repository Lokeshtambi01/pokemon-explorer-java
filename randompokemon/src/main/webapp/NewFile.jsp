<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Random Pokemon Generator</title>
<style type="text/css">
body{
height: 97vh;
display: flex;
justify-content: center;
align-items: center;
}
div{
display:flex;
flex-direction: column;
align-items:center;
}
img{
width: 300px;
height: 300px;
}
</style>
</head>
<body>
<div>
<form action="generate">

<button>Generate Random Pokemon</button>

</form>
<img alt="" src="${image} ">
<h1>${name}</h1>
</div>
</body>
</html>