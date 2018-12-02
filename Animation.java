import java.awt.Image;
import java.util.ArrayList;

/**
 * a class representing an animation
 * @author marius
 *
 */
public class Animation {
	/**
	 * the saved images
	 */
	private ArrayList<Image> imgs;
	/**
	 * this animation's length in seconds
	 */
	private double length;
	/**
	 * how far the animation has advanced currently
	 */
	private double time = 0;

	/**
	 * creates a new Animation with the given parameters
	 * @param imgs the images the animation consists of
	 * @param length the animation's length in seconds
	 */
	public Animation(ArrayList<Image> imgs, double length) {
		this.imgs = imgs;
		if (length <= 0) {
			throw new RuntimeException("Can't create an Animation of length 0 or less.");
		}
		this.length = length;
	}

	/**
	 * advances the animation by the given timestep
	 * @param dt the timestep in seconds
	 */
	public void update(double dt) {
		time += dt;
		while (time > length) {
			time -= length;
		}
	}

	/**
	 * gets the current image
	 * @return the result
	 */
	public Image getCurrentImage() {
		return imgs.get((int) Math.floor(imgs.size() * time / length));
	}

}
