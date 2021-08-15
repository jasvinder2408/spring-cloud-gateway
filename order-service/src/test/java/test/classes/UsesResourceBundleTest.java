package test.classes;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.jasvinder.order.test.classes.UsesResourceBundle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UsesResourceBundle.class)
public class UsesResourceBundleTest {

  @Mock
  private ResourceBundle bundle;

  private UsesResourceBundle instance;

  @Before
  public void setUp() {
    instance = new UsesResourceBundle();
  }

  @Test
  public final void testGetResourceStringAndSucceed() {

    mockStatic(ResourceBundle.class);
    when(ResourceBundle.getBundle("SomeBundleName", Locale.ENGLISH)).thenReturn(bundle);

    final String key = "DUMMY";
    final String message = "This is a Message";
    when(bundle.getString(key)).thenReturn(message);

    //replayAll();
    String result = instance.getResourceString(key);
    //verifyAll();
    assertEquals(message, result);
  }

  @Test(expected = MissingResourceException.class)
  public final void testGetResourceStringWithStringMissing() {

    mockStatic(ResourceBundle.class);
    when(ResourceBundle.getBundle("SomeBundleName", Locale.ENGLISH)).thenReturn(bundle);

    final String key = "DUMMY";
    Exception e = new MissingResourceException(key, key, key);
    when(bundle.getString(key)).thenThrow(e);

   // replayAll();
    instance.getResourceString(key);
  }

  @Test(expected = MissingResourceException.class)
  public final void testGetResourceStringWithBundleMissing() {

    mockStatic(ResourceBundle.class);
    final String key = "DUMMY";
    Exception e = new MissingResourceException(key, key, key);
    when(ResourceBundle.getBundle("SomeBundleName", Locale.ENGLISH)).thenThrow(e);

    //replayAll();
    instance.getResourceString(key);
  }

}