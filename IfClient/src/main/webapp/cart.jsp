<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
    
<!DOCTYPE html>
<div class="dropdown cart-dropdown">
                                <a href="#" class="dropdown-toggle" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-display="static">
                                    <div class="icon">
                                        <i class="icon-shopping-cart"></i>
                                        <span class="cart-count">${fn:length(cart) }</span>
                                    </div>
                                    <p>Cart</p>
                                </a>

                                <div class="dropdown-menu dropdown-menu-right">
                                    <div class="dropdown-cart-products">
                                    <c:forEach items="${cart}" var="product" >
                                        <div class="product">
                                            <div class="product-cart-details">
                                                <h4 class="product-title">
                                                    <a href="product.html">${product.name}</a>
                                                </h4>

                                                <span class="cart-product-info">
                                                    
                                                    <fmt:formatNumber type = "number" 
         minFractionDigits="2" maxFractionDigits="2" value = "${product.price}" /> ${currency}
                                                </span>
                                            </div><!-- End .product-cart-details -->

                                            <figure class="product-image-container">
                                                <a href="product.html" class="product-image">
                                                    <img src="${product.url}" alt="product">
                                                </a>
                                            </figure>
                                            <a href="#" class="btn-remove" title="Remove Product"><i class="icon-close"></i></a>
                                        </div><!-- End .product -->
</c:forEach>
                                      
                                    </div><!-- End .cart-product -->

                                    <div class="dropdown-cart-total">
                                        <span>Total</span>

                                        <span class="cart-total-price"><fmt:formatNumber type = "number" 
         minFractionDigits="2" maxFractionDigits="2" value = "${total}" /> ${currency}</span>
                                    </div><!-- End .dropdown-cart-total -->

                                    <div class="dropdown-cart-action">
                                        <a href="cartDetails" class="btn btn-primary">View Cart</a>
                                        
                                    </div><!-- End .dropdown-cart-total -->
                                </div><!-- End .dropdown-menu -->
                            </div><!-- End .cart-dropdown -->