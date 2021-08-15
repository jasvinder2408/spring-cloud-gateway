import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MyStaticTest.MyStaticClass.class)
public class MyStaticTest {

public static class MyStaticClass {
    public static String getA(String a) {
        return a;
    }
    public static String getB(String b) {
        return b;
    }
}

@Test
public void should_partial_mock_static_class() throws Exception {
    //given
    PowerMockito.spy(MyStaticClass.class);
    given(MyStaticClass.getB(Mockito.anyString())).willReturn("B");
    //then
    assertEquals("A", MyStaticClass.getA("A"));
    assertEquals("B", MyStaticClass.getA("B"));
    assertEquals("C", MyStaticClass.getA("C"));
    assertEquals("B", MyStaticClass.getB("A"));
    assertEquals("B", MyStaticClass.getB("B"));
    assertEquals("B", MyStaticClass.getB("C"));
}

}