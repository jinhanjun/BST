package BST_A2;
public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	
	BST_Node(String data){
		this.data=data;
	}
	
	public String getData(){
		return data;
	}
	public BST_Node getLeft(){
		return left;
	}
	public BST_Node getRight(){
		return right;
	}
	
	public boolean containsNode(String s){ //it was me
		if(data.equals(s))return true;
		if(data.compareTo(s)>0){//s lexiconically less than data
			if(left==null)return false;
			return left.containsNode(s);
		}
		if(data.compareTo(s)<0){
			if(right==null)return false;
			return right.containsNode(s);
		}
		return false; //shouldn't hit
	}
	public boolean insertNode(String s){
		if(data.compareTo(s)>0){
			if(left==null){
				left=new BST_Node(s);
				return true;
			}
			return left.insertNode(s);
		}
		if(data.compareTo(s)<0){
			if(right==null){
				right=new BST_Node(s);
				return true;
			}
			return right.insertNode(s);
		}
		return false;//ie we have a duplicate
	}
	public boolean removeNode(String s){ //DIO
		if(data==null)return false;
		if(data.equals(s)){
			if(left!=null){
				data=left.findMax().data;
				left.removeNode(data);
				if(left.data==null)left=null;
			}
			else if(right!=null){
				data=right.findMin().data;
				right.removeNode(data);
				if(right.data==null)right=null;
			}
			else data=null;
			return true;
		}
		else if(data.compareTo(s)>0){
			if(left==null)return false;
			if(!left.removeNode(s))return false;
			if(left.data==null)left=null;
			return true;
		}
		else if(data.compareTo(s)<0){
			if(right==null)return false;
			if(!right.removeNode(s))return false;
			if(right.data==null)right=null;
			return true;
		}
		return false;
	}
	public BST_Node findMin(){
		if(left!=null)return left.findMin();
		return this;
	}
	public BST_Node findMax(){
		if(right!=null)return right.findMax();
		return this;
	}
	public int getHeight(){
		int l=0;
		int r=0;
		if(left!=null)l+=left.getHeight()+1;
		if(right!=null)r+=right.getHeight()+1;
		return Integer.max(l, r);
	}
	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")+",Right: "+((this.right!=null)?right.data:"null");
	}
	
}


//package BST_A2;
//
//public class BST_Node {
//  String data;
//  BST_Node left;
//  BST_Node right;
//  
//  BST_Node(String data){ this.data=data; }
//
//  // --- used for testing  ----------------------------------------------
//  //
//  // leave these 3 methods in, as is
//
//  public String getData(){ return data; }
//  public BST_Node getLeft(){ return left; }
//  public BST_Node getRight(){ return right; }
//
//  // --- end used for testing -------------------------------------------
//
//  
//  // --- fill in these methods ------------------------------------------
//  //
//  // at the moment, they are stubs returning false 
//  // or some appropriate "fake" value
//  //
//  // you make them work properly
//  // add the meat of correct implementation logic to them
//
//  // you MAY change the signatures if you wish...
//  // make the take more or different parameters
//  // have them return different types
//  //
//  // you may use recursive or iterative implementations
//
//
//  public boolean containsNode(String s){  
//	  if(s.compareTo(this.data) == 0) {
//		  return true;
//	  } else if (s.compareTo(this.data) < 0) {
//		  if(this.left == null) {
//			  return false;
//		  }
//		  return this.left.containsNode(s);
//	  } else {
//		  if(this.right == null) {
//			  return false;
//		  }
//		  return this.right.containsNode(s);
//	  }
//	  
//	  
//  }
//  
//
//  public boolean insertNode(String s){ 
//	  if (s.compareTo(this.data) == 0) {
//		  return false;
//	  } else if (this.data.compareTo(s) > 0) {
//		  if(this.left == null) {
//			  this.left = new BST_Node(s);
//			  return true;
//		  }else {
//			  return this.left.insertNode(s);
//		  }
//	  } else {
//		  if(this.right == null) {
//			  this.right = new BST_Node(s);
//			  return true;
//		  }else {
//			  return this.right.insertNode(s);
//		  }	
//	  }
//
//  }
//
//
//
//  public boolean removeNode(String s) {
//	  BST_Node temp = this;
//	  if (temp != null) {
//		  if (temp.left != null) {
//			  //start left, sinces left values smaller
//			  if (temp.left.data.compareTo(s) == 0) {
//				  if (temp.left.right == null || temp.left.left == null) {
//					  if(temp.left.right == null) {
//						  temp.left = temp.left.left; //goes left if right null
//						  return true;
//					  } else if (temp.left.left == null) {
//						  temp.left = temp.left.right; //goes right if left null
//						  return true;
//					  } else {
//						  temp.left = null; //both null, just remove
//						  return true;
//					  }
//				  } else {
//					  //find min on left side and replace node with min, then relalign
//					  BST_Node key = temp.left.right.findMin();
//					  removeNode(key.data);
//					  key.left = temp.left.left;
//					  key.right = temp.left.right;
//					  temp.left = key;
//					  return true;
//				  }
//			  }
//		  }
//		  if (temp.right != null) {
//			  if (temp.right.data.compareTo(s) == 0) {
//				  if (temp.right.right == null || temp.right.left == null) {
//					  if(temp.right.right == null) {
//						  temp.right = temp.right.left; //goes to left if right null
//						  return true;
//					  } else if (temp.right.left == null) {
//						  temp.right = temp.right.right; //goes to right if left null
//						  return true;
//					  } else {
//						  temp.right = null; //if both null, then just remove
//						  return true;
//					  }
//				  } else {
//					  //find min on right side and replace node with min, then relalign
//					  BST_Node key = temp.right.right.findMin();
//					  removeNode(key.data);
//					  key.left = temp.right.left;
//					  key.right = temp.right.right;
//					  temp.right = key;
//					  return true;
//				  }
//
//			  }
//		  }
//		  if (temp.data.compareTo(s) > 0) {
//			  //recursion left if not equal
//			  return temp.left.removeNode(s);
//
//		  }
//		  if (temp.data.compareTo(s) < 0) {
//			  //recursion right if not equal
//			  return temp.right.removeNode(s);
//		  }
//	  }
//	  return false;
//  }
//
//
//  public BST_Node findMin(){ 
//	  if (this.left == null) {
//		  return this;
//	  }else{
//		  return this.left.findMin();
//	  } 
//  }
//
//
//  public BST_Node findMax(){ 
//	  if (this.right == null) {
//		  return this;
//	  }else{
//		  return this.right.findMin();
//	  } 
//  }
//  
//  
//  public int getHeight(){
//	  return getHeight1(this);
//  }
//  public int getHeight1(BST_Node node){ 
//	  if (node == null) {
//		  return -1;
//	  } else {  
//		  int lHeight = getHeight1(node.left); 
//		  int rHeight = getHeight1(node.right); 
//
//		  if (lHeight > rHeight) {
//			  return 1 + lHeight; 
//		  } else {
//			  return 1 + rHeight; 
//		  }
//	  }
//  }
//  
//
//
//
//  // --- end fill in these methods --------------------------------------
//
//
//  // --------------------------------------------------------------------
//  // you may add any other methods you want to get the job done
//  // --------------------------------------------------------------------
//  
//  public String toString(){
//    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
//            +",Right: "+((this.right!=null)?right.data:"null");
//  }
//}