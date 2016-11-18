<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<#import "/spring.ftl" as spring/>
<html> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>freemarker test</title><br> 
	</head>
<body><br> 
	<h1>demo info:</h1><br> 
	code:${demo.code}<br>
	<@spring.message  code ="hello"/>
</body>
</html> 