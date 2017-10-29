package skeleton;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observer> observers;
	private String message;
	private boolean changed;
//	private final Object MUTEX= new Object();

	public Subject() {
		observers = new ArrayList<Observer>();
		message = null;
		changed = false;
	}

	public void register(Observer obj) {
		if ( !observers.contains(obj) ) observers.add(obj);
	}

	public void unregister(Observer obj) {
		observers.remove(obj);
	}

	public void notifyObservers() {
		// TODO: notify every observers
		if (!changed)
			return;
		new ArrayList<Observer>(observers).stream().forEach( o -> o.update());
		this.changed = false;
	}

	public void setMessage(String msg) {
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	public List<Observer> getQueue() {
		return observers;
	}
}
