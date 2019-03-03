<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="menu-nav">
   <ul>
      <li class="first"><a href="do?command=Main">Главная</a></li>
            <li><a href="do?command=Duties">Duties</a></li>
            <li><a href="do?command=Currency">Currency</a>
               <ul>
                   <li><a href="do?command=AllCurrency">AllCurrency</a></li>
                   <li><a href="do?command=RateNB">RateNB</a></li>
                   <li><a href="do?command=RateCB">RateCB</a></li>
               </ul>
            </li>
            <li><a href="do?command=Operation">Operation</a>
               <ul>
                   <li><a href="do?command=Payment">Payment</a></li>
                   <li><a href="do?command=Balance">Balance</a></li>
                   <li><a href="do?command=UserOperations">UserOperations</a></li>
               </ul>
            </li>
            <li><a href="do?command=Report">Report</a>
               <ul>
                   <li><a href="do?command=SprReports">SprReports</a></li>
                   <li><a href="do?command=Entries">Entries</a></li>
               </ul>
            </li>
        <li><a href="do?command=Exit">Exit</a></li>
   </ul>
</div>
