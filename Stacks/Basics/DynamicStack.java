
public class DynamicStack extends Stack{
  
  public DynamicStack()
  {
    super(); // super is going to be the constructor which doesnot take any argument
  }
  public DynamicStack(int size)
  {
    super(size); // super is going to be the constructor which doesnot take any argument
  }
  
  @Override
  public boolean push(int item)
  {
    if(this.isFull())
    { 
      int [] newdata = new int[2*this.data.length];
      //copy all the previous items in new data
      for(int i = 0 ; i < data.length ; i++)
      {
        newdata[i] = data[i];
      }
      data = newdata;
    }
    //insert item
    return super.push(item);
  }
}
