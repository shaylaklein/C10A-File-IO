
public class Student implements Comparable<Student> {

	private String name; 
	private int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	} 
	
	@Override
	public int compareTo (Student o) {
		if (score < o.score) 
			return -1; 
		else if (score > o.score) 
			return 1; 
		else 
			return 0; 
	}

	@Override
	public String toString() {
		return name + " " + score;
	}
	
	
	
}
