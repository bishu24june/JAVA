package com.sample.design.pattern.behavioral.command;

//Command
 interface Command {
	public void execute();
}

// Concrete Command
 class LightOnCommand implements Command {
	// reference to the light
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.switchOn();
	}
}

// Concrete Command
 class LightOffCommand implements Command {
	// reference to the light
	Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.switchOff();
	}
}

// Receiver
 class Light {
	private boolean on;

	public void switchOn() {
		on = true;
	}

	public void switchOff() {
		on = false;
	}
}

// Invoker
 class RemoteControl {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}
}

public class CommandClient {

	public static void main(String[] args) {
		RemoteControl control = new RemoteControl();
		Light light = new Light();
		Command lightsOn = new LightOnCommand(light);
		Command lightsOff = new LightOffCommand(light);
		// switch on
		control.setCommand(lightsOn);
		control.pressButton();
		// switch off
		control.setCommand(lightsOff);
		control.pressButton();
	}

}
