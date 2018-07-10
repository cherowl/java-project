package etu.model;

import etu.model.heapsort.BinTree.NodeTree;
import etu.model.heapsort.BinTree.BinTree;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class BuildGraph {

	private final NodeTree nodeTree;
	Graph graph = new SingleGraph("G", false, true);
	int i = 0;

	public BuildGraph (NodeTree nodeTree) {
		this.nodeTree = nodeTree;
	}

	public void createGraph(NodeTree node, Node parent, int offset) {
		if (node == null) {
			return;
		}

		int max_depth = BinTree.maxDepth(node);

		if( i == 0 ){
			Node w = graph.addNode(String.valueOf(i++));
			w.setAttribute("xy", 0, -node.getLevel()* 25);
			w.setAttribute("label", node.getValue());
			parent = w;
		}

		if (node.getLeft() != null) {
			Node e = graph.addNode(String.valueOf(i++));
			e.setAttribute("xy", offset - 5*Math.pow(2, max_depth - node.getLeft().getLevel()), - node.getLeft().getLevel() * 25);
			e.setAttribute("label", node.getLeft().getValue());
			createGraph(node.getLeft(), e, offset - 5*(int)Math.pow(2, max_depth - node.getLeft().getLevel()));
			graph.addEdge(String.valueOf(i++), parent, e);
		}

		if (node.getRight() != null) {
			Node q = graph.addNode(String.valueOf(i++));
			q.setAttribute("xy", offset + 5*Math.pow(2, max_depth - node.getRight().getLevel()) ,  -node.getRight().getLevel() * 25);
			q.setAttribute("label", node.getRight().getValue());
			createGraph(node.getRight(), q, offset + 5*(int)Math.pow(2, max_depth - node.getRight().getLevel()));
			graph.addEdge(String.valueOf(i++), parent, q);
		}
	}

	public Graph build(){

		createGraph(nodeTree, null, 1);

		for (Node node : graph){
			node.addAttribute("ui.label", node.getAttributeCount());
		}

		graph.addAttribute("ui.stylesheet",
				"graph{fill-color: #BFD3F2;} " +
						"node{ " +
						"shape: circle;  " +
						"size: 20px, 20px; " +
						"fill-color: #5F6E86;" +
						"stroke-mode: plain;" +
						"text-mode: normal;" +
						"text-style: bold; " +
						"text-size: 15; " +
						"text-alignment: center;" +
						"size-mode: dyn-size;}");

		return graph;
	}
}