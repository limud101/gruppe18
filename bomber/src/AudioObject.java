public class AudioObject {
	private static double freq = 0;
	double sample = 0;
	double amp = 0;
	int rep = 0;
	double mult = 1;

	void play() {
		setFreq(getFreq() + (int) (Math.random() * getFreq() * 0.7));
		setFreq((getFreq()) * Player.y);

		StdAudio.play(StdAudio.note(getFreq(), sample, amp));

	}

	AudioObject() {

	}

	public double getFreq() {
		return freq;
	}

	public static void setFreq(double freq) {
		AudioObject.freq = freq;
	}

}
