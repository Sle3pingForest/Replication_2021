import java.io.File;
import java.util.List;

public interface FileSystem {
	public String getRooot();
	public String getParents(String path);
	public List<FileSystem> getChildren();
        public List<FileSystem> getChildren(String path);
	public List<String> getAncestors(String path);
	public String getAbsolutePath(File absolutePath);
	public String getRelativePath(File relativePath);
	public void replace(String absolutePathTargetFS, FileSystem fsSource, String absolutePathSourceFS) throws Exception ;
	public FileSystem getReference();
	public String createDirectory(String path) throws Exception;
	public void setChildrenFile(String path);
	public void setChildrenRep(String path);
	public File createFile(String name);
	public void fileCopy( FileSystem input, FileSystem output) throws Exception;
	public void fileCopy2( String input, String output) throws Exception;
	public void setAbsolutepathRep(String absolutepathRep);
	public void copyChildren(String path);
	public void setIfRep(boolean ifRep);
	boolean isIfRep();
	File getFile();
	List<String> getListFile();
        public String getName(String Name );

}
