package it.polito.tdp.baseball.model;

import it.polito.tdp.baseball.db.BaseballDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

public class Model {

	private BaseballDAO dao;
	private Graph<People,DefaultEdge> grafo;
	private Map<String, People> playerIDMap;
	private Map<Integer, Team> teamIDMap;
	
	public Model() {
		dao = new BaseballDAO();
		this.playerIDMap = new HashMap<String, People>();
		this.teamIDMap = new HashMap<Integer, Team>();
		List<People> players = this.dao.readAllPlayers();
		for(People p: players) {
			playerIDMap.put(p.getPlayerID(), p);   }
		
		List<Team> teams = this.dao.readAllTeams();
		for(Team t: teams) {
			teamIDMap.put(t.getID(), t);   }
		
	}
	
	public void creaGrafo(int anno, double salario) {
		//crea l'oggetto grafo
		this.grafo = new SimpleGraph<People, DefaultEdge> (DefaultEdge.class);
		
		//aggiunta vertici con metodo getVertices
		//List<String> vertici = this.dao.getVertices(anno, salario);
		//for(String s: vertici) {
		//	this.grafo.addVertex(this.playerIDMap.get(s));  }
		
		//aggiunta vertici con metodo getVertices2
		Graphs.addAllVertices(grafo, this.dao.getVertices2(anno, salario));
		
		//aggiunta archi
		List<PlayersTeam> players = this.dao.getAppearences(anno);
		
		Set<People> vertici = this.grafo.vertexSet(); //filtriamo i player rispetto ad un certo salario --> OSSIA I VERTICI DI PRIMA
		List<PlayersTeam> playersFiltrato = new ArrayList<PlayersTeam>(players);
		for(PlayersTeam p: players) {
			if(!vertici.contains(this.playerIDMap.get(p.getPlayerID()))) 
				playersFiltrato.remove(p);
		}
		
		//cercare gli archi
		for(int i=0; i<playersFiltrato.size(); i++) {
			for(int j=0; j<playersFiltrato.size(); j++) {
				People p1 = this.playerIDMap.get(playersFiltrato.get(i).getPlayerID());
				People p2 = this.playerIDMap.get(playersFiltrato.get(j).getPlayerID());
				int team1 = playersFiltrato.get(i).getTeamID();
				int team2 = playersFiltrato.get(j).getTeamID();
				if(!p1.equals(p2) && team1==team2) {
					grafo.addEdge(p1, p2);  }
			}
		}
		
	}
	
	public List<Grado> gradoMassimo() {
		List<Grado> result = new ArrayList<Grado>();
		int bestGrado = 0;
		for(People p: this.grafo.vertexSet()) {
			int grado = Graphs.neighborListOf(grafo, p).size();
			if(grado == bestGrado) {
				result.add(new Grado(p, grado));
			} else if(grado>bestGrado) {
				result.clear();
				result.add(new Grado(p, grado)); 
				bestGrado = grado;}
		}
		return result;
	}
	
	
	public int componentiConnesse() {
		ConnectivityInspector<People, DefaultEdge> inspector =
				new ConnectivityInspector<People, DefaultEdge>(this.grafo);
		return inspector.connectedSets().size();
	}
	
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public int nVertices() {
		return this.grafo.vertexSet().size();
	}
	
}