<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.JavaBeansAssociados"%>
<%@page import="java.util.ArrayList" %>
<%
    ArrayList<JavaBeansAssociados> lista = (ArrayList<JavaBeansAssociados>) request.getAttribute("editar");

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de pessoas</title>
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
                    <h1>EDITAR ASSOCIADO</h1>
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


        <form name="frmContato" action="update_associado">

            <table>

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
                    <td>EMPRESA: </td>
                    <td> <input type="text" name="empresa" class="Caixa_CPF"
                                value="<%out.print(request.getAttribute("empresa"));%>"></td>

                </tr>

                <tr>
                    <td>CIDADE: </td>
                    <td> <input type="text" name="cidade" class="Caixa_CPF"
                                value="<%out.print(request.getAttribute("cidade"));%>"></td>

                </tr>

                <tr>
                    <td>VALIDADE: </td>
                    <td> <input type="text" name="validade" class="Caixa_CPF"
                                value="<%out.print(request.getAttribute("validade"));%>"></td>

                </tr>
                <tr>
                    <td>CARGO: </td>
                    <td> <input type="text" name="cargo" class="Caixa_CPF"
                                value="<%out.print(request.getAttribute("cargo"));%>"></td>

                </tr>
                <tr>
                    <td>DEPENDENTES: </td>
                    <td>
                        <table id="tabela">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NOME</th>
                                    <th>NASCIMENTO</th>
                                </tr>
                            </thead>

                            <tbody>
                                <% for (int i = 0; i < lista.size(); i++) {%>
                                <tr>
                                    <td><%=lista.get(i).getIddependentes()%></td>
                                    <td><%=lista.get(i).getNome()%></td>
                                    <td><%=lista.get(i).getNascimento()%></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>  
                    </td>
                </tr>
            </table>
            <br>
            <br>

            <input type="button" value="Salvar" class="Botao1"
                   onclick="validar()">
        </form>

        <!-- JAVASCRIPTS -->
        <script src="layout/scripts/jquery.min.js"></script>
        <script src="layout/scripts/jquery.backtotop.js"></script>
        <script src="layout/scripts/jquery.mobilemenu.js"></script>
        <script src="scripts/validador.js"></script>
    </body>
</html>