<%-- 
    Document   : historicos
    Created on : 20/10/2016, 10:47:14
    Author     : Adriano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:import url="/cabecalho.jsp" />
<div class="container-page">


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>sysadvocacia | Históricos de Processo</title>
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
        <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    </head>
    <body>
        <h2>Históricos de Processo</h2>
        <table id="dg" title="Clientes" class="easyui-datagrid" style="width:800px;height:400px"
               url="ListarHistoricos"
               toolbar="#toolbar" pagination="true"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="codigo" width="50">Código</th>
                    <th field="data" width="150">Data</th>
                    <th field="descricao" width="80">Descrição</th>
                    <th field="parecer" width="200">Parecer</th>
                    <th field="statusanterior" width="100">Status</th>
                </tr>
            </thead>
        </table>
      
        <style type="text/css">
            #fm{
                margin:0;
                padding:10px 30px;
            }
            .ftitle{
                font-size:14px;
                font-weight:bold;
                padding:5px 0;
                margin-bottom:10px;
                border-bottom:1px solid #ccc;
            }
            .fitem{
                margin-bottom:5px;
            }
            .fitem label{
                display:inline-block;
                width:80px;
            }
            .fitem input{
                width:160px;
            }
        </style>
</div>
<c:import url="/rodape.jsp" />
