
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Synchronizer {
    public void synchronize(FileSystem fs1, FileSystem fs2)
    {
        FileSystem refCopy1 = fs1.getReference();
        FileSystem refCopy2 = fs2.getReference();
        /*
        List<String> dirtyPaths1 = computeDirty(refCopy1, fs1, "" );
        List<String> dirtyPaths2 = computeDirty(refCopy2, fs2, "");
        reconcile(fs1, dirtyPaths1, fs2, dirtyPaths2, "");*/
    }
    
    /**
     *
     * @param fs1
     * @param dirtyPath
     */
    public void reconcile(FileSystem fs1, List<String> dirtyPaths1, FileSystem fs2, List<String> dirtyPaths2, String currentRelativePath ) 
    {
        try {
            //condition 1
            System.out.println("tow paths dirty");
            if (dirtyPaths1.isEmpty() && dirtyPaths2.isEmpty()) {
                //return A and B
               //String fsUn =   fs1.createDirectory(currentRelativePath);
               FileSystem c = new LocalFileSystem("C");
               c.fileCopy(fs1,c);
               FileSystem d = new LocalFileSystem("D"); 
               d.fileCopy(fs2,d);
            } //condition 3 
            else if (dirtyPaths2.isEmpty()) {

            	System.out.println("dirty 2");
                
                 FileSystem c = new LocalFileSystem("C");
                 c.fileCopy(fs2,c);
                 FileSystem d = new LocalFileSystem("D"); 
                 d.fileCopy(fs2,d);
            } else if (dirtyPaths1.isEmpty()) {
            	System.out.println("dirty 1 "+fs1.getRooot());
            
                 FileSystem c = new LocalFileSystem("C");
                 fs1.fileCopy(fs1,c );
                 FileSystem d = new LocalFileSystem("D"); 
                 fs1.fileCopy(fs1,d);
            } //Condition2 
            else {
                //A
                
                for (Iterator it = dirtyPaths1.iterator(); it.hasNext();) {
                      FileSystem c = new LocalFileSystem("C");
                      c.fileCopy2((String) it.next(), c.getRooot());
                    
                }
                //B
                for (Iterator it = dirtyPaths2.iterator(); it.hasNext();) {
                        FileSystem d = new LocalFileSystem("D");
                        d.fileCopy2((String) it.next(), d.getRooot()); 
                }
              

            }

        } catch (Exception ex) {
            Logger.getLogger(Synchronizer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
    
    public List<String> computeDirty(FileSystem lastSync, FileSystem fs, String currentRelativePath , String Opath) {
        List<String> modify = new ArrayList<String>();
        /*
       * 
       * 
       * 
       * */
        // fs = B  ;  LastSync  C et current relative path pour le dossier actuelle A 
        // liste de O 
        System.out.println("tester chemon de 0 "+ Opath);
        List<FileSystem> listChildrenO = new ArrayList<FileSystem>();
        listChildrenO = fs.getChildren(Opath);
        List<String> O = new ArrayList<String>();
        for (FileSystem a : listChildrenO) {
            O.add(a.getName(a.getRooot()));
        }

        // d'abords je recupere la liste de B
        //list of B files 
         System.out.println("tester chemon de B "+ fs.getRooot());
        List<FileSystem> listChildrenB = new ArrayList<FileSystem>();
        listChildrenB = fs.getChildren(fs.getRooot());
        List<String> B = new ArrayList<String>();
        for (FileSystem a : listChildrenB) {
            B.add(a.getName(a.getRooot()));
        }

        // je recupere la lsite de current path   A 
         System.out.println("tester chemon de A "+currentRelativePath);
        List<FileSystem> listChildrenC = new ArrayList<FileSystem>();
        listChildrenC = fs.getChildren(currentRelativePath);
        List<String> C = new ArrayList<String>();
        for (FileSystem a : listChildrenC) {
            C.add(a.getName(a.getRooot()));
        }

        // et enfin je recupere la liste de dernier sync de fichier 
        System.out.println("tester chemon de C ou D  "+lastSync.getRooot());
        List<FileSystem> lastS = new ArrayList<FileSystem>();
        lastS = lastSync.getChildren(lastSync.getRooot());
        List<String> LS = new ArrayList<String>();
        for (FileSystem a : lastS) {
            LS.add(a.getName(a.getRooot()));
        }

        // je verifie si il ya un dossier qui existe dans O et qu il nexiste pas dans A et qu il existe en C 
        for (String a : C) // je parcour la liste de current  path A 
        // si c'est un fichier original 
        {
            if (O.contains(a)) {
                if (B.contains(a)) { // alors si c'est toujours disponible dans B 
                    if (!LS.contains(a)) // s'il n  existe pas déjà dans last sync 
                    {
                        modify.add(currentRelativePath + a); // ajouter le path }
                    }
                } 
             
            }
            else {
                 if (!LS.contains(a))
                    modify.add(currentRelativePath + a);
            }
        }


         
         
         
     
         
         
         
     return modify;
    
    }
}


