import java.awt.Graphics2D;
import java.awt.Image;


public class Render {
	private AnimationHandler anims;
	
	public void draw(Graphics2D g, Vec2 screenPos, Vec2 rotation, Vec2 scale) {
		Image img = anims.getCurrentImage();
	}	
}