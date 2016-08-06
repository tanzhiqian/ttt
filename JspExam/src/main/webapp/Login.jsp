<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>用户登陆界面</title>
<script type="text/javascript">
function chekUserName(){
 var username= document.all("username").value;
 var div=document.all("div");
 var flag=false;
 if(username.length==0){
 
    div.innerHTML="<font color='red'>用户名不能为空</font>";
    div.style.display="inline";
 }
 else{
 flag=true;
  div.style.display="none";
 }
 return flag;
}
function chekUserPwd(){
var userpwd= document.all("userpwd").value;
 var div1=document.all("div1");
  var flag=false;
 if(userpwd.length==0){
 
    div1.innerHTML="<font color='red'>密码不能为空</font>";
    div1.style.display="inline";
 }
 else{
 flag=true;
 div1.style.display="none";
 }
 return flag;
}
function chekSubMit(){
 var flag=false;
 if(chekUserName()&&chekUserPwd()){
       flag=true;
 }
 return flag;
 }
</script>
</head>
<body><%request.setCharacterEncoding("UTF-8"); %>
	<form action="Login" method="post">
		用户名：<input type="text" name="username"><br/>
		<input type="submit" value="登录">
	</form>
</body>
</html>