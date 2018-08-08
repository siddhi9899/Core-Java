class InvalidAmount extends RuntimeException{
                /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
				public InvalidAmount(){
                                super("Inavlid Amount");
                }
                public InvalidAmount(String msg){
                                                super(msg);
                }
}

public class UserExceptionTest{
                public static void main(String arg[]){
                                                int amount=-1;
                                                /*try{
                                                                if(amount<0)     {
                                                                                throw new InvalidAmount("this is not a valid amount");
                                                                }
                                                }
                                                catch(Exception e){
                                                                System.out.println(e.getMessage());
                                                }*/
                                                try{ 
                                               new UserExceptionTest().checkNum(amount);
                                                }catch(Throwable e){
                                            	   System.out.println("In Error"+e.getMessage());
                                               }
                                               System.out.println("After Throwable"); 
                                }
                
                public void checkNum(int amount) 
                {
                	System.out.println("In exception");
                	//throw new InvalidAmount("this is not a valid amount");
                	throw new OutOfMemoryError("In Error");
                }
}

/* Note: Analyze the code and understand the output. */
