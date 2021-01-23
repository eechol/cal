public class Cal {
    public static void main(String[] args) {
        
    }

    public static void reverse(Node h){
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

    public static void swim(int[] arr ,int k){

    }

    public static void sink(int[] arr, int k){

    }

    public static void swap(int[] arr, int m, int n){
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

}

class Node{
    Integer data;
    Node next;
}