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
}

initMap();
