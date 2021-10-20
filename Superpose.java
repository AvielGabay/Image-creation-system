package images;

public class Superpose extends BinaryImageDecorator {

	public Superpose(Image base1, Image base2) {
		super(base1, base2);
	}

	@Override
	public int getWidth() {
		return super.getWidth();
	}

	@Override
	public int getHeight() {
		return super.getHeight();
	}

	@Override
	public RGB get(int x, int y) {		
		boolean flag1 = false, flag2 = false;

		if (width1 >= x && height1 >= y)
			flag1 = true;
		if (width2 >= x && height2 >= y)
			flag2 = true;

		if (flag1 && flag2)
			return RGB.superpose(base1.get(x, y), base2.get(x, y));// if both defined.
		if (flag1 && !flag2)
			return base1.get(x, y);// if base1 defined and base2 not defined.
		if (!flag1 && flag2)
			return base2.get(x, y);// if base2 defined and base1 not defined.
		return RGB.BLACK;// if both are not defined.
	}
}