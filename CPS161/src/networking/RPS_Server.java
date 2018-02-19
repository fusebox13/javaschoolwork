package networking;

import java.io.PrintStream;
import java.util.Scanner;

public class RPS_Server extends EchoServer{
    static final char paper ='p';
    static final char rock = 'r';
    static final char scissors ='s';

//Overriding from EchoServer
    void processNextLine(Scanner input, PrintStream ps)
    {
        String s= input.nextLine().toLowerCase();
        if (s.length() == 0)
        {
            ps.println("Enter r,p,s for Rock, Paper, Scissors");
            return;
        }
        
        char clientChoice= s.charAt(0);
        char computerChoice = computerPick();

        System.out.println("You: "+ clientChoice+ " Computer: "+ computerChoice);
        String response = "You: " + rps_results(clientChoice,  computerChoice);

        ps.println(response);
        System.out.println("EchoServer echoed: "+response);
    }

    private char computerPick()
    {
        switch((int)(3* Math.random()))
        {
        case 0:
            return scissors;
        case 1:
            return paper;
        case 2:
            return rock;
        }
        return '?'; // Bad input and shouldn't happen
    }
    
    String rps_results(char userInput,  char otherInput)
    {
        String response=" LOSE :-) !!";

        if ( userInput == otherInput)
        {
            response =  " Tied";
        }
        else
        {
            switch (userInput)
            {
            case scissors:
                if (otherInput == paper)
                    response= " WIN!!";            
                break;
            case rock:
                if (otherInput == scissors)
                    response =  " WIN!!";    
                break;
            case paper:
                if (otherInput == rock)
                    response = " WIN!!";
                break;
            default:
                response = " had bad input: " +userInput + 
                            " -- Enter r,p,s for Rock, Paper, Scissors";
            }
        }
        return response;
    }

    public static void main(String[] args) {
        RPS_Server es = new RPS_Server();
        es.monitorServer();
        System.out.println("Exitting RPS_Server");

    }

}