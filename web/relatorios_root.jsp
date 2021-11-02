<%@page import="modelo.JavaBeansRelatorioRoot"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.JavaBeansRelatorios"%>
<%@page import="java.util.ArrayList" %>
<%
    ArrayList<JavaBeansRelatorioRoot> lista = (ArrayList<JavaBeansRelatorioRoot>) request.getAttribute("relatoriotodo");

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
    <body id="top">

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
                        <li><a href="sair">Sair</a>
                        </li>
                    </ul>
                </nav>
            </header>
        </div>


        <BR/>
        <BR/>
        <form name="frmPesquisa4" action="relatorios_para_root">
            <table >
                <td>
                    <label>
                        Selecione a Empresa
                    </label>

                </td>


                <tr>
                    <td id="nome">
                        <input  name="Empresa" type="text" placeholder="Digite a Empresa" class="Caixa_Contato" />
                    </td>

                    <td>
                        <input type="button" value="Pesquisar" class="Botao1" onclick="validarPesquisa4()">
                    </td>

                </tr>


                <tr>

                    <td id="select2"> 
                        <select name="E_OU" size="1" id="campo2">
                            <option value="-">-</option>
                            <option value="E">E</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td hidden id="select3">
                        <select  name="campo3" size="1" id="campo3">
                            <option value="c">-</option>
                            <option value="data2">Data</option>
                            <option value="pago2">Pago</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td hidden id="data_I2">
                        <input  name="DataI2" type="date" placeholder="Digite a Data Inicial" class="Caixa_Contato" />
                    </td>
                    <td hidden id="data_F2">
                        <input  name="DataF2" type="date" placeholder="Digite a Data Final" class="Caixa_Contato" />
                    </td>
                    <td hidden id="pago2">
                        <select  name="Pago2" size="1" id="Pago2">
                            <option value="sim">SIM</option>
                            <option value="nao">NÃO</option>
                        </select>
                        <!-- <input  name="Pago2" type="text" placeholder=" " class="Caixa_Contato" /> -->
                    </td>

                    <td></td>




                </tr>


            </table>
        </form>
        <form name="fazer_pagamento" action="pagamento">
            <table>


                <tr>
                    <td>
                        <table id="tabela">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>CÓDIGO</th>
                                    <th>EMPRESA</th>
                                    <th>ASSOCIADO</th>
                                    <th>DEPENDENTE</th>
                                    <th>DATA DO CORTE</th>
                                    <th>PAGO</th>
                                </tr>
                            </thead>

                            <tbody>
                                <% for (int i = 0; i < lista.size(); i++) {%>
                                <tr>
                                    <% String g = String.valueOf(lista.get(i).getPago());%>
                                    <% if (g.equals("0")) {%>

                                    <td><input type="checkbox" name="ID" id="selecao" value="<%=lista.get(i).getID_cortes()%>"></td>

                                    <%} else {%>

                                    <td></td>
                                    <%}%>

                                    <td><%=lista.get(i).getID_cortes()%></td>
                                    <td><%=lista.get(i).getNomeempresa()%></td>
                                    <td><%=lista.get(i).getAssociado_ID()%></td>
                                    <td><%=lista.get(i).getAssociado_Id_Dependente()%></td>
                                    <td><%=lista.get(i).getData_Corte()%></td>

                                    <% String pg = "SIM";%>
                                    <%if (lista.get(i).getPago().equals("0")) {%>
                                    <%pg = "NÃO";%>

                                    <%}%>

                                    <td><%=pg%></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>  
                    </td>

                </tr>
            </table>
            <input type="button" value="Finalizar" class="Botao1" onclick="fazerpagamento()">

            <br>
            <br>
        </form>

        <!-- JAVASCRIPTS -->
        <script src="layout/scripts/jquery.min.js"></script>
        <script src="layout/scripts/jquery.backtotop.js"></script>
        <script src="layout/scripts/jquery.mobilemenu.js"></script>
        <script src="scripts/validador.js"></script>
    </body>

</html>