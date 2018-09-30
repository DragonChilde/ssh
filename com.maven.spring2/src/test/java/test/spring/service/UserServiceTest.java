package test.spring.service;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Proxy;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.aop.LogInterceptor;
import com.spring.dao.UserDAO;
import com.spring.dao.impl.UserDAOImpl;
import com.spring.model.User;
import com.spring.service.UserService;


public class UserServiceTest {

	@Test
	public void testAdd() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		
		UserService service1 = (UserService)applicationContext.getBean("userService");
		
	/*	UserService service2 = (UserService)applicationContext.getBean("userService");
		
		System.out.println(service1==service2);*/
		
		User u = new User();
	
		service1.add(u);
		
		/*UserDAOImpl user = (UserDAOImpl) applicationContext.getBean("u");
		System.out.println(user.getLists().size());*/
		
	/*	SessionFactory session = (SessionFactory) applicationContext.getBean("sessionFactory");
		Session s = session.openSession();
		System.out.println(s);*/

	}

	
	@Test
	public void testProxy()
	{
		UserDAO userDAO = new UserDAOImpl();
		LogInterceptor li = new LogInterceptor();
		li.setTarget(userDAO);
		UserDAO userDAOProxy = (UserDAO)Proxy.newProxyInstance(userDAO.getClass().getClassLoader(), userDAO.getClass().getInterfaces(), li);
		System.out.println(userDAOProxy.getClass());
		userDAOProxy.delete();
		userDAOProxy.save(new User());
	}
	
	@Test
	public void postUrl()
	{
		String result = null;
		HashMap<String,Object> params = new HashMap<>();
		params.put("oder_id","123");
		params.put("sign","123456789");
		
		StringBuilder postData = new StringBuilder();
		
		try {
			for(Map.Entry<String, Object>param:params.entrySet())
			{
				postData.append("&");
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append("=");
				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
			URL url = new URL("http://www.fish068.com/Qipai/api/mobile_deposit/testCurl");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setRequestMethod("POST");
			OutputStream stream = con.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(stream);
			dataOutputStream.write(postDataBytes);
		
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			while((line = in.readLine()) != null)
			{
				System.out.println("ok");
				result += line;
			}
			in.close();
			dataOutputStream.close();
			stream.close();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(result);
		
		System.out.println(postData);
		
	}
	
	@Test
	public void testMD5()
	{
		String md5 = null;
		String str = "123456789";
		  try {
	            // 生成一个MD5加密计算摘要
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            // 计算md5函数
	            md.update(str.getBytes());
	            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	             md5 = new BigInteger(1, md.digest()).toString(16);
	        } catch (Exception e) {
	           e.printStackTrace();
	        }

		  System.out.println(md5);
	}
	
	
}
