package hellboss;

public class Node<E>{
	E data;
	Node<E> next;

	public Node(E d){
		this.data = d;
	}
	public String toString(){
		return ""+data;
	}
	public void setData(E d){data=d;}
	public E getData() {return data;}
	public void setNext(Node<E> n){next = n;}
	public Node<E> getNext(){return next;}
}
