package cn.kobelee.designPattern.observer;

/**
 * the Observer interface.
 * for each of the concrete observer, you should 
 * override the update method to define the actions.
 * @author liyx
 *
 */
public interface Observer {
	void update(Object...objs);
}
