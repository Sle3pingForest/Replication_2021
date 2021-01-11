import java.io.File;
import java.util.List;

public interface FileSystem {
	public String  getRooot();
	public String getParents(String path);
	public List<String> getChildren(String path);
	public List<String> getAncestors(String path);
	public String getAbsolutePath(String absolutePath);
	public String getRelativePath(String relativePath);
	public void replace(String absolutePathTargetFS, FileSystem fsSource, String absolutePathSourceFS);
	public FileSystem getReference();
	public File createDirectory(String path);
	public void fileCopy( File input, File output) throws Exception;

}
