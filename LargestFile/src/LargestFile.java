import java.io.File;

public class LargestFile {
	public static void main(String[] args) {
		String path = "C://";
		File largestFile = findLargestFile(path);
		
		  if (largestFile != null) {
	            System.out.println("가장 큰 파일은 " + largestFile.getAbsolutePath() + " " + largestFile.length() + " 바이트");
	        }
		  else {
	            System.out.println("파일을 찾을 수 없습니다.");
		  }
	}
	
	public static File findLargestFile(String path) {
		File directory = new File(path);
		File largestFile = null;
		long largestFileSize = 0;
		if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        File largestInSubDir = findLargestFile(file.getAbsolutePath());
                        if (largestInSubDir != null && largestInSubDir.length() > largestFileSize) {
                            largestFile = largestInSubDir;
                            largestFileSize = largestFile.length();
                        }
                    } else {
                        if (file.length() > largestFileSize) {
                            largestFile = file;
                            largestFileSize = file.length();
                        }
                    }
                }
            }
        }
        return largestFile;
	}

}
