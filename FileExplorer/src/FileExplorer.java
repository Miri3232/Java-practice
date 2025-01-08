import java.util.*;
import java.io.*;

public class FileExplorer {
	private File currentDir = null;
	private File subFiles[] = null;
	
	public FileExplorer(String dirName) {
		currentDir = new File(dirName);
	}
	
	private void showSubDirtories() {
		System.out.println("\t[" + currentDir.getPath() + "]");
		subFiles = currentDir.listFiles();
		for(File f : subFiles) {
			System.out.print(((f.isFile())?"file":"dir"));
			System.out.printf("%-15s", "\t\t" + f.length() + "바이트");
			System.out.println("\t\t" + f.getName());
		}		
	}
	
	private boolean contains(String filename) {
		for(File f : subFiles) {
			if(f.getName().equalsIgnoreCase(filename))
				return true;
		}
		return false;
	}
	
	private void renameFile(String oldName, String newName) {
		File oldFile = new File(currentDir, oldName);
		File newFile = new File(currentDir, newName);
		
		if (!oldFile.exists()) {
			System.out.println("\t파일이 존재하지 않습니다.");
			return;
		}
		if (newFile.exists()) {
			System.out.println("\t새 파일 이름이 이미 존재합니다.");
			return;
		}
		
		boolean renamed = oldFile.renameTo(newFile);
		if (renamed) {
			System.out.println(oldName + " -> " + newName + " 이름 변경하였습니다.");
		}
		else {
			System.out.println("\t파일 이름 변경에 실패했습니다.");
		}
	}
	
	public void run() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("***** 파일 탐색기입니다. *****");
		showSubDirtories();
		
		while(true) {
			System.out.print(">>");
			String command = s.nextLine().trim();
			if(command.equals("그만"))
				break;
			if(command.equals("..")) {
				String st = currentDir.getParent();
				if(st == null)
					continue;
				else { 					
					currentDir = new File(currentDir.getParent());
					showSubDirtories();
				}
			}
			else if (command.startsWith("mkdir")) {
				String[] parts = command.split(" ", 2);
				if (parts.length == 2) {
					createDirectory(parts[1].trim());
				} else {
					System.out.println("\t디렉터리 이름을 입력하세요.");
				}
			}
			else if (command.startsWith("rename")) {
				String[] parts = command.split(" ", 3); 
				if (parts.length == 3) {
					renameFile(parts[1].trim(), parts[2].trim());
				} else {
					System.out.println("두 개의 파일명이 주어지지 않았습니다.");
				}
			}
			else {
				if(contains(command)) {
					if(new File(currentDir, command).isDirectory()) {
						currentDir = new File(currentDir, command);
						showSubDirtories();
					}
					else {
						System.out.println("\t디렉터리가 아닙니다.!");
					}
				}
			}
		}	
		s.close();
	}
	
	private void createDirectory(String dirName) {
		File newDir = new File(currentDir, dirName);
		if (newDir.exists()) {
			System.out.println("\t디렉터리가 이미 존재합니다.");
		} else {
			boolean created = newDir.mkdir();
			if (created) {
				System.out.println(newDir.getName() + " 디렉터리를 생성하였습니다.");
			} else {
				System.out.println("\t디렉터리 생성에 실패했습니다.");
			}
		}
	}

	public static void main(String[] args) {
		FileExplorer fe = new FileExplorer("c:\\");
		fe.run();
	}

}
