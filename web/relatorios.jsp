<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.JavaBeansRelatorios"%>
<%@page import="java.util.ArrayList" %>
<%
    ArrayList<JavaBeansRelatorios> lista = (ArrayList<JavaBeansRelatorios>) request.getAttribute("relatorios");

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
                    <h1 class="logoname">SINDICATO PRESTADOR DE SERVIÇO</h1>


                </div>
                <nav id="mainav" class="fl_right"> 
                    <ul class="clear">
                        <li><a href="principalempregado.html">Início</a>
                        </li>
                        <li><a href="relatorios">Relatórios</a>
                        </li>
                        <li><a href="listarassociadonoservico">Associados</a>

                        </li>

                    </ul>
                </nav>
            </header>
        </div>


        <BR/>
        <BR/>
        <form name="frmPesquisa3" action="relatorios_para_empresa">
            <table >
                <td>
                    <label>
                        Selecione o Criterio
                    </label>
                    <select name="campo" size="1" id="campo">

                        <option value="nome">Nome</option>
                        <option value="data">Data</option>
                        <option value="pago">Pago</option>
                    </select>
                </td>


                <tr>
                    <td id="nome">
                        <input  name="Nome1" type="text" placeholder="Digite o Nome" class="Caixa_Contato" />
                    </td>
                    <td hidden id="data_I">
                        <input  name="DataI1" type="text" placeholder="Digite a Data Inicial" class="Caixa_Contato" hidden/>
                    </td>
                    <td hidden id="data_F">
                        <input  name="DataF1" type="text" placeholder="Digite a Data Final" class="Caixa_Contato" hidden/>
                    </td>
                    <td hidden id="pago">
                        <input  name="Pago1" type="text" placeholder=" " class="Caixa_Contato" hidden/>
                    </td>

                    <td></td>
                    <td><input type="button" value="Pesquisar" class="Botao1"
                               onclick="validarPesquisa3()"></td>
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
                            <option value="nome2">Nome</option>
                            <option value="data2">Data</option>
                            <option value="pago2">Pago</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td hidden id="nome2">
                        <input  name="Nome2" type="text" placeholder="Digite o Nome" class="Caixa_Contato" />
                    </td>
                    <td hidden id="data_I2">
                        <input  name="DataI2" type="text" placeholder="Digite a Data Inicial" class="Caixa_Contato" />
                    </td>
                    <td hidden id="data_F2">
                        <input  name="DataF2" type="text" placeholder="Digite a Data Final" class="Caixa_Contato" />
                    </td>
                    <td hidden id="pago2">
                        <input  name="Pago2" type="text" placeholder=" " class="Caixa_Contato" />
                    </td>

                    <td></td>




                </tr>


            </table>

            <table>

                
                <tr>
                    <td>
                        <table id="tabela">
                            <thead>
                                <tr>

                                    <th>ASSOCIADO</th>
                                    <th>DEPENDENTE</th>
                                    <th>DATA DO CORTE</th>
                                    <th>PAGO</th>
                                </tr>
                            </thead>

                            <tbody>
                                <% for (int i = 0; i < lista.size(); i++) {%>
                                <tr>


                                    <td><%=lista.get(i).getAssociado_ID()%></td>
                                    <td><%=lista.get(i).getAssociado_Id_Dependente()%></td>
                                    <td><%=lista.get(i).getData_Corte()%></td>
                                    <td><%=lista.get(i).getPago()%></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>  
                    </td>
                </tr>

            </table>
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