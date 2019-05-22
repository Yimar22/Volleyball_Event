package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStream;


public class VolleyballEvent {
	
	private Partaker root;
	private Partaker first;
	
	public VolleyballEvent() {
		
	}

	
	public void addPartakerIntoTree(Partaker part) {
		addPartakerIntoTree(part, root);
	}
	
	public void addPartakerIntoTree(Partaker part, Partaker current) {
		if(root == null) {
			root = part;
		}
		else {
			if(part.compareTo(current) <= 0) {
				if(current.getLeft() == null) {
					current.setLeft(part);
				}else{
					addPartakerIntoTree(part, current.getLeft());
				}
			} else{
				if(current.getRigth() == null) {
					current.setRigth(part);
				} else {
					addPartakerIntoTree(part, current.getRigth());
				}
			}
			
		}
	}
	
	public String LoadFileAndAddToTree(File path) throws IOException {
		
		FileReader fileReader = new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		line = br.readLine();
		int times = 0;
		while(line != null){
			String[] parts = line.split(",");
			Partaker temporalNewParticipant = new Partaker(Integer.parseInt(parts[0]),parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7]);
			addPartakerIntoTree(temporalNewParticipant);
			line = br.readLine();
			times ++;
		}
		fileReader.close();
		br.close();
		choiceAleatoryPartaker(times);
		return path.getAbsolutePath();
	}
	
	public Partaker searchSpectator(int id) {
		Partaker s= new Partaker(id,"","","","","",null,"");
		return searchSpectator(root,s);
	}
	
	private Partaker searchSpectator(Partaker current, Partaker s) {
		if(current!=null) {
			if(s.compareTo(current)<0) {
				if(current.getLeft()!=null){
					return searchSpectator(current.getLeft(),s);
				}else {
					return searchSpectator(current.getRigth(), s);
				}
			}else if(s.compareTo(current)>0){
				if(current.getRigth()!=null) {
					return searchSpectator(current.getRigth(), s);
				}else {
					return searchSpectator(current.getLeft(), s);
				}
			}else {
				return current;
			}
		}
		return current;
	}
	

	
	public Partaker searchPartaker(int id) {
		Partaker current = first;
		Partaker found = null;
		boolean find = false;
		
		while(current!= null && find == false) {
			if(current.getId() == id) {
				found = current;
				find = true;
			}else {
				current = current.getNext();
			}
		}
		
		return found;
	}
	
	
	public void choiceAleatoryPartaker(int size) {
		int[] ale = new int[10];
		for(int i=0;i<10;i++) {
			int n=(int) (Math.random() * size) + 1;
			if(i>0) {
				if(notChoice(n,ale)) {
					Partaker s=searchPartaker(n);
					addingOficialPartaker(s);
					System.out.println(n+" si lista "+i);
					ale[i]=n;
				}
			}else {
				ale[i]=n;
			}

		}
	}
	public boolean notChoice(int n, int[]a) {
		boolean flag=true;
		for(int i=0;i<a.length;i++) {
			if(n==a[i]) {
				flag=false;
			}
		}
		return flag;
	}
	public void addingOficialPartaker(Partaker newOne){
		if(first == null){
			first = newOne;
		}else{
			Partaker current = first;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(newOne);
			Partaker temp = current;
			current = current.getNext();
			current.setPrev(temp);
		}
	}
	public Partaker searchOficialPartaker(int n) {
		Partaker current = first;
		Partaker returned = null;
		boolean stop = false;
		while(current != null && !stop) {
			if(current.getId()==n) {
				stop = true;
				returned = current;
			}else {
					current = current.getNext();
			}
		}
		
		return returned;
	}
	
	public Partaker getRoot() {
		return root;
	}
	
	public void setRoot(Partaker root) {
		this.root = root;
	}
	
	public Partaker getFirst() {
		return first;
	}
	
	public void setFirst(Partaker first) {
		this.first = first;
	}
}
