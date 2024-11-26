
public class VArray {
	int[] array;	
	int size;
	
	public VArray(int num) {
		array = new int[num];
		size = 0;
	}
	
	public void add(int a) {
			if(size == array.length) {
				int[] newArray= new int[array.length*2];
				System.arraycopy(array, 0, newArray, 0, array.length);
				array = newArray;
			}
			array[size++] = a;
	}
	public int capacity() {
		return array.length;
	}
	public int size() {
		return size;
	}
	public void printAll() {
		for(int i=0; i<size; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	public void insert(int index, int value) {
		if(index < 0 || index > size) {
			return;
		}
		if (size == array.length) {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
		}
		for(int i=size; i>index; i--) {
			array[i] = array[i-1];	
		}
		array[index] = value;
		size++;
	}
	public void remove(int remove) {
		if(remove > size || remove < 0) {
			return;
		}
		for(int i=remove; i<size; i++) {
			array[i] = array[i+1];
		}
		size--;
	}
	
}
