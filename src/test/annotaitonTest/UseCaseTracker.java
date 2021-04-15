package test.annotaitonTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


public class UseCaseTracker {

	public static void main(String[] args) throws Exception {
		List<String> list = List.of("A", "B");
		trackerUseCase(list, UseCaseUtil.class);
	}

	static void trackerUseCase(List<String> useCaseList, Class<?> clazz) throws Exception {
		for(Method method : clazz.getDeclaredMethods()) {
			UseCase useCase = method.getAnnotation(UseCase.class);
			System.out.print(useCase.id() + ":" + useCase.description() + "-->");
			method.invoke(clazz.newInstance(), useCase.description());
		}
	}
}

