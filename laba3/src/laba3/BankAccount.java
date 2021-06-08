package laba3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccount {
private static BankAccount ba;
private String pib=""; 
private float wklad;
private LocalDate date;
private static Map<Integer, BankAccount> list=new HashMap<Integer, BankAccount>();
private Map<LocalDate, Float> operation=new HashMap<LocalDate, Float>();

public static void enterdataAcaunt()
{
	Scanner in=new Scanner(System.in);
	System.out.print("Скільки данних ввести: ");
	int i=in.nextInt();
	for(int j=0;j<i;j++)
	{
		ba=new BankAccount();
		ba.enter_new_ac();
		System.out.print("Введіть номер рахунку: ");
		int n=in.nextInt();
		list.put(n, ba);	
	}
}

private void enter_new_ac() 
{
	Scanner in=new Scanner(System.in);
	System.out.print("Введіть піб власника рахунку: ");
	pib=in.nextLine();
}
public static void enter_new_op() 
{
	Scanner in=new Scanner(System.in);
	System.out.print("Введіть номер рахунку: ");
	int num=in.nextInt();
	BankAccount b=list.get(num);
	System.out.print("Введіть суму операції: ");
	ba.wklad=in.nextFloat();
	System.out.print("Введіть день операції: ");
	int d=in.nextInt();
	System.out.print("Введіть місяць операції: ");
	int m=in.nextInt();
	System.out.print("Введіть рік операції: ");
	int y=in.nextInt();
	LocalDate date=LocalDate.of(y, m, d);
	b.operation.put(date, ba.wklad);
	list.put(num, b);
}
public static void print() 
{
	BankAccount b;
	for(int key: list.keySet())
	{
		b= list.get(key);
		System.out.print("\nHомер рахунку: "+ key);
		System.out.print("\nПіб власника рахунку: "+b.pib);
		for(LocalDate key1: b.operation.keySet())
		{
			System.out.print("\nДата операції: "+key1);	
			System.out.print("\nСума операції: "+b.operation.get(key1));
		}
	}
	System.out.print("\n");

}
public static void printZavd1()
{
	int []i=new int[list.size()];
	int j=0, tmp=0;
	BankAccount b;
	for(int key: list.keySet())
	{
		b= list.get(key);
		i[j]=b.operation.size();
		j++;
	}
	for(j=0;j<list.size();j++)
	{
		if(i[j]>tmp)
			tmp=i[j];
	}
	for(int key: list.keySet())
	{
		b= list.get(key);
		if(b.operation.size()==tmp) {
		System.out.print("\nHомер рахунку:"+ ""+"\tПіб власника рахунку:");
		System.out.print("\n"+key+"\t\t"+b.pib);
		for(LocalDate key1: b.operation.keySet())
		{
			System.out.print("\nДата операції: "+"\tСума операції: ");	
			System.out.print("\n"+key1+ "\t\t"+b.operation.get(key1));
		}
		 }
	}
	System.out.print("\n");
}
}
