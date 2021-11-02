<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="pt-br">
    <head>
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
                    <h1 class="logoname" ><%out.print(request.getAttribute("nome_menu"));%></h1>
                    <h1>SINDICATO - USUÁRIO PRINCIPAL</h1>
                    <h1>CADASTRAR NOVA EMPRESA</h1>
                    
                </div>
                <nav id="mainav" class="fl_right"> 
                    <ul class="clear">
                        <li><a href="principal">Início</a>
                        </li>
                        <li><a class="drop" href="#">Associados</a>
                            <ul>
                                <li><a href="setid">Adicionar</a></li>
                                <li><a href="listar">Listar</a></li>
                            </ul>
                        </li>
                        <li><a class="drop" href="#">Empresas</a>
                            <ul>
                                <li><a href="empresa456">Adicionar</a></li>
                                <li><a href="abrirempresa">Listar</a></li>
                            </ul>
                        </li>
                        <li><a class="drop" href="#">Usuarios</a>
                            <ul>
                                <li><a href="novo_user456">Adicionar</a></li>
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

        <br>
        <form name="frmEmpresa" action="empresa">



            <table>
                <tr>
                    <td>EMPRESA*</td>
                    <td><input name="nome" id="nome" type="text" placeholder="EMPRESA" class="Caixa_Cidade"/></td>
                </tr>
                <tr>
                    <td>ENDEREÇO</td>
                    <td><input name="endereco" type="text" placeholder="ENDEREÇO" class="Caixa_Contato"/></td>

                </tr>
                <tr> 
                    <td>CONTATO</td>
                    <td><input name="contato" type="text" placeholder="CONTATO" class="Caixa_Contato"/></td>
                </tr>
                <tr>
                    <td>LOGIN*</td>
                    <td><input type="text" name="login" id="login" placeholder="LOGIN" class="Caixa_Nome" /></td>
                </tr>
                <tr>
                    <td>SENHA*</td>
                    <td><input name="senha" type="text" id="senha" placeholder="SENHA" class="Caixa_Contato"/></td>

                </tr>
                <tr>
                    <td>CNPJ</td>
                    <td><input type="text" name="cnpj" placeholder="CNPJ" class="Caixa_Contato"/></td>

                </tr>


            </table>

            <br/>
            <input type="button" value="CADASTRAR" class="Botao1"
                   onclick="validarEmpresa()">


            <!-- JAVASCRIPTS -->
            <script src="layout/scripts/jquery.min.js"></script>
            <script src="layout/scripts/jquery.backtotop.js"></script>
            <script src="layout/scripts/jquery.mobilemenu.js"></script>
            <script src="scripts/validador.js"></script> 
    </body>
</html>

