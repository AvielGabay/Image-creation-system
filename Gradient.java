package images;

public class Gradient extends BaseImage {
	private RGB startColor, endColor;

	public Gradient(int width, int height, RGB start, RGB end) {
		super(width, height);
		startColor = start;
		endColor = end;
	}

	@Override
	//return filtered image according to another image
	public RGB get(int x, int y) {
		return RGB.mix(endColor, startColor, (double) x / (double) getWidth());
	}
}