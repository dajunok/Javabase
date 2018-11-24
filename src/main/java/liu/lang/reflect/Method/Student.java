package liu.lang.reflect.Method;

/**java反射：Method对象
 * 
 * @author LIU
 *
 */
public class Student {

	//体育课
	@Check
	public Integer peClass(String teacher) {
		System.out.println(teacher);
		return 10;
	}

	//数学课
	@SuppressWarnings("unused")
	private  Integer mathClass(String teacher) {
		System.out.println(teacher);
		return 20;
	}

	//物理课
	public Integer physicsClass(String ...teachers) {
		System.out.println(teachers);
		return 30;
	}

	//语文课
	public Integer chineseClass(String teacher) {
		System.out.println(teacher);
		return 40;
	}

	//英语课
	public Integer englishClass(String teacher) {
		System.out.println(teacher);
		return 50;
	}

	//班会
	public void meeting(String meetingName, String address) {
		System.out.println(meetingName+"  "+address);		
	}
	
}
