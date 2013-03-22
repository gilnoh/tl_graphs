package fragmentGraph;

import org.junit.Test;

public class FragmentGraphTest {

	@Test
	public void test() {
		FragmentGraph<FragmentGraphNode,FragmentGraphEdge<FragmentGraphNode>> g = new FragmentGraph(FragmentGraphEdge.class);
		
		// make nodes
		FragmentGraphNode v1 = new FragmentGraphNode("base statement");
		FragmentGraphNode v2 = new FragmentGraphNode("base statement + M1",1);
		FragmentGraphNode v3 = new FragmentGraphNode("base statement + M2",1);
		FragmentGraphNode v4 = new FragmentGraphNode("base statement + M1 + M2",2);
		
		// add nodes to graph
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		
		// add an edge with explicit edge object
		g.addEdge(v1, v2, new FragmentGraphEdge<FragmentGraphNode>(v1, v2, 3.0));
		
		// add an edge using the default method
		g.addEdge(v1, v3);
		g.addEdge(v2, v4);
		g.addEdge(v3, v4);
		
		System.out.println("Graph: \\" + g.toString());
	}
}
