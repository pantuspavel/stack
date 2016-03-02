public class Solution {
  private static class ExpandingShrinkingStringStack {
    private String[] stack = new String[1];
    private int index;
    
    public void push(String value) {
      if (index == stack.length) {
        resize(2 * index);
      }
      stack[index++] = value;
    }
    
    public String pop() {
      String element = stack[--index];
      stack[index] = null;
      
      if (index > 0 && stack.length == 4 * index) {
        // stack is only quarter full.
        resize(2 * index);
      }
      
      return element;
    }
    
    private void resize(int newCapacity) {
      String[] newStack = new String[newCapacity];
      
      for (int i = 0; i < index; i++) {
        newStack[i] = stack[i];
      }
      
      stack = newStack;
      
      System.out.println("Resized, new capacity = " + stack.length);
    }
    
    public boolean isEmpty() {
      return index == 0;
    }
    
    public void print() {
      System.out.print("<< ");
      for (int i = 0; i < stack.length; i++) {
        System.out.print(" [" + stack[i] + "] ");
      }
      System.out.print(" >>");
      System.out.println();
    }
  }
  
  public static void main(String[] args) {
    ExpandingShrinkingStringStack stack = new ExpandingShrinkingStringStack();
    
    System.out.println("Done here!");
  }
}
