<%-- 
    Document   : listaClientesDeuda
    Created on : 08/11/2019, 06:43:50
    Author     : Diego
--%>
<%
    HttpSession sesion = request.getSession();
    Object usuario = sesion.getAttribute("usuario");

    if (usuario == null) {
        response.sendRedirect("/TPCAYUN/LoginServlet?accion=cerrar");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Login</title>
        
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <link href="css/cssMio.css" rel="stylesheet" type="text/css"/>
    
        <link rel="shortcut icon" href="Assets/Images/front/simbolo0.ico" type="image/x-icon"/>
    
    
        <!--Fontawesome CDN-->
       <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
       <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
  
  <body style="">
    <header>
        <nav id="nav" class="navbar nav-transparent">
            <div class="container">
                <div class="navbar-header">
                    <div class="navbar-brand">
                        <a href="https://www.frc.utn.edu.ar/"> 
                            <img class="logo" src="Assets/Images/front/logoutn.png" alt="logo">
                            <img class="logo-alt" src="Assets/Images/front/logoutn2.png" alt="logo">
                        </a>
                    </div>
                    <div class="nav-collapse">
                        <span></span>
                    </div>
                 </div>
                
                <ul class="main-nav nav navbar-nav navbar-right tamañoMenu">
                    <li class=""><a href="index.jsp">Home</a></li>
                     <li class="has-dropdown "><a href="">Catalogo</a>
                        <ul class="dropdown">
                            <li><a href="/TPCAYUN/listaCatalogoServlet">Vigentes</a></li>
                            <li><a href="/TPCAYUN/agregarCatalogoServlet">Crear Nuevo</a></li>
                        </ul>
                    </li>
                     <li class="has-dropdown active"><a href="">Clientes</a>
                        <ul class="dropdown">
                            <li><a href="/TPCAYUN/listaCienteServlet">Lista</a></li>
                            <li><a href="/TPCAYUN/listaClienteDeudaServlet">Lista con deuda</a></li>
                            <li><a href="/TPCAYUN/modificacionImporteServlet">Actualizar Importe</a></li>
                            <li><a href="/TPCAYUN/agregarCliente">Alta Cliente</a></li>
                        </ul>
                    </li>
                    <li class="has-dropdown"><a href="">Articulos</a>
                        <ul class="dropdown">
                            <li><a href="/TPCAYUN/listarArticulosServlet">Lista</a></li>
                            <li><a href="/TPCAYUN/agregarArticuloServlet">Alta</a></li>
                        </ul>
                    </li>
                     <li class="has-dropdown"><a href="">Rubro</a>
                        <ul class="dropdown">
                            <li><a href="/TPCAYUN/listaRubrosServlet">Lista</a></li>
                            <li><a href="/TPCAYUN/agregarRubroServlet">Alta</a></li>
                        </ul>
                    </li>
                     <li class="has-dropdown"><a href="">Ventas</a>
                        <ul class="dropdown">
                            <li><a href="/TPCAYUN/listaVentasServlet">Lista</a></li>
                            <li><a href="/TPCAYUN/listaVentasClienteServlet">Lista por Cliente</a></li>
                            <li><a href="/TPCAYUN/AgregarVentaServlet">Alta</a></li>
                        </ul>
                    </li>
                     <li class="has-dropdown"><a href="">Reportes</a>
                        <ul class="dropdown">
                            <li><a href="/TPCAYUN/listarReportes?r=1">Reporte 1</a></li>
                            <li><a href="/TPCAYUN/listarReportes?r=2">Reporte 2</a></li>
                            <li><a href="/TPCAYUN/listarReportes?r=3">Reporte 3</a></li>
                            <li><a href="/TPCAYUN/listarReportes?r=4">Reporte 4</a></li>
                        </ul>
                    </li>
                    <li><a href="/TPCAYUN/LoginServlet?accion=cerrar">Cerrar Sesión</a></li>
                </ul>
            </div>
        </nav>
    </header>

      
      
      
<!-------------------------------------------HOME---------------------------------------------------->      
    <div id="home">
            <div class="bg-img" style="background-image: url(&#39;Assets/Images/front/fondo.jpg&#39;);">
                <div class="overlay"></div>
            </div>  

            <div class="principal ">

                          

                
                <div class="secundarioCliente table-wrapper-scroll-y my-custom-scrollbar2">
           <h1>LISTADO DE CLIENTES</h1>
        <table class="table table-hover table-dark">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">NOMBRE</th>
                <th scope="col">APELLIDO</th>
                <th scope="col">DOMICILIO</th>
                <th scope="col">TELEFONO</th>
                <th scope="col">SALDO</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaC}" var="c">      
                    <tr>
                      <th scope="row">${c.getIdCliente()}</th>
                      <td>${c.getNombre()}</td>
                      <td>${c.getApellido()}</td>
                      <td>${c.getDomicilio()}</td>
                      <td>${c.getTelefono()}</td>
                      <td>${c.getSaldo()}</td>
                      <td><a href="/TPCAYUN/listaClienteDeudaServlet?id=${c.getIdCliente()}"><button type="button" class="btn btn-outline-danger">CANCELAR DEUDA</button></a></td>
                      <td><a href="/TPCAYUN/agregarPagoServlet?id=${c.getIdCliente()}"><button type="button" class="btn btn-outline-success">PAGO PARCIAL</button></a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
                        
                </div>
            </div>
    </div>
   
 <!-------------------------------------------FIN HOME------------------------------------------------>     
      
      
      
    <footer id="footer" class="sm-padding bg-dark">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="footer-logo">
                    <a href="https://www.frc.utn.edu.ar/"><img src="Assets/Images/front/logoutn2.png" alt="logo"></a>
                    </div>
                    <div class="footer-copyright">
                    <p>Copyright © 2019. All Rights Reserved. Designed by CAYUN DIEGO</p>
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <div id="back-to-top" style="display: none;"></div>
    
    <script type="text/javascript" src="Bootstrap/jquery.min.js.descarga"></script>
    <script type="text/javascript" src="Bootstrap/bootstrap.min.js.descarga"></script>
    <script type="text/javascript" src="Bootstrap/owl.carousel.min.js.descarga"></script>
    <script type="text/javascript" src="Bootstrap/jquery.magnific-popup.js.descarga"></script>
    <script type="text/javascript" src="Bootstrap/main.js.descarga"></script>
</body>
</html>




        
       