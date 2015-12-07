var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: -5.8378122, lng: -35.1989288},
        zoom: 13
    });
}

function createMarker(latlng, html) {
    var contentString = html;
    var marker = new google.maps.Marker({
        position: latlng,
        map: map,
        zIndex: Math.round(latlng.lat() * -100000) << 5
    });

    var infowindow = new google.maps.InfoWindow({size: new google.maps.Size(150, 50)});

    google.maps.event.addListener(marker, 'click', function () {
        infowindow.setContent(contentString);
        infowindow.open(map, marker);
    });

    google.maps.event.addListener(infowindow, 'domready', function () {

        // Referência ao DIV que agrupa o fundo da infowindow
        var iwOuter = $('.gm-style-iw');

        /* Uma vez que o div pretendido está numa posição anterior ao div .gm-style-iw.
         * Recorremos ao jQuery e criamos uma variável iwBackground,
         * e aproveitamos a referência já existente do .gm-style-iw para obter o div anterior com .prev().
         */
        var iwBackground = iwOuter.prev();

        // Remover o div da sombra do fundo
        iwBackground.children(':nth-child(2)').css({'display': 'none'});

        // Remover o div de fundo branco
        iwBackground.children(':nth-child(4)').css({'display': 'none'});

        // Desloca a infowindow 115px para a direita
        iwOuter.parent().parent().css({left: '115px'});

        // Desloca a sombra da seta a 76px da margem esquerda 
        iwBackground.children(':nth-child(1)').attr('style', function (i, s) {
            return s + 'left: 76px !important;'
        });

        // Desloca a seta a 76px da margem esquerda 
        iwBackground.children(':nth-child(3)').attr('style', function (i, s) {
            return s + 'left: 76px !important;'
        });

        // Altera a cor desejada para a sombra da cauda
        iwBackground.children(':nth-child(3)').find('div').children().css({'box-shadow': 'rgba(72, 181, 233, 0.6) 0px 1px 6px', 'z-index': '1'});

        // Referência ao DIV que agrupa os elementos do botão fechar
        var iwCloseBtn = iwOuter.next();

        // Aplica o efeito desejado ao botão fechar
        iwCloseBtn.css({opacity: '1', right: '38px', top: '3px', border: '7px solid #48b5e9', 'border-radius': '13px', 'box-shadow': '0 0 5px #3990B9'});

        // Se o conteúdo da infowindow não ultrapassar a altura máxima definida, então o gradiente é removido.
        if ($('.iw-content').height() < 140) {
            $('.iw-bottom-gradient').css({display: 'none'});
        }

        // A API aplica automaticamente 0.7 de opacidade ao botão após o evento mouseout. Esta função reverte esse evento para o valor desejado.
        iwCloseBtn.mouseout(function () {
            $(this).css({opacity: '1'});
        });
    });
}

initMap();
