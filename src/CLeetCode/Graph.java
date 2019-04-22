package CLeetCode;

import java.util.*;

public class Graph {
    // 190203
    List<Vertex> vertices;
    Graph(){
        vertices = new ArrayList<>();
    }

    public void addNode(Vertex v){
        this.vertices.add(v);
    }

    public Vertex getNode(int index){
        return vertices.get(index);
    }
}

class Vertex{
    static final String NEW = "NEW";
    static final String CUR = "CUR";
    static final String OLD = "OLD";

    Edge edges;
    int value;
    String status;
    Vertex previous;

    // For BFS
    int depth;

    // For DFS
    int in;
    int out;

    Vertex(){ this.status = Vertex.NEW; }
}

class Edge{
    int index;
    Edge sibling;   // ListNode
    Edge(int index){ this.index = index; }
}

class GraphSorter{
    public static void bfs(Graph g, int s){
        bfs(g, g.vertices.get(s));
    }
    // Thus, the purpose of Search is to find the depth, depth is defined as the length of shortest path to start.
    public static void bfs(Graph g, Vertex v){
        LinkedList<Vertex> queue = new LinkedList<>();
        if(v!=null) {
            queue.offer(v);
            v.depth =0; v.status = Vertex.CUR;
        }
        while(!queue.isEmpty()){
            Vertex cur = queue.poll();
            if(cur.edges==null) continue;
            Edge curEdge = cur.edges;
            while(curEdge != null){
                Vertex tar = g.getNode(curEdge.index);
                // check for NEW status
                if(tar.status.equals(Vertex.NEW)) {
                    // add on depth of previous one
                    tar.depth = cur.depth + 1;
                    tar.status = Vertex.CUR;
                    tar.previous = cur;
                    // The help of queue.
                    queue.push(tar);
                }
                curEdge = curEdge.sibling;
            }
            cur.status = Vertex.OLD;
        }
    }

    public static void dfs(Graph g, int s){
        dfs(g, g.vertices.get(s));
    }
    public static void dfs(Graph g, Vertex v){

    }
}

class PlayGround{
    public static void intializeGraph(){
        String instruction = "Start 3:\n" +
                "Node 0: 2\n" +
                "Node 1: 0, 2\n" +
                "Node 2:\n" +
                "Node 3: 1, 0";
        String[] lines = instruction.split("\n");
        int start = Integer.parseInt(lines[0].substring(lines[0].indexOf("\\s")+1, lines[0].indexOf(":")));
        Graph graph = new Graph();
        for(int i=1; i<lines.length; i++){
            int index = Integer.parseInt(lines[0].substring(lines[0].indexOf("\\s")+1, lines[0].indexOf(":")));
            String[] edges = lines[0].substring(lines[0].indexOf(":")+1, lines[0].indexOf(":")).split(",\\s");
            Vertex v =new Vertex();
            v.value = index;

            Edge head = new Edge(-1); Edge cur = head;
            for(String edge: edges){
                if(!edge.isEmpty()){
                cur.sibling = new Edge(Integer.parseInt(edge));
                cur = cur.sibling;
            }}
            v.edges = head.sibling;
            graph.addNode(v);
        }
    }

    public static void main(String[] args){
        System.out.println("abc"+new Character('a'));

    }
}

class MultiStartBFS {
    // 190204 Chuxi
    // 269. Alien Dictionary
    // BFS from multi source.
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
}







