import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Digest: 摘要
 *
 */
public class DigestTest {
	
	@Test
	/**
	 * 计算一个文件的摘要(MD5)
	 * md5sum passwd
	 */
	public void testFileDidest()
		throws Exception {
		//文件passwd保存在项目文件夹中
		String file="passwd";
		//打开文件
		InputStream in=new FileInputStream(file);
		//计算文件中数据的md5摘要
		String md5=DigestUtils.md5Hex(in);
		in.close();
		//输出
		System.out.println(md5);
	}
	
	@Test
	/**
	 * 计算一个字符串的摘要
	 * 
	 */
	public void testStringDigest(){
		String pwd = "123";
		//"123"-UTF-8->bytes-md5->摘要
		String md5=DigestUtils.md5Hex(pwd);
		//输出
		System.out.println(md5); 
		//202cb962ac59075b964b07152d234b70
		
		String str="123今天你吃了吗?";
		md5=DigestUtils.md5Hex(str);
		//输出
		System.out.println(md5); 
	}
	
}







