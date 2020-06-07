package BST_A2;


public class BST implements BST_Interface {
	public BST_Node root;
	int size;
	  
	public BST(){
		size = 0;
		root = null;
	}
	  
	@Override
	//used for testing, please leave as is
	public BST_Node getRoot(){
		return root;
	}

	@Override
	public boolean insert(String s) { //It was me
		// TODO Auto-generated method stub
		if (empty()) {
			root = new BST_Node(s);
			size += 1;
			return true;
		}
		
		if (contains(s)) {
			return false;
		} else {
			size += 1;
			return root.insertNode(s);
		}
	}

	@Override
	public boolean remove(String s) {  //DIO
		// TODO Auto-generated method stub
		if (!contains(s)) {
			return false;
		} else {
			if (root.data.equals(s) && size == 1) {
				root = null;
				size -= 1;
				return true;
			} else {
				size -= 1;
				return root.removeNode(s);
			}
		}
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if (empty()) {
			return null;
		} else {
			return root.findMin().data;
		}
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (empty()) {
			return null;
		} else {
			return root.findMax().data;
		}
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		if (empty()) {
			return false;
		}
		
		return root.containsNode(s);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		if (empty()) {
			return -1;
		} else {
			return root.getHeight();
		}
	}
}

//package BST_A2;
//
//public class BST implements BST_Interface {
//  public BST_Node root;
//  int size;
//  
//  public BST(){ size=0; root=null; }
//  
//  @Override
//  //used for testing, please leave as is
//  public BST_Node getRoot(){ return root; }
//
//@Override
//public boolean insert(String s) {
//	if (root == null) {
//		root = new BST_Node(s);
//	}
//	size++;
//	return root.insertNode(s);
//}
//
//@Override
//public boolean remove(String s) {
//	if (root == null) {
//		return false;
//	} 
//	size--;
//	if (root.data == s) {
//		if((root.left == null)&&(root.right == null)) { 
//			root = null;
//			return true;
//		} else if (root.right == null) {
//			root = root.left;
//			return true;
//		} else if (root.left == null) {
//			root = root.right;
//			return true;
//		} else {
//			BST_Node min = root.findMin();
//			root.removeNode(min.data);
//			min.left = root.left;
//			min.right = root.right;
//			root = min;
//			return true;
//		}
//	} 
//		return root.removeNode(s);
//}
//
//@Override
//public String findMin() {
//	return root.findMin().getData();
//}
//
//@Override
//public String findMax() {
//	return root.findMax().getData();
//}
//
//@Override
//public boolean empty() {
//	if (size == 0) {
//		return true;
//	} else {
//		return false;
//	}
//}
//
//@Override
//public boolean contains(String s) {
//	return root.containsNode(s);
//}
//
//@Override
//public int size() {
//	return size;
//}
//
//@Override
//public int height() {
//	return root.getHeight();
//}
//
//}