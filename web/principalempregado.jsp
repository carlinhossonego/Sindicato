<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.JavaBeansAssociados"%>
<html lang="">

    <head>
        <title>Sindicato</title>
        <link rel="icon" href="imagens/favicon.png">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link href="layout/styles/layout_empresa.css" rel="stylesheet" type="text/css" media="all">
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

                    <h1 class="logoname2" ><%out.print(request.getAttribute("nome"));%></h1>
                    <h1>SINDICATO PRESTADOR DE SERVI?O</h1>


                </div>
                <nav id="mainav" class="fl_right"> 
                    <ul class="clear">
                        <li><a href="principalempregado">In?cio</a>
                        </li>
                        <li><a href="relatorios">Relat?rios</a>
                        </li>
                        <li><a href="listarassociadonoservico">Associados</a>
                        </li>
                        <li><a href="sair">Sair</a>
                        </li>

                    </ul>
                </nav>
            </header>
        </div>
                    
                    
                    

        <!-- JAVASCRIPTS -->
        <script src="layout/scripts/jquery.min.js"></script>
        <script src="layout/scripts/jquery.backtotop.js"></script>
        <script src="layout/scripts/jquery.mobilemenu.js"></script>
        
        
                
    </body>

</html>