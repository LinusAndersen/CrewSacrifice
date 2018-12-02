import java.awt.Image;
import java.util.ArrayList;
import java.util.Map;

/**
 * a class that handles multiple animations
 * @author marius
 *
 */
public class AnimationHandler {
	/**
	 * the saved named animations
	 */
	private Map<String, Animation> anims;
	/**
	 * the current animation
	 */
	private String currentAnimation = null;

	/**
	 * creates a new AnimationHandler
	 */
	AnimationHandler() {
	}

	/**
	 * adds an animation with given parameters
	 * @param name the name to be given to this handler to activate the new animation
	 * @param imgs the images to be used by the animation
	 * @param length the animation's length in seconds
	 */
	public void addAnimation(String name, ArrayList<Image> imgs, double length) {
		if (anims.containsKey(name)) {
			throw new RuntimeException("The AnimationHandler already has an animation called " + name);
		}
		this.anims.put(name, new Animation(imgs, length));
	}

	/**
	 * gets the currentAnimation
	 * @return the result
	 */
	private Animation getCurrentAnimation() {
		return anims.get(currentAnimation);
	}

	/**
	 * advances the current animation by the given timestep
	 * @param dt the timestep in seconds
	 */
	public void update(double dt) {
		Animation anim = getCurrentAnimation();
		if (anim != null) {
			anim.update(dt);
		}
	}
	
	/**
	 * checks whether this handler saves an animation named the given parameter
	 * @param name the name of the animation
	 * @return the result
	 */
	public boolean hasAnimation(String name) {
		return anims.containsKey(name);
	}
	
	/**
	 * if there is a saved animation named the given parameter, 
	 * this handler switches to it, else it switches to using no animation
	 * @param name the name of the animation
	 */
	public void switchTo(String name) {
		if (anims.containsKey(name)) {
			currentAnimation = name;
		} else {
			currentAnimation = null;
		}
	}

	/**
	 * gets the current image from the current animation
	 * @return the result
	 */
	public Image getCurrentImage() {
		Animation anim = getCurrentAnimation();
		if (anim != null) {
			return anim.getCurrentImage();
		} else {
			return null;
		}
	}
}
