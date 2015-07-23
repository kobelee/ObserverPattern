package cn.kobelee.designPattern.observer.concrete;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.kobelee.designPattern.observer.Observable;

/**
 * An concrete subject to be observed, singleton
 * 
 * @author liyx
 *
 */
public class ConcreteObservable extends Observable {

	private static ConcreteObservable instance = null;

	private ConcreteObservable() {
	}

	public static synchronized ConcreteObservable getInstance() {
		if (instance == null) {
			instance = new ConcreteObservable();
		}
		return instance;
	}

	@Override
	public void notifyAll(Object... objs) {
		// TODO Auto-generated method stub
		for (Class<?> clazz : observerList) {
			this.notifyObserver(clazz, objs);
		}
	}

	@Override
	public void notifyObserver(Class<?> clazz, Object... objs) {
		// TODO Auto-generated method stub
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equals("update")) {
				try {
					method.invoke(clazz, objs);
					break;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	@Override
	public <T> void notifyObserver(T t, Object... objs) {
		// TODO Auto-generated method stub
		this.notifyObserver(t.getClass(), objs);
	}

}
