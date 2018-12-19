package liu.test.Hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * Hamcrest常见用法：
 * 		assertThat断言结合匹配器的用法
 * @author LIU
 *
 */

public class TestMatcherAssert {
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void testHamcrestMatchers() {
        // 核心匹配
        // allOf匹配器: 所有条件都必须满足，相当于&&
        assertThat("myname", allOf(startsWith("my"), containsString("name")));
        // anyOf匹配器: 其中一个满足就通过， 相当于||
        assertThat("myname", anyOf(startsWith("na"), containsString("name")));
        // both匹配器: &&
        assertThat("myname", both(containsString("my")).and(containsString("me")));
        // either匹配器: 两者之一
        assertThat("myname", either(containsString("my")).or(containsString("you")));
        // everyItem匹配器: 每个元素都需满足特定条件
        assertThat(Arrays.asList("my", "mine"), everyItem(startsWith("m")));
        // hasItem匹配器: 是否有这个元素
        assertThat(Arrays.asList("my", "mine"), hasItem("my"));
        // hasItems匹配器: 包含多个元素
        assertThat(Arrays.asList("my", "mine", "your"), hasItems("your", "my"));
        // is匹配器: is(equalTo(x))或is(instanceOf(clazz.class))的简写
        assertThat("myname", is("myname"));
        assertThat("mynmae", is(String.class));
        // anything()匹配器: 任何情况下，都匹配正确
        assertThat("myname", anything());
        // not: 否为真，相当于！
        assertThat("myname", is(not("you")));
        // nullValue()匹配器: 值为空
        String str = null;
        assertThat(str, is(nullValue()));
        // notNullValue()匹配器: 值不为空
        String str2 = "123";
        assertThat(str2, is(notNullValue()));
 
        
        // 字符串匹配
        // containsString匹配器：包含字符串
        assertThat("myname", containsString("na"));
        // stringContainsInOrder: 顺序包含，“my”必须在“me”前面
        assertThat("myname", stringContainsInOrder(Arrays.asList("my", "me")));
        // endsWith匹配器: 后缀
        assertThat("myname", endsWith("me"));
        // startsWith匹配器: 前缀
        assertThat("myname", startsWith("my"));
        // isEmptyString()匹配器: 空字符串
        assertThat("", isEmptyString());
        // equalTo匹配器: 值相等， Object.equals(Object)
        assertThat("myname", equalTo("myname"));
        assertThat(new String[] {"a", "b"}, equalTo(new String[] {"a", "b"}));
        // equalToIgnoringCase匹配器: 比较时，忽略大小写
        assertThat("myname", equalToIgnoringCase("MYNAME"));
        // equalToIgnoringWhiteSpace匹配器: 比较时， 首尾空格忽略， 比较时中间用单个空格
        assertThat(" my \t name ", equalToIgnoringWhiteSpace(" my name "));
        // isOneOf匹配器: 是否为其中之一
        assertThat("myname", isOneOf("myname", "yourname"));
        // isIn匹配器: 是否为其成员
        assertThat("myname", isIn(new String[]{"myname", "yourname"}));
        // toString()匹配器： 返回值校验
        assertThat(333, hasToString(equalTo("333")));
       
        
        // 数值匹配
        // closeTo匹配器: [operand-error, operand+error], Double或BigDecimal类型
        assertThat(3.14, closeTo(3, 0.5));
        assertThat(new BigDecimal("3.14"), is(closeTo(new BigDecimal("3"), new BigDecimal("0.5"))));
        // comparesEqualTo匹配器: compareTo比较值
        assertThat(2, comparesEqualTo(2));
        // greaterThan匹配器： 大于
        assertThat(2, greaterThan(0));
        // greaterThanOrEqualTo匹配器: 大于等于
        assertThat(2, greaterThanOrEqualTo(2));
        // lessThan匹配器: 小于
        assertThat(0, lessThan(2));
        // lessThanOrEqualTo匹配器: 小于等于
        assertThat(0, lessThanOrEqualTo(0));
        
        
        
        // 集合匹配
        // array匹配器: 数组长度相等且对应元素也相等
        assertThat(new Integer[]{1, 2, 3}, is(array(equalTo(1), equalTo(2), equalTo(3))));
        // hasItemInArray: 数组是否包含特定元素
        assertThat(new String[]{"my", "you"}, hasItemInArray(startsWith("y")));
        // arrayContainingInAnyOrder匹配器， 顺序无关，长度要一致
        assertThat(new String[]{"my", "you"}, arrayContainingInAnyOrder("you", "my"));
        // arrayContaining匹配器:  顺序，长度一致
        assertThat(new String[]{"my", "you"}, arrayContaining("my", "you"));
        // arrayWithSize匹配器: 数组长度
        assertThat(new String[]{"my", "you"}, arrayWithSize(2));
        // emptyArray匹配器: 空数组
        assertThat(new String[0], emptyArray());
        // hasSize匹配器: 集合大小
        assertThat(Arrays.asList("my", "you"), hasSize(equalTo(2)));
        // empty匹配器: 空集合
        assertThat(new ArrayList<String>(), is(empty()));
        // isIn匹配器: 是否为集合成员
        assertThat("myname", isIn(Arrays.asList("myname", "yourname")));
       // Map匹配
        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("name", "john");
        // hasEntry匹配器: key && value匹配
        assertThat(myMap, hasEntry("name", "john"));
        // hasKey匹配器: key匹配
        assertThat(myMap, hasKey(equalTo("name")));
        // hasValue匹配器: value匹配
        assertThat(myMap, hasValue(equalTo("john")));
	}

}
