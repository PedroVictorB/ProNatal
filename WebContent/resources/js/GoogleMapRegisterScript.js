var map;

function initializeMap() {
  var mapProp = {
    center:new google.maps.LatLng(-5.8378122,-35.1989288),
    zoom:15,
    mapTypeId:google.maps.MapTypeId.ROADMAP
  };
  map=new google.maps.Map(document.getElementById("mapa"),mapProp);
}

google.maps.event.addDomListener(window, 'load', initializeMap);