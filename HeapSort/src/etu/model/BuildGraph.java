package etu.model;

import etu.model.heapsort.BinTree.*;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BuildGraph {

	private final NodeTree nodeTree;
	Graph graph = new SingleGraph("G", false, true);
	int i = 0;

	public BuildGraph (NodeTree nodeTree) {
	    this.nodeTree = nodeTree;
	}

//	public void createNodes(NodeTree b, int d, int offset, int k) {
//		if (b == null) {
//            return;
//        }
//        System.out.print("The value of the root is: "); b.print();
////        int i = 0;
//		int count = 1;
//		Queue<NodeTree> queue = new LinkedList<>();
//		queue.add(b);
//		do {
//			NodeTree bt = queue.remove();
//			if( count == 1){
//				Node w = graph.addNode(String.valueOf(i++));
//				w.setAttribute("xy", d, -bt.getLevel() * 4);
//				w.setAttribute("label", bt.getValue());
//				System.out.print("root: " + bt.getValue()+" lev: "+bt.getLevel());
//				bt.setLevel();
//				System.out.println();
//
//			}
//			if(1 != count++) offset /= 2;
//			if (bt.getLeft() != null) {
//				Node e = graph.addNode(String.valueOf(i++));
//				e.setAttribute("xy", d - offset, -bt.getLeft().getLevel() * 4);
//
//				e.setAttribute("label", bt.getLeft().getValue());
//				System.out.print("left: "+bt.getLeft().getValue()+" lev: "+bt.getLeft().getLevel());
//				bt.getLeft().setLevel();
//				System.out.println();
//
//				queue.add(bt.getLeft());
//
//			}
//			if (bt.getRight() != null) {
//				Node q = graph.addNode(String.valueOf(i++));
//				q.setAttribute("xy", d + offset ,  -bt.getRight().getLevel() * 4);
//				q.setAttribute("label", bt.getRight().getValue());
//				System.out.print( "right: "+bt.getRight().getValue()+" lev: "+bt.getRight().getLevel());
//				bt.getRight().setLevel();
//				System.out.println();
//
//				queue.add(bt.getRight());
//			}
//		} while (!queue.isEmpty());
//	}


	public void createNodes(NodeTree b, int d, int offset, int k) {
		if (b == null) {
			return;
		}
		System.out.print("The value of the root is: "); b.print();
//        int i = 0;
		int count = 1;
		Stack<NodeTree> stack = new Stack<>();
		stack.push(b);
		do {
		    int newd = 0;
			NodeTree bt = queue.remove();
			if( 1 == count){
				Node w = graph.addNode(String.valueOf(i++));
				w.setAttribute("xy", d, -bt.getLevel() * 4);
				w.setAttribute("label", bt.getValue());
				System.out.print("root: " + bt.getValue()+" lev: "+bt.getLevel() + " p: 0");
                System.out.print(" d: "+d+" o: "+offset);
				System.out.println();
//                offset = newd;

			}
			if(1 != count) offset /= 2;
			if (bt.getLeft() != null) {
				Node e = graph.addNode(String.valueOf(i++));
				e.setAttribute("xy", d - offset, -bt.getLeft().getLevel() * 4);

				e.setAttribute("label", bt.getLeft().getValue());
				System.out.print("left: "+bt.getLeft().getValue()+" lev: "+bt.getLeft().getLevel()+ " p: "+bt.getLeft().getParent());
                newd = d - offset;
				System.out.print(" d: "+newd+" o: "+offset);

				System.out.println();

                offset = newd;
				queue.add(bt.getLeft());

			}
			if (bt.getRight() != null) {
				Node q = graph.addNode(String.valueOf(i++));
				q.setAttribute("xy", d + offset ,  -bt.getRight().getLevel() * 4);
				q.setAttribute("label", bt.getRight().getValue());
				System.out.print( "right: "+bt.getRight().getValue()+" lev: "+bt.getRight().getLevel()+ " p: "+bt.getRight().getParent());
                newd = d + offset;
				System.out.print(" d: "+newd+" o: "+offset);

                System.out.println();

                offset = newd;
                queue.add(bt.getRight());
			}
            count++;
		} while (!queue.isEmpty());
	}

	public Graph build(){

		createNodes(nodeTree, 0, 10, 0);

		for (Node node : graph){
			node.addAttribute("ui.label", node.getAttributeCount());
		}

		graph.addAttribute("ui.stylesheet",
				"graph{fill-color: gray;} " +
						"node{ " +
						"shape: circle;  " +
						"size: 30px, 30px; " +
						"fill-color: white;" +
						"stroke-mode: plain;" +
						"text-mode: normal;" +
						"text-mode: normal; " +
						"text-style: bold; " +
						"text-size: 20; " +
						"text-alignment: center;" +
						"size-mode: dyn-size;}");

//
//		for (int i = 1, k = 0; i < metaData.length; i++) {
//			graph.addEdge(String.valueOf(i), String.valueOf(k), String.valueOf(i), true);
//			if(i % 2 == 0) {
//				k++;
//			}
//		}


		return graph;
	}
}
