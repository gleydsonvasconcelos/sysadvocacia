<%-- 
    Document   : advogados
    Created on : 16/10/2016, 20:50:11
    Author     : Gleydson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>sysadvocacia | Cadastro de Advogados</title>
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
        <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    </head>
    <body>
        <h2>Cadastro de Clientes</h2>
        <p>Listar, Cadastrar, Alterar e Remover Agvogados do Sistema</p>
        <table id="dg" title="Advogados" class="easyui-datagrid" style="width:1000px;height:400px"
               url="ListarAdvogados"
               toolbar="#toolbar" pagination="true"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="codigo" width="50">Código</th>
                    <th field="nome" width="150">Nome</th>
                    <th field="cpf" width="80">CPF</th>
                    <th field="oab" width="80">OAB</th>
                    <th field="endereco" width="100">Endereço</th>
                    <th field="telefone" width="80">Telefone</th>
                </tr>
            </thead>
        </table>
        <div id="toolbar">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">Novo Advogado</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Alterar Advogado</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remover Advogado</a>
        </div>

        <div id="dlg" class="easyui-dialog" style="width:400px;height:300px;padding:10px 20px"
             closed="true" buttons="#dlg-buttons">
            <div class="ftitle">Informações do Cliente</div>
            <form id="fm" method="post"  action="SalvarAdvogado" novalidate>
                <input type="hidden" name="codigo"/>
                <div class="fitem">
                    <label>Nome:</label>
                    <input name="nome" class="easyui-textbox" required="true">
                </div>
                <div class="fitem">
                    <label>CPF:</label>
                    <input name="cpf" class="easyui-textbox" required="true">
                </div>
                <div class="fitem">
                    <label>OAB:</label>
                    <input name="oab" class="easyui-textbox" required="true">
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
                url = 'SalvarAdvogado';
            }
            function editUser() {
                var row = $('#dg').datagrid('getSelected');
                if (row) {
                    $('#dlg').dialog('open').dialog('setTitle', 'Alterar Advogado');
                    $('#fm').form('load', row);
                    url = 'SalvarAdvogado';
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
                    $.messager.confirm('Confirmar', 'Deseja realmente remover este Advogado?', function (r) {
                        if (r) {
                            $.post('RemoverAdvogado', {id: row.codigo}, function (result) {
                                if (result.success) {
                                    $('#dg').datagrid('reload');	// reload the user data
                                } else {
                                    $.messager.show({// show error message
                                        title: 'Error',
                                        msg: result.errorMsg
                                    });
                                }
                            },'json');
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
    </body>
</html>