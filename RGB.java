package images;

public class RGB {
	private double red, green, blue;
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1, 0, 0);
	public static final RGB GREEN = new RGB(0, 1, 0);
	public static final RGB BLUE = new RGB(0, 0, 1);

	// Constructor that gets the 3 basis colors.
	public RGB(double red, double green, double blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	// Constructor that sets red green and blue to be grey.
	public RGB(double grey) {
		red = grey;
		green = grey;
		blue = grey;
	}

	public double getRed() {
		return red;
	}

	public double getBlue() {
		return blue;
	}

	public double getGreen() {
		return green;
	}

	/* Returns a new color that is the opposite of the original color
	   That is, all base colors are one less than the original base color.*/
	public RGB invert() {
		return new RGB(1 - red, 1 - green, 1 - blue);
	}

	/* Returns a new color in which each base color value is multiplied by the value of a filter.
	   For example if we started with the color white, we will get the color filter,
	   and any other color will have lower values, in proportion to how it started.*/
	public RGB filter(RGB filter) {
		return new RGB(red * filter.red, green * filter.green, blue * filter.blue);
	}

	/* Returns a new color whose base colors are the sum of the base colors of rgb1
	   and rgb2, up to a maximum of 1.
	   It simulates the color created by the projection of light from the two colors together.*/
	public static RGB superpose(RGB rgb1, RGB rgb2) {
		double rgbRed = rgb1.red + rgb2.red >= 1 ? 1 : rgb1.red + rgb2.red;
		double rgbGreen = rgb1.green + rgb2.green >= 1 ? 1 : rgb1.green + rgb2.green;
		double rgbBlue = rgb1.blue + rgb2.blue >= 1 ? 1 : rgb1.blue + rgb2.blue;
		return new RGB(rgbRed, rgbGreen, rgbBlue);
	}

	/* Returns a new color that is a weighted average of the two corresponding colors,
	   with each base color, the formula is: alpha * color1 + (1-alpha) * color2*/
	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		double rgbRed = (alpha*rgb1.red + (1-alpha)*rgb2.red);
		double rgbGreen = (alpha*rgb1.green + (1-alpha)*rgb2.green);
		double rgbBlue = (alpha*rgb1.blue + (1-alpha)*rgb2.blue);
		return new RGB(rgbRed, rgbGreen, rgbBlue);
	}

	/* Returns a string representing the color, exactly four digits after the dot,
	   for example:
	   <0.1002, 0.9922, 0.7000> The order is red, green, blue.*/
	public String toString() {
		return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
	}
}