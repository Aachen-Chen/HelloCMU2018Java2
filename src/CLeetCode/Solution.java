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

class kEmptySlot683{
    public int kEmptySlots(int[] flowers, int k) {
        // flowers record position of flower given day
        // days record day of bloom given position
        int[] days =  new int[flowers.length];
        // for each flower, record bloom day
        for(int i=0; i<flowers.length; i++) days[flowers[i] - 1] = i + 1;
        // compare pair of flowers, starting from flower 0 and k+1
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        // for each flower
        for(int i = 0; right < days.length; i++){
            // if this flower bloom before left or right flower (or that it is the right flower)
            if(days[i] < days[left] || days[i] <= days[right]){
                // but if all days between left and right is checked, and now we reach right,
                if(i == right)res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                // means that the flower cannot be included.
                left = i;
                right = k + 1 + i;
            }
        }
        // if we haven't got answer, res is max value.
        return (res == Integer.MAX_VALUE)?-1:res;
    }


    public int kEmptySlotsHandWrote(int[] flowers, int k) {
        // first, make new array to record each flower's day.
        int[] days = new int[flowers.length];
        // flowers[i] is the position, 1~N, need to be 0~N-1.
        // days[] is the days, 0~N-1, need to be 1~N.
        for(int i=0; i<flowers.length; i++) days[flowers[i]-1] = i+1;
        // Set cursor before searching.
        // right need to be k+1, because either end doesn't count. between (0, k+1) it is [1, k]
        int l = 0, r = k+1, result = Integer.MAX_VALUE;
        // Now search the days array.
        // Do remember to check only right! because right out of bound means nothing left.
        for(int i=0; r<days.length; i++){
            // check if i is valid. Invalid i: between l and r, and bloom earlier (smaller)
            if(days[i]<days[l] || days[i]<=days[r]){
                // three situation: 1. i<=l, won't happen. 2. i==l+1, check. 3. i==r, reached.
                if(i==r)
                    // do remember max, not min! wait untill the later (larger) one.
                    // Additional rules: return the earliest of such valid days
                    result = Math.min(result, Math.max(days[l], days[r]));
                // otherwise, i is invalid.
                l = i;
                r = i+k+1;
            }
        }

        return result==Integer.MAX_VALUE?
                -1  :   result;
    }

    public static int practice1018(int[] flowers, int k){
        if(flowers == null || flowers.length==0 || flowers.length < k+2) return -1;

        int[] days = new int[flowers.length];
        for(int i=0; i<flowers.length; i++) days[flowers[i]-1] = i+1;

        int l=0;
        int r=k+1;
        int result = Integer.MAX_VALUE;
        for(int i=0; r<days.length; i++){
            if(days[i]<days[l] || days[i] <= days[r]){
                if(i == r) result = Math.min(result, Math.max(days[l], days[r]));
                l = i;
                r = k+1+i;
            }
        }

        return result==Integer.MAX_VALUE? -1:result;
    }
}



class NextCloestTime681{

    public String nextClosestTime(String time) {
        // The whole idea is terrific. But it is also hard to remember.
        // Idea:
        // First find current maximum, from minute to hour
        //      to be 'cloest', must be just larger.
        //      start from minute, so that must be smaller than start from hour
        //      start from current digit, and increment to 10, make sure smaller comes first
        //      if a replacement at smaller is found, no need for search on higher digits
        // Then try to find local minimum, from hour to minute.
        //      must be small enough.
        //          thus, every lower digit need to be check. Use recursion.
        //          when checking, start from 0 and increase, smallest comes first.
        //      cannot be smaller than before
        //          thus, only find minimal on next lower digit.
        int[] num = new int[4];
        char[] trans = time.toCharArray();

        // change into normal numbers
        num[0] = trans[0]-'0';
        num[1] = trans[1]-'0';
        num[2] = trans[3]-'0';
        num[3] = trans[4]-'0';

        StringBuilder res = new StringBuilder();
        // denotes available numbers
        boolean[] ava = new boolean[10];
        for(int i:num) ava[i] = true;

        label:
        // check each digit, from minute to hour.
        for(int index = 3; index>=-1; index--){
            // if no valid replacement found,
            // meaning that we cannot find a larger valid digit
            // then we minimize the current time.
            if(index == -1){
                makeMin(num,ava,0);
                break;
            }
            // for each digit, search for min(larger digit) to replace current digit.
            for(int rep=num[index]+1; rep<10; rep++){
                // Situation 1: not available: then check next.
                if(!ava[rep]) continue;

                // Situation 2: not valid. Search next replacement.
                // for minute ones digit, if replace it make something > 59, invalid
                if(index == 3 && num[2]*10 + rep>59) break;
                // for minute tenth digit, if a replacement > 5, invalid
                if(index == 2 && rep>5) break;
                // for hour ones digit, if replace it make something > 23, invalid
                if(index == 1 && num[0]*10 + rep>23) break;
                // for hour tenth digit, if a replacement > 2, invalid
                if(index == 0 && rep>2) break;
                // if there is a valid replacement, let's check!
                // replace current digit with replacement

                // Situation 3: it is larger (next), then make current time smallest (nearest)
                // (Sounds like Lagrange)
                num[index] = rep;
                // make num the minimum, start
                makeMin(num,ava,index+1);
                // then call it tonight.
                // reason is that:
                //  any replacement larger than current replacement would be larger than current minimum
                //  any valid replacement, if could be applied to minute, must be better than applying to hour
                break label;
            }
        }

        res.append(num[0]);
        res.append(num[1]);
        res.append(":");
        res.append(num[2]);
        res.append(num[3]);
        return res.toString();
    }

    private void makeMin(int[] num, boolean[] ava, int index){
        // if already out of bound then stop
        if(index == num.length) return;

        // check nums that are smaller current digit
        for(int i=0; i<=num[index]; i++){
            // if not available, next num.
            if(!ava[i]) continue;
            // if available,
            else{
                // replace current digit with smaller digit
                num[index] = i;
                // then see if digit to the right could be made smaller
                makeMin(num,ava,index+1);
                return;
            }
        }
    }

}

class NextCloestTime681Practice{
//    class Solution {
//        public String nextClosestTime(String time) {
//
//            char[] digitsChar = time.toCharArray();
//            int[] digits = new int[4];
//            for(int i=0; i<digitsChar.length; i++) digits[i] = digitsChar[i]-'0';
//
//            boolean[] availbility = new boolean[10];
//            for(int i: digits) availbility[i] = true;
//
//            // Try to increment digit. From minute to hour.
//            for(int pos=digits.length-1; pos>=-1; pos--){
//                if(pos==-1){
//                    break;
//                }
//                // test numbers that are larger then current digit.
//                for(int rep=digits[pos]+1; rep<10; rep++){
//                    if(!availbility[rep])                   continue;
//                    if(pos==3 && rep + digits[2]*10 > 59)   break;
//                    if(pos==2 && rep > 5){}                 break;
//                    if(pos==1 && rep + digits[0]*10 > 23)   break;
//                    if(pos==0 && rep > 2){}                 break;
//
//                }
//
//            }
//
//            return time;
//        }
//
//        private void makeMin(int[] digits, boolean[] availbility, int pos){
//
//        }
//    }
}


