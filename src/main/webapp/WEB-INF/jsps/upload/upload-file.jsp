<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload file</title>
</head>
<body>
	<form action="/upload-image" method="POST" enctype="">
		<span >选择图片：</span><input type="file" name="image" />
		<input type="submit" value="上传" />
	</form>
</body>
</html>