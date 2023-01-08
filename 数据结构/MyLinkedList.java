class  ListNode{
    public int val;
    public DoubleLinkedList.ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    public DoubleLinkedList.ListNode head;

    public void createList(){
        DoubleLinkedList.ListNode listNode1 = new DoubleLinkedList.ListNode(11);
        DoubleLinkedList.ListNode listNode2 = new DoubleLinkedList.ListNode(12);
        DoubleLinkedList.ListNode listNode3 = new DoubleLinkedList.ListNode(13);
        DoubleLinkedList.ListNode listNode4 = new DoubleLinkedList.ListNode(14);
        DoubleLinkedList.ListNode listNode5 = new DoubleLinkedList.ListNode(15);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        this.head.next = listNode1;
    }


    public void display(){
        DoubleLinkedList.ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }


    public void display2(DoubleLinkedList.ListNode newNode){
        DoubleLinkedList.ListNode cur = newNode;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }


    public boolean contains(int key) {
        DoubleLinkedList.ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public int size(){
        int count = 0;
        DoubleLinkedList.ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //头插
    public void addFirst(int data){
        DoubleLinkedList.ListNode node = new DoubleLinkedList.ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插
    public void addLast(int data){
        DoubleLinkedList.ListNode node = new DoubleLinkedList.ListNode(data);
        if(this.head == null){
            this.head = node;
        }else{
            DoubleLinkedList.ListNode cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //找到index-1位置的节点的地址
    public DoubleLinkedList.ListNode findIndex(int index){
        DoubleLinkedList.ListNode cur = this.head;
        while(index -1 != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data){
        if(index < 0 || index > size()){
            System.out.println("index位置不合法！");
            return ;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }
        DoubleLinkedList.ListNode cur = findIndex(index);
        DoubleLinkedList.ListNode node = new DoubleLinkedList.ListNode(data);
        node.next = cur.next;
        cur.next = node;
    }

    //找到 要删除的关键字的前驱
    public DoubleLinkedList.ListNode searchPrev(int key){
        DoubleLinkedList.ListNode cur = this.head;
        while(cur.next != null){
            if(cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null){
            System.out.println("单链表为空，不能删除！");
            return;
        }
        if(this.head.val == key){
            this.head = head.next;
            return;
        }
        DoubleLinkedList.ListNode cur = searchPrev(key);
        if(cur == null){
            System.out.println("没有你要删除的节点！");
            return;
        }
        DoubleLinkedList.ListNode del = cur.next;
        cur.next = del.next;
    }


    public DoubleLinkedList.ListNode removeAllKey(int key){
        if(this.head == null) return null;
        DoubleLinkedList.ListNode prev = this.head;
        DoubleLinkedList.ListNode cur = this.head.next;
        while(cur != null) {
            if(cur.val == key){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        if(this.head.val == key){
            this.head = this.head.next;
        }
        return this.head;
    }

        public void clear(){
            while(this.head != null){
                DoubleLinkedList.ListNode next = this.head.next;
                this.head = null;
                this.head = next;
            }
        }

        public DoubleLinkedList.ListNode reverseList(){
            if(this.head  == null){
                return null;
            }

            DoubleLinkedList.ListNode prev = null;
            DoubleLinkedList.ListNode cur = this.head;

            while(cur != null){
                DoubleLinkedList.ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }

    

}
