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

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

/**
 * Hello for Java ME.
 */
public class HelloMIDlet extends MIDlet implements CommandListener {

	private Display display;

	// Button commands
	private Command okCmd;
	private Command exitCmd;

	// Registration form
	private Form registrationFrm;
	private TextField emailTxt;
	private TextField passwordTxt;
	private TextField nameTxt;
	private TextField mobileTxt;
	private TextField urlTxt;

	private Alert messageAlert;

	/**
	 * Constructor - initializes GUI components.
	 */
	public HelloMIDlet() {
		// Button commands
		okCmd = new Command("OK", Command.OK, 0);
		exitCmd = new Command("Exit", Command.EXIT, 1);

		// Registration form
		emailTxt = new TextField("Email:", "", 100, TextField.EMAILADDR);
		passwordTxt = new TextField("Password:", "", 16, TextField.PASSWORD);
		nameTxt = new TextField("Name:", "", 50, TextField.ANY);
		mobileTxt = new TextField("Mobile:", "", 15, TextField.PHONENUMBER);
		urlTxt = new TextField("Website:", "", 100, TextField.URL);
		registrationFrm = new Form("User Registration", new Item[]
				{emailTxt, passwordTxt, nameTxt, mobileTxt, urlTxt});
		registrationFrm.addCommand(okCmd);
		registrationFrm.addCommand(exitCmd);

		messageAlert = new Alert("Registration Complete");
		messageAlert.setTimeout(5000);
		messageAlert.setType(AlertType.CONFIRMATION);

		registrationFrm.setCommandListener(this);
	}

	/**
	 * @see javax.microedition.midlet.MIDlet#startApp()
	 */
	public void startApp() {
		display = Display.getDisplay(this);
		display.setCurrent(registrationFrm);
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
		if (aDisp == registrationFrm) {
			if (aCmd == okCmd) {
				String messageContent;
				messageContent = "Thanks " + nameTxt.getString() + "\nRegistration Complete.";
				messageAlert.setString(messageContent);
				display.setCurrent(messageAlert, registrationFrm);
			} else if (aCmd == exitCmd) {
				notifyDestroyed();
			}
		}
	}

}
