package APITests;

public class Experience {
	
	public boolean current;
	public String _id;
	public String title;
	public String company;
	public String location;
	public String from;
	public String to;
	public String description;
	
	public Experience() {
		
	} 
	
	public Experience(boolean current, 
					  String _id,
					  String title,
					  String company,
					  String location,
					  String from,
					  String to,
					  String description) {
		this.current = current;
		this._id = _id;
		this.title = title;
		this.company = company;
		this.location = location;
		this.from = from;
		this.to = to;
		this.description = description;
	} 
	
	public boolean equals(Experience obj) {
        return (this.current == obj.current) && (this._id.equals(obj._id)) && 
        		(this.title.equals(obj.title)) && (this.company.equals(obj.company)) && 
        		(this.location.equals(obj.location)) && (this.from.equals(obj.from)) && 
        		(this.description.equals(obj.description));
    }
	
}
