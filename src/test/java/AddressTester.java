import java.util.List;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;

public class AddressTester {
	
	DataSourceTransactionManager dstx;

	@Test
	public void testServiceSetDefault() {
		AbstractApplicationContext ctx 
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml",
				"spring-service.xml");
		
		IAddressService addressService
			= ctx.getBean(
				"addressService", IAddressService.class);
		
		Integer id = 6;
		Integer uid = 1;
		Integer affectedRows 
			= addressService.setDefault(uid, id);
		System.out.println("affectedRows=" + affectedRows);
		
		ctx.close();
	}
	
	@Test
	public void testMapperDelete() {
		AbstractApplicationContext ctx 
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml",
				"spring-service.xml");
		
		AddressMapper mapper
			= ctx.getBean(
				"addressMapper", AddressMapper.class);
		
		Integer id = 20;
		Integer uid = 1;
		Integer affectedRows 
			= mapper.delete(id, uid);
		System.out.println("affectedRows=" + affectedRows);
		
		ctx.close();
	}
	
	@Test
	public void testMapperGetList() {
		AbstractApplicationContext ctx 
		= new ClassPathXmlApplicationContext(
				"spring-dao.xml",
				"spring-service.xml");
		
		AddressMapper mapper
		= ctx.getBean(
				"addressMapper", AddressMapper.class);
		
		Integer uid = 1;
		List<Address> addresses
		= mapper.getAddressListByUid(uid);
		System.out.println(addresses.size());
		for (Address address : addresses) {
			System.out.println(address);
		}
		
		ctx.close();
	}
	
	@Test
	public void testMapperInsert() {
		AbstractApplicationContext ctx 
		= new ClassPathXmlApplicationContext(
				"spring-dao.xml");
		
		AddressMapper mapper
		= ctx.getBean(
				"addressMapper", AddressMapper.class);
		
		Address addr = new Address();
		addr.setUid(1);
		addr.setRecvName("小张");
		addr.setRecvProvince("100000");
		addr.setRecvCity("110000");
		addr.setRecvArea("110001");
		addr.setRecvDistrict("河北省石家庄市第一区");
		addr.setRecvAddr("第二街道三号楼405室");
		addr.setRecvPhone("13900139001");
		Integer affectedRows = mapper.insert(addr);
		System.out.println(
				"增加新地址完成：" + affectedRows);
		
		ctx.close();
	}
	
}
