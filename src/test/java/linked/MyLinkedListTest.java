package linked;

import com.study.algorithms.linked.MySinglyLinkedList;

import java.util.Arrays;

/**
 * 简单非线程安全单向链表实现
 *
 * @author duchu
 * @date 2019/2/27 3:38 PM
 */
public class MyLinkedListTest {
    public static void main(String[] args) {
//        MySinglyLinkedList mySinglyLinkedList = new MySinglyLinkedList();
//        mySinglyLinkedList.add(1).add(2);
//        System.out.println(mySinglyLinkedList.size());
//        System.out.println(mySinglyLinkedList.getLast());
//
//        System.out.println(mySinglyLinkedList.remove(1));
//        System.out.println(mySinglyLinkedList.remove(2));
//
//        System.out.println(mySinglyLinkedList.size());
//
//
//        System.out.println(mySinglyLinkedList.getLast());


        /**
         * 反转测试
         */
        MySinglyLinkedList re = new MySinglyLinkedList();
        re.add(1).add(2).add(3).add(0);
        System.out.println(" reversal before all:::::"+ Arrays.asList(re.toArray()));
        System.out.println("last::::"+re.getLast());
        System.out.println("midd::::"+re.getMiddle());

        System.out.println("remove::::"+      re.remove(0));
        re.reversal();

        System.out.println("size:::::"+re.size());
        System.out.println(" reversal after all:::::"+Arrays.asList(re.toArray()));
        System.out.println("midd::::"+re.getMiddle());


        System.out.println("last::::"+re.getLast());

    }


}
