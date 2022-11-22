public class Cal {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 8, 16, 7, 5, 12, 18};
//        Node first = new Node();
//        first.setData(2);
//        Node two = new Node();
//        two.setData(1);
//        Node three = new Node();
//        three.setData(10);
//        Node four = new Node();
//        four.setData(12);
//        Node five = new Node();
//        five.setData(5);
//        first.setNext(two);
//        two.setNext(three);
//        three.setNext(four);
//        four.setNext(five);
//
//        print(first);
//        System.out.printf("this is a cut " + "\n");
//        print(reverse(first));
//        heapSort(arr);
        dTuMerge(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + "\n");
        }
    }

    /**
     * 堆调整
     *
     * @param arr
     * @param n
     * @param i
     */
    public static void adjust(int[] arr, int n, int i) {
        int parent = i;
        int l_ch = 2 * i + 1;
        int r_ch = 2 * (i + 1);
        if (l_ch < n && arr[parent] < arr[l_ch]) {
            swap(arr, parent, l_ch);
            adjust(arr, n, l_ch);
        }

        if (r_ch < n && arr[parent] < arr[r_ch]) {
            swap(arr, parent, r_ch);
            adjust(arr, n, r_ch);
        }
    }

    /**
     * 堆排
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null) return;
        int n = arr.length;
        // 建堆
        for (int i = n / 2; i >= 0; i--) {
            adjust(arr, n, i);
        }
        // 排序
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjust(arr, i, 0);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null) return;
        int[] temp = new int[arr.length];
        int low = 0;
        int high = arr.length - 1;
        mergeS(arr, temp, low, high);
    }

    /**
     * 递归切分
     *
     * @param arr
     * @param temp
     * @param low
     * @param high
     */
    public static void mergeS(int[] arr, int[] temp, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeS(arr, temp, low, mid);
            mergeS(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    /**
     * 归并递归
     *
     * @param arr
     * @param temp
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        int p = low;
        int lp = low;
        int rp = mid + 1;
        while (lp <= mid && rp <= high) {
            if (lp <= mid && arr[lp] < arr[rp]) {
                temp[p++] = arr[lp++];
            }
            if (rp <= high && arr[rp] < arr[lp]) {
                temp[p++] = arr[rp++];
            }
        }
        while (lp <= mid) {
            temp[p++] = arr[lp++];
        }
        while (rp <= high) {
            temp[p++] = arr[rp++];
        }
        while (low <= high) {
            arr[low] = temp[low++];
        }
    }

    /**
     * 原地归并
     *
     * @param arr
     */
    public static void dTuMerge(int[] arr) {
        if (null == arr || arr.length == 1) return;
        int[] temp = new int[arr.length];
        for (int i = 2; i < arr.length; i = 2 * i) {
            for (int j = 0; j + i < arr.length; j = j + i) {
                merge(arr, temp, j, j + (i - 1) / 2, j + i - 1);
            }
        }
    }

    /**
     * 翻转链表
     *
     * @param h
     * @return
     */
    public static Node reverse(Node h) {
        if (null == h || null == h.next) return h;
        Node pre = null;
        Node tmp = null;
        Node cur = h;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void print(Node n) {
        if (n == null) return;
        while (null != n) {
            System.out.print("this is " + n.getData() + "\n");
            n = n.next;
        }
    }

//    public static void swim(int[] arr, int k, int len) {
//        while (k >= 0) {
//            k = len / 2 - 1;
//            if (2 * k + 3 > len) {
//                if (bigThan(arr[2 * k + 1], arr[k])) {
//                    return;
//                } else {
//                    swap(arr, 2 * k + 1, k);
//                }
//            } else {
//                if (bigThan(arr[2 * k + 1], arr[2 * k + 2])) {
//                    if (bigThan(arr[2 * k + 1], arr[k])) {
//                        swap(arr, 2 * k + 1, k);
//                    }
//                } else {
//                    if (bigThan(arr[2 * k + 2], arr[k])) {
//                        swap(arr, 2 * k + 2, k);
//                    }
//                }
//            }
//        }
//    }

    public static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static boolean bigThan(int a, int b) {
        return a >= b;
    }

}


class Node {
    Integer data;
    Node next;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}