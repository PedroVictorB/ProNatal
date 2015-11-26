var map;
var marker;

function initializeMap() {
	  var mapProp = {
	    center:new google.maps.LatLng(-5.8378122,-35.1989288),
	    zoom:15,
	    mapTypeId:google.maps.MapTypeId.ROADMAP
	  };
	  map=new google.maps.Map(document.getElementById("mapa"),mapProp);
	  google.maps.event.addListener(map, 'click', function(event) {placeMarker(event.latLng);});
}

function placeMarker(location) {
	  if ( marker ) {
	    marker.setPosition(location);
	  } else {
	    marker = new google.maps.Marker({
	      position: location,
	      map: map
	    });
	  }
}

function GetAddress(lat, lng) {
    var latlng = new google.maps.LatLng(lat, lng);
    var geocoder = geocoder = new google.maps.Geocoder();
    geocoder.geocode({ 'latLng': latlng }, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            if (results[1]) {
                alert("Location: " + results[1].formatted_address);
            }
        }
    });
}

google.maps.event.addDomListener(window, 'load', initializeMap);
