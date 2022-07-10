package it.polito.tdp.nyc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sound.midi.Track;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.nyc.db.NYCDao;

public class Model {
	
	private NYCDao dao;
	
	private Graph<City,DefaultWeightedEdge> grafo;
	LinkedList<City> vertici = new LinkedList<City>();
	Map<String,Adiacenza> aMap = new TreeMap<String,Adiacenza>();
	LinkedList<Adiacenza> listaA = new LinkedList<Adiacenza>();

    public Model() {
	
	this.dao = new NYCDao();
}


public void creaGrafo(String provider) {
	
	this.grafo = 
			new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
	
	//aggiungo i vertici
	
	
	vertici.clear();
	for(City s : dao.getCities(provider)) {
		vertici.add(s);
	}
	
	
	Graphs.addAllVertices(this.grafo,vertici);
	
	listaA.clear();
	
	for(City c1 : this.grafo.vertexSet()) {
		for(City c2: this.grafo.vertexSet()) {
			
			if(c1.city.compareTo(c2.city)!= 0 ) {
				
				Double distanza = LatLngTool.distance(c1.getLatlng(), c2.getLatlng(),LengthUnit.KILOMETER );
				
				
				Graphs.addEdgeWithVertices(this.grafo, c1, c2, distanza);
			}
		}
	}
	
	
}

public List<CityDistance> getCityDistances(City scelto) {
	List<CityDistance> result = new ArrayList<>();
	List<City> vicini = Graphs.neighborListOf(this.grafo, scelto);
	for(City v: vicini) {
		result.add(new CityDistance(v.city, 
				this.grafo.getEdgeWeight(this.grafo.getEdge(scelto, v)))) ;
	}
	
	Collections.sort(result, new Comparator<CityDistance>() {
		@Override
		public int compare(CityDistance o1, CityDistance o2) {
			return o1.getDistanza().compareTo(o2.getDistanza());
		}			
	});
	
	return result ;
}

/*public List<CityDistance> getAdiacenze(City quartiere){

	List<CityDistance> lista = new ArrayList<>();
	
	List<City> vicini = Graphs.neighborListOf(this.grafo, quartiere);
	
	for(City v: vicini) {
		
		lista.add(new CityDistance(v.city, 
				this.grafo.getEdgeWeight(this.grafo.getEdge(quartiere, v)))) ;
	}
	
	Collections.sort(lista);
	
	return lista;
	
}

*/


public List<String> getAllProvider(){
	
	return dao.getProvider();
}

public List<City> getVertici(String provider){
	return dao.getCities(provider);
}

public int nVertici() {
	return this.grafo.vertexSet().size();
}

public int nArchi() {
	return this.grafo.edgeSet().size();
}


}