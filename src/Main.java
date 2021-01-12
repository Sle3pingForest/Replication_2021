import java.io.File;

public class Main {

	public static void main(String[] args) throws Exception {
		
		LocalFileSystem lsfO = new LocalFileSystem("O");
		LocalFileSystem lsfA = new LocalFileSystem("A");
		LocalFileSystem lsfB= new LocalFileSystem("B");
		
		lsfO.setChildrenFile("a");
		lsfO.setChildrenFile("b");
		lsfO.setChildrenFile("Test");
		lsfO.setChildrenRep("DIR");
		
		System.out.println(lsfA.getAbsolutepathRep());
		System.out.println(lsfA.getParents(lsfA.getAbsolutepathRep()));
		System.out.println(lsfA.getChildren());
		
		lsfO.fileCopy(lsfO, lsfB);
		lsfO.fileCopy(lsfO, lsfA);
		
		
		
	}
}
