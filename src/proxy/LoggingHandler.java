package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class LoggingHandler implements InvocationHandler {

    private final Object target;
    private Map<String, Integer> calls = new HashMap<>();

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        calls.merge(method.getName(), 1, Integer::sum);
        if (method.getName().contains("toString"))
            return calls.toString();
        return method.invoke(target, args);
    }

    @SuppressWarnings("unchecked")
    public static <T> T withLogging(T target, Class<T> tClass) {
        return (T) Proxy.newProxyInstance(
                tClass.getClassLoader(),
                new Class[]{tClass},
                new LoggingHandler(target)
        );
    }

    public static void main(String[] args) {
        Person person = new Person();
        Human human = withLogging(person, Human.class);
        human.talk();
        human.walk();
        System.out.println(human.toString());
    }

}
