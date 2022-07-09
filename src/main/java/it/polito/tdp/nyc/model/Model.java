package it.polito.tdp.nyc.model;

import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.Track;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.nyc.db.NYCDao;

public class Model {
	
	private NYCDao dao;
	
	private Graph<String,DefaultWeightedEdge> grafo;
	LinkedList<String> vertici = new LinkedList<String>();

    public Model() {
	
	this.dao = new NYCDao();
}


public void creaGrafo(String provider) {
	
	this.grafo = 
			new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
	
	//aggiungo i vertici
	
	
	vertici.clear();
	for(String s : dao.getVertici(provider)) {
		vertici.add(s);
	}
	
	
	Graphs.addAllVertices(this.grafo,vertici);
	
	for(Hotspot h1 : dao.getAllHotspot()) {
		for(Hotspot h2 : dao.getAllHotspot()) {
			
			if( h1 != h2 )
		}
	}

	
	
}

public List<String> getAllProvider(){
	
	return dao.getProvider();
}

public List<String> getVertici(String provider){
	return dao.getVertici(provider);
}

public int nVertici() {
	return this.grafo.vertexSet().size();
}

public int nArchi() {
	return this.grafo.edgeSet().size();
}


}