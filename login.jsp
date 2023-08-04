<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <style>
  @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');
*{
  margin:0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}
 html{
  background: url("https://media.istockphoto.com/id/1266975549/vector/mobile-bank-conceptual-illustration-internet-online-banking-on-phone-access-to-the-money-on.jpg?s=612x612&w=0&k=20&c=U4i9L--l0sVcqI59HnyFRK6Q11KZQwHPUEk_5iNhTWI=");
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  height: 600px;
 
 }

body{
  display: grid;
  place-items: center;
  text-align: center;
  background-size: cover;
  
 

  
}

.content{
  width: 330px;
 
  border-radius: 10px;
  padding: 40px 30px;
  margin-top: 100px;

  background: rgba(255, 255, 255, 0.178);
    backdrop-filter: blur(10px);
}


.content .text{
  font-size: 25px;
  font-weight: 600;
  margin-bottom: 35px;
  color: rgb(247, 233, 233);
}

.content .field{
  height: 50px;
  width: 100%;
  display: flex;
  position: relative;
}

.field input{
  height: 100%;
  width: 100%;
  padding-left: 45px;
  font-size: 18px;
  outline: none;
  border: none;
  color: #e0d2d2;
 
  border-radius: 8px;
  background: rgba(19, 18, 18, 0);
  backdrop-filter: blur(10px);
}


.field input::placeholder{
  color: #e0d2d2a6;
}
.field:nth-child(2){
  margin-top: 20px;
}

.field span{
  position: absolute;
  width: 50px;
  line-height: 50px;
  color: #ffffff;
}



button{
  margin: 25px 0 0 0;
  width: 100%;
  height: 50px;
  color: rgb(238, 226, 226);
  font-size: 18px;
  font-weight: 600;
  background: rgba(255,255,255,0.05);
    backdrop-filter: blur(10px);
  border: none;
  outline: none;
  cursor: pointer;
  border-radius: 8px;
 
}
 

 
.icon-button{
  margin-top: 15px;
}
.icon-button span{
  padding-left: 17px;
  padding-right: 17px;
  padding-top: 6px;
  padding-bottom: 6px;
   color: rgba(244, 247, 250, 0.795);
 border-radius: 5px;
  line-height: 30px;
  background: rgba(255, 255, 255, 0.164);
    backdrop-filter: blur(10px);
}

}
button:hover,
.icon-button span:hover{
  background-color: #babecc8c;
}
 
    </style>
</head>
<body>
  
<!--==== Design +by foolishdeveloper.com ====-->

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<div class="content">
 <div class="text">Login</div>
  <form action="Login" method="post">
    <div class="field">
      <span class="fa fa-user"></span>
      <input type="text" name="cust_id" placeholder="Customer Id"  required>
   
    </div>
    <div class="field">
      <span class="fa fa-lock"></span>
      <input type="text" name="pin" placeholder="Pin">
      
    </div>
    
    <button>Log in</button>
    
  </form>
</div>

</body>
</html>