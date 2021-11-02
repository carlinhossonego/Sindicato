<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.JavaBeans2"%>
<%@page import="java.util.ArrayList" %>
<%
    ArrayList<JavaBeans2> lista = (ArrayList<JavaBeans2>) request.getAttribute("user");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="icon" href="imagens/favicon.png"> 
        <link rel="stylesheet" href="style.css">
        <link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
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
                    <h1>PESQUISAR USUÁRIOS</h1>

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
        <table id="tabela">

            <thead>
                <tr>
                    <th>ID</th>
                    <th>LOGIN</th>
                    <th>SENHA</th>
                    <th>NOME</th>

                </tr>
            </thead>
            <tbody>
                <% for (int i = 0; i < lista.size(); i++) {%>
                <tr>
                    <td><%=lista.get(i).getId_user()%></td>
                    <td><%=lista.get(i).getLogin_user()%></td>
                    <td><%=lista.get(i).getSenha_user()%></td>
                    <td><%=lista.get(i).getNome_user()%></td>
                    <td>
                        <a href="select_user?id=<%=lista.get(i).getId_user()%>" class="Botao1">Editar</a>
                    </td>
                </tr>
                <% }%>
            </tbody>

        </table>

        <!-- JAVASCRIPTS -->
        <script src="layout/scripts/jquery.min.js"></script>
        <script src="layout/scripts/jquery.backtotop.js"></script>
        <script src="layout/scripts/jquery.mobilemenu.js"></script>
    </body>
</html>
