import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSorting {

	public static void main(String[] args) {

		//Before Lambda implementation
		/*List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}

		//sort by age
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		System.out.println("After Sort by age ");
				for (Developer developer : listDevs) {
					System.out.println(developer);
		}
		//sort by name
		Collections.sort(listDevs, new Comparator<Developer>() {
				@Override
				public int compare(Developer o1, Developer o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});

		System.out.println("After Sort by name");
				for (Developer developer : listDevs) {
					System.out.println(developer);
		}

		//sort by salary
		Collections.sort(listDevs, new Comparator<Developer>() {
				@Override
				public int compare(Developer o1, Developer o2) {
					return o1.getSalary().compareTo(o2.getSalary());
				}
	    });

		System.out.println("After Sort salary");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}*/

		//After Lambda implementation
		List<Developer> listDevs = getDevelopers();
		System.out.println("Before Sort");
		listDevs.forEach((developer)-> System.out.println(developer));
		Comparator<Developer> ageComp = (Developer o1, Developer o2)->o2.getAge()-o1.getAge();
		Comparator<Developer> nameComp = (Developer o1, Developer o2)->o1.getName().compareTo(o2.getName());
		//listDevs.sort(nameComp);
		listDevs.sort(nameComp.thenComparing(ageComp));
		System.out.println("After Sort age");
		listDevs.forEach((developer)-> System.out.println(developer));

	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));
		result.add(new Developer("iris", new BigDecimal("170000"), 65));

		return result;

	}

}