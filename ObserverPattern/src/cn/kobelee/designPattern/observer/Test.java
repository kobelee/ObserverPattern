package cn.kobelee.designPattern.observer;

import cn.kobelee.designPattern.observer.concrete.ConcreteObservable;
import cn.kobelee.designPattern.observer.concrete.Text;

public class Test {
	public static void main(String[] args) {
		Observable observable = ConcreteObservable.getInstance();
		Observer observer = new Text();
		
		observable.registerObserver(observer);
		
		String context = "XXXX";
		observable.notifyAll(null);
	}
}
