<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="main-header-div">
		<div style="width: 80%; display: inline-table">
			<div style="display: table-row">
				<div style="display: table-cell">
					<div style="display: inline">
						<a href="home.jsp" style="display: inline-block">
							<img src="images/logo3.png">
						</a>
						<div class="dropdown" style="display: inline-block">
							<a class="navbtn dropbtn" href="products.jsp">Products</a>
							<div class="dropdown-content">
								<a href="products.jsp?filter=Food">Food</a>
								<a href="products.jsp?filter=Toys">Toys</a>
								<a href="products.jsp?filter=Furniture">Furniture</a>
								<a href="products.jsp?filter=Grooming">Grooming</a>
								<a href="products.jsp?filter=Apparel">Apparel</a>
							</div>
						</div>
					</div>
				</div>
				<div id="searchBar" style="display: table-cell; text-align: center; width: 40%">
					<form action="products.jsp" method="get">
						<input class="search-box" type="text" name="search" placeholder="Search">
						<button type="submit" class="search-btn"><i class="fas fa-search"></i> Search</button>
					</form>
				</div>
				<div style="display: table-cell">
					<c:choose>
						<c:when test="${sessionScope.user != null}">
							<c:url var="btnURL" value="myAccount.jsp"/>
							<c:set var="btnLabel" value="Hello, ${sessionScope.user.firstName}!"/>
						</c:when>
						<c:otherwise>
							<c:url var="btnURL" value="signin.jsp"/>
							<c:set var="btnLabel" value="Sign In/Register"/>
						</c:otherwise>
					</c:choose>
					<a class="navbtn" href="${btnURL}">
						<i class="fas fa-user"></i> ${btnLabel}
					</a>
					<a class="navbtn" href="myCart.jsp">
						<i class="fas fa-shopping-cart"></i> Cart
						<c:if test="${sessionScope.cart != null}">
						</c:if>
					</a>
					<br>
					<c:if test="${sessionScope.user != null}">
						<a class="logout" href="logout">Sign Out</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>