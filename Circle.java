package images;

public class Circle extends BaseImage {
	 private int centerX, centerY, radius;
	 private RGB center, outside;

	/* The recipient builder: the width and length of the image, the coordinates of
	   the center of the circle, the radius,
	   the color that will be in the center, and the color at the end of the circle
	   and outside it. */
	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		super(width, height);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}
	
	/* constructor that produces an image with a height and width equal to a size
	   and a circle whose center is the center of the image.*/
	public Circle(int size, int radius, RGB center, RGB outside) {
		this(size,size,size/2,size/2,radius,center, outside);

	}

	// returns color according to x,y values.
	public RGB get(int x, int y) {
		double xTemp, yTemp, distance, ratio;
		xTemp = Math.pow(x-centerX, 2);
		yTemp = Math.pow(y-centerY, 2);
		distance = Math.sqrt(xTemp + yTemp);
		distance = radius < distance ? radius : distance;
		ratio = 1 - (distance / radius);
		return RGB.mix(center, outside, ratio);
	}
}