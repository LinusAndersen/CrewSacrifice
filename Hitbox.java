/**
 * Hitbox-class (circle)
 * @author Linus
 *
 */
public class Hitbox {
	Physicsbody parent;
	double radius;
	/**
	 * 
	 * @param radius the radius of the circle
	 * @param parent the parent (where the hitbox gets its position from)
	 */
	Hitbox(double radius, Physicsbody parent){
		this.radius = radius;
		this.parent = parent;
	}
	/**
	 * checks if this hitbox collides with another hitbox
	 * @param hitbox the other hitbox
	 * @return true/false
	 */
	public boolean collides(Hitbox hitbox) {
		return(parent.pos.dist(hitbox.parent.pos) <= hitbox.radius + this.radius);
	}
}
