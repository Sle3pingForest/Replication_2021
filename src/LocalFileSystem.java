import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class LocalFileSystem implements FileSystem{

	@Override
	public String getRooot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParents(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getChildren(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAncestors(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAbsolutePath(String absolutePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRelativePath(String relativePath) {
		
		return relativePath;
	}

	@Override
	public void replace(String absolutePathTargetFS, FileSystem fsSource, String absolutePathSourceFS) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FileSystem getReference() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File createDirectory(String path) {
		File file = new File(path);
		if(!file.exists()) {
			if(file.mkdir()) {
				System.out.println("Directory is created");
			}
			else System.out.println("Failed to create directory");
		}
		;
		return file;
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
