import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LocalFileSystem implements FileSystem{
	private String nameRep;
	private File file;
	private String absolutepathRep;
	private List<String> listFile;
	private List<String> listRep;
	private List<String> dirty1;
	private List<String> dirty2;
	private boolean ifRep = false;
	
	public LocalFileSystem() {
		this.listFile = new ArrayList<String>();
		this.listRep = new LinkedList<String>();
		this.dirty1 = new ArrayList<String>();
		this.dirty2 = new ArrayList<String>();
	}

	//init dirty list because this constructor is a REP
	public LocalFileSystem(String repName) {
		this.nameRep= repName;
		this.absolutepathRep = createDirectory(repName);
		this.listFile = new ArrayList<String>();
		this.listRep = new LinkedList<String>();
		this.dirty1 = new ArrayList<String>();
		this.dirty2 = new ArrayList<String>();
		this.listRep.add(this.absolutepathRep);
		this.ifRep = true;
	}
	
	//construtor a FILE and rep, add file in rep
	public LocalFileSystem(String repName, File file) {
		this.absolutepathRep = createDirectory(repName);

		this.file = createFile(this.absolutepathRep +"/"+file.getName());
		this.listFile = new ArrayList<String>();
		this.listRep = new LinkedList<String>();
		this.listFile.add(file.getAbsolutePath());
		this.ifRep = false;
	}
	
	
	@Override
	public String getRooot() {	
		if(ifRep) {
			return this.absolutepathRep;
		}
		else {
			return this.getAbsolutePath(file);
		}
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
	public List<FileSystem> getChildren() {

		List<FileSystem> listChildren = new ArrayList<FileSystem>();
		for(String s : listFile) {
			File f = new File(s);
			LocalFileSystem lfs = new LocalFileSystem(f.getParent(), f);
			lfs.setIfRep(false);
			listChildren.add(lfs);
		} 
		for(String s : listRep) {
			LocalFileSystem lfs = new LocalFileSystem(s);
			lfs.setIfRep(true);
			listChildren.add(lfs);
		}
		return listChildren;
	}

	@Override
	public boolean isIfRep() {
		return ifRep;
	}

	@Override
	public void setIfRep(boolean ifRep) {
		this.ifRep = ifRep;
	}

	@Override
	public void setChildrenFile(String path) {
		String s = this.getAbsolutepathRep() + "/" + path;
		if(!listFile.contains(s)) {
			this.file = this.createFile(s);
			this.listFile.add(file.getAbsolutePath());
		}
		else {
			System.out.println("File exist");
		}
	}
	
	@Override
	public void setChildrenRep(String path) {
		String s = this.getAbsolutepathRep() + "/" + path;
		if(!listRep.contains(s)) {
			this.absolutepathRep = this.createDirectory(s);
			this.listRep.add(this.absolutepathRep);
		}
		else {
			System.out.println("Dir exist");
		}
	}
	
	@Override
	public void copyChildren(String path) {
		
		
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
	public String createDirectory(String path) {
		File file = new File(path);
		if(!file.exists()) {
			if(file.mkdir()) {
				System.out.println("Directory is created");
			}
			else System.out.println("Failed to create directory");
		};
		return file.getAbsolutePath();
	}
	
	
	@Override
	public void fileCopy2( String input, String output) throws Exception {

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

	@Override
	public void fileCopy(FileSystem input, FileSystem output) throws Exception {
	 // pas ide pour code sa attend un peu
		
	}

	public String getAbsolutepathRep() {
		return absolutepathRep;
	}

	@Override
	public void setAbsolutepathRep(String absolutepathRep) {
		this.absolutepathRep = absolutepathRep;
	}

	public List<String> getListFile() {
		return listFile;
	}

	public void setListFile(List<String> listFile) {
		this.listFile = listFile;
	}

	public List<String> getListRep() {
		return listRep;
	}

	public void setListRep(List<String> listRep) {
		this.listRep = listRep;
	}
	
	

}
