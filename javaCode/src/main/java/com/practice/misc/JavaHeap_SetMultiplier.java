/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setmultiplier;
import java.util.*;

/**
 *
 * @author Utkarsh
 */
public class SetMultiplier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(2);
        set.add(21);
        set.add(5);
        set.add(12);
        set.add(6);
        System.out.println(GetMultiple(set, 10));
    }
    
    public static int GetMultiple(HashSet<Integer> set, int n)
    {
        PriorityQueue<Number> heap = new PriorityQueue<Number>(new MyComparator());
        Iterator it = set.iterator();
        while(it.hasNext())
        {
            Number number = new Number();
            number.number = (int)it.next();
            number.multiple = number.number;
            number.multplier = 1;
            heap.add(number);
        }
        
        int t = 0;
        int multiple = -1;
        while(t<n)
        {
            while(true)
            {
                Number k = heap.poll();
                if(k.multiple != multiple)
                {
                    t++;
                    multiple = k.multiple;
                    k.multplier = k.multplier+1;
                    k.multiple = k.multplier*k.number;
                    heap.add(k);
                    break;
                }
                else
                {
                    k.multplier = k.multplier+1;
                    k.multiple = k.multplier*k.number;
                    heap.add(k);
                }
            }
            
        }
        
        return multiple;
    }
    
    private static class Number{
        int number;
        int multplier;
        int multiple;
    }
    
    private static class MyComparator implements Comparator<Number>{
        
        @Override
        public int compare(Number a, Number b)
        {
            return a.multiple - b.multiple;
        }
    }
}
