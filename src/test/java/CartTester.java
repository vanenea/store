import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.service.ICartService;

public class CartTester {
	
	@Test
	public void testChangeGoodsCount() {
		AbstractApplicationContext ctx
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml",
				"spring-service.xml");
		
		ICartService cartService = 
			ctx.getBean(
				"cartService", 
				ICartService.class);
		
		Integer uid = 7;
		Integer goodsId = 10000022;
		Integer amount = -10;
		Integer affectedRows 
			= cartService
				.changeGoodsCount(uid, goodsId, amount);
		
		System.out.println("affectedRows=" + affectedRows);
		
		ctx.close();
	}
	
	@Test
	public void testGetRecordCount() {
		AbstractApplicationContext ctx
		= new ClassPathXmlApplicationContext(
				"spring-dao.xml",
				"spring-service.xml");
		
		ICartService cartService = 
				ctx.getBean(
						"cartService", 
						ICartService.class);
		
		Integer uid = 7;
		Integer goodsId = 10000032;
		Integer count 
		= cartService
		.getRecordCount(uid, goodsId);
		
		System.out.println("count=" + count);
		
		ctx.close();
	}
	
	@Test
	public void testAdd() {
		AbstractApplicationContext ctx
		= new ClassPathXmlApplicationContext(
				"spring-dao.xml",
				"spring-service.xml");
		
		ICartService cartService = 
				ctx.getBean(
						"cartService", 
						ICartService.class);
		
		Cart cart = new Cart();
		cart.setUid(9527);
		cart.setGoodsId(100);
		cart.setGoodsImage("image url");
		cart.setGoodsTitle("Thinkpad x1");
		cart.setGoodsItemType("Thinkpad");
		cart.setGoodsPrice(9888);
		cart.setGoodsCount(5);
		Integer id = cartService.add(cart);
		
		System.out.println("cart id=" + id);
		
		ctx.close();
	}

}
