<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap Login Form</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <style type="text/css">
     body{background-color: #f1f1f1;}
     .bslf{
    width: 350px;
  margin: 120px auto;
  padding: 25px 20px;
  background: #3a1975;
  box-shadow: 2px 2px 4px #ab8de0;
  border-radius: 5px;
  color: #fff;
     }
     .bslf h2{
    margin-top: 0px;
  margin-bottom: 15px;
  padding-bottom: 5px;
  border-radius: 10px;
  border: 1px solid #25055f;
     }
     .bslf a{color: #783ce2;}
     .bslf a:hover{
    text-decoration: none;
      color: #03A9F4;
     }
     .bslf .checkbox-inline{padding-top: 7px;}
  </style>
</head>
<body>
  <div class="bslf">
    <form action="" method="post">
      <h2 class="text-center">Please login</h2>
      <div class="form-group">
        <input type="text" name="log" class="form-control" placeholder="Username" required="required">
      </div>
      <div class="form-group">
        <input type="password" name="pwd" class="form-control" placeholder="Password" required="required">
      </div>
      <div class="form-group clearfix">
        <label class="checkbox-inline pull-left"><input type="checkbox"> Remember me</label>
        <button type="submit" class="btn btn-primary pull-right">Log in</button>
      </div>
      <div class="clearfix">
        <a href="#" class="pull-left">Forgot Password?</a>
        <a href="#" class="pull-right">Create an Account</a>
      </div>
    </form>
    ${requestScope.error}
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
