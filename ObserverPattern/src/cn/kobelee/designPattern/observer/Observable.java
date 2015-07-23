package cn.kobelee.designPattern.observer;

import java.util.ArrayList;
/**
 * the subject to be observed.An abstract class.
 * 
 * 
 * @author liyx
 *
 */
public abstract class Observable {
	public final ArrayList<Class<?>> observerList = new ArrayList<Class<?>>();
	
	/**
	 * Register observer by instance.
	 * @param observer
	 */
	public <T> void registerObserver(T observer){
		this.registerObserver(observer.getClass());
	}
	
	/**
	 * Register observer by class
	 * @param clazz
	 */
	public void registerObserver(Class<?> clazz){
		synchronized (observerList) {
			if(!observerList.contains(clazz)){
				observerList.add(clazz);
			}
		}
	}
	
	/**
	 * cancel the registration of an observer via instance
	 * @param observer
	 */
	public <T> void unRegisterObserver(T observer){
		this.unRegisterObserver(observer.getClass());
	}
	/**
	 * cancel the registration of an observer via class
	 * @param clazz
	 */
	public void unRegisterObserver(Class<?> clazz){
		synchronized (clazz) {
			if(observerList.contains(clazz)){
				
				observerList.remove(clazz);
			}
		}
	}
	
	/**
	 * cancel the registration of all observers
	 */
	public void unRegisterAll(){
		observerList.clear();
	}
	
	/**
	 * return the count of all registered observers
	 * @return
	 */
	public int countObservers(){
		synchronized (observerList) {
			return observerList.size();
			
		}
	}
	
	/**
	 * notify all registered observers
	 * @param objs
	 */
	public abstract void notifyAll(Object...objs);
	/**
	 * notify one certain observer via class
	 * @param clazz
	 * @param objs
	 */
	public abstract void notifyObserver(Class<?> clazz,Object...objs);
	/**
	 * notify one certain observer via instance
	 * @param t
	 * @param objs
	 */
	public abstract <T> void notifyObserver(T t,Object...objs);
}
