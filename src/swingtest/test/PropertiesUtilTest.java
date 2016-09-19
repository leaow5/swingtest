package swingtest.test;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import swingtest.OrderConst;
import swingtest.PropertiesUtil;

public class PropertiesUtilTest {
	@Test
	public void testHANDSHAKE_ORDER() {
		PropertiesUtil pro = PropertiesUtil.getDefaultOrderPro();
		String order = pro.getProperty(OrderConst.QUERY_MACHINE_ORDER_MATCH);
		assertThat(order, equalTo("55aa01F90101040D"));
	}

}
