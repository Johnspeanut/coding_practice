import java.util.AbstractMap;



// Java program to print ordering of
// all elements using TreeMap

    import java.util.*;
    import java.lang.*;
    import java.io.*;

class TreeMapnew
{
  // This function prints ordering of all elements
  static void insertAndPrint(AbstractMap<Integer, String> map)
  {
    int[] array= {1, -1, 0, 2,-2};
    for (int x: array)
    {
      map.put(x, Integer.toString(x));
    }
    for (int k: map.keySet())
    {
      System.out.print(k + ", ");
    }
  }

  // Driver method to test above method
  public static void main (String[] args)
  {
    TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    insertAndPrint(map);
  }
}
