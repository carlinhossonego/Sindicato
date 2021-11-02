function confirmar (Id_cliente){
    let resposta = confirm("** Tem certesa que quer mesmo excluir essa Pessoa?? **");
    if (resposta === true){
        //alert(Id_cliente)
        window.location.href = "delete_cliente?Id_cliente=" + Id_cliente;
    }
}

