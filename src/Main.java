import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
		
		

		lsfA.setChildrenFile("h");
		lsfA.setChildrenRep("DirTest");
		
		/*

        Synchronizer s = new Synchronizer(); 
		List<String> dirtyPaths = new ArrayList<String>();
		List<String> dirtyPaths2 = new ArrayList<String>();
		
		 for(FileSystem fs : lsfA.getChildren()) {
			 
			 dirtyPaths.add(fs.getRooot());
		 }
		
        
        s.reconcile(lsfA, dirtyPaths, lsfB, dirtyPaths2, lsfO.getRooot());
		*/
		
	}
}
