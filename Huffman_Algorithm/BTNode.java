package Data_Structures_Final_Project;
import java.util.*;
public class BTNode<T>{
    T data;
    BTNode left;
    BTNode right;
    int frequency;
	public BTNode(T data,int frequency) {
		super();
		this.data = data;
		left = null;
	    right = null;
	    this.frequency=frequency;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BTNode getLeft() {
		return left;
	}
	public void setLeft(BTNode left) {
		this.left = left;
	}
	public BTNode getRight() {
		return right;
	}
	public void setRight(BTNode right) {
		this.right = right;
	}
    
}
