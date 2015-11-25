var map;
var problems = [];

function initializeMap() {
  var mapProp = {
    center:new google.maps.LatLng(-5.8378122,-35.1989288),
    zoom:15,
    mapTypeId:google.maps.MapTypeId.ROADMAP
  };
  map=new google.maps.Map(document.getElementById("mapa"),mapProp);
}

function loadMarkers() {
	for (var i = 0; i < problems.length; i++) {
		var problem = problems[i];
		var location = new google.maps.LatLng(problem.latitude, problem.longitude);
		var marker = new google.maps.Marker({
	        position: location,
	        map: map
	    });
		marker.setMap(map);
	}
}

function initialize() {
	google.maps.event.addDomListener(window, 'load', initializeMap);
	google.maps.event.addDomListener(window, 'load', loadMarkers);
}