package Data_Structures_Final_Project;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.util.Scanner;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	char choose;
	do {
	System.out.println("-----------------------------------MENU-----------------------------------\r\n"
			+ "表t\tPress 1:Read the data from file original.txt\r\n"
			+ "表t\tPress 2:Calculate the size of the file original.txt in bits\r\n"
			+ "表t\tPress 3:How many unique characters are there in file original.txt\r\n"
			+ "表t\tPress 4:Print the Frequency table(characters and their frequencies) for the file original.txt\r\n"
			+ "表t\tPress 5:Print the Huffman Tree for the file original.txt\r\n"
			+ "表t\tPress 6:Print the Huffman Table(characters and their corressponding enconding) for the file original.txt\r\n"
			+ "表t\tPress 7:Encoding of each character in separate file encoded.txt\r\n"
			+ "表t\tPress 8:Print the size of the file encoded.txt in bits\r\n"
			+ "表t\tPress 9:Reconstruct the original file by the name of reconstructed.txt\r\n"
			+ "表t\tPress 10:Print report that tells us whether the file original.txt and the file reconstructed.txt are same");
	System.out.println("--------------------------------------------------------------------------\r\n");
	System.out.println("Enter your choice:");
	Scanner input=new Scanner(System.in);
	int choice=input.nextInt();
	switch(choice) {
	case 1:
	String file="";
    try {
    	File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","original.txt"); //File already created
    	Scanner reader=new Scanner(obj);
    	while(reader.hasNextLine()) {
    		String filedata = reader.nextLine();
    		file=file+filedata;
    	}
    }
    catch(FileNotFoundException e){
    	System.out.println("#Error: File not found ");
    	e.printStackTrace();
    }
    System.out.println("File successfully read");
	System.out.println("Data  in the file is as follows: "+file);
    break;
	case 2:
		try {
	    	File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","original.txt"); //File already created
	    	Scanner reader=new Scanner(obj);
	    	while(reader.hasNextLine()) {
	    		String filedata = reader.nextLine();
	    		System.out.println("Data  in the file original.txt is as follows: "+filedata);
	    		System.out.println("Size of the file original.txt in bits: "+obj.length()*8);
	    		
	    	}
	    }
	    catch(FileNotFoundException e){
	    	System.out.println("#Error: File not found ");
	    	e.printStackTrace();
	    }
		break;
	case 3:
		try {
	    	File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","original.txt");//File already created
	    	Scanner reader=new Scanner(obj);
	    	while(reader.hasNextLine()) {
	    		String filedata = reader.nextLine();
	    		System.out.println("Data in the file is as follows: "+filedata);
	    		int unique=0;
	    		for(int i = 0; i < filedata.length(); i++) {
	    			
	    			for(int j=0;j < filedata.length();j++) {
	    				if(i==j && i!=filedata.length()-1 && j!=filedata.length()-1) {
	    					continue;
	    				}
	    				if(filedata.charAt(i)==filedata.charAt(j)) {
	    					break;
	    				}
	    				if(filedata.charAt(i)!=filedata.charAt(j) && j==filedata.length()-1) {
	    					unique++;
	    				}
	    				if(i==filedata.length()-1 && filedata.charAt(i)!=filedata.charAt(j) && j==filedata.length()-2) {
	    					unique++;
	    				}
	    			}
	    		}
	    		System.out.println("Total number of unique characters is: "+unique);
	    		}
	    	}
	    catch(FileNotFoundException e){
	    	System.out.println("#Error: File not found ");
	    	e.printStackTrace();
	    }
		break;
	case 4:
		 try {
		    	File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","original.txt");//File already created
		    	Scanner reader=new Scanner(obj);
		    	while(reader.hasNextLine()) {
		    		String filedata = reader.nextLine();
		    		System.out.println("Data  in the file is as follows: "+filedata);
		    		System.out.println("\t-------------Frequency Table-------------");
		    		String distinctstr="";
				for(int i = 0; i < filedata.length(); i++) {
					if(i==0) {
			    		distinctstr=distinctstr+filedata.charAt(i);
			    	}
					    for(int j=0;j<distinctstr.length();j++) {
					    	
					    	if(i!=0 && filedata.charAt(i)==distinctstr.charAt(j)) {
					        	break;
					        }
					        if(i!=0 && filedata.charAt(i)!=distinctstr.charAt(j) && j==distinctstr.length()-1) {
					        	distinctstr=distinctstr+filedata.charAt(i);
					        }
					       }
						}
				char distinctelements[]=new char[distinctstr.length()];
				for(int i=0;i<distinctelements.length;i++) {
					distinctelements[i]=distinctstr.charAt(i); //For characters
				}
				int frequencyofchars[]=new int[distinctelements.length];
				
				for(int i=0;i<distinctelements.length;i++) {   //for frequency of characters
					 
					int frequency = 0;
					
				for(int j=0;j<filedata.length();j++) {
					
				    if(distinctelements[i]==filedata.charAt(j)) {
				    	
				    	frequency++;
				    }
				}
				frequencyofchars[i]=frequency;
				}
				System.out.println("\t|Character\tFrequency\t\t|");
				for(int i=0;i<distinctelements.length;i++) {
					  if(distinctelements[i]==' ') {
						  System.out.println("\t"+"|"+"   (space)"+"\t"+frequencyofchars[i]+"\t\t\t|");
					  }
					  else {
						  System.out.println("\t"+"|"+"\t"+distinctelements[i]+"\t"+frequencyofchars[i]+"\t\t\t|");
					  }
					}
				System.out.println("\t-----------------------------------------");
		    	}
		 }
		    catch(FileNotFoundException e){
		    	System.out.println("#Error: File not found ");
		    	e.printStackTrace();
		    }
		break;
	case 5:
		try {
			File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","original.txt");//File already created
	    	Scanner reader=new Scanner(obj);
	    	while(reader.hasNextLine()) {
	    		String filedata = reader.nextLine();
	    		String distinctstr="";
			for(int i = 0; i < filedata.length(); i++) {
				if(i==0) {
		    		distinctstr=distinctstr+filedata.charAt(i);
		    	}
				    for(int j=0;j<distinctstr.length();j++) {
				    	
				    	if(i!=0 && filedata.charAt(i)==distinctstr.charAt(j)) {
				        	break;
				        }
				        if(i!=0 && filedata.charAt(i)!=distinctstr.charAt(j) && j==distinctstr.length()-1) {
				        	distinctstr=distinctstr+filedata.charAt(i);
				        }
				       }
					}
			char distinctelements[]=new char[distinctstr.length()];
			for(int i=0;i<distinctelements.length;i++) {
				distinctelements[i]=distinctstr.charAt(i); //For characters
			}
			int frequencyofchars[]=new int[distinctelements.length];
			
			for(int i=0;i<distinctelements.length;i++) {   //for frequency of characters
				 
				int frequency = 0;
				
			for(int j=0;j<filedata.length();j++) {
				
			    if(distinctelements[i]==filedata.charAt(j)) {
			    	
			    	frequency++;
			    }
			}
			frequencyofchars[i]=frequency;
			}
			PriorityQueue q=new PriorityQueue(distinctelements.length);
			BinaryTree bt=new BinaryTree();
			int i=0;
			do {
				BTNode newnode=new BTNode(distinctelements[i],frequencyofchars[i]);
				bt.root=newnode;
				newnode=bt.root;
      			newnode.left=null;
				newnode.right=null;
				q.queueEnqueue(newnode);
			    i++;
			}while(i!=distinctelements.length);
			System.out.println("\t\tPriority Queue is as Follows:\n");
			q.queueDisplay();
			System.out.println("\t\t------------------------");
			do {
				int freq1=q.peek().frequency;
				BTNode nodeleft=q.deletemin();
				int freq2=q.peek().frequency;
				int sum=freq1+freq2;
				BTNode noderight=q.deletemin();
				BTNode newlynode=new BTNode('*',sum);
				bt.root=newlynode;
				newlynode=bt.root;
      			newlynode.left=nodeleft;
				newlynode.right=noderight;
				q.queueEnqueue(newlynode);
				q.queueDisplay();
				System.out.println("\t\t-------------------------");
			}while(q.size()!=1);
			System.out.println("\t\tHuffman Tree is as follows:\n");
			bt.showNodesWithoutEncode();
	    	}

		}
	    catch(FileNotFoundException e){
	    	System.out.println("#Error: File not found ");
	    	e.printStackTrace();
	    }
		break;
	case 6:
		try {
			File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","original.txt");//File already created
	    	Scanner reader=new Scanner(obj);
	    	while(reader.hasNextLine()) {
	    		String filedata = reader.nextLine();
	    		String distinctstr="";
			for(int i = 0; i < filedata.length(); i++) {
				if(i==0) {
		    		distinctstr=distinctstr+filedata.charAt(i);
		    	}
				    for(int j=0;j<distinctstr.length();j++) {
				    	
				    	if(i!=0 && filedata.charAt(i)==distinctstr.charAt(j)) {
				        	break;
				        }
				        if(i!=0 && filedata.charAt(i)!=distinctstr.charAt(j) && j==distinctstr.length()-1) {
				        	distinctstr=distinctstr+filedata.charAt(i);
				        }
				       }
					}
			char distinctelements[]=new char[distinctstr.length()];
			for(int i=0;i<distinctelements.length;i++) {
				distinctelements[i]=distinctstr.charAt(i); //For characters
			}
			int frequencyofchars[]=new int[distinctelements.length];
			
			for(int i=0;i<distinctelements.length;i++) {   //for frequency of characters
				 
				int frequency = 0;
				
			for(int j=0;j<filedata.length();j++) {
				
			    if(distinctelements[i]==filedata.charAt(j)) {
			    	
			    	frequency++;
			    }
			}
			frequencyofchars[i]=frequency;
			}
			PriorityQueue q=new PriorityQueue(distinctelements.length);
			BinaryTree bt=new BinaryTree();
			int i=0;
			do {
				BTNode newnode=new BTNode(distinctelements[i],frequencyofchars[i]);
				bt.root=newnode;
				newnode=bt.root;
      			newnode.left=null;
				newnode.right=null;
				q.queueEnqueue(newnode);
			    i++;
			}while(i!=distinctelements.length);
			do {
				int freq1=q.peek().frequency;
				BTNode nodeleft=q.deletemin();
				int freq2=q.peek().frequency;
				int sum=freq1+freq2;
				BTNode noderight=q.deletemin();
				BTNode newlynode=new BTNode('*',sum);
				bt.root=newlynode;
				newlynode=bt.root;
      			newlynode.left=nodeleft;
				newlynode.right=noderight;
				q.queueEnqueue(newlynode);
			}while(q.size()!=1);
			System.out.println("\t\t-------------------------");
			System.out.println("\t\tHuffman Table is as follows:");
			System.out.println("\t\t-------------------------");
			System.out.println("\t\tCharacter\tCode");
			bt.showNodes();
			System.out.println("\t\t-------------------------");
	    	}

		}
	    catch(FileNotFoundException e){
	    	System.out.println("#Error: File not found ");
	    	e.printStackTrace();
	    }
		break;
	case 7:
		try {
			File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","original.txt");//File already created
	    	Scanner reader=new Scanner(obj);
	    	while(reader.hasNextLine()) {
	    		String filedata = reader.nextLine();
	    		String distinctstr="";
			for(int i = 0; i < filedata.length(); i++) {
				if(i==0) {
		    		distinctstr=distinctstr+filedata.charAt(i);
		    	}
				    for(int j=0;j<distinctstr.length();j++) {
				    	
				    	if(i!=0 && filedata.charAt(i)==distinctstr.charAt(j)) {
				        	break;
				        }
				        if(i!=0 && filedata.charAt(i)!=distinctstr.charAt(j) && j==distinctstr.length()-1) {
				        	distinctstr=distinctstr+filedata.charAt(i);
				        }
				       }
					}
			char distinctelements[]=new char[distinctstr.length()];
			for(int i=0;i<distinctelements.length;i++) {
				distinctelements[i]=distinctstr.charAt(i); //For characters
			}
			int frequencyofchars[]=new int[distinctelements.length];
			
			for(int i=0;i<distinctelements.length;i++) {   //for frequency of characters
				 
				int frequency = 0;
				
			for(int j=0;j<filedata.length();j++) {
				
			    if(distinctelements[i]==filedata.charAt(j)) {
			    	
			    	frequency++;
			    }
			}
			frequencyofchars[i]=frequency;
			}
			PriorityQueue q=new PriorityQueue(distinctelements.length);
			BinaryTree bt=new BinaryTree();
			int i=0;
			do {
				BTNode newnode=new BTNode(distinctelements[i],frequencyofchars[i]);
				bt.root=newnode;
				newnode=bt.root;
      			newnode.left=null;
				newnode.right=null;
				q.queueEnqueue(newnode);
			    i++;
			}while(i!=distinctelements.length);
			do {
				int freq1=q.peek().frequency;
				BTNode nodeleft=q.deletemin();
				int freq2=q.peek().frequency;
				int sum=freq1+freq2;
				BTNode noderight=q.deletemin();
				BTNode newlynode=new BTNode('*',sum);
				bt.root=newlynode;
				newlynode=bt.root;
      			newlynode.left=nodeleft;
				newlynode.right=noderight;
				q.queueEnqueue(newlynode);
			}while(q.size()!=1);
			System.out.println("\t\t-------------------------");
			System.out.println("\t\tHuffman Table is as follows:");
			System.out.println("\t\t-------------------------");
			System.out.println("\t\tCharacter\tCode");
			bt.showNodes();
			System.out.println("\t\t-------------------------");
			System.out.println("Original String: "+filedata);
			ArrayList<codeChar> aa=bt.listofcodes;
			String encode="";
			for(int k=0;k<filedata.length();k++) {
				for(int l=0;l<aa.size();l++) {
					if(filedata.charAt(k)==aa.get(l).character) {
						encode=encode+aa.get(l).code;
					}
				}
			}
			
			String encodeupdate=encode.replaceAll(" ","");
			
			System.out.println("Encoding of the String in bits from Huffman Table: "+encodeupdate);
			
			System.out.println("Total bits: "+encodeupdate.length());
			int size = 0;
			if(encodeupdate.length()%7==0) {
				size=size+encodeupdate.length()/7;
			}
			else if(encodeupdate.length()%7!=0) {
				size=size+encodeupdate.length()/7;
				size=size+1;
			}
			String binaryset[]=new String[size];
			int start=0;
			int end=7;
			for(int index1=0;index1<binaryset.length;index1++) {
				  String temp="";
				for(int index2=start;index2<end;index2++) {
					temp=temp+encodeupdate.charAt(index2);
					if(index2==encodeupdate.length()-1) {
						if(temp.length()==7) {
						break;
						}
						else if(temp.length()!=7) {
							while(temp.length()!=7) {
								temp=temp+"0";
							}
						}
						break;
					}
				}
				binaryset[index1]=temp;
				if(index1!=binaryset.length-1) {
				start=end;
				end=end+7;
				}
				else if(index1==binaryset.length-1) {
					start=end;
					end=end+7;
				}
			}
			System.out.println("\t\t-----------------------------------------------------------------");
			System.out.println("\t\tCharacter Number\tBinary\t\tASCII value/char");
		    int intbinaryset[]=new int[binaryset.length];
			for(int index=0;index<intbinaryset.length;index++) {
				 intbinaryset[index]=Integer.parseInt(binaryset[index],2);
			}
			char chararray[]=new char[intbinaryset.length];
			for(int index=0;index<intbinaryset.length;index++) {
				chararray[index]=(char) intbinaryset[index];
			}
			System.out.println("\t\t-----------------------------------------------------------------");
			for(int index=0;index<binaryset.length;index++) {
				System.out.println("\t\t"+(index+1)+"\t\t\t"+binaryset[index]+"\t\t"+intbinaryset[index]+" / '"+chararray[index]+"'"+"\t");
			}
			System.out.println("\t\t----------------------------------------------------------------");
			String encodechars="";
	    	for(int index=0;index<chararray.length;index++) {
	    		encodechars=encodechars+chararray[index];
			}
	    	System.out.println("Data to be stored in the file encoded.txt: "+encodechars);
	    	try {
	    		FileWriter writer=new FileWriter("C:/Users/Syed Muhammad Ali/Desktop/encoded.txt");
	    		writer.write(encodechars);
	    		writer.close();
	    		System.out.println("Successfully wrote to the file encoded.txt");
	    	}
	    	catch(IOException e){
	    		System.out.println("#Error: Content not written on file");
	    		e.printStackTrace();
	    	}
	    	}
		}
	    catch(FileNotFoundException e){
	    	System.out.println("#Error: File not found ");
	    	e.printStackTrace();
	    }
		break;
	case 8:
		try {
	    	File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","encoded.txt"); //File already created
	    	Scanner reader=new Scanner(obj);
	    	while(reader.hasNextLine()) {
	    		String filedata = reader.nextLine();
	    		System.out.println("Data  in the file is as follows: "+filedata);
	    		System.out.println("Size of the file in bits: "+obj.length()*8);
	    	}
	    }
	    catch(FileNotFoundException e){
	    	System.out.println("#Error: File not found ");
	    	e.printStackTrace();
	    }
		break;
	case 9:
		BinaryTree bt=new BinaryTree();
		try {
			File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","original.txt"); //File already created
	    	Scanner reader=new Scanner(obj);
	    	while(reader.hasNextLine()) {
	    		String filedata = reader.nextLine();
	    		String distinctstr="";
			for(int i = 0; i < filedata.length(); i++) {
				if(i==0) {
		    		distinctstr=distinctstr+filedata.charAt(i);
		    	}
				    for(int j=0;j<distinctstr.length();j++) {
				    	
				    	if(i!=0 && filedata.charAt(i)==distinctstr.charAt(j)) {
				        	break;
				        }
				        if(i!=0 && filedata.charAt(i)!=distinctstr.charAt(j) && j==distinctstr.length()-1) {
				        	distinctstr=distinctstr+filedata.charAt(i);
				        }
				       }
					}
			char distinctelements[]=new char[distinctstr.length()];
			for(int i=0;i<distinctelements.length;i++) {
				distinctelements[i]=distinctstr.charAt(i); //For characters
			}
			int frequencyofchars[]=new int[distinctelements.length];
			
			for(int i=0;i<distinctelements.length;i++) {   //for frequency of characters
				 
				int frequency = 0;
				
			for(int j=0;j<filedata.length();j++) {
				
			    if(distinctelements[i]==filedata.charAt(j)) {
			    	
			    	frequency++;
			    }
			}
			frequencyofchars[i]=frequency;
			}
			PriorityQueue q=new PriorityQueue(distinctelements.length);
			int i=0;
			do {
				BTNode newnode=new BTNode(distinctelements[i],frequencyofchars[i]);
				bt.root=newnode;
				newnode=bt.root;
      			newnode.left=null;
				newnode.right=null;
				q.queueEnqueue(newnode);
			    i++;
			}while(i!=distinctelements.length);
			do {
				int freq1=q.peek().frequency;
				BTNode nodeleft=q.deletemin();
				int freq2=q.peek().frequency;
				int sum=freq1+freq2;
				BTNode noderight=q.deletemin();
				BTNode newlynode=new BTNode('*',sum);
				bt.root=newlynode;
				newlynode=bt.root;
      			newlynode.left=nodeleft;
				newlynode.right=noderight;
				q.queueEnqueue(newlynode);
			}while(q.size()!=1);
			System.out.println("\t\tHuffman Tree is as follows:\n");
			bt.showNodesWithoutEncode();
			System.out.println("\t\t-------------------------");
			System.out.println("\t\tHuffman Table is as follows: ");
			System.out.println("\t\t-------------------------");
			bt.showNodes();
			System.out.println("\t\t-------------------------");
	    	}
	    	
		}
	    catch(FileNotFoundException e){
	    	System.out.println("#Error: File not found ");
	    	e.printStackTrace();
	    }
		try {
        	File object=new File("C:/Users/Syed Muhammad Ali/Desktop","encoded.txt"); //File already created
        	Scanner read=new Scanner(object);
        	while(read.hasNextLine()) {
        		String filedata = read.nextLine();
        		System.out.println("Characters Stored in the file encoded.txt are: "+filedata);
        		System.out.println("\t\t--------------------------------------------------------------------------");
        		System.out.println("\t\tCharacters\tDecimals\tBinary Number\tBinary numbers in 7 bits");
        		System.out.println("\t\t--------------------------------------------------------------------------");
        		int decimals[]= new int[filedata.length()];
        		for(int i=0;i<filedata.length();i++) {
        			decimals[i]=filedata.charAt(i);
        		}
        		String binary[]= new String[filedata.length()];
        		for(int index=0;index<filedata.length();index++) {
        			binary[index]=Integer.toBinaryString(decimals[index]);
        		}
        		
        		String binarystring="";
        		for(int index=0;index<filedata.length();index++) {
        		     binarystring=binarystring+binary[index];
        		}
        		int size = filedata.length();
    			String binarycode[]=new String[size];
    			int start=0;
    			int end=7;
    			for(int q=0;q<binarycode.length;q++) {
    				String temp="";
    				for(int j=start;j<end;j++) {
    					if(j>=binarystring.length()) {
    					while(temp.length()!=7) {
    						temp=temp+"0";
    					}
    					}
    					else if(j<binarystring.length()) {
    						temp=temp+binarystring.charAt(j);
    					}
    					}
    				binarycode[q]=temp;
    				start=end;
    				end=end+7;
    			}
    			for(int i=0;i<filedata.length();i++) {
        			System.out.println("\t\t"+filedata.charAt(i)+"\t\t"+decimals[i]+"\t\t"+binary[i]+"\t\t"+binarycode[i]);
        		}
        		System.out.println("\t\t--------------------------------------------------------------------------");
        		String reconstructed="";
        		for(int p=0;p<binarycode.length;p++) {
        			reconstructed=reconstructed+bt.decodeHuffmanTree(binarycode[p]);
        		}
        		System.out.println("Characters got from Huffman Tree: "+reconstructed);
        		try {
    	    		FileWriter writer=new FileWriter("C:/Users/Syed Muhammad Ali/Desktop/reconstructed.txt"); //File already created
    	    		writer.write(reconstructed);
    	    		writer.close();
    	    		System.out.println("Successfully wrote to the file reconstructed.txt");
    	    	}
    	    	catch(IOException e){
    	    		System.out.println("#Error: Content not written on file");
    	    		e.printStackTrace();
    	    	}
        	}
        }
        catch(FileNotFoundException e){
        	System.out.println("#Error: File not found ");
        	e.printStackTrace();
        }
	    break;
	case 10:
		System.out.println("--------------------------REPORT------------------------");
		System.out.println("\n--------------------original.txt FILE-------------------");
		String original="";
		try {
	    	File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","original.txt");
	    	Scanner reader=new Scanner(obj);
	    	while(reader.hasNextLine()) {
	    		String filedata = reader.nextLine();
	    		original=original+filedata;
	    		System.out.println("Data  in the file original.txt is as follows: "+filedata);
	    		System.out.println("Size of the file original.txt in bits: "+obj.length()*8);
	    	}
	    }
	    catch(FileNotFoundException e){
	    	System.out.println("#Error: File not found ");
	    	e.printStackTrace();
	    }
		System.out.println("\n----------------------encoded.txt FILE------------------");
		try {
	    	File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","encoded.txt");
	    	Scanner reader=new Scanner(obj);
	    	while(reader.hasNextLine()) {
	    		String filedata = reader.nextLine();
	    		System.out.println("Data  in the file encoded.txt is as follows: "+filedata);
	    		System.out.println("Size of the file encoded.txt in bits: "+obj.length()*8);
	    	}
	    }
	    catch(FileNotFoundException e){
	    	System.out.println("#Error: File not found ");
	    	e.printStackTrace();
	    }
		String reconstructed="";
		System.out.println("\n--------------------reconstructed.txt FILE--------------");
		try {
	    	File obj=new File("C:/Users/Syed Muhammad Ali/Desktop","reconstructed.txt");
	    	Scanner reader=new Scanner(obj);
	    	while(reader.hasNextLine()) {
	    		String filedata = reader.nextLine();
	    		reconstructed=reconstructed+filedata;
	    		System.out.println("Data  in the file reconstructed.txt is as follows: "+filedata);
	    		System.out.println("Size of the file reconstructed.txt in bits: "+obj.length()*8);
	    	}
	    }
	    catch(FileNotFoundException e){
	    	System.out.println("#Error: File not found ");
	    	e.printStackTrace();
	    }
	     break;
	default:
	     break;
	    
	}
	System.out.println("\nDo you want to go back to the general menu?(Y/N)");
	choose=input.next().charAt(0);
	}while(choose=='Y' || choose=='y');
}
}