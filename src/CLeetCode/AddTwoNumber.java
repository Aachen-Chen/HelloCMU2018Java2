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

class OldSolution{
    private static ListNode sol2(ListNode l1, ListNode l2){
        StringBuilder sb1 = dfs(l1);
        StringBuilder sb2 = dfs(l2);
        // int resultNum = Integer.parseInt(sb1.toString())+Integer.parseInt(sb2.toString());   // Wrong because int not large enough.
        String resultString = stringAdd(sb1.toString(), sb2.toString());
        // String resultString = stringAdd("10", "10");
        ListNode result = build(resultString, resultString.length()-1);
        // ListNode result = build("123", 2);
        return result;
    }
    private static StringBuilder dfs(ListNode cur){
        if(cur==null) return null;
        StringBuilder child = dfs(cur.next);
        if(child==null) return new StringBuilder(String.valueOf(cur.val));
        child.append(cur.val);
        return child;
        // [3,2,1] -> "123"
    }

    private static String stringAdd(String s1, String s2){
        if(s1==null || s2==null) {return null;}
        if(s1.length()<s2.length()){
            String temp = s1; s1 = s2; s2 = temp;
        }
        // "123" -> [3,2,1]
        char[] cLong = (new StringBuilder(s1)).reverse().toString().toCharArray();
        char[] cShort= (new StringBuilder(s2)).reverse().toString().toCharArray();
        boolean ten = false;
        for(int i=0; i<cLong.length; i++){
            if(i<cShort.length) {
                cLong[i]=(char)(cLong[i]+cShort[i]-48);
            }
            if(ten) {
                cLong[i]=(char)(cLong[i]+1);
                ten = false;
            }
            if(cLong[i]>'9') {
                cLong[i]=(char)(cLong[i]-10);
                ten = true;
            }
        }
        StringBuilder sb = new StringBuilder(new String(cLong));
        if(ten){ sb.append("1"); }
        return sb.reverse().toString();
    }

    private static ListNode build(String s, int index){
        if(s==null || index<0) return null;
        int curDigit = s.charAt(index)-48;
        ListNode cur = new ListNode(curDigit);
        cur.next = build(s, index-1);
        return cur;
    }

}