package images;

public abstract class ImageDecorator implements Image {
	private Image base;

	public ImageDecorator(Image base) {
		this.base = base;
	}
	
	@Override
	public int getWidth() {
		return base.getWidth();
	}
	
	@Override
	public int getHeight() {
		return base.getHeight();
	}
	
	@Override
	public RGB get(int x, int y) {
		return base.get(x, y);
	}
}