import java.io.File;

public class Main {

	public static void main(String[] args) throws Exception {
		LocalFileSystem lsf = new LocalFileSystem("O");

		LocalFileSystem lsfA = new LocalFileSystem("A");
		
		File a = new File("a");
		File b = new File("b");
		LocalFileSystem lsf1 = new LocalFileSystem("O", a);
		
		System.out.println(lsf.getRooot());
		lsf.setChildrenFile(b.getName());
		System.out.println(lsf.getRooot());
		lsf1.setChildrenRep("02");
		//lsf.fileCopy2(a.getName(), "02");
		lsfA.fileCopy(lsfA, lsf);
		System.out.println(lsfA.getAbsolutepathRep());
		File c = new File("O/O2/C");
		System.out.println(c.getParent());
		
		
	}
}
