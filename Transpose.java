package images;

public class Transpose extends ImageDecorator{
	public Transpose (Image base) {
		super(base);
	}
	
	//swap between height and width
	@Override
	public int getWidth() {	
		return super.getHeight();
	}

	//swap between height and width
	@Override
	public int getHeight() {
		return super.getWidth();
	}

	//swap between x and y
	@Override
	public RGB get(int x, int y) {
		return super.get(y, x);
	}
}