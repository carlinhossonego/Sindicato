<%@page import="modelo.JavaBeansRelatorioRoot"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.JavaBeansRelatorios"%>
<%@page import="java.util.ArrayList" %>
<%
    ArrayList<JavaBeansRelatorioRoot> lista = (ArrayList<JavaBeansRelatorioRoot>) request.getAttribute("pagamento");

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




        <BR/>
        <BR/>

        <table>


            <tr>
                <td>
                    <input type="text" name="" class="Caixa_Id" readonly 
                           value="<% out.print("TOTAL DE CORTES: " + lista.size());%>">

                    <table id="tabela">
                        <thead>
                            <tr>

                                <th>EMPRESA</th>
                                <th>ASSOCIADO</th>
                                <th>DEPENDENTE</th>
                                <th>DATA DO CORTE</th>
                                <th>NÚMERO</th>
                                <th>ASSINATURA</th>
                            </tr>
                        </thead>

                        <tbody>
                            <% for (int i = 0; i < lista.size(); i++) {%>
                            <tr>


                                <td><%=lista.get(i).getNomeempresa()%></td>
                                <td><%=lista.get(i).getAssociado_ID()%></td>
                                <td><%=lista.get(i).getAssociado_Id_Dependente()%></td>
                                <td><%=lista.get(i).getData_Corte()%></td>
                                <td><%=lista.get(i).getID_cortes()%></td>
                                <td></td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>  

                    <input type="text" name="data" class="Caixa_Id" readonly 
                           value="<%out.print(request.getAttribute("data"));%>">

                    <input type="button" value="Imprimir" class="Botao1"
                           onclick="imprimir()">  
                </td>

            </tr>
        </table>


        <br>
        <br>


        <!-- JAVASCRIPTS -->
        <script src="layout/scripts/jquery.min.js"></script>
        <script src="layout/scripts/jquery.backtotop.js"></script>
        <script src="layout/scripts/jquery.mobilemenu.js"></script>
        <script src="scripts/validador.js"></script>
    </body>

</html>