package CLeetCode;

import java.util.*;

import BasicExample.CollectionExample;

public class WordLadderII126 implements CollectionExample.WordLadderII126 {

    List<List<String>> res=new ArrayList();
    HashMap<String,List<String>> map=new HashMap();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null||wordList.size()==0) return res;
        HashSet<String> dic=new HashSet(wordList);
        HashSet<String> start=new HashSet();
        HashSet<String> end=new HashSet();
        if(!dic.contains(endWord)) return res;
        start.add(beginWord);
        end.add(endWord);
        buildMap(start,end,dic,false);
        List<String> path=new ArrayList();
        path.add(beginWord);
        dfs(beginWord,endWord,path);
        return res;
    }
    public void buildMap(HashSet<String> start,HashSet<String> end,HashSet<String> dic,boolean reverse){
        if(start.size()==0) return;
        if(start.size()>end.size()){buildMap(end,start,dic,!reverse);return;}
        HashSet<String> next=new HashSet();
        dic.removeAll(start);
        boolean finished=false;
        for(String s:start){
            char[] arr=s.toCharArray();
            for(int i=0;i<arr.length;i++){
                char tmp=arr[i];
                for(char c='a';c<='z';c++){
                    if(c==tmp) continue;
                    arr[i]=c;
                    String nStr=new String(arr);
                    if(dic.contains(nStr)){
                        if(end.contains(nStr)) finished=true;
                        else next.add(nStr);
                        String key=reverse?nStr:s;
                        String val=reverse?s:nStr;
                        if(!map.containsKey(key)) map.put(key,new ArrayList());
                        map.get(key).add(val);
                    }
                }
                arr[i]=tmp;
            }
        }
        if(!finished) buildMap(next,end,dic,reverse);
    }
    public void dfs(String begin,String end,List<String> path){
        if(begin.equals(end)){
            res.add(new ArrayList(path));
            return;
        }
        if(!map.containsKey(begin)) return;
        for(String next:map.get(begin)){
            path.add(next);
            dfs(next,end,path);
            path.remove(path.size()-1);
        }
    }
}


class Solution2 {
    public List<List<String>> findLadders(String start, String end, List<String> wordList){
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        List<String> solution = new ArrayList<String>();

        HashMap<String, HashSet<String>> adjunctList = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> distanceList = new HashMap<String, Integer>();

        // ????debug????????
        dict.add(start);
        bfs(start,end,dict,adjunctList,distanceList);
        dfs(start,end,dict,adjunctList,distanceList, solution, result);
        return result;
    }
    private void bfs(String start, String end, HashSet<String> dict,
                     HashMap<String, HashSet<String>> adjunctList, HashMap<String, Integer> distanceList){
        for (String x: dict)
            adjunctList.put(x, new HashSet<>());

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distanceList.put(start, 0);

        while(!queue.isEmpty()){
            boolean foundEnd = false;
            int len = queue.size();
            for(int i=0; i<len; i++){
                String cur = queue.poll();
                int curDistance = distanceList.get(cur);
                List<String> neighbors = findNeighbor(cur, dict);
                adjunctList.put(cur, new HashSet<String>(neighbors));

                for(String neighbor: neighbors){
                    if(! distanceList.containsKey(neighbor)){
                        distanceList.put(neighbor, curDistance+1);
                        if(neighbor.equals(end)) foundEnd = true;
                        else queue.offer(neighbor);
                    }
                }
            }
            if(foundEnd) break;
        }
    }
    private List<String> findNeighbor(String cur, HashSet<String> dict){
        List<String> res = new ArrayList<String>();
        char[] chars = cur.toCharArray();
        for(char ch='a'; ch<= 'z'; ch++){
            for(int i=0; i<chars.length; i++){
                if(ch==chars[i]) continue;
                char oldch = chars[i];
                chars[i] = ch;
                if(dict.contains(String.valueOf(chars)))
                    res.add(String.valueOf(chars));
                chars[i] = oldch;
            }
        }
        return res;
    }

    private void dfs(String cur, String end, HashSet<String> dict,
                     HashMap<String, HashSet<String>> adjunctList, HashMap<String, Integer> distanceList,
                     List<String> solution, List<List<String>> result){
        solution.add(cur);
        if(cur.equals(end)) result.add(new ArrayList<>(solution));
            // ????????????????
        else{
            for(String next: adjunctList.get(cur)){
                if(distanceList.get(next) == distanceList.get(cur)+1)
                    dfs(next, end, dict, adjunctList, distanceList, solution, result);
            }
        }
        solution.remove(solution.size()-1);
    }

}
