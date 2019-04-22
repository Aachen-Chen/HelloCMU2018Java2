package CLeetCode;

import java.util.HashMap;

public class CopyListwithRandomPointer {

    // TODO: Solution:
    // 181228: on lc the fastest way simply create new node for random,
    //      rather than pointing to the node on chain. I don't think it is right.

    public RandomListNode copyRandomList181228(RandomListNode head) {
        if(head==null) return null;
        RandomListNode res = new RandomListNode(head.label);
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, res);

        RandomListNode cur=head.next;
        RandomListNode rescur=res;
        while(cur!=null){
            rescur.next = new RandomListNode(cur.label);
            rescur = rescur.next;
            map.put(cur, rescur);
            cur = cur.next;
        }

        cur=head; rescur=res;
        while(cur!=null){
            rescur.random = map.get(cur.random);
            rescur = rescur.next;
            cur = cur.next;
        }
        return res;
    }
}


//Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};




