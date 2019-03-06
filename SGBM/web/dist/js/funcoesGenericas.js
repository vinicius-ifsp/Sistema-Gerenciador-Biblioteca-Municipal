/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//$('.modal').modal({keyboard:true});

// Funcao responsavel por abrir um modal passado no primeiro parametro e caso
// o segundo tbm seja passado um valor, chama a função formEdit
function abrirModal(myModal){
    $(myModal).modal('show');
    //$(myModal).modal({keyboard:true}); // fechar com esc true
}
// Funcao responsavel por fechar um modal passado como parametro
function fecharModal(myModal){
  $(myModal).modal('hide');
}
// Funcao responsavel por atualizar um campo do form com o valor passado
function atualizarCampoVal(campo,valor){
    $(campo).val(valor);
}
// Funcao responsavel por atualizar um campo Html com o valor passado
function atualizarCampoHtml(campo,valor){
    $(campo).html(valor);
}
function getCampo(form,campo){
    return $(form+" "+campo).val();
}
function limpar(campo){
  $(campo).resetForm();
}