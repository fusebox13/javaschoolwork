package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class EchoObjectServer extends EchoServer{

    void processStream(InputStream is, OutputStream os)
    {
        System.out.println("EchoObjectServer.processStream begins");
        ObjectInputStream input = null;
        ObjectOutputStream output = null;

        try
        {
            input = new ObjectInputStream(is);
            output = new ObjectOutputStream(os);
            UserInputs ui=(UserInputs)input.readObject();

            while (ui != null)
            {
                System.out.println("EchoObjectServer read: "+ui);
                output.writeObject(ui); // Echo data read
                ui=(UserInputs)input.readObject();
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("EchoObjectServer.processStream ClassNotFoundException: "+e);
        }
        catch (IOException e)
        {
            System.out.println("EchoObjectServer.processStream IOException: "+e);            
        }
        finally
        {
            try
            { // I'm annoyed that I need try/catch for this
                input.close();
                output.close();
            }
            catch (IOException e)
            {}
        }
        System.out.println("Exitting EchoObjectServer.processStream");
    }

    public static void main(String[] args) {
        EchoObjectServer es = new EchoObjectServer();
        es.monitorServer();
        System.out.println("Exitting EchoServer");

    }

}