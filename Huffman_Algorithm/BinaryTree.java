package Data_Structures_Final_Project;
import java.util.*;
public class BinaryTree{
    BTNode root;
    ArrayList<codeChar> listofcodes=new ArrayList<codeChar>();
    public BinaryTree() {
		super();
		this.root=null;
	}
	public BTNode getRoot() {
		return root;
	}

	public void setRoot(BTNode root) {
		this.root = root;
	}
	public void traverseInOrder(BTNode btnode) {
		if(btnode!=null) {
			traverseInOrder(btnode.left);
    		System.out.println("\t\t"+btnode.data);
        	traverseInOrder(btnode.right);
    	}
	}
	 public void traverseInOrder(BTNode btnode, String code) {
	    	
	    	if( btnode==null) {
	    		return;
	    	}
	    	if(btnode.left==null && btnode.right==null) {
	    		System.out.println("\t\t"+btnode.data+"\t\t"+code);
	    		listofcodes.add(new codeChar(code,(char) btnode.data));
	    	    return;
	    	}
	    	traverseInOrder(btnode.left,code+"0");
	    	traverseInOrder(btnode.right,code+"1");
	    }
	 public String decodeHuffmanTree(String binary) {
		 String result="";
		 BTNode temp=root;
		 for(int i=0;i<binary.length();i++) {
			 if(binary.charAt(i)=='1') {
				temp=temp.right;
				 if(temp.left==null && temp.right==null) {
					 result=result+temp.data;
					 temp=root;
				 }
			 }
			 else {
				 temp=temp.left;
				 if(temp.left==null && temp.right==null) {
					 result=result+temp.data;
					 temp=root;
				 }
				 
			 }
		 }
	    	return result;
	    }
    public void showNodes() {
    	traverseInOrder(root," ");
    }
    public void showNodesWithoutEncode() {
    	traverseInOrder(root);
    }
}
