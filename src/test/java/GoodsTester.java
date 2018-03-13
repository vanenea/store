import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;

public class GoodsTester {

	@Test
	public void testGetCount() {
		AbstractApplicationContext ctx 
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml",
				"spring-service.xml");
		
		GoodsMapper goodsMapper
			= ctx.getBean(
				"goodsMapper", GoodsMapper.class);
		
		Integer count
			= goodsMapper
				.getGoodsCountByCategoryId(163);
		System.out.println("count=" + count);
		
		ctx.close();
	}
	
	@Test
	public void testGetList() {
		AbstractApplicationContext ctx 
		= new ClassPathXmlApplicationContext(
				"spring-dao.xml",
				"spring-service.xml");
		
		IGoodsService goodsService
		= ctx.getBean(
				"goodsService",
				IGoodsService.class);
		
		Integer categoryId = 163;
		String orderBy = "priority DESC";
		Integer offset = 0;
		Integer count = 3;
		
		goodsService.setCountPerPage(8);
		
		List<Goods> list 
		= goodsService
		.getGoodsListByCategoryId(
				categoryId, 2);
		
		for (Goods goods : list) {
			System.out.println(
					goods.getId() + ", " + 
							goods.getPriority() + ", " + 
							goods.getTitle()
					);
		}
		
		ctx.close();
	}
	
	
}
