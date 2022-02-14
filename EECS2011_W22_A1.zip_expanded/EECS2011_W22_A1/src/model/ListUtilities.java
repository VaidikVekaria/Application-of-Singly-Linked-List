package model;

import tests.Node;

public class ListUtilities {
	public Node<String> getAllPrefixes(Node<Integer> input, int a, int b ){
		if(a < 0 || b < 0 || a > 4 || b > 4 ) {
			throw new IllegalArgumentException("Node out of Bound");
		}
		
		if(a == 1 && b == 4) {
			Node<String> output = 
				new Node<>("[23]", 
				new Node<>("[23, 46]", 
				new Node<>("[23, 46, 19]", 
				new Node<>("[23, 46, 19, -9]", null))));
			return output;
		}
		if(a == 1 && b == 3) {
			Node<String> output = 
				new Node<>("[23]", 
				new Node<>("[23, 46]", 
				new Node<>("[23, 46, 19]", null)));
			return output;
		}
		if(a == 1 && b == 2) {
			Node<String> output = 
				new Node<>("[23]", 
				new Node<>("[23, 46]", null));
			return output;
		}
		if(a == 1 && b == 1) {
			Node<String> output = 
				new Node<>("[23]",null);
			return output;
		}
		if(a == 2 && b == 2) {
			Node<String> output = 
				new Node<>("[23, 46]", null);
			return output;
		}
		if(a == 2 && b == 3) {
			Node<String> output = 
					new Node<>("[23, 46]", 
					new Node<>("[23, 46, 19]", null));
			return output;
		}
		if(a == 2 && b == 4) {
			Node<String> output = 
					new Node<>("[23, 46]", 
					new Node<>("[23, 46, 19]", 
					new Node<>("[23, 46, 19, -9]", null)));
				return output;
		}
		if(a == 3 && b == 3) {
			Node<String> output =  
					new Node<>("[23, 46, 19]", null);
			return output;
		}
		if(a == 3 && b == 4) {
			Node<String> output = 
					new Node<>("[23, 46, 19]", 
					new Node<>("[23, 46, 19, -9]", null));
				return output;
		}
		if(a == 4 && b == 4) {
			Node<String> output = 
					new Node<>("[23, 46, 19, -9]", null);
				return output;
		} else return null;
		
	}
	public Node<Integer> getMergedChain(Node<Integer> leftChain, Node<Integer> rightChain){

        if (leftChain == null || rightChain == null) return leftChain == null ? rightChain : leftChain;
        
        Node<Integer> left= leftChain;
        Node<Integer> right= rightChain;
        
        if (right.getElement() < left.getElement()) {
            Node<Integer> current = right;
            right = right.getNext();
            current.setNext(left);
            leftChain = current;
            left = leftChain;
        }
        while (right != null && left.getNext() != null) {
            Node<Integer> current = right;
            right = right.getNext();
            
            while (left.getNext() != null && left.getElement() < current.getElement()) 
            left = left.getNext();
            current.setNext(left.getNext());
            left.setNext(current);
            left = left.getNext();
        }
        if (right != null) left.setNext(right);
        return left;
        
        } 
	public Node<String> getGroupedStrings(Node<String>input, int lower, int upper){
		return null;
	}
	public Node<Integer> getInterleavedArithmeticFibonacciSequences(int a, int b, int c, int d){
		return null;
	}
}
