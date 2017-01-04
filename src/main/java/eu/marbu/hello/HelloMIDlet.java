/*
 * Copyright 2017 marbu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.marbu.hello;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.midlet.MIDlet;

/**
 * Hello for Java ME.
 */
public class HelloMIDlet extends MIDlet implements CommandListener {

	private Display display;
	private Form helloForm;
	private StringItem helloString;
	private Command helloCmd;
	private Command exitCmd;

	/**
	 * Constructor - initializes GUI components.
	 */
	public HelloMIDlet() {
		helloForm = new Form("Hello ME");
		helloString = new StringItem("Label:", "Some text.");
		helloCmd = new Command("Hello", Command.SCREEN, 0);
		exitCmd = new Command("Exit", Command.EXIT, 1);
		helloForm.append(helloString);
		helloForm.addCommand(helloCmd);
		helloForm.addCommand(exitCmd);
		helloForm.setCommandListener(this);
	}

	/**
	 * @see javax.microedition.midlet.MIDlet#startApp()
	 */
	public void startApp() {
		display = Display.getDisplay(this);
		display.setCurrent(helloForm);
	}

	/**
	 * @see javax.microedition.midlet.MIDlet#pauseApp()
	 */
	public void pauseApp() {
	}

	/**
	 * @see javax.microedition.midlet.MIDlet#destroyApp(boolean)
	 */
	public void destroyApp(boolean unconditional) {
	}

	/**
	 * Handles command actions from all forms.
	 *
	 * @see javax.microedition.lcdui.CommandListener#commandAction(javax.microedition.lcdui.Command,
	 *      javax.microedition.lcdui.Displayable)
	 */
	public void commandAction(Command aCmd, Displayable aDisp) {
		if (aDisp == helloForm) {
			if (aCmd == helloCmd) {
				helloString.setLabel("Hello");
				helloString.setText("World!");
			} else if (aCmd == exitCmd) {
				notifyDestroyed();
			}
		}
	}

}
