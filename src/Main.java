import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		
		LocalFileSystem lsfO = new LocalFileSystem("O");
              
		LocalFileSystem lsfA = new LocalFileSystem("A");
		LocalFileSystem lsfB= new LocalFileSystem("B");
                lsfO.fileCopy(lsfO, lsfB);
                 lsfO.fileCopy(lsfO, lsfA);
                lsfA.setChildrenFile("a");
                lsfB.setChildrenFile("b");
		//lsfA.setChildrenRep("DirTest");
                //lsfB.setChildrenFile("h");
		//lsfB.setChildrenRep("DirTest");
                Synchronizer s = new Synchronizer(); 
                List<String> dirtyPaths = new ArrayList<String>();
		List<String> dirtyPaths2 = new ArrayList<String>();
                 lsfA.setChildrenFile("c");
                lsfA.setChildrenFile("d");
                 s.reconcile(lsfA, dirtyPaths, lsfB, dirtyPaths2, lsfO.getRooot());
                 dirtyPaths = s.computeDirty(new LocalFileSystem("C"), lsfB, lsfA.getRooot() , lsfO.getRooot()); 
                 dirtyPaths2 = s.computeDirty(new LocalFileSystem("D"), lsfA, lsfB.getRooot(), lsfO.getRooot()); 
                 s.reconcile(lsfA, dirtyPaths , lsfB, dirtyPaths2, lsfO.getRooot());
		
		

	}
}
