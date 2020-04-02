public class ArrayStack<T> implements Stack<T>{

    T[]arr = (T[]) new Object[10];
    int top = 0;

    public void push(T item)
    {
        if(top == arr.length)
            growArray();
        arr[top] = item;
        top++; 
    }

    public T pop() throws Exception
    {
        if(top <= 0)
            throw new IndexOutOfBoundsException();
        T taken = arr[top-1];
        top--;
        return taken;
    }

    public T peek() throws Exception
    {
        if(empty())
            throw new IndexOutOfBoundsException();
        return arr[top];
    }

    public boolean empty()
    {
        return top == 0;
    }

    private void growArray()
    {
        T [] temp = (T[]) new Object[arr.length*2];
        for(int i = 0; i < arr.length; i++)
            temp[i] = arr[i];
        arr = temp;
    }
}