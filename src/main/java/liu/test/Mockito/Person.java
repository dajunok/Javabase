package liu.test.Mockito;

/**
 * POJO：人
 * @author LIU
 *
 */
public class Person {
	private int id;
    private String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
