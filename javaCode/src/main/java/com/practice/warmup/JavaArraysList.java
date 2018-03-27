/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaarrayslist;
import java.util.*;
/**
 *
 * @author Utkarsh
 */
public class JavaArraysList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = new int[]{1,10,21,-10,3,6};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(11);
        al.add(15);
        al.add(-11);
        al.add(4);
        al.add(31);
        al.sort(new IntComparator());
        System.out.println(al.toString());
    }
    
    public static class IntComparator implements Comparator<Integer>
    {
        @Override
        public int compare(Integer left, Integer right)
        {
            return left - right;
        }
    }
    
}


