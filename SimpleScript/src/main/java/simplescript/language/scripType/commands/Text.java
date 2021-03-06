package simplescript.language.scripType.commands;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import simplescript.program.utilities.KeyMapper;
import simplescript.program.utilities.RobotDelays;

/**
 * Implementation class for the scripType command - "TEXT".
 * 
 * @author Georgi Iliev
 *
 */
public class Text extends Command {

    protected String text;

    public Text(String text) {
	this.text = text;
    }

    public void execute() throws AWTException, IOException {
	Robot robot = new Robot();

	robot.delay(RobotDelays.INITIAL_DELAY);
	robot.setAutoDelay(RobotDelays.TYPING_DELAY);

	int key = 0;
	char[] keys = text.toCharArray();

	for (int i = 0; i < keys.length; i++) {

	    key = KeyMapper.retrieveKeyCode(keys[i]);

	    if (KeyMapper.SpecialSymbols.isSpecialSymbol(keys[i]) || Character.isUpperCase(keys[i])) {
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(key);

		robot.keyRelease(key);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	    } else {
		robot.keyPress(key);
		robot.keyRelease(key);
	    }

	}

    }

    @Override
    public String toString() {
	return "text";
    }

}
