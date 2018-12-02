/**
 * 2D Vector class
 * 
 * @author marius
 *
 */
public class Vec2 {
	/**
	 * x-component of the vector
	 */
	public double x;
	/**
	 * y-component of the vector
	 */
	public double y;

	/**
	 * creates a new vector with the given components
	 * 
	 * @param x x-component of the vector
	 * @param y y-component of the vector
	 */
	public Vec2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * clones the vector
	 * 
	 * @return the cloned vector
	 */
	public Vec2 clone() {
		return new Vec2(x, y);
	}

	/**
	 * creates a new vector with components (0,0)
	 * 
	 * @return the new vector
	 */
	public static Vec2 zero() {
		return new Vec2(0, 0);
	}

	/**
	 * creates a vector from polar coordinates
	 * 
	 * @param r     the magnitude
	 * @param theta the argument, i.e the angle (ccw) from the x-axis in radians
	 * @return the new vector
	 */
	public static Vec2 fromPolar(double r, double theta) {
		return new Vec2(r * Math.cos(theta), r * Math.sin(theta));
	}

	/**
	 * checks for both components being 0
	 * 
	 * @return the result
	 */
	public boolean isZero() {
		return x == 0 && y == 0;
	}

	/**
	 * negates both components
	 * 
	 * @return the new vector
	 */
	public Vec2 neg() {
		return new Vec2(-x, -y);
	}

	/**
	 * adds another vector to this vector (component-wise)
	 * 
	 * @param other the other vector
	 * @return the new vector
	 */
	public Vec2 add(Vec2 other) {
		return new Vec2(x + other.x, y + other.y);
	}

	/**
	 * subtracts another vector from this vector (component-wise)
	 * 
	 * @param other the other vector
	 * @return the new vector
	 */
	public Vec2 sub(Vec2 other) {
		return add(other.neg());
	}

	/**
	 * scales both components by a factor
	 * 
	 * @param f the factor
	 * @return the new vector
	 */
	public Vec2 scale(double f) {
		return new Vec2(f * x, f * y);
	}

	/**
	 * scales the x-component by one factor and the y-component by another
	 * 
	 * @param x the factor for the x-component
	 * @param y the factor for the y-component
	 * @return the new vector
	 */
	public Vec2 scale(double x, double y) {
		return new Vec2(x * this.x, y * this.y);
	}

	/**
	 * rotates this vector by an angle
	 * 
	 * @param theta the angle in radians
	 * @return the new vector
	 */
	public Vec2 rotateBy(double theta) {
		return fromPolar(mag(), arg() + theta);
	}
	
	/**
	 * rotates this vector to an angle
	 * 
	 * @param theta the angle in radians
	 * @return the new vector
	 */
	public Vec2 rotateTo(double theta) {
		return fromPolar(mag(),theta);
	}

	/**
	 * calculates the dot-product of this and another vector
	 * 
	 * @param other the other vector
	 * @return the result
	 */
	public double dot(Vec2 other) {
		return x * other.x + y * other.y;
	}

	/**
	 * calculates the square of the distance to another vector
	 * 
	 * @param other the other vector
	 * @return the result
	 */
	public double distSquare(Vec2 other) {
		return (x - other.x) * (x - other.x) + (y - other.y) * (y - other.y);
	}

	/**
	 * calculates the distance to another vector
	 * 
	 * @param other the other vector
	 * @return the result
	 */
	public double dist(Vec2 other) {
		return Math.sqrt(distSquare(other));
	}

	/**
	 * calculates the magnitude of this vector
	 * 
	 * @return the result
	 */
	public double mag() {
		return dist(zero());
	}

	/**
	 * calculates the argument, i.e. the angle relative to the x-axis, of this vector
	 * 
	 * @return the result in radians
	 */
	public double arg() {
		return Math.atan2(x, y);
	}

	/**
	 * norms this vector to a magnitude of 1
	 * 
	 * @return the new vector
	 */
	public Vec2 norm() {
		return scale(1 / mag());
	}

	/**
	 * creates a String-representation of this vector in the form "(x,y)"
	 * 
	 * @return the String
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
