package Queues.Basics;

public class DynamicQueue extends Circularqueue{

  public DynamicQueue()
  {
    super();
  }

  public DynamicQueue(int size)
  {
    super(size);
  }

  @Override
  public boolean insert(int item) throws Exception
  {
    if(isFull())
    {
      int [] newdata = new int[2*data.length];
      for(int i = 0 ; i < data.length ; i++)
      {
        newdata[i] = data[(front+i)%data.length];
      }
      front = 0;
      end = data.length;
      data = newdata;
    }
    return super.insert(item);
  }
  @Override
  public int remove() throws Exception
  {
    
    return super.remove();
  }
}


