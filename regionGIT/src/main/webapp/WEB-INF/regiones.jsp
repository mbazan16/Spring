<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename = "app" />

 <link rel="stylesheet" type="text/css" href="${context}/css/estilo.css">
 <link
rel="stylesheet"
type="text/css"
href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css"
/>
 <meta charset="ISO-8859-1">
<title><fmt:message key="region.listado"/></title>

<script
type="text/javascript"
charset="utf8"
src="https://code.jquery.com/jquery-3.5.1.js"
></script>
<script
type="text/javascript"
charset="utf8"
src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js">
</script>
<c:if test="${locale == null || locale == 'es_ES'}">
<script>
$(document).ready( function () {
    $('#table_id').DataTable({    	 
          "language": {
            "url": "https://cdn.datatables.net/plug-ins/1.11.5/i18n/es-ES.json"
        }
    });
} );
</script>
</c:if>
<c:if test="${locale != null && locale == 'en_US'}">
<script>
$(document).ready( function () {
    $('#table_id').DataTable();
} );
</script>
</c:if>
</head>
<body>

<header>

</header>
<main>
<div id="listadoRegiones">
<h1><fmt:message key="region.listado"></fmt:message></h1>
<table id="table_id">
<thead>
<tr>
	<th><fmt:message key="region"/></th>
	<th><fmt:message key="label.acciones"/></th>
</tr>
</thead>
<tbody>
<c:forEach items="${listado}" var="region">
<tr>
<td>${region.nombre}</td>
<td></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<div id="crearRegion">
<h1><fmt:message key="region.crear"/></h1>
<form method="post" action="${context}/region/n">
<label for="nombre"><fmt:message key="label.nombre"/></label>
<input type="text" name="nombre" required>
<button><fmt:message key="button.enviar"/></button>
</form>

</div>
<div id="messages">
<c:if test="${message!=null}">
	${message}
</c:if>
</div> 
</main>
<footer>

</footer>

</body>
</html>