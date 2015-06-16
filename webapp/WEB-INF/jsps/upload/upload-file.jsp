<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload file</title>
</head>
<body>
	<h4>上传文件表单</h4>
	<form action="upload-image" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td><span style="color: blue">选择图片：</span></td>
				<td><input type="file" name="filea"/><span style="color: green">${message}</span></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="上传" /></td>
			</tr>
		</table>
	</form>
</body>
</html>