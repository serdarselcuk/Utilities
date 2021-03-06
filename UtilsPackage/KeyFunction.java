package com.trycloudapp.utilities;

public class KeyFunction {

    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        if (System.getProperty("os.name").toLowerCase().charAt(0) == 'm') {
            ifMACos();// if MacOs so need to pres (command+shift+G)
        }
    }

    /*
    for multiple keys write characters as numbers in ASCII and also
    as string and put between them "+"
    EXAMPLE ( "12+23+1")
    */
    public static void sendKeyToSystem(String string) {

        String[] keys = string.split("\\+");

        for (String key : keys) {

            keyFuncPress(key);
        }

        for (String key : keys) {

            keyFuncRelease(key);
        }

    }

    private static void keyFuncPress(String key) {

        int num = Integer.parseInt(key);

        robot.keyPress(num);
    }

    private static void keyFuncRelease(String key) {
        int num = Integer.parseInt(key);

        robot.keyRelease(num);
    }

    private static void ifMACos() {

        sendKeyToSystem("157+16+71");
    }
}
