package marko.kozic;

public class Berry {

	private String nameOfBerry;
	private int sizeOfBerry;
	private int growthTimeOfBerry;

	public Berry(String nameOfBerry, int sizeOfBerry, int growthTimeOfBerry) {
		this.nameOfBerry = nameOfBerry;
		this.sizeOfBerry = sizeOfBerry;
		this.growthTimeOfBerry = growthTimeOfBerry;
	}

	public String getNameOfBerry() {
		return nameOfBerry;
	}

	public int getSizeOfBerry() {
		return sizeOfBerry;
	}

	public int getGrowthTimeOfBerry() {
		return growthTimeOfBerry;
	}

	@Override
	public String toString() {
		return "name : " + this.nameOfBerry + " size : " + this.sizeOfBerry + " growth time : " + this.growthTimeOfBerry;
	}
}
