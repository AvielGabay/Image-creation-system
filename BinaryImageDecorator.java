package images;

public abstract class BinaryImageDecorator implements Image {
	protected Image base1, base2;
	protected int width1, width2, height1, height2;
	private int width, height;
	
	public BinaryImageDecorator(Image base1, Image base2) {
		this.base1 = base1;
		this.base2 = base2;
		width1 = base1.getWidth();
		width2 = base2.getWidth();
		height1 = base1.getHeight();
		height2 = base2.getHeight();
		width = (width1 > width2 ? width1 : width2); // width gets the max width
		height = (height1 > height2 ? height1 : height2); // height gets the max height
	}
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public abstract RGB get(int x, int y);
}