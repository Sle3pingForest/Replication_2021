package com.mycompany.project.src;

import java.util.List;



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
    
    }
   
    
    public List<String> computeDirty(FileSystem lastSync, FileSystem fs, String currentRelativePath) 
    {
      List<String> modify = null ;  
       
     return modify;
    
    }
}


