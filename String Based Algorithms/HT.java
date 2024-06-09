/*
QUESTION :
Write a java program to implement hash table to stores strings and its frequency.Define methods for insertion of string, searching a string and returning frequency of a string.

ALGORITHM :
Class Node:
    Properties:
        data: String
        frequency: Integer
        next: Node
    Constructor:
        Initialize data with given string and frequency as 1
        Set next node as null

Class HashTable:
    Properties:
        table: Array of Nodes
        size: Integer
    Constructor:
        Initialize table with given size
        Initialize size with given value
        
    Method hashFunction(String data):
        Initialize hash as 0
        For each character in data:
            Add ASCII value of character to hash
        Return hash modulo size
        
    Method insert(String data):
        Calculate index using hashFunction
        If table[index] is null:
            Create a new Node with data and set it as table[index]
        Else:
            Iterate through the linked list at table[index]:
                If current node's data equals data:
                    Increment frequency and return
            Create a new Node with data:
                Set its next as table[index]
                Set it as table[index]
                
    Method search(String data):
        Calculate index using hashFunction
        Iterate through the linked list at table[index]:
            If current node's data equals data:
                Print frequency of data and return
        Print "Data not found"

Main method:
    Create Scanner object for input
    Create HashTable object with size 10
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
class Node{
    String data;
    int frequency;
    Node next;
    public Node(String data){
        this.data = data;
        this.frequency = 1;
        this.next = null;
    }
}
class HashTable{
    private final Node[] table;
    private final int size;
    public HashTable(int size){
        this.size = size;
        table = new Node[size];
    }
    private int hashFunction(String data){
        int hash = 0;
        for(int i = 0; i < data.length(); i++) hash += data.charAt(i);
        return hash % size;
    }
    public void insert(String data){
        int index = hashFunction(data);
        if(table[index] == null) table[index] = new Node(data);
        else{
            for(Node current = table[index]; current != null; current = current.next)
                if(current.data.equals(data)){
                    current.frequency++;
                    return;
                }
            Node newNode = new Node(data);
            newNode.next = table[index];
            table[index] = newNode;
        }
    }
    public void search(String data){
        int index = hashFunction(data);
        for(Node current = table[index]; current != null; current = current.next)
            if(current.data.equals(data)){
                System.out.println("Frequency of "+data+" : "+ current.frequency);
                return;
            }
        System.out.println(data + " not found");
    }
}
public class HT{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashTable ht = new HashTable(10);
        while(true){
            System.out.print("1. Insert\n2. Search\n3. Exit\nEnter your choice : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter the string to insert: ");
                    String str = sc.next();
                    ht.insert(str);
                    break;
                case 2:
                    System.out.print("Enter the string to search: ");
                    str = sc.next();
                    ht.search(str);
                    break;
                case 3: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}