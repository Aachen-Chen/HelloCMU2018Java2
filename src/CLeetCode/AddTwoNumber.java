package CLeetCode;


public class AddTwoNumber {
    public static void main(String[] args){
        ListNode n1 = null;
        ListNode n2 = null;
        for(int i=1; i<4; i++){
            ListNode cur = new ListNode(i);
            cur.next = n1;
            n1 = cur;

            cur = new ListNode(i);
            cur.next = n2;
            n2 = cur;
        }
//        System.out.println(n1.toString());
//        System.out.println(n2.toString());
        ListNode l = addTwoNumbers(n1, n2);
        System.out.println(l.toString());

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        ListNode cur = l1;
        while(cur != null){
            sb1.insert(0, cur.val);
            cur = cur.next;
        }
        cur = l2;
        while(cur != null){
            sb2.insert(0, cur.val);
            cur = cur.next;
        }

        char[] c1;
        char[] c2;
        if(sb1.length()>sb2.length()){
            c1 = sb1.toString().toCharArray();
            c2 = sb2.toString().toCharArray();
        }
        else{
            c2 = sb1.toString().toCharArray();
            c1 = sb2.toString().toCharArray();
        }

        int[] sumList = new int[c1.length];
        int additional = 0;
        for(int i=0; i<c2.length; i++){
            int sum= (int)c1[i] + (int)c2[i] + additional - 96;
            additional = sum/10;
            sumList[i] = sum%10;
        }
        if(c1.length>c2.length)
            for(int i=c2.length; i<c1.length; i++){
                int sum= (int)c1[i] +additional -48;
                additional = sum/10;
                sumList[i] = sum%10;
            }

        ListNode x = null;
        for(int a: sumList){
            ListNode current = new ListNode(a);
            current.next = x;
            x = current;
        }

        if(additional==1){
            ListNode current = new ListNode(1);
            current.next = x;
            x = current;
        }
        return x;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public String toString(){
        ListNode cur = new ListNode(this.val);
        cur.next = this.next;
        StringBuilder sb = new StringBuilder();
        while(cur!=null){
            sb.append(cur.val);
            cur = cur.next;
        }
        return sb.toString();
    }
}