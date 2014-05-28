package hellboss;

public class DoubleLL<E>{

	private Node<E> start,current;
	private int length;
	
	public DoubleLL<E>(){
		start = new Node<E>(null);
		length = 0;
	}

	public void add(E d){
		Node<E> n = new Node<E>(d);
		n.setNext(current.getNext());
		current.setNext(n);
		length++;
	}

	public void forward(){
		if(current.getNext()!=null)
			current=current.getNext();
	}
	public void back(){
		if(current.getPrev() !=null)
			current=current.getPrev();
	}
	public String toString(){
		Node<E> tmp = current;
		if(tmp == null)
			return "";
		String s = "";
		do{
			s=s+tmp.getData()+" ";
			tmp = tmp.next;
		}
		while(tmp!=current);
		return s;
	}

	public void delete(){
		if(current.next.equals(current)){
			current = null;
		}
		else{
			current.prev.next = current.next;
			current.next.prev = current.prev;
			current = current.next;
		}
	}

	public int find(E s){
		Node tmp = current;
		int i = 0;
		do{
			if(tmp.getData().equals(s))
				return i;
			tmp = tmp.next;
			i++;
		}
		while(tmp!=current);
		return -1;
	}

}
