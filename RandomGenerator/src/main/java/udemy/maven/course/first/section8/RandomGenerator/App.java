package udemy.maven.course.first.section8.RandomGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RandomGenerator rg = new DefaultRandomGenerator();
        System.out.println("The number is "+rg.generate());
    }
}
