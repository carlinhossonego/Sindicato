function imprimir() {
    window.print();

}

//Valida a pagina novo.jsp (CADASTRAR NOVO ASSOCIADO)
function validar() {

    if (document.getElementById("nome").value == "") {
        alert("Digite um NOME Valido.");
        document.getElementById("nome").focus();
        Break;
    }
    if (document.getElementById("validade").value == "") {
        alert("Digite a VALIDADE");
        document.getElementById("validade").focus();
        Break;
    }
    if (document.getElementById("login").value == "") {
        alert("Digite o LOGIN");
        document.getElementById("login").focus();
        Break;
    }
    if (document.getElementById("senha").value == "") {
        alert("Digite a SENHA");
        document.getElementById("senha").focus();
        Break;
    }
    var perg;
    perg = window.confirm("Deseja cadastrar DEPENDENTES? \n\n USE:\n OK (SIM) \n CANCELAR (NÃO)");

    if (perg === true) {
        document.getElementById("controle").value = "1";

    } else {
        document.getElementById("controle").value = "0";
        alert("O Associado " + document.getElementById("nome").value + " foi cadastrado com sucesso!");
    }



    document.forms["frmContato"].submit();
}
//Valida a pagina editar.jsp (EDITAR ASSOCIADO)
function validareditar() {

    if (document.getElementById("nome").value == "") {
        alert("Digite um NOME Valido.");
        document.getElementById("nome").focus();
        Break;
    }
    if (document.getElementById("validade").value == "") {
        alert("Digite a VALIDADE");
        document.getElementById("validade").focus();
        Break;
    }

    if (document.getElementById("login").value == "") {
        alert("Digite o LOGIN");
        document.getElementById("login").focus();
        Break;
    }
    if (document.getElementById("senha").value == "") {
        alert("Digite a SENHA");
        document.getElementById("senha").focus();
        Break;
    }

    alert("O Associado " + document.getElementById("nome").value + " foi editado com sucesso!");
    document.forms["frmeditarContato"].submit();

}
function validarPesquisaempresa() {
    document.forms["frmPesquisaempresa"].submit();

}
function validarPesquisa() {
    document.forms["frmPesquisa"].submit();

}

function validarPesquisa2() {
    document.forms["frmPesquisa2"].submit();

}
function validarPesquisa3() {
    document.forms["frmPesquisa3"].submit();

}
function validarPesquisa4() {
    document.forms["frmPesquisa4"].submit();

}
//Valida a pagina relatorios_root.jsp (FAZ O PAGAMENTO)
function fazerpagamento() {
    //relatorioroot.setValor_pego(request.getParameterValues("ID"));

    var chk_arr = document.getElementsByName("ID");
    var chklength = chk_arr.length;
    var cont = "0";
    for (k = 0; k < chklength; k++) {
        if (chk_arr[k].checked === true) {
            cont = cont + "1";
            alert("Baixa realizada com sucesso!");
            document.forms["fazer_pagamento"].submit();
            break;
        } else {
            cont = cont + "0";
        }
    }
    if (cont.indexOf("1") >= 0) {
    } else {
        alert("Selecione pelo menos um corte!");
    }







}

//Valida a pagina empresa.jsp (CADASTRAR NOVA EMPRESA)
function validarEmpresa() {
    if (document.getElementById("nome").value == "") {
        alert("Digite um NOME da empresa Valido.");
        document.getElementById("nome").focus();
        exit;
    }
    if (document.getElementById("login").value == "") {
        alert("Digite o LOGIN");
        document.getElementById("login").focus();
        exit;
    }
    if (document.getElementById("senha").value == "") {
        alert("Digite a SENHA");
        document.getElementById("senha").focus();
        exit;
    }
    alert("A Empresa " + document.getElementById("nome").value + " foi cadastrada com sucesso!");


    document.forms["frmEmpresa"].submit();

}

function validarEmpresaEditar() {
    if (document.getElementById("nome").value == "") {
        alert("Digite um NOME da empresa Valido.");
        document.getElementById("nome").focus();
        exit;
    }
    if (document.getElementById("login").value == "") {
        alert("Digite o LOGIN.");
        document.getElementById("login").focus();
        exit;
    }
    if (document.getElementById("senha").value == "") {
        alert("Digite a SENHA.");
        document.getElementById("senha").focus();
        exit;
    }
    alert("A Empresa " + document.getElementById("nome").value + " foi editada com sucesso!");

    document.forms["frmeditarempresa"].submit();

}

//Valida a pagina novouser.jsp (CADASTRAR NOVO USUARIO)
function validarUser() {
    if (document.getElementById("nome").value == "") {
        alert("Digite um NOME do Usuário Valido.");
        document.getElementById("nome").focus();
        exit;
    }
    if (document.getElementById("login").value == "") {
        alert("Digite o LOGIN.");
        document.getElementById("login").focus();
        exit;
    }
    if (document.getElementById("senha").value == "") {
        alert("Digite a SENHA.");
        document.getElementById("senha").focus();
        exit;
    }
    alert("O Usuário " + document.getElementById("nome").value + " foi cadastrado com sucesso!");
    document.forms["frmNovo_User"].submit();

}
//Valida a pagina editaruser.jsp (EDITAR O USUARIO)
function validarUserEditar() {
    if (document.getElementById("nome").value == "") {
        alert("Digite um NOME do Usuário Valido.");
        document.getElementById("nome").focus();
        exit;
    }
    if (document.getElementById("login").value == "") {
        alert("Digite o LOGIN.");
        document.getElementById("login").focus();
        exit;
    }
    if (document.getElementById("senha").value == "") {
        alert("Digite a SENHA.");
        document.getElementById("senha").focus();
        exit;
    }
    alert("O Usuário " + document.getElementById("nome").value + " foi editado com sucesso!");
    document.forms["frmeditaruser"].submit();

}

function validarPesquisauser() {
    document.forms["frmPesquisauser"].submit();

}


//Valida a pagina novodependente.jsp (CADASTRAR NOVO DEPENDENTE)
function validarNovoDependente() {

    if (document.getElementById("nome").value == "") {
        alert("Digite um NOME Valido.");
        document.getElementById("nome").focus();
        exit;
    }
    if (document.getElementById("nascimento").value == "") {
        alert("Digite a DATA DE NASCIMENTO");
        document.getElementById("nascimento").focus();
        exit;
    }

    document.forms["frmnovodependente"].submit();
    alert("O dependente " + document.getElementById("nome").value + " \nfoi cadastrado com sucesso!");

}

function validarDependenteEditar() {
    document.forms["frmeditardependente"].submit();

}

function validarLogin() {
    document.forms["frmLogin"].submit();

}

function validarcortes() {

    document.forms["frmCortes"].submit();

}

function validarLogincliente() {

    document.forms["frmLogincliente"].submit();

}




function hide() {
    var earrings = document.getElementById('1');
    earrings.style.visibility = 'hidden';
}

function show() {
    var earrings = document.getElementById('earringstd');
    earrings.style.visibility = 'visible';
}

$("#campo").change(function () {
    if ($(this).val() == "nome") {
        $('#nome').show();
        $('#data_I').hide();
        $('#data_F').hide();
        $('#pago').hide();

    } else if ($(this).val() == "data") {
        $('#nome').hide();
        $('#data_I').show();
        $('#data_F').show();
        $('#pago').hide();

    } else if ($(this).val() == "pago") {
        $('#nome').hide();
        $('#data_I').hide();
        $('#data_F').hide();
        $('#pago').show();

    }
});

$("#campo2").change(function () {
    if ($(this).val() == "-") {
        $('#nome2').hide();
        $('#data_I2').hide();
        $('#data_F2').hide();
        $('#pago2').hide();
        $('#select3').hide();

    } else if ($(this).val() == "E") {
        $('#nome2').show();
        $('#data_I2').hide();
        $('#data_F2').hide();
        $('#pago2').hide();
        $('#select3').show();

    }
});

$("#campo3").change(function () {
    if ($(this).val() == "nome2") {
        $('#nome2').show();
        $('#data_I2').hide();
        $('#data_F2').hide();
        $('#pago2').hide();

    } else if ($(this).val() == "data2") {
        $('#nome2').hide();
        $('#data_I2').show();
        $('#data_F2').show();
        $('#pago2').hide();

    } else if ($(this).val() == "pago2") {
        $('#nome2').hide();
        $('#data_I2').hide();
        $('#data_F2').hide();
        $('#pago2').show();

    } else if ($(this).val() == "c") {
        $('#nome2').hide();
        $('#data_I2').hide();
        $('#data_F2').hide();
        $('#pago2').hide();

    }
}
);

