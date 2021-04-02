package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * 业务接口
 * @author yinzixian
 *
 */

interface ProxyService {
	void service() throws Exception;
}

/**
 * 业务实现类
 * @author yinzixian
 *
 */

class ProxyServiceImpl implements ProxyService{

	@Override
	public void service() throws Exception {
		System.out.println("Service Implements");
		throw new Exception();
	}
	
}

/**
 * 1.静态代理
 * @author yinzixian
 *
 */

class StaticProxyServiceImplProxy implements ProxyService{

	private ProxyService servicveImpl;
	public StaticProxyServiceImplProxy(ProxyService servicveImpl) {
		this.servicveImpl = servicveImpl;		
	}
	@Override
	public void service() throws Exception {
		before();
		servicveImpl.service();
		after();
	}
	private void before() {
		System.out.println("StaticProxy: Before Service");
	}
	private void after() {
		System.out.println("StaticProxy: After Service");
	}
}

/**
 * 2.动态代理
 * @author yinzixian
 *
 */

class MyProxyHandler implements InvocationHandler {
	private Object target;

	public MyProxyHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		before();
		
		Object obj = method.invoke(target, args);
		
		after();
		
		return obj;
	}
	private void before() {
		System.out.println("DynamicProxy: Before Service");
	}
	private void after() {
		System.out.println("DynamicProxy: After Service");
	}
}


/**
 * 3.动态代理模拟AOP
 * @author yinzixian
 *
 */

//通知接口
interface Advice {
	abstract void before();
	abstract void after();
	abstract void end();
	abstract void arround();
	abstract void exception();
}

//通知默认实现类
class DefaultAdvice implements Advice {

	@Override
	public void before() {
		
	}

	@Override
	public void after() {
		
	}

	@Override
	public void end() {
		
	}

	@Override
	public void arround() {
		
	}

	@Override
	public void exception() {
		
	}
	
}

//代理handler
class ProxyInActionHandler implements InvocationHandler {

	private Object target;
	
	public ProxyInActionHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		List<Advice> adviceChain = TestProxy.AdviceUtil.adviceMap.getOrDefault(target.getClass().getCanonicalName() + "." +method.getName(), new ArrayList<>());
		if(adviceChain.isEmpty())
			method.invoke(target, args);	
		else proceed(target, method, args, adviceChain.iterator());
		return null;
	}
	
	private void proceed(Object target, Method method, Object[] args, Iterator<Advice> adviceChain) throws Throwable{
		if(adviceChain.hasNext()) {
			Advice advice = adviceChain.next();
			try {
				advice.arround();
				advice.before();
				proceed(target, method, args, adviceChain);
				advice.after();
				advice.arround();
			} catch (Throwable t){
				advice.exception();
				throw t;
			} finally {
				advice.end();
			}
		}
		else 
			method.invoke(target, args);	
	}
}


public class TestProxy {
	
	//增加和移除通知工具类
	static class AdviceUtil {
		public static Map<String, List<Advice>> adviceMap = new HashMap<>();	
		
		static <T> void add(Class<T> clazz, String methodNameReg, Advice advice) {
			String className = clazz.getCanonicalName();
			List<Advice> adviceList;
			for(Method method : clazz.getMethods()) {
				String methodName = method.getName();
				if(!methodName.matches(methodNameReg))
					continue;
				adviceList = adviceMap.get(className +"."+ methodName);
				if(adviceList == null) {
					adviceList = new ArrayList<>();
					adviceMap.put(className +"."+ methodName, adviceList);
				}
				adviceList.add(advice);
			}
		}

		static <T> void remove(Class<T> clazz, String methodNameReg, Advice advice) {
			String className = clazz.getCanonicalName();
			List<Advice> adviceList;
			for(Method method : clazz.getMethods()) {
				String methodName = method.getName();
				if(!methodName.matches(methodNameReg))
					continue;
				adviceList = adviceMap.getOrDefault(className +"."+ methodName, new ArrayList<Advice>());
				adviceList.remove(advice);
			}
		}
	}
	public static void main(String[] args) {
		/**
		 * 静态代理测试
		 */
		System.out.println("*************************************");
		
		//获取类实例
		ProxyService staticService = new ProxyServiceImpl();
		
		//获取代理实例
		StaticProxyServiceImplProxy staticProxy = new StaticProxyServiceImplProxy(staticService);
		
		//执行代理方法
		try {
			staticProxy.service();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
		/**
		 * 动态代理测试
		 */
		System.out.println("*************************************");
		
		//获取类实例
		ProxyService dynamicService = new ProxyServiceImpl();
		
		//获取应用程序类加载器,可根据双亲委派机制对类进行加载
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		
		//获取代理handler
		MyProxyHandler handler = new MyProxyHandler(dynamicService);
		
		//获取代理对象
		ProxyService dynamicProxy = (ProxyService)Proxy.newProxyInstance(loader, dynamicService.getClass().getInterfaces(), handler);
		
		try {
			dynamicProxy.service();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
		/**
		 * 动态代理模拟AOP测试
		 */
		System.out.println("*************************************");
		
		//获取类实例
		ProxyService serviceInAction = new ProxyServiceImpl();

		//获取应用程序类加载器,可根据双亲委派机制对类进行加载
		ClassLoader loaderInAction = ClassLoader.getSystemClassLoader();
		
		//获取代理handler
		ProxyInActionHandler handlerInAction = new ProxyInActionHandler(serviceInAction);
		
		//获取代理对象
		ProxyService proxyInAction = (ProxyService) Proxy.newProxyInstance(loaderInAction, serviceInAction.getClass().getInterfaces(), handlerInAction);
		
		//管理切面通知
		AdviceUtil.add(ProxyServiceImpl.class, "service", new DefaultAdvice() {			
			@Override
			public void before() {
				System.out.println("override before advice111");
			}
			@Override
			public void after() {
				System.out.println("override after advice111");
			}
		});
		AdviceUtil.add(ProxyServiceImpl.class, "service", new Advice() {		
			@Override
			public void before() {
				System.out.println("override before advice222");
			}
			@Override
			public void after() {
				System.out.println("override after advice222");			
			}
			@Override
			public void end() {
				System.out.println("override end advice222");				
			}
			@Override
			public void arround() {
				System.out.println("override arround advice222");				
			}
			@Override
			public void exception() {
				System.out.println("override exception advice222");				
			}			
		});
		try {
			proxyInAction.service();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
	}

}