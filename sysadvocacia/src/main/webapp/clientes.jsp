<%-- 
    Document   : advogados
    Created on : 16/10/2016, 20:50:11
    Author     : Gleydson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:import url="/cabecalho.jsp" />
<div class="container-page">


<!DOCTYPE html>
        <h2>Cadastro de Clientes</h2>
        <p>Listar, Cadastrar, Alterar e Remover Clientes do Sistema</p>
        <table id="dg" title="Clientes" class="easyui-datagrid" style="width:1000px;height:400px"
               url="ListarClientes"
               toolbar="#toolbar" pagination="true"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="codigo" width="50">Código</th>
                    <th field="nome" width="150">Nome</th>
                    <th field="cpfCnpj" width="80">CPF/CNPJ</th>
                    <th field="endereco" width="100">Endereço</th>
                    <th field="telefone" width="80">Telefone</th>
                </tr>
            </thead>
        </table>
        <div id="toolbar">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">Novo Cliente</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Alterar Cliente</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remover Cliente</a>
        </div>

        <div id="dlg" class="easyui-dialog" style="width:400px;height:300px;padding:10px 20px"
             closed="true" buttons="#dlg-buttons">
            <div class="ftitle">Informações do Cliente</div>
            <form id="fm" method="post"  action="SalvarCliente" novalidate>
                <input type="hidden" name="codigo"/>
                <div class="fitem">
                    <label>Nome:</label>
                    <input name="nome" class="easyui-textbox" required="true">
                </div>
                <div class="fitem">
                    <label>CPF:</label>
                    <input name="cpfCnpj" class="easyui-textbox" required="true">
                </div>
                <div class="fitem">
                    <label>Endereço:</label>
                    <input name="endereco" class="easyui-textbox">
                </div>
                <div class="fitem">
                    <label>Telefone</label>
                    <input name="telefone" class="easyui-textbox" >
                </div>
            </form>
        </div>
        <div id="dlg-buttons">
            <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Salvar</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancelar</a>
        </div>

        <script type="text/javascript">
            var url;
            function newUser() {
                $('#dlg').dialog('open').dialog('setTitle', 'Novo Advogado');
                $('#fm').form('clear');
                url = 'SalvarCliente';
            }
            function editUser() {
                var row = $('#dg').datagrid('getSelected');
                if (row) {
                    $('#dlg').dialog('open').dialog('setTitle', 'Alterar Cliente');
                    $('#fm').form('load', row);
                    url = 'SalvarCliente';
                }
            }
            function saveUser() {
                $('#fm').form('submit', {
                    url: url,
                    onSubmit: function () {
                        return $(this).form('validate');
                    },
                    success: function (result) {
                        var result = eval('(' + result + ')');
                        if (result.errorMsg) {
                            $.messager.show({
                                title: 'Error',
                                msg: result.errorMsg
                            });
                        } else {
                            $('#dlg').dialog('close');		// close the dialog
                            $('#dg').datagrid('reload');	// reload the user data
                        }
                    }
                });
            }

            function destroyUser() {
                var row = $('#dg').datagrid('getSelected');
                if (row) {
                    $.messager.confirm('Confirmar', 'Deseja realmente remover este Cliente?', function (r) {
                        if (r) {
                            $.post('RemoverCliente', {id: row.codigo}, function (result) {
                                if (result.success) {
                                    $('#dg').datagrid('reload');	// reload the user data
                                } else {
                                    $.messager.show({// show error message
                                        title: 'Error',
                                        msg: result.errorMsg
                                    });
                                }
                            }, 'json');
                        }
                    });
                }
            }
        </script>
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