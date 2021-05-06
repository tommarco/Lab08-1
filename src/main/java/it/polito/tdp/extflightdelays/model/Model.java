package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	private Map<Integer, Airport> idMap;

	public Model() {

		dao = new ExtFlightDelaysDAO();
		idMap = new HashMap<Integer, Airport>();

		dao.loadAllAirports(idMap);

	}

	public void creaGrafo(int x) {

		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

		// aggiungo vertici

		Graphs.addAllVertices(this.grafo, idMap.values());

		// aggiungo archi

		for (Adiacenza a : dao.getAdiacenze(x, idMap)) {

			if (this.grafo.containsVertex(a.getA1()) && this.grafo.containsVertex(a.getA2())) {

				DefaultWeightedEdge e = this.grafo.addEdge(a.getA1(), a.getA2());

				if (e == null) {
					Graphs.addEdgeWithVertices(this.grafo, a.getA1(), a.getA2(), a.getDistanzaMedia());

				} else {
					double distanzaNuova = (a.getDistanzaMedia()) / 2;

					this.grafo.setEdgeWeight(e, distanzaNuova);

				}

			}
		}
		System.out.println("Grafo creato");
		System.out.println("# vertici: " + grafo.vertexSet().size());
		System.out.println("# archi: " + grafo.edgeSet().size());

	}

	public int vertici() {

		return grafo.vertexSet().size();
	}

	public int archi() {

		return grafo.edgeSet().size();
	}

	public String stampaArchi() {

		String s = "";

		for (DefaultWeightedEdge e : grafo.edgeSet()) {

			s += e + " " + grafo.getEdgeWeight(e) + "\n";

		}

		return s;
	}

}
