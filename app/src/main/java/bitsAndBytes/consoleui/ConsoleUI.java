package bitsAndBytes.consoleui;

import org.mindmistress4.SessionActivity;

import bitsAndBytes.Session;
import filesReadAndWrite.Settings;

public class ConsoleUI {
	private Session session = null;
    private SessionActivity sessionActivity = null;
	private static boolean runInTestMode = false; // debug mode test mode testmode
	private long startOfSession = 0;
	private long gamesTimeInMinutes = 0;
	private long gamesTimeInMilliSeconds = 0;

	public static void main(String[] args) {
		if(args.length > 0) {
			runInTestMode = true;
			System.out.println("run in debug mode");
		}

		System.out.println("console UI:");

		ConsoleUI consoleUI = new ConsoleUI(null);
		consoleUI.startUI();
	}

    public ConsoleUI(SessionActivity sessionActivity) {
        this.sessionActivity = sessionActivity;
    }


	public void startUI(int minutes, boolean runInTestMode)  {
        this.runInTestMode = runInTestMode;
		startUIAsync(minutes, runInTestMode);
	}


	public void startUI(int minutes) {
		if(!runInTestMode) setSettings();

		session = new Session(minutes /* wishedTimeForSessionInMinutes */,
				100 /* level */,
				runInTestMode /* runInTestMode */);

		System.out.println();
		if(sessionActivity == null) System.out.println("Sessionbegin");
		else sessionActivity.addTextLine("Sessionbegin");

		// if(!runInTestMode) performSession();
		schlafe();
		// performSession();

		if(sessionActivity == null) System.out.println("Sessionende");
		else sessionActivity.addTextLine("Sessionende");
	}


	public void startUIAsync(int minutes, boolean runInTestMode) {
		session = new Session(minutes /* wishedTimeForSessionInMinutes */,
				100 /* level */,
				runInTestMode /* runInTestMode */);
		sessionActivity.addTextLine("Sessionbegin");

		startOfSession = System.currentTimeMillis();
		gamesTimeInMinutes = 0;
	}


	private void startUI() {
		startUI(60);
	}


	private void performSession() {
		long startOfSession = System.currentTimeMillis();
		long gamesTimeInMinutes = 0;


		while(gamesTimeInMinutes <= session.getSessionDuration()) {
			long startOfRound = System.currentTimeMillis();
            gamesTimeInMilliSeconds = startOfRound - startOfSession;

			if(runInTestMode) gamesTimeInMinutes = (startOfRound - startOfSession) / 100;
			else gamesTimeInMinutes = (startOfRound - startOfSession) / (1000 * 60);

			int countActionItems = session.getCountActionItemsPlannedToExecute();
			for(int i=0; i<countActionItems; i++) {
				// if(session.getActionItem(i).performToStart(gamesTimeInMinutes)) java.awt.Toolkit.getDefaultToolkit().beep();
				session.getActionItem(i).performToStart(gamesTimeInMinutes, gamesTimeInMilliSeconds, sessionActivity);
			}

			for(int i=countActionItems-1; i>=0; i--) {
				// if(session.getActionItem(i).performToEnd(gamesTimeInMinutes)) java.awt.Toolkit.getDefaultToolkit().beep();
				session.getActionItem(i).performToEnd(gamesTimeInMinutes, gamesTimeInMilliSeconds, sessionActivity);
			}

			schlafe();
		}

	}


	public void update() {
		// System.out.println("update " + gamesTimeInMinutes);
		if(gamesTimeInMinutes <= session.getSessionDuration()) {
			long startOfRound = System.currentTimeMillis();
            gamesTimeInMilliSeconds = startOfRound - startOfSession;

			if(runInTestMode) gamesTimeInMinutes = gamesTimeInMilliSeconds / 100;
			else gamesTimeInMinutes = gamesTimeInMilliSeconds / (1000 * 60);

            long nextPointInTimeActionMin = 0;
			int countActionItems = session.getCountActionItemsPlannedToExecute();
			for(int i=0; i<countActionItems; i++) {
                long nextPointInTimeAction = session.getActionItem(i).performToStart(gamesTimeInMinutes, gamesTimeInMilliSeconds, sessionActivity);
                // System.out.println("   nextPointInTimeActionStart " + nextPointInTimeAction);
                if(nextPointInTimeAction >= 0) {
                    if(nextPointInTimeActionMin == 0) nextPointInTimeActionMin = nextPointInTimeAction;
                    if (nextPointInTimeAction < nextPointInTimeActionMin) nextPointInTimeActionMin = nextPointInTimeAction;
                }
			}

			for(int i=countActionItems-1; i>=0; i--) {
                long nextPointInTimeAction = session.getActionItem(i).performToEnd(gamesTimeInMinutes, gamesTimeInMilliSeconds, sessionActivity);
                // System.out.println("   nextPointInTimeActionEnd " + nextPointInTimeAction);
                if(nextPointInTimeAction >= 0) {
                    if(nextPointInTimeActionMin == 0) nextPointInTimeActionMin = nextPointInTimeAction;
                    if (nextPointInTimeAction < nextPointInTimeActionMin) nextPointInTimeActionMin = nextPointInTimeAction;
                }
            }
            // System.out.println("nextPointInTimeActionMin " + nextPointInTimeActionMin);
            long remainingMinutes = nextPointInTimeActionMin / 1000 / 60;
            long remainingSeconds = nextPointInTimeActionMin / 1000 - remainingMinutes * 60;
            if(remainingSeconds < 10) sessionActivity.updateRemainingTime(" " + remainingMinutes + ":0" + remainingSeconds);
            else sessionActivity.updateRemainingTime(" " + remainingMinutes + ":" + remainingSeconds);
		}
		else {
			sessionActivity.endOfSession();
		}
	}


	private void schlafe() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}
	}


	private void setSettings() {
		Settings.getInstance().enableWish(0);
		Settings.getInstance().enableWish(1);
		Settings.getInstance().enableWish(2);
		Settings.getInstance().enableWish(3);
		Settings.getInstance().enableWish(4);
		Settings.getInstance().enableWish(5);
		Settings.getInstance().enableWish(6);
		Settings.getInstance().enableWish(7);
		Settings.getInstance().enableWish(8);
		Settings.getInstance().enableWish(9);
		Settings.getInstance().enableWish(10);
		Settings.getInstance().enableWish(11);
		Settings.getInstance().enableWish(12);
		Settings.getInstance().enableWish(13);
		Settings.getInstance().enableWish(14);
		Settings.getInstance().enableWish(15);
		Settings.getInstance().enableWish(16);
		Settings.getInstance().enableWish(17);
		Settings.getInstance().enableWish(18);
		Settings.getInstance().enableWish(19);
		Settings.getInstance().enableWish(20);
		Settings.getInstance().enableWish(21);
		Settings.getInstance().enableWish(22);
		Settings.getInstance().disableWish(23);
		Settings.getInstance().disableWish(24);
		Settings.getInstance().disableWish(25);
		Settings.getInstance().disableWish(26);
	}	

	/*
    static public void playSound() {
        int BUFFER_SIZE = 128000;
        AudioInputStream audioStream = null;
        SourceDataLine sourceLine = null;
        File soundFile = null;
        String strFilename = "falling.wav";

        try {
            soundFile = new File(strFilename);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
        	audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        AudioFormat audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }
*/
}
