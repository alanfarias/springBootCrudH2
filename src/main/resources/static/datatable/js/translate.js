$(document).ready(function () {
    $('#example').DataTable({
        language: {
            lengthMenu: 'Exibir _MENU_ registros por página',
            zeroRecords: 'Nada encontrado - desculpe',
            info: 'Mostrando página _PAGE_ de _PAGES_',
            infoEmpty: 'Nenhum registro encontrado',
            infoFiltered: '(filtrado de _MAX_ registros totais)',            
            sLoadingRecords:"Carregando...",
            sProcessing:"Processing...",
            sSearch:"Filtrar:",
            oPaginate:{sFirst:"Primeiro",sLast:"Último",sNext:"Próximo",sPrevious:"Anterior"},
        },
    });
});