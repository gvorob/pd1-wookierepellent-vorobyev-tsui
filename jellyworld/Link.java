package jellyworld;

public class Link{
    public double k;
    public double len;
    public MyPoint other;
    

    public Link(double constant,double length,MyPoint point){
	k = constant;
	len = length;
	other = point;
    }
    
    public boolean equals(Link l){
    	return ((k == l.k) && (len == l.len) && (other.equals(l)));
    }
}
