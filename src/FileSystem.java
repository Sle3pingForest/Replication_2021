import java.io.File;
import java.util.List;

public interface FileSystem {
	public String getRooot();
	public String getParents(String path);
	public List<String> getChildren(String path);
	public List<String> getAncestors(String path);
	public String getAbsolutePath(File absolutePath);
	public String getRelativePath(File relativePath);
	public void replace(String absolutePathTargetFS, FileSystem fsSource, String absolutePathSourceFS) throws Exception ;
	public FileSystem getReference();
	public void createDirectory(String path) throws Exception;
	public File createFile(String name);
	public void fileCopy( FileSystem input, FileSystem output) throws Exception;
	public void fileCopy2( String input, String output) throws Exception;

}
