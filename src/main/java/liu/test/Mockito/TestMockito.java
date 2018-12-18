package liu.test.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

/**
 * Mockito功能调试类：测试Mockito各种功能。
 * @author LIU
 *
 */

@RunWith(MockitoJUnitRunner.class)  //给类中所有模拟对象初始化(使用默认构造器实例化)
public class TestMockito {	
	//验证方法是否执行过----------------------------------------------
	@Test
	@SuppressWarnings("unchecked")
	public void verify_behaviour(){
        //模拟创建一个List对象
        List<Integer> mock = mock(List.class);       
        //使用mock的对象
        mock.add(1);
        mock.clear();        
        //验证add(1)和clear()行为是否发生
        verify(mock).add(1);
        verify(mock).clear();
    }
	//-----------------------------------------------------------------------------end
	
	//模拟我们所期望的结果------------------------------------------------------------
	@Test
	@SuppressWarnings("rawtypes")
    public void when_thenReturn(){
        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);  //使用静态方法mock()模拟Iterator对象。      
        //预设当iterator调用next()时第一次返回hello，第n次都返回world
        when(iterator.next()).thenReturn("hello").thenReturn("world");        
        //使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();        
        //验证结果
        assertEquals("hello world world",result);
    }	
	
	@Test(expected = IOException.class)
	@SuppressWarnings("unused")
    public void when_thenThrow() throws IOException {
        OutputStream outputStream = mock(OutputStream.class);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        //预设当流关闭时抛出异常
        doThrow(new IOException()).when(outputStream).close();
        outputStream.close();
    }
	//-----------------------------------------------------------------------------end
	
	
	// RETURNS_SMART_NULLS和RETURNS_DEEP_STUBS参数避免空指针报错.s---------------------------
	@Test
    public void returnsSmartNullsTest() {
        List<?> mock = mock(List.class, RETURNS_SMART_NULLS);  //, RETURNS_SMART_NULLS
        System.out.println(mock.get(0));
        
        //使用RETURNS_SMART_NULLS参数创建的mock对象，不会抛出NullPointerException异常。另外控制台窗口会提示信息“SmartNull returned by unstubbed get() method on mock”
        System.out.println(mock.toArray().length);
    }
	
	@Test
    public void deepstubsTest2(){ //模拟连环调用
        Account account=mock(Account.class);  //使用静态方法mock()模拟Account对象。
        RailwayTicket railwayTicket=mock(RailwayTicket.class);  //使用静态方法mock()模拟RailwayTicket对象。       
        when(account.getRailwayTicket()).thenReturn(railwayTicket); //当模拟对象account的getRailwayTicket()方法被调用时返回另外另外一个模拟对象railwayTicket
        when(railwayTicket.getDestination()).thenReturn("Beijing");  ////当模拟对象railwayTicket的getDestination()方法被调用时返回字符串"Beijing"。
        
        account.getRailwayTicket().getDestination();  //测试模拟连环调用
        verify(account.getRailwayTicket()).getDestination();  //验证模拟对象railwayTicket的方法getDestination()是否被调用过。
        assertEquals("Beijing",account.getRailwayTicket().getDestination()); //判断模拟对象railwayTicket的方法getDestination()的返回值是否为"Beijing"。
        
    }  
	//-----------------------------------------------------------------------------end
	
	
	//模拟方法体抛出异常---------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Test(expected = RuntimeException.class)
    public void doThrow_when(){        
		List<Integer> list = mock(List.class);  //使用静态方法mock()模拟
        //doThrow(new RuntimeException()).when(list).add(1);
        when(list.add(1)).thenThrow(new RuntimeException());
        try {
        	list.add(1);
        }catch (Exception e) {
        	System.out.println("发生RuntimeException异常！！");
        	e.printStackTrace();
        	Assert.assertEquals("测试", e.getMessage());  
		}
        verify(list).add(1);
    }
	//-----------------------------------------------------------------------------end
	
	//使用注解@Mock快速模拟================================================================================
	@Mock
	private List<Integer> mockList;   //通过注解@Mock模拟mockList对象。
	@Test
	public void shortthand() {
		mockList.add(1);   //运行这个测试会发现报错了，mock的对象为NULL，为此我们必须在基类中添加初始化mock的代码
		verify(mockList).add(1);
	}		
	 
	@SuppressWarnings("rawtypes")
	@Mock 
    private List mockListInit;  //通过注解@Mock模拟mockListInit对象。
    public TestMockito(){  //通过类的构造方法对所有模拟对象进行初始化,另外可以在类上面添加@RunWith(MockitoJUnitRunner.class)注解对类中的所有模拟对象进行初始化。
        MockitoAnnotations.initMocks(this);  //对所有模拟对象进行初始化
    }
    
	@Test
	@SuppressWarnings("unchecked")
    public void shorthand(){
    	mockListInit.add(1);  //调用模拟对象方法add(1)
        verify(mockListInit).add(1);  //验证模拟对象mockListInit的add(1)方法是是否被调用过（或者称为add(1)行为是否发生过）。如果没有则报错。
    }
    //-----------------------------------------------------------------------------end
    
    
	//参数匹配========================================================================
    @Test
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void with_arguments(){
        Comparable comparable = mock(Comparable.class);   //使用静态方法mock()模拟Comparable对象
        //预设根据不同的参数返回不同的结果
        when(comparable.compareTo("Test")).thenReturn(1); //当模拟对象方法被调用且参数为"Test"时，返回数值1。
        when(comparable.compareTo("Omg")).thenReturn(2);  //当模拟对象方法被调用且参数为"Omg"时，返回数值2。
        assertEquals(1, comparable.compareTo("Test"));
        assertEquals(2, comparable.compareTo("Omg"));
        //对于没有预设的情况会返回默认值
        assertEquals(0, comparable.compareTo("Not stub"));
    }    
    
    @SuppressWarnings("rawtypes")
	@Test
    public void with_unspecified_arguments(){ //除了匹配指定参数外还可以匹配自己想要的任意参数
        List list = mock(List.class);
        //匹配任意参数
        when(list.get(anyInt())).thenReturn(1);
        when(list.contains(argThat(new IsValid()))).thenReturn(true); //当调用方法参数满足IsValid对象matches()方法的匹配要求时，放回true。
        assertEquals(1, list.get(1));
        assertEquals(1, list.get(999));
        assertTrue(list.contains(1));
        assertTrue(!list.contains(3));
        System.out.println("list.get(999): "+list.get(999));
        System.out.println("list.contains(1): "+list.contains(1));  //运行结果：true
        System.out.println("list.contains(2): "+list.contains(2));  //运行结果：true
        System.out.println("list.contains(3): "+list.contains(3));  //运行结果：false
    }
    private class IsValid extends ArgumentMatcher<List>{  //当IsValid对象被当作参数时，调用方法中的参数会使用matches(Object o)方法进行判断。
        @Override
		public boolean matches(Object o) { //匹配方法
			return o == (Object)1 || o == (Object)2;
		}
    }
    //-----------------------------------------------------------------------------end
    
    //自定义参数匹配==================================================================
    @Test
    public void argumentMatchersTest(){
        //创建mock对象
        List<String> mock = mock(List.class);

        //argThat(Matches<T> matcher)方法用来应用自定义的规则，可以传入任何实现Matcher接口的实现类。
        when(mock.addAll(argThat(new IsListofTwoElements()))).thenReturn(true);

        mock.addAll(Arrays.asList("one","two","three"));
        //IsListofTwoElements用来匹配size为2的List，因为例子传入List为三个元素，所以此时将失败。
        verify(mock).addAll(argThat(new IsListofTwoElements()));
    }
    
    class IsListofTwoElements extends ArgumentMatcher<List>
    {
        public boolean matches(Object list)
        {
            return((List)list).size()==2;
        }
    }
    //-----------------------------------------------------------------------------end
    
    
    //使用参数捕获器捕获参数来进一步断言，较复杂的参数匹配器会降低代码的可读性，有些地方使用参数捕获器更加合适。================    
    @Test
    public void capturing_args(){
        PersonDao personDao = mock(PersonDao.class); //使用静态方法mock()模拟PersonDao对象
        PersonService personService = new PersonService(personDao); //将模拟对象personDao作为参数传入

        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class); //定义参数捕获器argument，它是一个具有捕获参数增强功能的Person类对象。
        personService.update(1,"jack");  
        verify(personDao).update(argument.capture()); //在验证方法是否被调用的基础上捕获被调用方法的参数。(1,"jack")参数会通过构造器Person(int id, String name)传入Person对象。
        assertEquals(1,argument.getValue().getId());  //进一步对捕获的参数进行判断
        assertEquals("jack",argument.getValue().getName());
    }
    //-----------------------------------------------------------------------------end
    
    // 使用方法预期回调接口生成期望值（Answer结构）=================================================
    @Test
    public void answerTest(){
        when(mockList.get(anyInt())).thenAnswer(new CustomAnswer());  //通过回调接口实现类CustomAnswer的回调方法answer()返回期望值。
        assertEquals("hello world:0",mockList.get(0));
        assertEquals("hello world:999",mockList.get(999));
    }

    private class CustomAnswer implements Answer<String>{  //创建回调接口Answer实现类CustomAnswer
        @Override
        public String answer(InvocationOnMock invocation) throws Throwable {
            Object[] args = invocation.getArguments();  //invocation对应的是模拟对象mockList的方法get(0)。因此args[0]的值为0。
            return "hello world:"+args[0];
        }
    }
    
    @Test
    public void answer_with_callback(){   //通过匿名内部类实现上述功能。
        //使用Answer来生成我们我们期望的返回
        when(mockList.get(anyInt())).thenAnswer(new Answer<Object>() { //创建回调接口Answer实现类（匿名内部类），并返回期望值（即answer（）方法的返回值）
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments(); 	//invocation对应的是模拟对象mockList的方法get(0)。因此args[0]的值为0。
                return "hello world:"+args[0];  
            }
        });
        assertEquals("hello world:0",mockList.get(0));
        assertEquals("hello world:999",mockList.get(999));
    }
    //-----------------------------------------------------------------------------end
    
    //用spy监控真实对象 ======================================================================================
    @Test(expected = IndexOutOfBoundsException.class)
    public void spy_on_real_objects(){  //此处没有使用模拟mock(),而是通过doReturn(xxx).when(xxx).xx(xxx)实现Spy功能。
        List list = new LinkedList();
        List spy = spy(list);
        //下面预设的spy.get(0)会报错，因为会调用真实对象的get(0)，所以会抛出越界异常
        //when(spy.get(0)).thenReturn(3);

        //使用doReturn-when可以避免when-thenReturn调用真实对象api
        doReturn(999).when(spy).get(999); //返回期望值999，当调用spy.get(999)时。        
        when(spy.size()).thenReturn(100); //预设size()的期望值100
        //调用真实对象的api
        spy.add(1);
        spy.add(2);
        assertEquals(100,spy.size());
        assertEquals(1,spy.get(0));
        assertEquals(2,spy.get(1));
        verify(spy).add(1);
        verify(spy).add(2);
        assertEquals(999,spy.get(999));
        spy.get(2);
    }
    //-----------------------------------------------------------------------------end
    
    //真实的部分mock==================================================================
    @Test
    public void real_partial_mock(){  //通过Mock调用真实的API
        //通过spy来调用真实的api
        List list = spy(new ArrayList());
        assertEquals(0,list.size());
        A a  = mock(A.class);
        
        when(a.doSomething(anyInt())).thenCallRealMethod(); //通过thenCallRealMethod来调用真实的api
        assertEquals(999,a.doSomething(999));
    }

    class A{
        public int doSomething(int i){
            return i;
        }
    }
    //-----------------------------------------------------------------------------end
    
    // 重置mock========================================================================
    @Test
    public void reset_mock(){
        List list = mock(List.class);
        when(list.size()).thenReturn(10);  //使用when...thenReturn预设期望值
        list.add(1);  		//给模拟对象添加值（互动行为）
        assertEquals(10,list.size());  //判断预设值
        
        reset(list);  //重置mock，清除所有的互动和预设
        assertEquals(0,list.size());
    }
    //-----------------------------------------------------------------------------end
    
    //验证确切的调用次数================================================================
    @SuppressWarnings("unchecked")
	@Test
    public void verifying_number_of_invocations(){
        @SuppressWarnings("rawtypes")
		List list = mock(List.class);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        verify(list).add(1);
        verify(list,times(1)).add(1); //验证是否被调用一次    
        verify(list,times(2)).add(2); //验证是否被调用2次        
        verify(list,times(3)).add(3);//验证是否被调用3次       
        verify(list,never()).add(4);  //验证是否从未被调用过        
        verify(list,atLeastOnce()).add(1); //验证至少调用一次        
        verify(list,atLeast(2)).add(2); //验证至少调用2次       
        verify(list,atMost(3)).add(3);  //验证至多调用3次
    }
    //-----------------------------------------------------------------------------end
    
    //连续调用========================================================================
    @SuppressWarnings("rawtypes")
	@Test(expected = RuntimeException.class)
    public void consecutive_calls(){
        //模拟连续调用返回期望值，如果分开，则只有最后一个有效
    	List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn(0);
        when(mockList.get(0)).thenReturn(1);
        when(mockList.get(0)).thenReturn(2);
        when(mockList.get(1)).thenReturn(0).thenReturn(1).thenThrow(new RuntimeException());
        assertEquals(2,mockList.get(0));
        assertEquals(2,mockList.get(0));
        assertEquals(0,mockList.get(1));
        assertEquals(1,mockList.get(1));
        //第三次或更多调用都会抛出异常
        mockList.get(1);
    }
    //-----------------------------------------------------------------------------end
    
    //验证执行顺序======================================================================
    @Test
    public void verification_in_order(){
        List list = mock(List.class);
        List list2 = mock(List.class);
        list.add(1);
        list2.add("hello");
        list.add(2);
        list2.add("world");
        //将需要排序的mock对象放入InOrder
        InOrder inOrder = inOrder(list,list2);
        //下面的代码不能颠倒顺序，验证执行顺序        
        inOrder.verify(list).add(1);
        inOrder.verify(list2).add("hello");
        inOrder.verify(list).add(2);
        inOrder.verify(list2).add("world");        
    }
    //-----------------------------------------------------------------------------end
    
    //找出冗余的互动(即未被验证到的执行)
    @Test(expected = NoInteractionsWanted.class)
    public void find_redundant_interaction(){
        List list = mock(List.class);
        list.add(1);
        list.add(2);
        verify(list,times(2)).add(anyInt());        
        verifyNoMoreInteractions(list); //检查是否有未被验证的互动行为，因为add(1)和add(2)都会被上面的anyInt()验证到，所以代码会通过

        List list2 = mock(List.class);
        list2.add(1);
        list2.add(2);
        verify(list2).add(1);        
        verifyNoMoreInteractions(list2);//检查是否有未被验证的互动行为，因为add(2)没有被验证，所以代码会失败抛出异常
    }
    //-----------------------------------------------------------------------------end
    
    //测试无返回值的方法======================================================================
    public void no_Return() {
    	List list = mock(List.class);
    	doNothing().when(list).remove(list);   
    	doNothing().when(list).notify(); 
    	// 或直接 
    	when(list).notify();
    	when(((Iterator) list).next()).thenThrow(new RuntimeException());
    	doThrow(new RuntimeException()).when(list).remove(0);
    	try {
    		list.remove(0);
    	}
    	catch (Exception e) {
			System.out.println("发生RuntimeException异常");
		}
    	
    }
}





















































