package com.study.algorithms.linked;

import java.util.LinkedList;

/**
 * 简单非线程安全单向链表实现
 *
 * @author duchu
 * @date 2019/2/27 3:38 PM
 */
public class MySinglyLinkedList<T> {
    private Node<T> head;
    private volatile int size = 0;


    /**
     * 两个有序的链表合并
     */

    public MySinglyLinkedList<T> mergeSortLink(MySinglyLinkedList<T> singlyLinkedList1, MySinglyLinkedList<T> singlyLinkedList2) {
        return null;
    }

    /**
     * 删除链表倒数第 n 个结点
     * 思路：
     * 1、假如知道当前链表的长度（size）就比较简短，就是删除掉第（size-n）个节点
     * 2、假如不知道当前链表长度，需要想办法找到第（size-n）个节点，
     * 可以利用先后指针：先指针先遍历那个节点，慢指针在从头开始，当先指针遍历完成时，后指针指向的就是倒数第n+1个节点
     * <p>
     * 所有我们就按不知道长度的解法来解答
     */
    public Node<T> removeSpecfiedNode(int n) {
        if(n < 1 || head == null) {
            return head;
        }
        Node guard = new Node('/');
        guard.next = head;

        Node slow = guard;
        Node fast = guard;

        for(int i = 0; i < n; i++) {
            if(fast != null) {
                fast = fast.next;
            }
        }
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return guard.next;
    }


    /**
     * 检查当前链表是否有环
     * 思路：慢指针一次进行前进一个，快指针一次前进两个，假如链表中有环，那么慢指针肯定能"追上"快指针（当慢指针遍历一遍，快指针改好遍历两遍）
     *
     * @return
     */
    public boolean circleLink() {
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

        }
        return false;
    }

    /**
     * 找到链表的中间值
     * 思路：快慢指针，慢指针一次进行前进一个，快指针一次前进两个，当快指针为null时，慢指针指向的就是链表中间值
     */

    public T getMiddle() {

        Node<T> slow = head;
        Node<T> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.date;
    }

    /**
     * 实现链表的反转
     */
    public void reversal() {
        if (head == null) {
            return;
        }
        Node newHead = head;
        Node oldHead = head.next;
        head.next = null;

        while (oldHead != null) {
            Node willOldHead = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = willOldHead;
        }
        head = newHead;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            result[i++] = x.date;
        }
        return result;
    }

    /**
     * 删除指定数据(相当于删除指定节点)
     *
     * @param o
     * @return
     */
    public boolean remove(T o) {
        if (head == null) {
            return false;
        }
        Node<T> temp = head;
        Node<T> pre = head;

        while (temp != null) {
            if (temp.date.equals(o)) {
                //删除当前节点
                Node<T> next = temp.next;
                //临界条件，要删除最后一个节点（思路：则把最后一个节点置为null）
                if (next == null) {
                    pre.next = next;

                    //只有一个节点
                    if (size == 1) {
                        head = null;
                    }
                } else {
                    //当前节点非最后一个节点，则把当前节点删除掉（思路：把下一个节点的数据复制到当前节点，把当前节点的next指项当前节点的.next.next）
                    temp.date = next.date;
                    temp.next = next.next;
                }

                size--;
                return true;
            }
            pre = temp;
            temp = temp.getNext();
        }
        return false;

    }

    /**
     * 添加到数据到链表中
     *
     * @param object
     * @return
     */
    public MySinglyLinkedList add(T object) {
        Node tempNode = new Node<T>(object);

        Node<T> last = this.getLastNode();
        if (last == null) {
            head = tempNode;
        } else {
            last.setNext(tempNode);
        }
        size++;
        return this;
    }

    public T getLast() {
        if (head == null) {
            return null;
        }
        Node<T> last = this.getLastNode();
        if (last == null) {
            return null;
        }
        return last.date;

    }

    public int size() {
        return size;
    }


    /**
     * 获取最后一个节点
     *
     * @return
     */
    public Node getLastNode() {
        if (head == null) {
            return null;
        }
        Node nextNode = head;
        while (nextNode.hasNext()) {
            nextNode = nextNode.getNext();
        }
        return nextNode;
    }


    class Node<T> {
        private T date;
        private Node next;

        public boolean hasNext() {
            return next != null;
        }

        public Node() {
        }

        public Node(T date) {
            this.date = date;
        }

        public T getDate() {
            return date;
        }

        public void setDate(T date) {
            this.date = date;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
