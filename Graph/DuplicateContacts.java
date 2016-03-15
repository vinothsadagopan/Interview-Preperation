/*
http://www.geeksforgeeks.org/find-same-contacts-in-a-list-of-contacts/
*/
	import java.util.*;
 class Contacts {
	String field1, field2, field3;
	Contacts(String field1, String field2, String field3) {
		this.field1= field1;
		this.field2 = field2;
		this.field3= field3;
	}


}
class DuplicateContacts {
	public void buildGraph(Contacts[] contact, int[][]adjMatrix) {
		for(int i=0;i< contact.length;i++) {
			for(int j =i+1; j<contact.length;j++) {
				if(contact[i].field1== contact[j].field1||contact[i].field1==contact[j].field2||contact[i].field1==contact[j].field3||contact[i].field2== contact[j].field1||contact[i].field2==contact[j].field2||contact[i].field2==contact[j].field3||contact[i].field3== contact[j].field1||contact[i].field3==contact[j].field2||contact[i].field3==contact[j].field3) {
					adjMatrix[i][j]=1;
					adjMatrix[j][i]=1;
					break;
				}
			}
		}
	}
	public void DFSVisit(int[][] adjMatrix, int index, Set<Integer> visited) {
		visited.add(index);
		for(int j= 0 ; j< adjMatrix[0].length; j++) {
			if(adjMatrix[index][j]==1 &&!visited.contains(j)) {
				System.out.println("contact"+(index+1 )+" and contact "+(j+1) +" are duplicates");
				DFSVisit(adjMatrix, j, visited);

			}
		}
	}
	public void duplicates(Contacts[] contact) {
		int[][] adjMatrix = new int[contact.length][contact.length]; 
		buildGraph(contact,adjMatrix);
		
		Set<Integer> visited = new HashSet<Integer>();
		DFSVisit(adjMatrix,0,visited);

	}
	public static void main(String[] args) {
		Contacts[] contact = { new Contacts("Gaurav", "gaurav@gmail.com", "gaurav@gfgQA.com"),
       new Contacts("Lucky", "lucky@gmail.com", "+1234567"),
       new Contacts( "gaurav123", "+5412312", "gaurav123@skype.com"),
       new Contacts( "gaurav1993", "+5412312", "gaurav@gfgQA.com")
     };
     DuplicateContacts dc = new DuplicateContacts();
     dc.duplicates(contact);
	}
}