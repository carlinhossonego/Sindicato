<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.JavaBeansAssociados"%>
<%@page import="java.util.ArrayList" %>
<%
    ArrayList<JavaBeansAssociados> lista = (ArrayList<JavaBeansAssociados>) request.getAttribute("associado");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
        <link rel="icon" href="imagens/favicon.png">
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
                    <h1>PESQUISAR ASSOCIADOS</h1>

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
                        <li><a href="#">Relatórios</a>
                        </li>
                        <li><a href="index.html">Sair</a>
                        </li>
                    </ul>
                </nav>
            </header>
        </div>

        <form name="frmPesquisa" action="main2">
            <br/>
            <br/>
            <table borde="1">
                <tr>
                    <td><input name="pesquisar" type="text" placeholder="Digite o Nome" class="Caixa_Contato"/></td>
                    <td><input type="button" value="Pesquisar" class="Botao1"
                               onclick="validarPesquisa()"></td>
                </tr>


            </table>

            <table id="tabela">

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOME</th>
                        <th>EMPRESA</th>
                        <th>VALIDADE</th>
                    </tr>
                </thead>

                <tbody>
                    <% for (int i = 0; i < lista.size(); i++) {%>
                    <tr>
                        <td><%=lista.get(i).getId_associado()%></td>
                        <td><%=lista.get(i).getNome_associado()%></td>
                        <td><%=lista.get(i).getEmpresa_associado()%></td>
                        <td><%=lista.get(i).getValidade_associado()%></td>
                        <td>
                            <a href="select_associado?id=<%=lista.get(i).getId_associado()%>" class="Botao1">Editar</a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </form>

        <!-- JAVASCRIPTS -->
        <script src="layout/scripts/jquery.min.js"></script>
        <script src="layout/scripts/jquery.backtotop.js"></script>
        <script src="layout/scripts/jquery.mobilemenu.js"></script>
        <script src="scripts/validador.js"></script>
    </body>
</html>
