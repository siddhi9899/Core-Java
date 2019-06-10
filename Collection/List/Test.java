public class Test {
	public static void main(String[] args) {
		Bucket b1 = new Bucket("first");
		Bucket b2 = new Bucket("second");
		Bucket b3 = new Bucket("third");
		Bucket b4 = new Bucket("fourth");
		LinkedList list = new LinkedList();
		// Add bucket at First
		list.insertBucketAtFirst(b1);
		list.insertBucketAtFirst(b2);
		list.insertBucketAtFirst(b3);
		list.insertBucketAtFirst(b4);
		System.out.println("=====Start View Buckets at first====");
		list.viewBuckets();
		System.out.println("=====End View Buckets at first====");
		
		// Add bucket at End
		System.out.println("=====Start View Buckets at Last====");
		Bucket b5 = new Bucket("fifth");
		Bucket b6 = new Bucket("sixth");
		Bucket b7 = new Bucket("seventh");
		Bucket b8 = new Bucket("eigth");
		list.insertBucketAtLast(b5);
		list.insertBucketAtLast(b6);
		list.insertBucketAtLast(b7);
		list.insertBucketAtLast(b8);
		list.viewBuckets();
		System.out.println("=====End View Buckets at Last====");
		
		// Add bucket at End
		System.out.println("=====Start View Buckets at Pos====");
		Bucket pos = new Bucket("pos");
		Bucket pos1 = new Bucket("pos1");
		list.insertBucketAtPos(7,pos);
		list.insertBucketAtPos(9,pos1);
		list.viewBuckets();
		System.out.println("=====End View Buckets at Pos====");
		
		// Delete bucket at End
		System.out.println("=====Start Delete Buckets at End====");
		list.deleteBucketAtLast();
		list.viewBuckets();
		System.out.println("=====End Delete Buckets at End====");
		
		// Delete bucket at End
		System.out.println("=====Start Delete Buckets at first====");
		list.deleteBucketAtFirst();
		list.viewBuckets();
		System.out.println("=====End Delete Buckets at first====");
		
		// Delete bucket at End
		System.out.println("=====Start Delete Buckets at pos====");
		list.deleteBucketAtPos(6);
		list.viewBuckets();
		System.out.println("=====End Delete Buckets at pos====");
		
		
	}
}

class Bucket {
	private String data;
	private Bucket next;
	
	public Bucket() {
		
	}
	
	public Bucket(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Bucket getNext() {
		return next;
	}

	public void setNext(Bucket next) {
		this.next = next;
	}
}

class LinkedList {
	private Bucket start;
	private int size;
	
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}
	public int getSize() {
		return size;
	}
	public void insertBucketAtFirst(Bucket bucket) {
		if(start == null) {
			start = bucket;
		} else {
			bucket.setNext(start);
			start = bucket;
		}
		size++;
	}
	public void insertBucketAtLast(Bucket bucket) {
		if(start == null) {
			start = bucket;
		} else {
			Bucket temp = start;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(bucket);
		}
		size++;
	}
	public void insertBucketAtPos(int pos, Bucket bucket) {
		if(start == null) {
			start = bucket;
			size++;
		} else {
			if(pos == size) {
				insertBucketAtLast(bucket);
			} else {
				Bucket temp = start;
				for(int i = 0; i <= size-1; i++) {
					if(i == pos-1) {
						Bucket next = temp.getNext();
						bucket.setNext(next);
						temp.setNext(bucket);
						break;
					} else {
						temp = temp.getNext();
					}
				}
				size++;
			}
		}
		
	}
	public void deleteBucketAtLast() {
		if(start != null) {
			Bucket temp = start;
			for(int i = 1; i < size-1; i++) {
				temp = temp.getNext();
			}
			temp.setNext(null);
			size--;
		}
	}
	public void deleteBucketAtFirst() {
		if(start != null) {
			Bucket temp = start;
			start = temp.getNext();
			size--;
		}
	}
	public void deleteBucketAtPos(int pos) {
		if(start != null) {
			if(pos == size) {
				deleteBucketAtLast();
			} else {
				Bucket temp = start;
				for(int i = 0; i <= size-1; i++) {
					if(i == pos-1) {
						Bucket next = temp.getNext();
						Bucket nexttonext = next.getNext();
						temp.setNext(nexttonext);
						break;
					} else {
						temp = temp.getNext();
					}
				}
				size--;
			}
		}
		
	}
	public void viewBuckets() {
		Bucket temp = start;
		if(isEmpty()) {
			System.out.println("list is empty!");
		} else{
			while(temp.getNext() != null) {
				System.out.println(temp.getData());
				temp = temp.getNext();
			}
			System.out.println(temp.getData());
		}
		System.out.println("size of list: "+getSize());
	}
}