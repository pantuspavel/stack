public class Solution {
  static class Node {
    int val;
    Node next;
    Node random;
    
    public Node(int _val, Node _next) {
      val = _val;
      next = _next;
    }
  }
  
  public static Node reverse(Node first) {
    Node newHead = null;
    
    Node cur = first;
    while(cur != null) {
      Node tmp = cur.next;
      cur.next = newHead;
      newHead = cur;
      cur = tmp;
    }
    
    return newHead;
  }
  
  public static Node deepCopy(Node first) {
    Map<Node, Node> copies = new HashMap<Node, Node>();
      
    Node cur = first;
    while (cur != null) {
      Node copy = copies.get(cur);
      if (copy == null) {
        copy = new Node(cur.val, null);
        copies.put(cur, copy);
      }

      if (cur.next != null) {
        Node copyNext = copies.get(cur.next);
        if (copyNext == null) {
          copyNext = new Node(cur.next.val, null);
          copies.put(cur.next, copyNext);
        }
        copy.next = copyNext;
      }

      if (cur.random != null) {
        Node copyRandom = copies.get(cur.random);
        if (copyRandom == null) {
          copyRandom = new Node(cur.random.val, null);
          copies.put(cur.random, copyRandom);
        }
        copy.random = copyRandom; 
      }
      
      cur = cur.next;
    }
    
    return copies.get(first);
  }
  
  public static void main(String[] args) {   
  }
}
