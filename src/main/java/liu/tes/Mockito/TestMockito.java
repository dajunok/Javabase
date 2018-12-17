package liu.tes.Mockito;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestMockito {	
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
	
	
	@Test
	@SuppressWarnings("rawtypes")
    public void when_thenReturn(){
        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        
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
	
	@Test
    public void returnsSmartNullsTest() {
        List<?> mock = mock(List.class, RETURNS_SMART_NULLS);
        System.out.println(mock.get(0));
        
        //使用RETURNS_SMART_NULLS参数创建的mock对象，不会抛出NullPointerException异常。另外控制台窗口会提示信息“SmartNull returned by unstubbed get() method on mock”
        System.out.println(mock.toArray().length);
    }
	
	@Test
    public void deepstubsTest2(){
        Account account=mock(Account.class); 
        RailwayTicket railwayTicket=mock(RailwayTicket.class);        
        when(account.getRailwayTicket()).thenReturn(railwayTicket); 
        when(railwayTicket.getDestination()).thenReturn("Beijing");
        
        account.getRailwayTicket().getDestination();
        verify(account.getRailwayTicket()).getDestination();    
        assertEquals("Beijing",account.getRailwayTicket().getDestination());
    }  
}
