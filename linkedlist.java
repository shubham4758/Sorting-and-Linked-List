1.// Solution


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteNodeInLinkedList {

    public static void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        // Copy the value of the next node to the current node
        node.val = node.next.val;

        // Update the next pointer to skip the next node
        node.next = node.next.next;
    }

    // Custom test case setup
    public static ListNode buildLinkedList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test example 1
        ListNode head1 = buildLinkedList(new int[]{4, 5, 1, 9});
        ListNode node1 = head1.next;  // node with value 5
        deleteNode(node1);
        printLinkedList(head1);  // Output: 4 -> 1 -> 9 -> null

        // Test example 2
        ListNode head2 = buildLinkedList(new int[]{4, 5, 1, 9});
        ListNode node2 = head2.next.next;  // node with value 1
        deleteNode(node2);
        printLinkedList(head2);  // Output: 4 -> 5 -> 9 -> null
    }
}




2.// Solution



class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveNodesWithValue {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = dummyHead;

        while (current.next != null) {
            if (current.next.val == val) {
                // Remove the node with the given value
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummyHead.next;
    }

    // Custom test case setup
    public static ListNode buildLinkedList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test example 1
        ListNode head1 = buildLinkedList(new int[]{1, 2, 6, 3, 4, 5, 6});
        int val1 = 6;
        ListNode newHead1 = removeElements(head1, val1);
        printLinkedList(newHead1);  // Output: 1 -> 2 -> 3 -> 4 -> 5 -> null

        // Test example 2
        ListNode head2 = buildLinkedList(new int[]{});
        int val2 = 1;
        ListNode newHead2 = removeElements(head2, val2);
        printLinkedList(newHead2);  // Output: null

        // Test example 3
        ListNode head3 = buildLinkedList(new int[]{7, 7, 7, 7});
        int val3 = 7;
        ListNode newHead3 = removeElements(head3, val3);
        printLinkedList(newHead3);  // Output: null
    }
}




3.// Solution



class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeSortedLinkedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummyHead.next;
    }

    // Custom test case setup
    public static ListNode buildLinkedList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test example 1
        ListNode list1 = buildLinkedList(new int[]{1, 2, 4});
        ListNode list2 = buildLinkedList(new int[]{1, 3, 4});
        ListNode mergedList1 = mergeTwoLists(list1, list2);
        printLinkedList(mergedList1);  // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null

        // Test example 2
        ListNode list3 = buildLinkedList(new int[]{});
        ListNode list4 = buildLinkedList(new int[]{});
        ListNode mergedList2 = mergeTwoLists(list3, list4);
        printLinkedList(mergedList2);  // Output: null

        // Test example 3
        ListNode list5 = buildLinkedList(new int[]{});
        ListNode list6 = buildLinkedList(new int[]{0});
        ListNode mergedList3 = mergeTwoLists(list5, list6);
        printLinkedList(mergedList3);  // Output: 0 -> null
    }
}




4.// Solution



class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListCycleStart {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Find the meeting point (if there is a cycle)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break; // Meeting point found
            }
        }

        // Step 2: Check if there is a cycle or not
        if (fast == null || fast.next == null) {
            return null; // No cycle
        }

        // Step 3: Find the starting node of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // Custom test case setup
    public static ListNode buildLinkedList(int[] values, int pos) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        ListNode cycleStart = null;

        for (int i = 0; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;

            if (i == pos) {
                cycleStart = current; // Store the starting node of the cycle
            }
        }

        // Create a cycle (connect the tail to the starting node of the cycle)
        current.next = cycleStart;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // Test example 1
        ListNode head1 = buildLinkedList(new int[]{3, 2, 0, -4}, 1);
        ListNode cycleStart1 = detectCycle(head1);
        System.out.println("Cycle start: " + cycleStart1.val);  // Output: Cycle start: 2

        // Test example 2
        ListNode head2 = buildLinkedList(new int[]{1, 2}, 0);
        ListNode cycleStart2 = detectCycle(head2);
        System.out.println("Cycle start: " + cycleStart2.val);  // Output: Cycle start: 1

        // Test example 3
        ListNode head3 = buildLinkedList(new int[]{1}, -1);
        ListNode cycleStart3 = detectCycle(head3);
        System.out.println("Cycle start: " + (cycleStart3 != null ? cycleStart3.val : "No cycle"));  // Output: No cycle
    }
}




5.// Solution


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // Move the fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummyHead.next;
    }

    // Custom test case setup
    public static ListNode buildLinkedList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Test example 1
        ListNode head1 = buildLinkedList(new int[]{1, 2, 3, 4, 5});
        int n1 = 2;
        ListNode newHead1 = removeNthFromEnd(head1, n1);
        printLinkedList(newHead1);  // Output: 1 -> 2 -> 3 -> 5 -> null

        // Test example 2
        ListNode head2 = buildLinkedList(new int[]{1});
        int n2 = 1;
        ListNode newHead2 = removeNthFromEnd(head2, n2);
        printLinkedList(newHead2);  // Output: null

        // Test example 3
        ListNode head3 = buildLinkedList(new int[]{1, 2});
        int n3 = 1;
        ListNode newHead3 = removeNthFromEnd(head3, n3);
        printLinkedList(newHead3);  // Output: 1 -> null
    }
}



6.// Solution



class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LeftShiftLinkedList {

    public static ListNode leftShiftLinkedList(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        // Find the length of the linked list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Calculate the actual shift count
        k %= length;
        if (k == 0) {
            return head; // No need to rotate
        }

        // Find the new tail and new head
        int newTailIndex = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailIndex; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // Perform the rotation
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    // Custom test case setup
    public static ListNode buildLinkedList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] values = {2, 4, 7, 8, 9};
        int k = 3;

        ListNode head = buildLinkedList(values);
        ListNode newHead = leftShiftLinkedList(head, k);
        printLinkedList(newHead);  // Output: 8 -> 9 -> 2 -> 4 -> 7 -> null
    }
}



7.// Solution



class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class RemoveZeroSumSublists {

    public static ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }

        // Create a dummy node to handle the case when the original head node is part of a sum to 0 sequence
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // Use a hashmap to store the running sum and its corresponding node
        HashMap<Integer, ListNode> sumMap = new HashMap<>();
        ListNode current = dummyHead;
        int runningSum = 0;

        while (current != null) {
            runningSum += current.val;

            if (sumMap.containsKey(runningSum)) {
                // Remove the sequence from the last sum to the current sum
                ListNode prevNode = sumMap.get(runningSum).next;
                int sumToRemove = runningSum + prevNode.val;

                while (prevNode != current) {
                    sumMap.remove(sumToRemove);
                    prevNode = prevNode.next;
                    sumToRemove += prevNode.val;
                }

                sumMap.get(runningSum).next = current.next;
            } else {
                sumMap.put(runningSum, current);
            }

            current = current.next;
        }

        return dummyHead.next;
    }

    // Custom test case setup
    public static ListNode buildLinkedList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] values = {1, 2, -3, 3, 1};
        ListNode head = buildLinkedList(values);
        ListNode newHead = removeZeroSumSublists(head);
        printLinkedList(newHead);  // Output: 3 -> 1 -> null
    }
}




8.// Solution


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReorderLinkedList {

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode oddCurrent = oddHead;
        ListNode evenCurrent = evenHead;

        // Separate the list into two parts: odd nodes and even nodes
        while (evenCurrent != null && evenCurrent.next != null) {
            oddCurrent.next = evenCurrent.next;
            oddCurrent = oddCurrent.next;

            evenCurrent.next = oddCurrent.next;
            evenCurrent = evenCurrent.next;
        }

        // Merge the two lists
        oddCurrent.next = evenHead;

        return oddHead;
    }

    // Custom test case setup
    public static ListNode buildLinkedList(int[] values) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = buildLinkedList(values);
        ListNode newHead = reorderList(head);
        printLinkedList(newHead);  // Output: 1 -> 3 -> 5 -> 2 -> 4 -> null
    }
}


