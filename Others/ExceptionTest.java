
public class ExceptionTest extends MyParentClass {

	public static void main(String[] args) {

		System.out.println("*********IN MAIN***********");
		int divide = 0;
		try{
		   divide = new ExceptionTest().divide(10, 0);
		}
		catch(Exception e){
			System.out.println("In Main Exception caught: "+e.getMessage());
		}
		//divide = new ExceptionTest().divide(10, 0);
		System.out.println("divide is  "+divide);
		/*try
		{
		 int divide = new ExceptionTest().divide(10, 0);
		}
		catch (IllegalArgumentException ex) { 
		      System.out.println("IllegalArgumentException divide throws exception: "+ex.getMessage());
		      throw ex;
		}
		catch (Exception ex) { 
		        System.out.println("Exception divide throws exception: "+ex.getMessage());
		        throw ex;
		} */

	}

	@Override
	public int divide(int x, int y)  {
		/*boolean flag = false;
		try {
			flag = checkNumber(y);
		} 
		catch (IllegalArgumentException ex) { 
		      System.out.println("IllegalArgumentException checkNumber throw exception: "+ex.getMessage());
		      throw ex;
		}
		catch (Exception ex1) { 
		        System.out.println("Exception checkNumber throw exception: "+ex1.getMessage());
		        throw ex1;
		} 
		return flag ? x / y : 0;*/
		
		return x/y;
	}
	
	public boolean checkNumber(int y) throws Exception
	{
		if (y == 0) { 
		      throw new IllegalArgumentException("Number must be greater than zero"); 
		    } 
		return true;
	}

}

class MyParentClass
{
	int divide(int x, int y) throws Exception
	{
	 return 0;	
	}
}
