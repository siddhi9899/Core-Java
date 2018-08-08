import java.math.BigDecimal;
class Developer
{
	private String name;
	private int age;
	private BigDecimal salary;
	Developer(String name, BigDecimal salary, int age)
	{
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

    public String toString() {
	        return "[name: "+name+" age: "+age+" salary: "+salary+"]";
    }

}