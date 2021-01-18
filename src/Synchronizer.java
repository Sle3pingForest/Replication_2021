
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Synchronizer {
    public void synchronize(FileSystem fs1, FileSystem fs2)
    {
        FileSystem refCopy1 = fs1.getReference();
        FileSystem refCopy2 = fs2.getReference();
        List<String> dirtyPaths1 = computeDirty(refCopy1, fs1, "");
        List<String> dirtyPaths2 = computeDirty(refCopy2, fs2, "");
        reconcile(fs1, dirtyPaths1, fs2, dirtyPaths2, "");
    }
    
    /**
     *
     * @param fs1
     * @param dirtyPath
     */
    public void reconcile(FileSystem fs1, List<String> dirtyPaths1, FileSystem fs2, List<String> dirtyPaths2, String currentRelativePath) 
    {
        try {
            //condition 1
            if (!dirtyPaths1.contains(currentRelativePath) && !dirtyPaths2.contains(currentRelativePath)) {
                //return A and B
                fs1.createDirectory(currentRelativePath);
                fs2.createDirectory(currentRelativePath);
            } //condition 3 
            else if (!dirtyPaths1.contains(currentRelativePath)) {
                fs1.fileCopy(fs2, fs1);
            } else if (!dirtyPaths2.contains(currentRelativePath)) {
                fs1.fileCopy(fs1, fs1);
            } //Condition2 
            else {
                //A
                for (Iterator it = dirtyPaths1.iterator(); it.hasNext();) {
                    fs1.setChildrenFile((String) it.next());
                }
                //B
                for (Iterator it = dirtyPaths2.iterator(); it.hasNext();) {
                    fs2.setChildrenFile((String) it.next());  //a remplacer avec setchildren 
                }
                FileSystem A0 = fs1;
                FileSystem B0 = fs2;

            }

        } catch (Exception ex) {
            Logger.getLogger(Synchronizer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
    
    public List<String> computeDirty(FileSystem lastSync, FileSystem fs, String currentRelativePath) 
    {
      List<String> modify = null ;  
       
     return modify;
    
    }
}


