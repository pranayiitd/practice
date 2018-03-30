package com.practice.heap;
import java.util.*;

class HeapImpl{
	static ArrayList<Integer> h = new ArrayList<Integer>();
	
	public static void insert(int v){
		h.add(v);
		int l = h.size()-1;
		while(l>=2){
			if(h.get(l/2) <= h.get(l))
				break;
			else{
				//swap
				int temp = h.get(l/2);
				h.set(l/2,h.get(l));
				h.set(l,temp);
			}
			l = l/2;
		}

		}
	
	
	public static int delete(){
		if(h.size()<2)
			return -1;
		int v = h.get(1);
		int leaf = h.remove(h.size()-1);
		if(h.size()>1){
		h.set(1,leaf);
		int l =1;
		while(2*l+1<h.size()){
			if(h.get(l)<=h.get(2*l)&& h.get(l)<=h.get(2*l+1))
				break;	
			else{
				int temp = h.get(l);
				int pos = (h.get(2*l+1)<=h.get(2*l)) ? 2*l+1:2*l;
				h.set(l,h.get(pos));
				h.set(pos,temp);
			}
		}
		}

		return v;
	}

public static int delete_new(){
		if(h.size()<2)
			return -1;
		int v = h.get(1);
		int leaf = h.remove(h.size()-1);
		if(h.size()>1){

			h.set(1,leaf);
			int l =1;
			while(true){
				
				int pos = l;
 				if(2*l < h.size() && h.get(2*l) < h.get(pos))
					pos = 2*l;
				if(2*l+1 < h.size() && h.get(2*l+1) < h.get(pos))
					pos = 2*l+1;
				if(pos == l)
					break;
				else{
					int temp = h.get(l);
					h.set(l,h.get(pos));
					h.set(pos,temp);
					l = pos;
				}
					
			}

		}

		return v;
	}



	public static void traverse(){
		while(h.size()>1){
			System.out.format("%d ",delete_new());
		}
		System.out.format("\n");
	}
	
	public static void main(String arg[]){
		insert(-1);

		insert(8);
		insert(1);
		insert(100);
		insert(53);
		insert(26);
		insert(73);
		insert(6);
		System.out.println(h);
		traverse();
	}
}
