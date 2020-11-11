package D_JavaAdvancedOOP.Lecture7_ReflectionandAnnotations.ExProblem_1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);



		String input = scanner.nextLine();
		while (!input.equals("HARVEST")) {
			//wryshta samo public poleta
			//Field[] fields = RichSoilLand.class.getFields();

			//public, protected, default, private - excludes inherited field
			Field[] fields = RichSoilLand.class.getDeclaredFields();

			for (Field field : fields) {
				int modifier = field.getModifiers();
				String modifierAsStr = Modifier.toString(modifier);
				if (modifierAsStr.equals(input) || input.equals("all")) {

					System.out.printf("%s %s %s\n",
							modifierAsStr,
							field.getType().getSimpleName(),
							field.getName());
				}
			}
			input = scanner.nextLine();
		}



	}
}
