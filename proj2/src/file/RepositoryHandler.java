package file;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class RepositoryHandler {
	private File repository;
	private Set<File> directories;
    private Set<File> files;
    
    private void initialize(){
    	if (!repository.exists())
    		System.out.println("(ERROR) repository "+repository.getName()+" does not exist");
    	else
    	   if (repository.isDirectory()){
    	      for(File f:repository.listFiles()){
    	         if (f.isDirectory())
    	            directories.add(f);
    	         else
    		        if (f.isFile())
    		           files.add(f);
    	      }
    	   }
    	   else
    	      System.out.println("(ERROR) repository "+repository.getName()+" is not a file directory");     
    }
    
    public RepositoryHandler(String s){
    	directories = new HashSet<File>();
    	files = new HashSet<File>();
    	repository = new File(s);
    	initialize();
    }
    
    public Set<File> get_directories(){
    	return directories;
    }
    
    public Set<File> get_files(){
    	return files;
    }
    
    public File get_directory(String directory){
    	File result = null;
    	boolean found = true;
    	Iterator<File>it=directories.iterator();
    	while (!found & it.hasNext()){
    		result = it.next();
    		if (directory.equals(result.getName()))
    			found = true;
    	}
    	return result;
    }
    
    public File get_file(String file){
    	File result = null;
    	boolean found = false;
    	Iterator<File>it=files.iterator();
    	while (!found & it.hasNext()){
    		result = it.next();
    		if (file.equals(result.getName()))
    			found = true;
    	}
    	return result;
    }
    
    public Set<String> get_publications(){
    	Set<String> result = new HashSet<String>();
    	for(File f:repository.listFiles())
    		if (f.isFile()) 
    		   result.add(new String(f.getName()));
    	return result;
    }
    
    public void remove(){
    	for(File f:files)
    		f.delete();
    	for(File d:directories)
    		d.delete();
    }
    
    private Map<String,Long> get_files_length(){
    	Map<String,Long>result = new HashMap<String,Long>();
    	for(File f:repository.listFiles())
    		result.put(f.getName(), Long.valueOf(f.length()));
    	
    	return result;
    }
    
    public void show_files_length(){
    	System.out.println("Show repository");
    	Map<String,Long> m = this.get_files_length();
    	for(String k:m.keySet())
    		System.out.println(k+": "+m.get(k));
    }
    
}
