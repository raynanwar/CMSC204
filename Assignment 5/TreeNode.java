/*
 
Class: CMSC204
Instructor: Eivzi
Description:MorseCode
Due: 4/18
Platform/compiler: Eclipse
I pledge that I have completed the programming
assignment independently. I have not copied the code
from a student or any source. I have not given my code
to any student.
Print your Name here:= Rayn Anwar
*/
public class TreeNode<T>  {
    T data; 
    TreeNode<T> left;
    TreeNode<T> right;
    
   public TreeNode(T dataNode) {
        this.data = dataNode;
        this.left = null;
        this.right = null;
   }
   public TreeNode(TreeNode<T> node) {
     this.data = node.data; 
     this.left = node.left; 
     this.right = node.right;
 }
   public T getData() {
    return this.data;
   }
} 
