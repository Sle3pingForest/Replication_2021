import java.io.File;

public class Main {

	public static void main(String[] args) throws Exception {
		LocalFileSystem lsf = new LocalFileSystem();
		//lsf.createDirectory("A/A2");
		//lsf.createDirectory("B/B2");
		
		//lsf.fileCopy("O/O2/b" ,"B/B2/b");
		//System.out.println(lsf.getParents("O"));
		File test = lsf.createFile("Test.txt");
		//System.out.println(lsf.getAbsolutePath(test));
		//System.out.println(lsf.getRelativePath(test));
		//lsf.replace(absolutePathTargetFS, lsf, absolutePathSourceFS);
	}
}
