<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
<!DOCTYPE html>
<html lang="pl" ng-app>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
 
    <title></title>
    <script type="text/javascript" src="/js/angular.min.js"></script>
    </head>
	<body>
 
	<input type="text" ng-model="name" ng-pattern="/^\d+$/" />{{ name }}
 
	</body>
</html>
