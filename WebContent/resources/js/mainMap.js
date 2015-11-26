function inicializeMap(){
	var map = L.map('map').setView([-5.8378122,-35.1989288], 13);
			    		L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
			    		    attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">Mapbox</a>',
			    		    maxZoom: 18,
			    		    id: 'mapbox.streets',
			    		    accessToken: 'pk.eyJ1IjoiYnJ1bm9tb3JlaXJhIiwiYSI6ImNpaGV4aWR0NDBsdGF0Y2x6ZjA0MXB6aGMifQ.84LECZ-gs3Z7zjffGnezjQ'
			    		}).addTo(map);
}

inicializeMap();