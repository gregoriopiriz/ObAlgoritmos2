public class ImprimirPostorden { 
    static int preIndex = 0; 
    void printPost(char[] in, char[] pre, int inStrt, int inEnd) 
    { 
        if (inStrt > inEnd)  
            return;         
  
        // Find index of next item in preorder traversal in 
        // inorder. 
        int inIndex = search(in, inStrt, inEnd, pre[preIndex++]); 
  
        // traverse left tree 
        printPost(in, pre, inStrt, inIndex - 1); 
  
        // traverse right tree 
        printPost(in, pre, inIndex + 1, inEnd); 
  
        // print root node at the end of traversal 
        System.out.print(in[inIndex] + " "); 
    } 
  
    int search(char[] in, int startIn, int endIn, int data) 
    { 
        int i = 0; 
        for (i = startIn; i < endIn; i++)
            if (in[i] == data)  
                return i;             
        return i; 
    } 
    
} 