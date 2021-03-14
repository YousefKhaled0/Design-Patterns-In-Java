package prototype;

class Line implements Cloneable{

	private Point start, end;

	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public Line(Line line) {
		this.start = new Point(line.start);
		this.end = new Point(line.end);
	}

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Line [start=" + start + ", end=" + end + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new Line((Point) start.clone(), (Point) end.clone());
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		
		// Without handling the copying.
		Line l1 = new Line(new Point(0, 0), new Point(10, 10));
		Line l2 = l1;
		l2.setStart(new Point(55, 66));
		System.out.println(l1);
		System.out.println(l2); // l1 is the same object as l2
		
		System.out.println();
		
		// Using clone function
		Line l3 = new Line(new Point(0, 0), new Point(10, 10));
		Line l4 = (Line) l3.clone();
		l4.setStart(new Point(55, 66));
		System.out.println(l3);
		System.out.println(l4); // l3 is not the same object as l4

		System.out.println();
		
		// Using copy constructor 
		Line l5 = new Line(new Point(0, 0), new Point(10, 10));
		Line l6 = new Line(l5);
		l6.getStart().setX(100);
		System.out.println(l5);
		System.out.println(l6); // l5 is not the same object as l6
		
		// We can also Apache-Commons Serialization-Utils
	}

}
