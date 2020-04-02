public class ArrayQueue<T> implements Queue<T>
{

	T[]arr;
	int front = 0;
	int back = 0;
	int size = 0;

	public ArrayQueue()
	{
		arr = (T[]) new Object[10];
	}

	public void enqueue(T item)
	{
		if(size == arr.length)
			growArray();
		arr[(back%arr.length)] = item;
		back++;
		size++;
	}

	public T dequeue() throws Exception
	{
		if(empty())
			throw new IndexOutOfBoundsException();
		T data = arr[front];
		front++;
		size--;
		return data;
	}

	public boolean empty()
	{
		if(size == 0)
			return true;
		return false;
	}

	public void growArray()
	{
		T [] temp = (T[]) new Object[arr.length*2];
		for (int i = 0; i <= size; i++) 
		{
            temp[i] = arr[(front + i) % arr.length];
        }
		front = 0;
		back = size;
		arr = temp;
	}
}
	