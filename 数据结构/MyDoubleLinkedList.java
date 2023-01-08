package DoubleLinkedList;

import java.util.List;

class ListNode{
    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode(int val){
        this.val  = val;
    }
}

public class MyDoubleLinkedList {
    public ListNode head;

    public ListNode last;

    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public int size(){
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }


    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            node.next = this.head;
            this.head.prev = node;
            this.head  = node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }


    //寻找下标为 index 的节点
    public ListNode searchIndex(int index){
        ListNode cur = this.head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index , int data){
        if(index < 0 || index > size()){
            System.out.println("index位置不合法！");
            return;
        }

        if(index == 0){
            addFirst(data);
            return;
        }

        if(index == size()){
            addLast(data);
            return ;
        }

        ListNode node  = new ListNode(data);
        ListNode cur = searchIndex(index);
        node.prev = cur.prev;
        cur.prev.next = node;
        node.next = cur;
        cur.prev = node;
    }

    public void remove(int key){
        if(this.head == null)  return ;

        ListNode cur  = this.head;
        while(cur != null) {
            if(cur.val == key){
                if(cur == this.head){ //要删除的节点就在头部
                    head = head.next;
                    if(head != null){
                        head.prev = null;
                    } else{
                      last = null;
                    }
                }else{
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev =  cur.prev;
                    }else{
                        last = last.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

    public void removeAllKey(int key){
        if(head == null) return ;

        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){
                if(cur == head){
                    head  = head.next;
                    if(head != null){
                        head.prev = null;
                    }else{
                        last = null;
                    }
                }else{
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{
                        last = last.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    public void clear(){
        while(head != null) {
            ListNode curNext = head.next;
            head.prev = null;
            head.next = null;
            head = curNext;
        }
        last = null;
    }
}
