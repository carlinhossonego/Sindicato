<html lang="pt-br">
    <head>
        <title>Controle de pessoas</title>

        <link rel="icon" href="imagens/favicon.png"> 
        <link rel="stylesheet" href="style.css">


        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body bgcolor="333333">

        <br/>
        <br/>
        <br/>
        <form name="frmLogin" action="main4">
            <table class="tabela2">
                <tr>
                    <td>
                        <img src="imagens/LOGO_p.png" alt="some text" width=225 height=114>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h1 class="logoname">Login</h1>
                    </td>
                </tr>
                <tr>
                    <th ><input name="login_login" type="text" placeholder="Digite o Login" class="Caixa_Login"/></th>
                </tr>
                <tr>
                    <th><input name="senha_login" type="password" placeholder="Digite a senha" class="Caixa_Login"/></th>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="button" value="Salvar" class="Botao1"
                   onclick="validarLogin()"></td>
                </tr>
            </table>
        </form>


        <!-- JAVASCRIPTS -->
       <script src="layout/scripts/jquery.min.js"></script>
        <script src="layout/scripts/jquery.backtotop.js"></script>
        <script src="layout/scripts/jquery.mobilemenu.js"></script>
        <script src="scripts/validador.js"></script>
        <footer>
            Endereço: Av. da Saudade, 345 - Vila Garavello, Guariba - SP, 14840-000 / Telefone: (16) 3251-5353
        </footer>

    </body>

</html>
