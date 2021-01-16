public class Cal {
    public static void main(String[] args) {

    }

    public void reverse(Node h){
        if (null == h || null == h.next) return;
        Node pre = null;
        Node tmp = null;
        Node cur = h;
        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }
}

class Node{
    Integer data;
    Node next;
}