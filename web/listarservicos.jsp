<%@page import="modelo.JavaBeansServicos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.JavaBeansAssociados"%>
<%@page import="java.util.ArrayList" %>
<%
    ArrayList<JavaBeansServicos> lista = (ArrayList<JavaBeansServicos>) request.getAttribute("servicos");
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
                    <h1 class="logoname">SINDICATO PRESTADOR DE SERVIÇO</h1>


                </div>
                <nav id="mainav" class="fl_right"> 
                    <ul class="clear">
                        <li><a href="principalempregado.html">Início</a>
                        </li>
                        <li><a href="listarassociadonoservico">Associados</a>

                        </li>

                    </ul>
                </nav>
            </header>
        </div>


        <table id="tabela">

            <thead>
                <tr>

                    <th>NOME DO DEPENDENTE</th>
                    <th>DATA DO CORTE</th>
                    <th>NOME DA EMPRESA</th>

                </tr>
            </thead>
            <tbody>
                <% for (int i = 0; i < lista.size(); i++) {%>
                <tr>

                    <td><%=lista.get(i).getAssociado_id()%></td>
                    <td><%=lista.get(i).getAssociado_iddependentes()%></td>
                    <td><%=lista.get(i).getData_corte()%></td>


                </tr>
                <% }%>
            </tbody>




        </table>
        <table>
            <tr> 
                <td> <a href="login_de_corte.jsp">Executar Corte</a></td>
            </tr>
        </table>
        <!-- JAVASCRIPTS -->
        <script src="layout/scripts/jquery.min.js"></script>
        <script src="layout/scripts/jquery.backtotop.js"></script>
        <script src="layout/scripts/jquery.mobilemenu.js"></script>
        <script src="scripts/validador.js"></script> 
    </body>
</html>
