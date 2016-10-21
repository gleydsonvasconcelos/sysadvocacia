<%-- 
    Document   : cabecalho
    Created on : 21/10/2016, 11:28:08
    Author     : Adriano
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SysAdvocacia | Página Inicial</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Droid+Sans|Droid+Serif:400,400italic,700italic">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
        <link href="css/estilo.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
        <script src="http://code.jquery.com/jquery-1.12.4.min.js"   integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="   crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div id="custom-bootstrap-menu" class="navbar navbar-default teste-shadow3" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header"><a class="navbar-brand" href="#">SysAdvocacia</a>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse navbar-menubuilder">
                    <ul class="nav navbar-nav navbar-left">
                        <li><a href="<c:url value="/" />">Página Inicial</a>
                        </li>
                        <li><a href="<c:url value="/processos.jsp" />">Processos</a>
                        </li>
                        <li><a href="<c:url value="/clientes.jsp" />">Clientes</a>
                        </li>
                        <li><a href="<c:url value="/advogados.jsp" />">Advogados</a>
                        </li>
                        <li><a href="<c:url value="/lei.jsp" />">Leis</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>