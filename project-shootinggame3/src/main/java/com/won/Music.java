package com.won;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

// 음악 스레드.
class Music implements Runnable {
	boolean checkPlaying = true;
	String filename;
	long playTime = 0;
	Clip clip;

	public Music(String filename) {
		this.filename = filename;
		try {
			this.clip = AudioSystem.getClip();
			this.clip.open(AudioSystem.getAudioInputStream(new File(this.filename)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
//			this.clip.open(AudioSystem.getAudioInputStream(new File(this.filename)));
			this.clip.start();
			this.clip.loop(this.clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// check은 loop로 실행할 것이냐 start로 실행할 것이냐를 구분하기 위함.
	public void playOnetime(int check) {
		try {
			if (check == 1) {
				this.clip.start();
				Thread.sleep(100);
			} else if (check == 2)
				this.clip.loop(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void pause() {
		this.playTime = this.clip.getMicrosecondPosition();
		this.checkPlaying = false;
		this.clip.stop();
	}

	public void resume() {
		this.checkPlaying = true;
		this.clip.setMicrosecondPosition(this.playTime);
		this.clip.start();
		this.clip.loop(this.clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		this.clip.stop();
	}

}

//데몬스레드를 사용한 story description.
class story extends Thread {

	public story() {
		init();
	}

	class keyMusic extends Thread {

		@Override
		public void run() {
			
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(new File("src/main/SOURCE/keyboard.wav")));

				while (true) {
					if (isInterrupted()) {
						clip.stop();
						return;
					}

					clip.loop(1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

	// 한글자 한글자 출력하는 메소드.
	static void printOneByOne(String story) {
		for (int i = 0; i < story.length(); i++) {
			System.out.print(story.charAt(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void init() {
		keyMusic t1 = new keyMusic();
		t1.start();

		for (int k = 0; k < 60; k++)
			System.out.println();
		System.out.println("\n -------------------------------------------------------- \n");
		System.out.println("        _____   _______    ____    _____   __     __");
		System.out.println("       / ____| |__   __|  / __ \\  |  __ \\  \\ \\   / /");
		System.out.println("      | (___      | |    | |  | | | |__) |  \\ \\_/ /");
		System.out.println("       \\___ \\     | |    | |  | | |  _  /    \\   /");
		System.out.println("       ____) |    | |    | |__| | | | \\ \\     | |");
		System.out.println("      |_____/     |_|     \\____/  |_|  \\_\\    |_|\n");
		System.out.println("\n -------------------------------------------------------- \n");

		t1.interrupt();
	}
}