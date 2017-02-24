<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
 
<html>
<head>
<title>${title}</title>
</head>
<body>
    <jsp:include page="_menu.jsp" />
 
    <h2>Admin Page</h2>
 
 
    <h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
 
    <b>This is protected page!</b>  
    
    <table border="1">
    	<tr>
    		<td>ID</td>
    		<td>ID_CARICO</td>
    		<td>C_L</td>
    		<td>DEPOSITO</td>
    		<td>SP</td>
    		<td>SV</td>
    		<td>SL</td>
    		<td>L</td>
    		<td>VOCE</td>
    		<td>QUAL</td>
    		<td>ET_FORN</td>
    		<td>PESO</td>
    		<td>NUMPZ</td>
    		<td>NOTA</td>
    	</tr>
    	<c:forEach var="mat" items="${list}">
    	<tr>
    		<td>${mat.getID()}</td>
    		<td>${mat.getID_CARICO()}</td>
    		<td>${mat.getC_L()}</td>
    		<td>${mat.getDEPOSITO()}</td>
    		<td>${mat.getSP()}</td>
    		<td>${mat.getSV()}</td>
    		<td>${mat.getSL()}</td>
    		<td>${mat.getL()}</td>
    		<td>${mat.getVOCE()}</td>
    		<td>${mat.getQUAL()}</td>
    		<td>${mat.getET_FORN()}</td>
    		<td>${mat.getPESO()}</td>
    		<td>${mat.getNUMPZ()}</td>
    		<td>${mat.getNOTA()}</td>
    	</tr>  	
    	</c:forEach>
    </table>
</body>
</html>