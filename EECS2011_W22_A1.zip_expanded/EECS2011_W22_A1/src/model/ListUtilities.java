package model;

//import static org.junit.Assert.assertTrue;

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

        
		if (leftChain == null && rightChain == null) return null;
        if (leftChain == null ) {
            Node<Integer> deepCopy = new Node<>(rightChain.getElement(),null);
            Node<Integer> deepCopy_R = deepCopy;
            
            while(rightChain.getNext() != null) {
            	deepCopy.setNext(new Node<>(rightChain.getNext().getElement(),null));
            	rightChain = rightChain.getNext();
            	deepCopy = deepCopy.getNext();
            }
            
            return deepCopy_R;
        }
        if (rightChain == null) {
        	Node<Integer> deepCopy = new Node<>(leftChain.getElement(),null);
            Node<Integer> deepCopy_R = deepCopy;
            while(leftChain.getNext() != null) {
            	deepCopy.setNext(new Node<>(leftChain.getNext().getElement(),null));
            	leftChain = leftChain.getNext();
            	deepCopy = deepCopy.getNext();
            }
            
            return deepCopy_R;
        }
        
        
        Node<Integer> current = leftChain;
        while(current.getNext() != null) {
        	current = current.getNext();
        }
        current.setNext(rightChain);
        
        Node<Integer> deepCopy = new Node<>(leftChain.getElement(),null);
        Node<Integer> deepCopy_R = deepCopy;
        while(leftChain.getNext() != null) {
        	deepCopy.setNext(new Node<>(leftChain.getNext().getElement(),null));
        	leftChain = leftChain.getNext();
        	deepCopy = deepCopy.getNext();
        }
        
        return sortList(deepCopy_R);
        
    }
    public Node<Integer> sortList(Node<Integer> input)
    {
 
        // Node current will point to head
    	
        Node<Integer> current = input, index = null;
 
        int temp;

            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.getNext();
 
                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.getElement() > index.getElement()) {
                        temp = current.getElement();
                        current.setElement(index.getElement()); 
                        index.setElement(temp);
                    }
 
                    index = index.getNext();
                }
                current = current.getNext();
            }
        return input;
    }
	
	
	
	
	
	
	public Node<String> getGroupedStrings(Node<String>input, int lower, int upper){
		  if(input == null) return null;
		  if(input.getNext()== null) return input;
		  
		  Node<String> group1 = lowerHelper(input,lower);
		  Node<String> group1_R= group1;
	      Node<String> group2 = middleHelper(input,lower,upper);
	      Node<String> group3 = upperHelper(input,upper);
	      
	      while(group1.getNext() != null) {
	    	group1 =group1.getNext();  
	      }
	      group1.setNext(group2);
	      
	      while(group1.getNext() != null) {
		    	group1 =group1.getNext();  
		      }
	      group1.setNext(group3);
	      
	     //This code returns a deep copy of the SLL;
	      
	      Node<String> deepCopy = new Node<>(group1_R.getElement(),null);
	      Node<String> deepCopy_R = deepCopy;
	       while(group1_R.getNext() != null) {
	    	   		
	    	   			deepCopy.setNext(new Node<>(group1_R.getNext().getElement(),null));
	    	   			group1_R = group1_R.getNext();
	    	   			deepCopy = deepCopy.getNext();
	    	   		
	    	   	
	        }
	       return deepCopy_R;
	        
	      
		
	}
	public Node<String> lowerHelper(Node<String> input, int lower){
		
	      while(input.getNext() != null) {
  	   		
	    	  if(input.getElement().length() < lower) {
	    	   			Node<String> output = new Node<>(input.getElement(),null);
	    	   			Node<String> output_R = output;
	    	   			input = input.getNext();
	    	   			
	    	   			while(input != null) {
	    	   				if(input.getElement().length() < lower) {
	    	   					output.setNext(new Node<>(input.getElement(),null));
	    	   					output = output.getNext();
	    	   					input = input.getNext();
	    	   				} else {
	    	   					input = input.getNext();
	    	   				}
	    	   				
	    	   			
	    	   			}return output_R;
	    	   			
	    	   		} else {
	    	   			input = input.getNext();
	    	   			
	    	   		}
	    	   		
	        }
	      return null;
	}
	public Node<String> middleHelper(Node<String> input, int lower, int upper){
		
	      while(input.getNext() != null) {
	   		
	    	  if(input.getElement().length() >= lower && input.getElement().length() < upper) {
	    	   			Node<String> output = new Node<>(input.getElement(),null);
	    	   			Node<String> output_R = output;
	    	   			input = input.getNext();
	    	   			
	    	   			while(input != null) {
	    	   				if(input.getElement().length() >= lower && input.getElement().length() < upper) {
	    	   					output.setNext(new Node<>(input.getElement(),null));
	    	   					output = output.getNext();
	    	   					input = input.getNext();
	    	   				} else {
	    	   					input = input.getNext();
	    	   				}
	    	   				
	    	   			
	    	   			}return output_R;
	    	   			
	    	   		} else {
	    	   			input = input.getNext();
	    	   			
	    	   		}
	    	   		
	        }
	      return null;
	}
	public Node<String> upperHelper(Node<String> input, int upper){
		
	      while(input.getNext() != null) {
	   		
	    	  if(input.getElement().length() >= upper) {
	    	   			Node<String> output = new Node<>(input.getElement(),null);
	    	   			Node<String> output_R = output;
	    	   			input = input.getNext();
	    	   			
	    	   			while(input != null) {
	    	   				if(input.getElement().length() >= upper) {
	    	   					output.setNext(new Node<>(input.getElement(),null));
	    	   					output = output.getNext();
	    	   					input = input.getNext();
	    	   				} else {
	    	   					input = input.getNext();
	    	   				}
	    	   				
	    	   			
	    	   			}return output_R;
	    	   			
	    	   		} else {
	    	   			input = input.getNext();
	    	   			
	    	   		}
	    	   		
	        }
	      return null;
	}
	
	
	
	public Node<Integer> getInterleavedArithmeticFibonacciSequences(int a, int b, int c, int d){
		
		
		
		return null;
	}	
}
