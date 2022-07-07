package it.polito.tdp.nyc.model;

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

    public Model() {
	
	this.dao = new NYCDao();
}


public void creaGrafo(String provider) {
	
	this.grafo = 
			new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
	
	//aggiungo i vertici
	Graphs.addAllVertices(this.grafo,this.dao.getVertici(provider));
	
	
	for(String c1 : this.getVertici(provider)) {
		for(String c2 : this.getVertici(provider)) {
			if(!c1.equals(c2)) {
				double peso = LatLngTool.distance(c1.ub(), c2.getPosizione(), LengthUnit.KILOMETER);
				Graphs.addEdge(this.grafo, c1, c2, peso);
	
	
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