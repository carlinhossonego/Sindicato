<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.JavaBeansAssociados"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar dependente</title>
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

                    <h1 class="logoname">SINDICATO</h1>
                    <h1>EDITAR DEPENTENDE</h1>
                </div>
                <nav id="mainav" class="fl_right"> 
                    <ul class="clear">
                        <li><a href="principal.html">Início</a>
                        </li>
                        <li><a class="drop" href="#">Associados</a>
                            <ul>
                                <li><a href="setid">Adicionar</a></li>
                                <li><a href="listar">Listar</a></li>
                            </ul>
                        </li>
                        <li><a class="drop" href="#">Empresas</a>
                            <ul>
                                <li><a href="empresa.jsp">Adicionar</a></li>
                                <li><a href="abrirempresa">Listar</a></li>
                            </ul>
                        </li>
                        <li><a class="drop" href="#">Usuarios</a>
                            <ul>
                                <li><a href="novo_user.jsp">Adicionar</a></li>
                                <li><a href="novousuario">Listar</a></li>
                            </ul>
                        </li>
                        <li><a href="relatoriosroot">Relatórios</a>
                        </li>
                        <li><a href="index.html">Sair</a>
                        </li>
                    </ul>
                </nav>
            </header>
        </div>
        <form name="frmeditardependente" action="update_dependente">

            <table>
                <tr>
                    <td>EDITAR DEPENTENDE</td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>ID: </td>
                    <td> <input type="text" name="id" class="Caixa_Id" readonly 
                                value="<%out.print(request.getAttribute("id"));%>"></td>

                </tr>

                <tr>
                    <td>NOME: </td>
                    <td> <input type="text" name="nome" class="Caixa_Nome"
                                value="<%out.print(request.getAttribute("nome"));%>"></td>

                </tr>

                <tr>
                    <td>DATA DE NASCIMENTO: </td>
                    <td> <input type="text" name="nascimento"  class="Caixa_Telefone"
                                value="<%out.print(request.getAttribute("nascimento"));%>"></td>

                </tr>

            </table>
            <br>
            <br>


            <input type="button" value="Salvar" class="Botao1"
                   onclick="validarDependenteEditar()">
        </form>

        <!-- JAVASCRIPTS -->
        <script src="layout/scripts/jquery.min.js"></script>
        <script src="layout/scripts/jquery.backtotop.js"></script>
        <script src="layout/scripts/jquery.mobilemenu.js"></script>
        <script src="scripts/validador.js"></script>
    </body>
</html>