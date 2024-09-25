//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Driver_code {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return head;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            Node head = null;

            String str[] = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }
            boolean f = new Solution().isPalindrome(head);

            System.out.println(f ? "true" : "false");
        }
    }
}

// } Driver Code Ends


/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to check whether the list is palindrome.
        // Your code here
         public Node middle(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        Node slow=head;
        Node fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public Node reverse(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        
        Node prev=null;
        Node curr=head;
        
        while(curr!=null)
        {
            Node forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
    boolean isPalindrome(Node head) 
    {
        if(head==null || head.next==null)  // 1 2 3 4
        {
            return true;
        }
        Node mid=middle(head);
        Node newhead=mid.next;
        mid.next=null;
        
        newhead=reverse(newhead);
        Node c1=head;
        Node c2=newhead;
        
        while(c2!=null)
        {
            if(c1.data!=c2.data)
            {
                return false;
            }
            c1=c1.next;
            c2=c2.next;
        }
        return true;
    }
}
