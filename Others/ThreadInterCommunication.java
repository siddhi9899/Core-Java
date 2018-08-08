
public class ThreadInterCommunication {

	public static void main(String[] args) {
		Employee emp = new Employee("Siddhi", 100);
		//Employee emp1 = new Employee("Rajiv", 1000);
		Company comp = new Company(emp);
		Bank bank = new Bank(emp);
		Bank bank1 = new Bank(emp);
		comp.setName("Company Thread");
		bank.setName("Bank Thread");
		bank1.setName("Another Bank Thread");
		comp.start();
		bank.start();
		bank1.start();
		
		
		

	}

}

class Employee
{
	private String name;
	private double salary;
	private boolean dataTransferFlag=false;
	
	public Employee(String name, double salary)
	{
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isDataTransferFlag() {
		return dataTransferFlag;
	}

	public void setDataTransferFlag(boolean dataTransferFlag) {
		this.dataTransferFlag = dataTransferFlag;
	}
	
	/*public void send(String name)
	{
		synchronized(this){
			if(this.isDataTransferFlag())
			{
				try{
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
			this.setSalary(this.getSalary()*2);
			System.out.println(name+" Employee Name:"+this.getName()+" Salary:"+this.getSalary());
			this.setDataTransferFlag(true);
			notify();
		  }
	}
	public void receive(String name)
	{
		synchronized(this){
			if(!this.isDataTransferFlag())
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
				
			}
			System.out.println(name+" Employee Name:"+this.getName()+" Salary:"+this.getSalary());
			this.setDataTransferFlag(false);
			notify();
	       }
	}*/
	
}

class Company extends Thread
{
	private Employee emp;
	public Company(Employee emp)
	{
		this.emp = emp;
	}
	public  void run()
	{
		while(true)
			{
			send(this.getName());
			}
	}
	
	public void send(String name)
	{
		synchronized(this.emp){
			if(emp.isDataTransferFlag())
			{
				try{
					Thread.sleep(1000);
					//emp.wait();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
			emp.setSalary(emp.getSalary());
			System.out.println(name+" Employee Name:"+emp.getName()+" Salary:"+emp.getSalary());
			emp.setDataTransferFlag(true);
			//emp.notifyAll();
			//emp.notify();
			
		  }
	}
}

class Bank extends Thread
{
	private Employee emp;
	public Bank(Employee emp)
	{
		this.emp = emp;
	}
	public  void run()
	{
		while(true){
			receive(this.getName());
			}
	}
	public void receive(String name)
	{
		synchronized(this.emp){
			if(!emp.isDataTransferFlag())
			{
				try {
					Thread.sleep(1000);
					//emp.wait();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
				
			}
			System.out.println(name+" Employee Name:"+emp.getName()+" Salary:"+emp.getSalary());
			emp.setDataTransferFlag(false);
			//emp.notify();
			
	       }
	}
}