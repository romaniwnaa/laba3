
package laba3;
import java.util.*;
public class laba3 {
public static void main(String[] str) 
{
	
	Scanner in=null;
	int v=10;
	while(v!=0) {
		try {
	in=new Scanner(System.in);
	System.out.print("������� ��������:\n1 -������� ���� ��� ���� ������ � ����������� ��� ��� �볺��� ����� � ������: � �������, \r\n"
			+ "������� �� ���, ���� ������, ���� ���������� ��������. ��������� �볺��� ����� � ��������� ������� \r\n"
			+ "���������� �������� �� ������� ��� ��� ��� �� ����� � ���� �������.\r\n"
			+ ".\n2 ����� �� ����� \n0 - �����");
	v=in.nextInt();
	switch(v) {
	case 1:one();break;
	case 2:two();break;
	case 3:break;}
		}
		catch(Exception ex) {System.out.print("������� ������ ������!");};
	}
	
}

public static void one()
{
	
	Scanner in2=new Scanner(System.in);
	int v1=10;
	while(v1!=0) {
	System.out.print("1 - ������ ����� ������ \n2 - ������ ��������\n3 - ������� ���\n4 - �������� ��������\n0-exit");
	v1=in2.nextInt();
	switch(v1)
	{
	case 1: BankAccount.enterdataAcaunt(); break;
	case 2:BankAccount.enter_new_op();break;
	case 3: BankAccount.print(); break;
	case 4: BankAccount.printZavd1();break;
	case 0: break;
	}
	}
}

public static void two()
{
	kvartyry.start();
	kvartyry km;
	Scanner in=null;
	String v="";
	while(v.equals("exit")==false) {
		try {
	in=new Scanner(System.in);
	System.out.print("������� ��������:\none - ������/���������� two - ������� three - �������� four - ����� five - ����������");
	v=in.nextLine();
	switch(v) {
	case "one":km=new kvartyry(); km.add() ;break;
	case "two":kvartyry.print() ;break;
	case "three":kvartyry.delete(); break;
	case "four":kvartyry.search();break;
	case "five":kvartyry.sort();kvartyry.print();break;
	default: System.out.print("Error value");
	}
		}
		catch(Exception ex) {System.out.print("������� ������ ������!");};
	}
};

}
