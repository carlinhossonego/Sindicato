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



        <form name="frmCortes" action="venda">

            <table>

                <tr>
                    <td>ID: </td>


                    <td> <input type="text" name="id" class="Caixa_Id_menor" readonly 
                                value="<%out.print(request.getAttribute("id"));%>"></td>

                    <td><input type="button" value="Selecionar" class="Botao1" onclick= "window.location.href = 'select_venda?id_corte2=<%=request.getAttribute("id")%>'">
                    </td>

                <tr>
                    <td>NOME: </td>
                    <td> <input type="text" name="nome" class="Caixa_Nome" readonly
                                value="<%out.print(request.getAttribute("nome"));%>"></td>

                    <td></td>
                </tr>

                <tr>
                    <td>ENDEREÇO: </td>
                    <td> <input type="text" name="endereco"  class="Caixa_Telefone" readonly
                                value="<%out.print(request.getAttribute("endereco"));%>"></td>
                    <td></td>
                </tr>



                <tr>
                    <td>CIDADE: </td>
                    <td> <input type="text" name="cidade" class="Caixa_CPF" readonly
                                value="<%out.print(request.getAttribute("cidade"));%>"></td>
                    <td></td>
                </tr>

                <tr>
                    <td>VALIDADE: </td>
                    <td> <input type="text" name="validade" class="Caixa_CPF" readonly
                                value="<%out.print(request.getAttribute("validade"));%>"></td>
                    <td></td>
                </tr>

                <tr>
                    <td>DEPENDENTES: </td>
                    <td>
                        <table id="tabela">
                            <thead>
                                <tr>

                                    <th>NOME</th>
                                    <th>NASCIMENTO</th>
                                </tr>
                            </thead>

                            <tbody>
                                <% for (int i = 0; i < lista.size(); i++) {%>
                                <tr>
                                    <td><%=lista.get(i).getNome()%></td>
                                    <td><%=lista.get(i).getNascimento()%></td> 
                                    <td>

                                        <input type="button" value="Selecionar" class="Botao1" onclick= "window.location.href = 'select_venda?id_corte=<%=lista.get(i).getIddependentes()%>'">

                                    </td>



                                </tr>
                                <% }%>
                            </tbody>
                        </table>  
                    </td>
                    <td></td>
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