import java.io.*;

class InsufficientFundsException extends Exception
{
   private double amount;
   public InsufficientFundsException(double amount)
   {
      this.amount = amount;
   } 
   public double getAmount()
   {
      return amount;
   }
}

class BaseClass{
// throws InsufficientFundsException
public void methodToOverride() 
{

	// System.out.println("parent");
	try{
		// int i =1/0;
		throw new InsufficientFundsException(1);
		// throw new ArithmeticException("aadasda");
		// throw new NullPointerException();
	}
	catch(java.lang.ArithmeticException e){
		System.out.println(e);
	}
	// catch(InsufficientFundsException e){
	// 	System.out.println(e);
	// }

}

}

class DerivedClass extends BaseClass{

public void methodToOverride () 

{

	System.out.println("child");
	// try{

	// 	int i = 1/0;
	// 	// throw new RemoteException();
	// 	// throw new IOExecption();

	// }
	// catch(Exception e){
	// 	System.out.println("galat baat");
	// }

}

}

class OOP{
	
	public static void main(String arg[]){
		
		BaseClass b = new BaseClass();
		try{
			b.methodToOverride();	
		}
		catch(Exception e){
			System.out.println("checked exception");
			System.out.println(e);
		}
		

		// DerivedClass c = new DerivedClass();
		// c.methodToOverride();
	}
}