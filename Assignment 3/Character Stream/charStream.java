import java.io.*;
public class charStream
{
    public static void main(String[] args)throws IOException 
    {
	FileReader f_in = null;
	FileOutputStream f_out = null;
	try
	{
            f_in = new FileReader("C:\\Users\\vikash kumar\\Desktop\\INPUT1.txt");
            f_out = new FileOutputStream("C:\\Users\\vikash kumar\\Desktop\\OUTPUT1.txt",true); 
            int temp;
            while((temp=f_in.read())!=-1)
		f_out.write((char)temp);
	}
	finally
	{
            if(f_in != null)
                f_in.close();
            if(f_out != null)
		f_out.close();
	}
    }
}