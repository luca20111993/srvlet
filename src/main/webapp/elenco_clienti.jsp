<%-- 
    Document   : elenco_clienti
    Created on : 13-feb-2017, 14.01.16
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elenco Clienti</title>
    </head>
    <body>
        <table style="margin: 0 auto">
            
            <th>Id</th>
            <th>RagSoc</th>
            <th>Indirizzo</th>
            
            <!-- con questa tag possiamo rendere la tabella dinamica
            Per ogni giro avrò la mia variabile di cliente.-->
            <c:forEach items="${clientiSrv.findAll()}" var="cli">
              
            <tr>
                <td>   <c:out value="${cli.id}"/>  </td>
                <td>   <c:out value="${cli.ragioneSociale}"/>  </td>
                <td>   <c:out value="${cli.indirizzo}"/>  </td>
                
            </tr>
            </c:forEach>
        </table>
        
        <a href="index.html" >Home</a>
    </body>
</html>
