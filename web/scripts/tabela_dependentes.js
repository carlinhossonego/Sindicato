//Funcao adiciona uma nova linha na tabela
function adicionaLinha(idTabela) {

    var tabela = document.getElementById(idTabela);
    var numeroLinhas = tabela.rows.length;
    var linha = tabela.insertRow(numeroLinhas);
    var celula1 = linha.insertCell(0);
    var celula2 = linha.insertCell(1);
    var celula3 = linha.insertCell(2);
    celula1.innerHTML = document.getElementById('fname').value;
    celula2.innerHTML = document.getElementById('fdate').value;
    celula3.innerHTML = "<button onclick='removeLinha(this)'>Remover</button>";
}

// funcao remove uma linha da tabela
function removeLinha(linha) {
    var i = linha.parentNode.parentNode.rowIndex;
    document.getElementById('tbl').deleteRow(i);
}
function iterar(nome_table) {
    var table = document.getElementById(nome_table);
    for (let i in table.rows) {
        if (i > 0) {
            let row = table.rows[i]
            //iterate through rows
            //rows would be accessed using the "row" variable assigned in the for loop
            for (let j in row.cells) {
                if (j < 2) {
                    let col = row.cells[j]



                    alert(col.innerHTML);

                }
                //iterate through columns
                //columns would be accessed using the "col" variable assigned in the for loop
            }
        }
    }
} 