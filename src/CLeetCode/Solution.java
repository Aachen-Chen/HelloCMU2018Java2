package CLeetCode;

import java.util.*;


public class Solution {
    // Make neighborTable and result public to all method,
    // so don't have to pass by value.
    // Also distinguish local and shared variables.
    List<List<String>> res = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();

    public List<List<String>> findLadders(
        String beg, String end, List<String> wordL)
    {
        if(wordL==null || wordL.size()==0) return res;
        HashSet<String> dic = new HashSet<>(wordL);
        if(!dic.contains(end)) return res;
        HashSet<String> sta = new HashSet<>();
        HashSet<String> sto = new HashSet<>();
        List<String> path = new ArrayList<>();
        sta.add(beg);
        sto.add(end);
        path.add(beg);

        bfs(sta, sto, dic, false);
        dfs(beg, end, path);

        return res;
    }

    private void bfs(
        HashSet<String> sta, HashSet<String> sto, HashSet<String> dic, boolean reverse)
    {
        // If have nothing to start with
        if(sta.size()==0) return;
        // Ok. Traverse from both side of map.
        if(sta.size()>sto.size()) {
            bfs(sto, sta, dic, !reverse); return;
        }

        HashSet<String> next = new HashSet<>();
        boolean finished = false;
        // For each candidate in waitlist (HashSet next)
        for(String s: sta){
            char[] arr=s.toCharArray();
            // Search for all neighbor, add them to waitlist
            for(int i=0; i<arr.length; i++){
                // All neighbors (if more than one)
                // are added to waitlist.
                char tmp = arr[i];
                // Try out every possible String
                for(char c='a'; c<='z'; c++){
                    if(c == tmp) continue;
                    arr[i] = c;
                    String nStr = new String(arr);
                    if(dic.contains(nStr)){
                        // If reach the stop elements, stop bfs.
                        if(sto.contains(nStr)) finished = true;
                        // Record current location
                        else next.add(nStr);
                        // Fill the map
                        String key = reverse? nStr:s;
                        String val = reverse? s:nStr;
                        if(!map.containsKey(key))
                            map.put(key, new ArrayList<>());
                        map.get(key).add(val);
                    }
                }
                arr[i]=tmp;
            }
        }
        // The neighbor start without previous node
        dic.removeAll(sta);
        if (!finished) bfs(next, sto, dic, reverse);
        // Key takeaway: two ways to record path:
        //    1. Make a queue, use while, traverse each, delete previous, add new
        //    2. Make a set, recurse, traverse each, delete previous, add new, give to next point.
    }

    // Key difference between bfs & dfs:
    //   BFS: record current neighbor list, traverse list first;
    //   DFS: just recurse on each neighbor found.
    private void dfs(String beg, String end, List<String> path){
        if(beg.equals(end)){res.add(new ArrayList<>(path));     return;}
        if(!map.containsKey(beg)) return;
        // For
        for(String next : map.get(beg)){
            path.add(next);
            dfs(next, end, path);
            // Roll back to root.
            path.remove(path.size()-1);
        }
    }

}




class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}


class TreePreorder {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        // sol_recursion(root);
        // return res;

        List<Integer> candidates = new ArrayList<>();
        return sol_wout_recursion(root, candidates);
    }

    private void sol_recursion(TreeNode cur){
        if(cur==null) return;
        res.add(cur.val);
        sol_recursion(cur.left);
        sol_recursion(cur.right);
    }

    private List<Integer> sol_wout_recursion(TreeNode root, List<Integer> candidates){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode cur = null;
        queue.push(root);
        while(!queue.isEmpty()){
            cur = queue.pop();
            candidates.add(cur.val);
            if(cur.right!=null) queue.push(cur.right);
            if(cur.left!=null) queue.push(cur.left);
        }
        return candidates;
    }
}




