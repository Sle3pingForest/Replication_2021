import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class LocalFileSystem implements FileSystem{
	private File file;
	private List<String> listFile;
	
	public LocalFileSystem() {
		
	}

	public LocalFileSystem(String path) {
		this.file = new File(path);
		this.listFile = new ArrayList<String>();
		listFile.add(file.getName());
	}
	
	
	@Override
	public String getRooot() {
		return this.file.getAbsolutePath();
	}

	@Override
	public String getParents(String path) {
		File f = new File(path);
		if(f.exists()) {
			return f.getParent();
		}
		else return "File not exist for getParents";
	}

	@Override
	public List<String> getChildren(String path) {
		File f = new File(path);
		return null;
	}

	public void setChildren(String path, String name) {
		if(!getChildren(path).contains(name)) {
			this.getChildren(path).add(name);
		}
		else {
			this.createFile(name);
		}
		
		
	}
	@Override
	public List<String> getAncestors(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAbsolutePath(File absolutePath) {
		if(absolutePath.exists()) {
			return absolutePath.getAbsolutePath();
		}
		else return " File not exist for getAbsolutePath";
	}


	
	public String getRelativePath(File f) {
		if(f.exists()) {
			return f.getAbsolutePath().substring(3);
		}
		else return " File not exist for getCanonicalPath";
	}

	@Override
	public void replace(String absolutePathTargetFS, FileSystem fsSource, String absolutePathSourceFS)  throws Exception  {
		for (String s : fsSource.getChildren(absolutePathSourceFS)) {
			this.fileCopy(absolutePathTargetFS + "/" +s , absolutePathTargetFS + "/"+s);
		}
		
	}

	@Override
	public FileSystem getReference() {
		return this;
	}
	
	@Override
	public File createFile(String name) {
		File f = new File(name);
		try {
			if(f.createNewFile()) {
				System.out.println("File created");
			}
			else System.out.println("File already exists");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}

	@Override
	public void createDirectory(String path) {
		File file = new File(path);
		if(!file.exists()) {
			if(file.mkdir()) {
				System.out.println("Directory is created");
			}
			else System.out.println("Failed to create directory");
		};
	}
	
	@Override
	public void fileCopy( String input, String output) throws Exception {

		File fileI = new File(input);
		File fileO = new File(output);
		if(fileI.exists()) {
			InputStream is = new FileInputStream(fileI);
			OutputStream os = new FileOutputStream(fileO);
			byte[] buffer = new byte[1024];
			int length = 0;
			while((length = is.read(buffer)) >  0) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
		}
		else System.out.println("Input file n'exists pas");
	}


}
