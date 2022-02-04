package udemy.maven.course.first.section8.RandomGenerator;

import org.apache.commons.math3.random.RandomDataGenerator;

public class DefaultRandomGenerator implements RandomGenerator {

	public String getName() {
		return "Default Random Generator";
	}

	public int generate() {
		final RandomDataGenerator aRandomDataGenerator = new RandomDataGenerator();
		return aRandomDataGenerator.nextInt(5, 10);
	}

}
