/**
 * Physicsbody
 * @author Linus
 *
 */
public class Physicsbody {
	Hitbox hitbox;
	Vec2 pos;
	double dir;
	Physicsbody(int size, Vec2 pos){
		this.pos = pos;
		this.hitbox = new Hitbox(size, this);
	}
	/**
	 * moves the position by the vector
	 * @param adder The Vector which indicates where the new position is relative to the old 
	 */
	public void moveVec(Vec2 adder){
		pos = pos.add(adder);
	}
	/**
	 * moves the position by the dist in the direction the body is facing
	 * @param dist the distance from the old to the new position
	 */
	public void moveDir(double dist) {
		pos = pos.add(pos.fromPolar(dist, dir));
	}
	/**
	 * turns the physicsbody
	 * @param dir how much the physicsbody turns
	 */
	public void turn(double dir) {
		this.dir += dir;
	}
	/**
	 * sets a new position
	 * @param pos the new position
	 */
	public void setPos(Vec2 pos) {
		this.pos = pos;
	}
	/**
	 * sets a new direction
	 * @param dir the new direction
	 */
	public void setDir(double dir) {
		this.dir = dir;
	}
	/**
	 * checks if the object collides with the other object
	 * @param otherObject the other Object
	 * @return true/false
	 */
	public boolean collision(Physicsbody otherObject) {
		return(hitbox.collides(otherObject.hitbox));
	}
}
