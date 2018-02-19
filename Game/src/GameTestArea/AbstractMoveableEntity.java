package GameTestArea;

public abstract class AbstractMoveableEntity extends AbstractEntity implements MoveableEntity {

	protected double dx, dy;
	public AbstractMoveableEntity(double x, double y, double width,
			double height) {
		super(x, y, width, height);
		this.dx = 0;
		this.dy = 0;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(int delta) {
		this.x += delta * dx;
		this.y += delta * dy;
		
	}
	
	public double getDX(){
		return dx;
	}
	public double getDY(){
		return dy;
	}
	public void setDX(double dx){
		this.dx = dx;
	}
	public void setDY(double dy){
		this.dy = dy;
	}


}
