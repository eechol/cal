public class Cal {
    public static void main(String[] args) {
        int[] arr = {10,9,2,7,16,7,5,12};
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

    public static void swim(int[] arr ,int k, int len){
        while(k>=0){
            k = len / 2 - 1;
            if(2*k +3 > len){
                if(bigThan(arr[2*k +1],arr[k])){
                    return;
                }else{
                    swap(arr,2*k +1, k);
                }
            }else {
                if (bigThan(arr[2 * k + 1], arr[2 * k + 2])) {
                    if (bigThan(arr[2 * k + 1], arr[k])) {
                        swap(arr, 2 * k + 1, k);
                    }
                } else {
                    if (bigThan(arr[2 * k + 2], arr[k])) {
                        swap(arr, 2 * k + 2, k);
                    }
                }
            }
        }
    }

    public static void sink(int[] arr, int k, int len){

    }

    public static void swap(int[] arr, int m, int n){
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static boolean bigThan(int a, int b){
        return a >= b;
    }

}

class Node{
    Integer data;
    Node next;
}