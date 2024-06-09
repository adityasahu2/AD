/*
QUESTION :
Write a java program to implement binary search tree to stores strings and its frequency.Define methods for insertion of string, searching a string and returning frequency of a string.

ALGORITHM :
Class Node:
  Properties:
      String data
      Integer frequency
      Node left
      Node right

  Constructor:
      Initialize data with the given string
      Set frequency to 1
      Set left and right child nodes to null

Class BinarySearchTree:
  Properties:
      Node root

  Constructor:
      Initialize root to null

  Method insert(String data):
      Call insertRec(root, data)

  Method insertRec(Node root, String data):
      If root is null:
          Create a new node with the given data
          Return the new node
      Compare data with root.data
      If data < root.data:
          Recursively insert into the left subtree
      Else if data > root.data:
          Recursively insert into the right subtree
      Else:
          Increment the frequency counter
      Return the modified root

  Method search(String data):
      Call searchRec(root, data)

  Method searchRec(Node root, String data):
      If root is null:
          Return "String not found"
      Compare data with root.data
      If data < root.data:
          Recursively search in the left subtree
      Else if data > root.data:
          Recursively search in the right subtree
      Else:
          Return "String: " + root.data + "\nFrequency: " + root.frequency

Main method:
  Create a Scanner object
  Create a BinarySearchTree object
  Loop indefinitely:
      Print menu options
      Read user input for choice
      Switch on choice:
          Case 1:
              Prompt user for string to insert
              Call insert method with the entered string
          Case 2:
              Prompt user for string to search
              Call search method with the entered string
          Case 3:
              Exit the program
          Default:
              Print "Invalid choice"
*/  
import java.util.Scanner;
class node {
    String data;
    int frequency;
    node left,right;
    node(String data){
        this.data = data;
        this.frequency = 1;
        this.left = null;
        this.right = null;
    }
}
class BinarySearchTree{
    node root;
    BinarySearchTree(){root = null;}
    void insert(String data){root = insertRec(root, data);}
    node insertRec(node root, String data){
        if(root == null){
            root = new node(data);
            return root;
        }
        int compare = data.compareTo(root.data);
        if(compare < 0) root.left = insertRec(root.left, data);
        else if(compare > 0) root.right = insertRec(root.right, data);
        else root.frequency++;
        return root;
    }
    void search(String data){
        int frequency = searchRec(root, data);
        if(frequency == 0) System.out.println(data + " not found");
        else System.out.println("Frequency of "+data+" : "+ frequency);
    }
    int searchRec(node root, String data){
        if(root == null) return 0;
        int compare = data.compareTo(root.data);
        if(compare < 0)return searchRec(root.left, data);
        else if(compare > 0)return searchRec(root.right, data);
        else return root.frequency;
    }
}
public class BST{
    public static void main(String[] args){
        Scanner ob = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while(true){
            System.out.print("1. Insert\n2. Search\n3. Exit\nEnter your choice : ");
            int choice = ob.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter a string to insert : ");
                    String str = ob.next();
                    bst.insert(str);
                    break;
                case 2:
                    System.out.print("Enter string to search : ");
                    str = ob.next();
                    bst.search(str);
                    break;
                case 3: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}