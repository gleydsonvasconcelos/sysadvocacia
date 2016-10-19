<%-- 
    Document   : processos
    Created on : 16/10/2016, 20:50:11
    Author     : Gleydson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>sysadvocacia | Cadastro de Processos</title>
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
        <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    </head>
    <body>
        <h2>Cadastro de Processos</h2>
        <p>Listar, Cadastrar, Alterar e Remover Processos do Sistema</p>
        <table id="dg" title="Processos" class="easyui-datagrid" style="width:1000px;height:400px"
               url="ListarProcessos"
               toolbar="#toolbar" pagination="true"
               rownumbers="true" fitColumns="true" singleSelect="true">
            <thead>
                <tr>
                    <th field="codigo" width="50">Código</th>
                    <th field="descricao" width="150">Código</th>
                    <th field="dataAbertura" width="50" formatter="formatDate">Data de Abertura</th>
                    <th field="instanciaAtual" width="100">Instância Atual</th>
                    <th field="status" width="30">Status</th>

                </tr>
            </thead>
        </table>
        <div id="toolbar">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">Novo Processo</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Alterar Processo</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remover Processo</a>
        </div>

        <div id="dlg" class="easyui-dialog" style="width:400px;height:300px;padding:10px 20px"
             closed="true" buttons="#dlg-buttons">
            <div class="ftitle">Informações do Processo</div>
            <form id="fm" method="post"  action="SalvarProcesso" novalidate>
                <input type="hidden" name="codigo"/>
                <div class="fitem">
                    <label>Data de Abertura:</label>
                    <input name="dataAbertura" class="easyui-datebox" formatter="formatDate" required="true">
                </div>
                <div class="fitem">
                    <label>Descrição:</label>
                    <input name="descricao" class="easyui-textbox">
                </div>

                <div class="fitem">
                    <label>Instancia Atual:</label>
                    <input name="instanciaAtual" class="easyui-textbox" required="true">
                </div>
                <div class="fitem">
                    <label>Status:</label>
                    <input name="status" class="easyui-textbox">
                </div>
                <div class="fitem">
                    <label>Decisao Final:</label>
                    <input name="decisaoFinal" class="easyui-textbox">
                </div>

            </form>
        </div>
        <div id="dlg-buttons">
            <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Salvar</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancelar</a>
        </div>

        <script type="text/javascript">
            var url;

            
            function formatDate(value, row) {
                var d = new Date(value);
                return $.fn.datebox.defaults.formatter(d);
            }


            function newUser() {
                $('#dlg').dialog('open').dialog('setTitle', 'Novo Processo');
                $('#fm').form('clear');
                url = 'SalvarProcesso';
            }
            function editUser() {
                var row = $('#dg').datagrid('getSelected');
                if (row) {
                    $('#dlg').dialog('open').dialog('setTitle', 'Alterar Processo');
                    $('#fm').form('load', row);
                    url = 'SalvarProcesso';
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
                    $.messager.confirm('Confirmar', 'Deseja realmente remover este Processo?', function (r) {
                        if (r) {
                            $.post('RemoverProcesso', {id: row.codigo}, function (result) {
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
    </body>
</html>