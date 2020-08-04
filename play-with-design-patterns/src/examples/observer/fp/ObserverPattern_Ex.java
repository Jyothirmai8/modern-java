package examples.observer.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

enum Type {
	OPEN, CLOSE
}

class DoorEvent {
	Type type;
}

interface DoorListener {
	public void toggle(DoorEvent doorEvent);
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
		doorEvent.type = Type.OPEN;
		for (DoorListener doorListener : doorListeners) {
			doorListener.toggle(doorEvent);
		}
	}

	public void close() {
		System.out.println("door closed");
		DoorEvent doorEvent = new DoorEvent();
		doorEvent.type = Type.CLOSE;
		for (DoorListener doorListener : doorListeners) {
			doorListener.toggle(doorEvent);
		}
	}
}

public class ObserverPattern_Ex {

	public static void main(String[] args) {

		Door door = new Door();

		DoorListener lightListener = event -> {
			if (event.type == Type.OPEN)
				System.out.println("light on");
			else
				System.out.println("light off");
		};
		DoorListener fanListener = event -> {
			if (event.type == Type.OPEN)
				System.out.println("fan on");
			else
				System.out.println("fan off");
		};
		DoorListener acListener = event -> {
			if (event.type == Type.OPEN)
				System.out.println("ac on");
			else
				System.out.println("ac off");
		};

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
