package liu.lang.annotation;


@Person(role="artist",id=1)
@Person(role="coder",id=2)
@Person(role="PM",id=3)
@Perform
@Check("class")
public class SuperMan {
	@Check("hi")
	public int a;
}
