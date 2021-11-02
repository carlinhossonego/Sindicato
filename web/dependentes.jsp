<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <link rel="icon" href="imagens/favicon.png">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form name="frmdependentes" action="insert_dependentes"> 
            <table border="1" cellpadding="1" cellspacing="1" style="width:500px">
                <tbody>
                    <tr>
                        <td colspan="3" style="text-align:center">DEPENDENTES</td>
                    </tr>
                    <tr>
                        <td>NOME</td>
                        <td><input name="nome_dependentes" type="text" /></td>
                        <td colspan="1" rowspan="2"><input type="button" value="Adicionar" class="Botao1" onclick="dependente()"></td>
                    </tr>
                    <tr>
                        <td>DATE</td>
                        <td><input name="nascimento_dependentes" type="date" /></td>
                        <td>&nbsp;</td>
                    </tr>
                </tbody>
            </table>
        </form>>
        </body>
</html>

