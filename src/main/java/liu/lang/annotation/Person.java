package liu.lang.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(Persons.class)
public @interface Person {
	String role();
	int id();
}
