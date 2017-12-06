package buildutil;

import java.io.File;

public class DeleteSaveFile {
	
	public static void main(String[] args) {
		final File saveFile = new File(".expensememory");
		if(saveFile.exists()) saveFile.delete();
	}

}
