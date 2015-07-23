package cn.kobelee.designPattern.observer.concrete;

import cn.kobelee.designPattern.observer.Observer;

public class Text  implements Observer{

	@Override
	public void update(Object... objs) {
		// TODO Auto-generated method stub
		System.out.println("observed by Text");
	}

}
