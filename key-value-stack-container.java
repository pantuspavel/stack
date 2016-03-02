public class Solution {
  private static class Node {
    String key;
    int value;
    Node next;
    
    public Node(String _key, int _value, Node _next) {
      key = _key;
      value = _value;
      next = _next;
    }
  }
  
  static Node find(String key, Node first) {
    Node cur = first;
    while(cur != null) {
      if (cur.key == key) {
        return cur;
      }
      cur = cur.next;
    }
    return null;
  }
  
  static Node set(String key, int value, Node first) {
    if (value == 0) {
      return remove(key, first);
    }
    
    Node n = find(key, first);
    if (n == null) {
      Node last = first;
      while(last != null) {
        if (last.next == null) {
          break;
        }
        last = last.next;
      }
      n = new Node(key, value, null);
      last.next = n;
    } else {
      n.key = key;
      n.value = value;
    }
    
    return first;
  }
  
  static Node remove(String key, Node first) {
    Node cur = first;
    Node prev = null;
    
    while(cur != null) {
      if (cur.key == key) {
        if (prev != null) {
          prev.next = cur.next;
          return first;
        } else {
          Node next = cur.next;
          cur.next = null;
          return next;
        }
      }
      prev = cur;
      cur = cur.next;
    }
    
    return first;
  }
  
  static void printStack(Node first) {
    Node cur = first;
    while(cur != null) {
      System.out.println("Key: " + cur.key + "; val: " + cur.value + " next: " + (cur.next != null ? cur.next.key : "null"));
      cur = cur.next;
    }
    System.out.println();
  }
  
  public static void main(String[] args) {   
  }
}
