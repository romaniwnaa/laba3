package laba3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class kvartyry implements Serializable {
public kvartyry() {}
public String surname, stat;
int n_b, n_k;
float borg;
private static ArrayList<kvartyry> list=new ArrayList<kvartyry>();
public void add()
{
	byte f=0;
	Scanner in= new Scanner(System.in);
	System.out.print("\nНомер квартири: ");
	n_k=in.nextInt();
	System.out.print("\nНомер будинку:");
	n_b=in.nextInt();
	for(int i=0;i<list.size();i++) 
	{
		kvartyry k=list.get(i);
		if(k.n_b==n_b)
			if(k.n_k==n_k)
				f=1;
	}
	if(f==1)
	{ System.out.println("Будинок існує. редагувати?\n0 - так");
	f=in.nextByte();}
	if(f==0)
	{
		 System.out.println("\nПрізвище - ");
		 surname=in.next();
		 System.out.println("\nСтать - ");
		 stat=in.next();
		 System.out.println("\nСума боргу - ");
		 borg=in.nextFloat();
		 add_new(this);
	}

		
}
public static void add_new(kvartyry kv)
{
	list.add(kv);
	int i;
	
	try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("D:\\COLLAGE\\Джава\\fil.txt")))
	{
		oos.writeObject(list);
	}
	catch(Exception e) {System.out.println("error - "+e.getMessage());}
}
public static void sort()
{
	ArrayList<String> temp=new ArrayList<String>();
	ArrayList<kvartyry> t=new ArrayList<kvartyry>();
	for(int i=0;i<list.size();i++) 
	{
		kvartyry tt=list.get(i);
		temp.add(i, tt.surname);
	}
	 Collections.sort(temp);
	 int j=0;
	 for(int i=0;i<list.size();i++) 
		{
			kvartyry tt=list.get(i);
			if(temp.get(j).contains(tt.surname))
				{
			t.add(tt);
			list.remove(i);
			j++;
			i=-1;
			}
		}
	 list=t;
}
public static void print()
{
	for(int i=0;i<list.size();i++) 
	{
		kvartyry k=list.get(i);
		System.out.print("\nНомер квартири: "+k.n_k);
		System.out.print("\nНомер будинку:"+k.n_b);
		 System.out.println("\nПрізвище - "+k.surname);
		 System.out.println("\nСтать - "+k.stat);
		 System.out.println("\nСума боргу - "+k.borg);
	}
}
public static void search()
{
	Scanner in= new Scanner(System.in);
	System.out.print("Введіть суму боргу:");
	float s=in.nextFloat();
	for(int i=0;i<list.size();i++) 
	{
		kvartyry k=list.get(i);
		if(s==k.borg) {
		System.out.print("\nНомер квартири: "+k.n_k);
		System.out.print("\nНомер будинку:"+k.n_b);
		 System.out.println("\nПрізвище - "+k.surname);
		 System.out.println("\nСтать - "+k.stat);
		 System.out.println("\nСума боргу - "+k.borg);}
	}
	
}
public static void delete()
{
	Scanner in= new Scanner(System.in);
System.out.print("\nНомер квартири: ");
int n_k=in.nextInt();
System.out.print("\nНомер будинку:");
int n_b=in.nextInt();
for(int i=0;i<list.size();i++) 
{
	kvartyry k=list.get(i);
	if(n_k==k.n_k&&n_b==k.n_b)
	{
		list.remove(i);
		break;
	}
	}
}
public static void start()
{
	 try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:\\COLLAGE\\Джава\\fil.txt"))) 
	 {
		 list=(ArrayList<kvartyry>)ois.readObject();
	 }
	 catch(Exception e) {System.out.print(e.getMessage());}
	 }
}
