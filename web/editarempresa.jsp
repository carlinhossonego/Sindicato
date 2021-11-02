<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.JavaBeansAssociados"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de empresa</title>
        <link rel="icon" href="imagens/favicon.png"> 
        <link rel="stylesheet" href="style.css">
        <link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <div class="wrapper overlay row0">
            <div id="topbar" class="hoc clear">
                <div class="fl_left"> 
                    <!-- ################################################################################################ -->
                    <ul class="nospace">
                        <li><i class="fas fa-address-book"></i> Av. da Saudade, 345 - Vila Garavello, Guariba - SP, 14840-000</li>
                    </ul>

                    <ul class="nospace">
                        <li><i class="fas fa-phone"></i> (16) 3251-5353</li>
                    </ul>

                    <!-- ################################################################################################ -->
                </div>
                <div class="fl_right"> 
                    <!-- ################################################################################################ -->

                </div>
            </div>
        </div>

        <div class="wrapper row1">
            <header id="header" class="hoc clear">
                <div id="logo" class="fl_left"> 


                    <img src="imagens/LOGO_p.png" alt="some text" width=100 height=500>
                    <h1 class="logoname" ><%out.print(request.getAttribute("nome_menu"));%></h1>
                    <h1>SINDICATO - USUÁRIO PRINCIPAL</h1>
                    <h1>EDITAR EMPRESA</h1>
                    
                </div>
                <nav id="mainav" class="fl_right"> 
                    <ul class="clear">
                        <li><a href="principal">Início</a>
                        </li>
                        <li><a class="drop" href="#">Associados</a>
                            <ul>
                                <li><a href="setid">Adicionar</a></li>
                                <li><a href="listar">Listar</a></li>
                            </ul>
                        </li>
                        <li><a class="drop" href="#">Empresas</a>
                            <ul>
                                <li><a href="empresa456">Adicionar</a></li>
                                <li><a href="abrirempresa">Listar</a></li>
                            </ul>
                        </li>
                        <li><a class="drop" href="#">Usuarios</a>
                            <ul>
                                <li><a href="novo_user456">Adicionar</a></li>
                                <li><a href="novousuario">Listar</a></li>
                            </ul>
                        </li>
                        <li><a href="relatoriosroot">Relatórios</a>
                        </li>
                        <li><a href="sair">Sair</a>
                        </li>
                    </ul>
                </nav>
            </header>
        </div>
        <form name="frmeditarempresa" action="update_empresa">

            <table>

                <tr>
                    
                    <td hidden> <input type="text" name="id" class="Caixa_Id" readonly 
                                value="<%out.print(request.getAttribute("id"));%>"></td>

                </tr>

                <tr>
                    <td>NOME*: </td>
                    <td> <input type="text" name="nome" id="nome" class="Caixa_Nome"
                                value="<%out.print(request.getAttribute("nome"));%>"></td>

                </tr>

                <tr>
                    <td>ENDEREÇO: </td>
                    <td> <input type="text" name="endereco"  class="Caixa_Telefone"
                                value="<%out.print(request.getAttribute("endereco"));%>"></td>

                </tr>

                <tr>
                    <td>TELEFONE: </td>
                    <td> <input type="text" name="telefone" class="Caixa_CPF"
                                value="<%out.print(request.getAttribute("telefone"));%>"></td>

                </tr>

                <tr>
                    <td>LOGIN*: </td>
                    <td> <input type="text" name="login" id="login" class="Caixa_CPF"
                                value="<%out.print(request.getAttribute("login"));%>"></td>

                </tr>

                <tr>
                    <td>SENHA*: </td>
                    <td> <input type="text" name="senha" id="senha" class="Caixa_CPF"
                                value="<%out.print(request.getAttribute("senha"));%>"></td>

                </tr>

                <tr>
                    <td>CNPJ: </td>
                    <td> <input type="text" name="cnpj" class="Caixa_CPF"
                                value="<%out.print(request.getAttribute("cnpj"));%>"></td>

                </tr>

            </table>
            <br>
            <br>


            <input type="button" value="Salvar" class="Botao1"
                   onclick="validarEmpresaEditar()">
        </form>

        <!-- JAVASCRIPTS -->
        <script src="layout/scripts/jquery.min.js"></script>
        <script src="layout/scripts/jquery.backtotop.js"></script>
        <script src="layout/scripts/jquery.mobilemenu.js"></script>
        <script src="scripts/validador.js"></script>
    </body>
</html>