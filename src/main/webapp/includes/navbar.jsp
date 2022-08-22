
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="container">
  <a class="navbar-brand" href="index.jsp" style="color:orchid; font-family:cursive; font-weight:bold; font-variant: small-caps; ">FoodCart </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item "><a class="nav-link" href="index.jsp"  style="color:crimson;">Home </a></li>
      <li class="nav-item"><a class="nav-link" href="cart.jsp"   style="color:crimson;">Cart<span class="badge badge-danger px-1">${cart_list.size()}</span></a></li>
      <% 
     
      if(auth!=null){%>
    	  <li class="nav-item"><a class="nav-link" href="orders.jsp"  style="color:crimson;" >Orders</a></li>
          <li class="nav-item"><a class="nav-link" href="log-out"  style="color:crimson;" >Logout</a></li>
     <% }else{ %> 
    	  <li class="nav-item"><a class="nav-link" href="login.jsp"   style="color:crimson;">Login</a></li>
      <% }
      %>

      
      
      
    </ul>
    
  </div>
  </div>
</nav>
