<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!-- Nav bar for search bar, my account button, and shopping cart button -->
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #3071A9;"id="navcolor">
    
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home.jsp">
        <img class="navbar-image"src="${pageContext.request.contextPath}/images/logo3.png" alt="PawsCo"></a>
        
        <!-- Search Bar Form -->
        <form id="searchBar"class=" form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/products.jsp">
            <input id="searchProductInput" class="form-control mr-sm-2" type="search"
                placeholder="Search" aria-label="Search" >
            <button id="searchButton" class="btn btn-danger" type="submit">Search</button>
        </form>
        
        <c:if test="${not empty cookie.userEmail}">
        	<c:out value="Welcome back, ${user.firstName}!"/>
        </c:if>

 <!-- Nav tag for second level selections for categories and home button -->
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #3071A9;">
            <div class="homeNav collapse navbar-collapse"
                id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
              
                    <li id="home" class="btn btn-danger"
                        ><a id="home"
                        class="nav-link" href="${pageContext.request.contextPath}/home.jsp">Home <span class="sr-only">(current)</span>
                    </a></li>
                    <!-- Products button that will redirect to the products page -->
                    <li id="product" class="btn btn-danger"
                        >
                        <a id="product" class="nav-link" href="${pageContext.request.contextPath}/products.jsp">Products</a>
                    </li>
                    
                </ul>
            </div>
        </nav>
        
        <!--        MyAccount button that will redirect to the My Account page -->
        <div class="btn-group">
        	<a id="signin-reg" class="signin-RegisterBtn btn btn-danger" 
        	href="${pageContext.request.contextPath}/register.jsp">Sign in/Register</a>
            <button type="button"
                class="MyAccountBtn btn btn-danger dropdown-toggle"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">My
                Account</button>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/myAccount.jsp">Profile</a>
                <a class="dropdown-item" href="#">Orders</a> <a
                    class="dropdown-item" href="#">Wishlist</a> <a
                    class="dropdown-item" href="#">Logout</a>
            </div>
            <!-- MyCart button to see what is in your cart -->
            <a id="cart" class="nav-link btn btn-danger" href="${pageContext.request.contextPath}/myCart.jsp">Cart</a>
            
        </div>
    </nav>
