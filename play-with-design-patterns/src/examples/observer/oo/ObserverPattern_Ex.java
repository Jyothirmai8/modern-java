package examples.observer.oo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class DoorEvent {
}

interface DoorListener {
	public void on(DoorEvent doorEvent);

	public void off(DoorEvent doorEvent);
}

class Light implements DoorListener {
	public void on(DoorEvent doorEvent) {
		System.out.println("Light ON>>");
	}

	public void off(DoorEvent doorEvent) {
		System.out.println("Light OFF<<");
	}
}

class Fan implements DoorListener {
	public void on(DoorEvent doorEvent) {
		System.out.println("Fan ON>>");
	}

	public void off(DoorEvent doorEvent) {
		System.out.println("Fan OFF<<");
	}
}

class AC implements DoorListener {
	public void on(DoorEvent doorEvent) {
		System.out.println("AC ON>>");
	}

	public void off(DoorEvent doorEvent) {
		System.out.println("AC OFF<<");
	}
}

// Open closed Principle
class Door {
	private List<DoorListener> doorListeners = new ArrayList<DoorListener>();

	public void addDoorListener(DoorListener doorListener) {
		this.doorListeners.add(doorListener);
	}

	public void removeListener(DoorListener doorListener) {
		this.doorListeners.remove(doorListener);
	}

	public void open() {
		System.out.println("door opened");
		DoorEvent doorEvent = new DoorEvent();
		for (DoorListener doorListener : doorListeners) {
			doorListener.on(doorEvent);
		}
	}

	public void close() {
		System.out.println("door closed");
		DoorEvent doorEvent = new DoorEvent();
		for (DoorListener doorListener : doorListeners) {
			doorListener.off(doorEvent);
		}
	}
}

public class ObserverPattern_Ex {

	public static void main(String[] args) {

		Door door = new Door();

		DoorListener lightListener = new Light();
		DoorListener fanListener = new Fan();
		DoorListener acListener = new AC();

		door.addDoorListener(lightListener);
		door.addDoorListener(fanListener);
		door.addDoorListener(acListener);

		door.removeListener(acListener);

		sleep(3);
		door.open();
		sleep(2);
		door.close();
	}

	public static void sleep(int sec) {
		try {
			TimeUnit.SECONDS.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
