package images;

public class TwoColorImage extends BaseImage{
	private RGB zero, one;
	private TwoDFunc func;

	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
		super(width, height);
		this.zero = zero;
		this.one = one;
		this.func = func;
	}
	
	@Override
	// return new image according to two colors and function.
	public RGB get(int x, int y) {
		double newx = (double) x / Math.sqrt(Math.pow(super.getWidth(), 2));
		double newy = (double) y / Math.sqrt(Math.pow(super.getHeight(), 2));
		double alpha = func.f(newx, newy);
		if (alpha > 1)
			alpha = 1;
		else if (alpha < 0)
			alpha = 0;
		return RGB.mix(one, zero, alpha);
	}
}