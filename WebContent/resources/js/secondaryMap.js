var map = null;

var marker = null;

var infowindow = new google.maps.InfoWindow({ size: new google.maps.Size(150,50) });
                
var geocoder = new google.maps.Geocoder;

function geocodeLatLng(latlng) {
    geocoder.geocode({'location': latlng}, function(results, status) {
        if (status === google.maps.GeocoderStatus.OK) {
            if (results[1]) {
                $('#address').val(results[0].formatted_address);
                $('#latitudeOne').val(latlng.lat());
                document.getElementById('latitudeTwo').value = latlng.lat();
                $('#longitudeOne').val(latlng.lng());
                document.getElementById('longitudeTwo').value = latlng.lng();
            } else {
                window.alert('No results found');
            }
        } else {
            window.alert('Geocoder failed due to: ' + status);
        }
    });
}

// A function to create the marker and set up the event window function 
function createMarker(latlng, name, html) {
    var contentString = html;
    var marker = new google.maps.Marker({
            position: latlng,
            map: map,
            zIndex: Math.round(latlng.lat()*-100000)<<5
        });

    google.maps.event.addListener(marker, 'click', function() {
            infowindow.setContent(contentString); 
            infowindow.open(map,marker);
        });
    google.maps.event.trigger(marker, 'click');
    
    geocodeLatLng(latlng);
    
    return marker;
}

function initAutocomplete() {
    // Create the search box and link it to the UI element.
    var input = document.getElementById('pac-input');
    var searchBox = new google.maps.places.SearchBox(input);
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    // Bias the SearchBox results towards current map's viewport.
    map.addListener('bounds_changed', function() {
            searchBox.setBounds(map.getBounds());
    });

    var markers = [];
    // Listen for the event fired when the user selects a prediction and retrieve
    // more details for that place.
    searchBox.addListener('places_changed', function() {
        var places = searchBox.getPlaces();

        if (places.length == 0) {
            return;
        }

        // Clear out the old markers.
        markers.forEach(function(marker) {
            marker.setMap(null);
        });
        markers = [];

        // For each place, get the icon, name and location.
        var bounds = new google.maps.LatLngBounds();
        places.forEach(function(place) {
            var icon = {
                url: place.icon,
                size: new google.maps.Size(71, 71),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(25, 25)
            };

            // Create a marker for each place.
            /*
            markers.push(new google.maps.Marker({
                map: map,
                icon: icon,
                title: place.name,
                position: place.geometry.location
            }));
            */
           
            if (place.geometry.viewport) {
                // Only geocodes have viewport.
                bounds.union(place.geometry.viewport);
            } else {
                bounds.extend(place.geometry.location);
            }
        });
        map.fitBounds(bounds);
    });
}

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: -5.8378122, lng: -35.1989288},
        zoom: 13,
        mapTypeControlOptions: {
            style: google.maps.MapTypeControlStyle.DEFAULT,
            position: google.maps.ControlPosition.LEFT_BOTTOM
        }
    });
    
    google.maps.event.addListener(map, 'click', function() {
        infowindow.close();
    });

    google.maps.event.addListener(map, 'click', function(event) {
        //call function to create marker
        if (marker) {
            marker.setMap(null);
            marker = null;
        }
        marker = createMarker(event.latLng, "name", "<b>Location</b><br>"+event.latLng);
    });
    
    initAutocomplete();
}

initMap();