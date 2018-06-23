package project1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class Record {
	File file_out ;
	FileOutputStream fos;
	public Record(){
		try{
			file_out = new File("file_out.txt");
			fos = new FileOutputStream(file_out,false);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
