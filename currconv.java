import java.io.*;
import java.util.*;

class FileHandling
{
    double amt,converted;
    String ChangeFrom , Changeto;
    int flag=1,flag1=1,flag2,flag3;

	FileHandling()
	{
        this.amt = 0.00;
        this.converted = 0.00;
        this.ChangeFrom = "";
        this.Changeto = "";
	}
	void DisplayFull() throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("CurrencyNames.txt"));
		String a;
		while((a=br.readLine())!=null)
		{			
			System.out.println("\t\t"+a);			
		}
        br.close();
        System.out.println("\n");	
	}
	
	double XtoY()throws IOException
	{
        String a = "",b = "", g= "",h="", i="", j="";
        double x = 0.00,y = 0.00;
        
        FileHandling F = new FileHandling();
        BufferedReader Sc = new BufferedReader(new InputStreamReader(System.in)); 

        System.out.print("Enter the currency code you wish to convert from. (Type AAA to display a list of all supported currency codes) : ");
        this.ChangeFrom = Sc.readLine();
        
        if(ChangeFrom.equalsIgnoreCase("AAA"))
        {
            F.DisplayFull();
            System.out.print("Enter the type of currency you wish to convert from : ");
            this.ChangeFrom = Sc.readLine();

            BufferedReader br3 = new BufferedReader(new FileReader("CurrencyNames.txt"));
            while((h=br3.readLine())!=null)
            {
                String from2[] = h.split(" ");
                if(from2[0].equalsIgnoreCase(this.ChangeFrom)){
                    flag=0;
                    break;
                 }
                 else{
                     flag=1; 
                 }
             }
             if(flag==1){
                 System.out.println("WRONG INPUT!.");
                 F.XtoY();
             }
             
            
            System.out.println();
        }
        
else{
        BufferedReader br = new BufferedReader(new FileReader("CurrencyNames.txt"));
           
            while((g=br.readLine())!=null)
            {
                String from[] = g.split(" ");
                if(from[0].equalsIgnoreCase(this.ChangeFrom)){
                   flag1=0;
                   break;
                }
                else{
                    flag1=1;
                   
                }
            }
            if(flag1==1){
                System.out.println("WRONG INPUT!.");
                F.XtoY();
            }
            
    
        System.out.println();

}
        System.out.print("Enter the amount : ");
        try
        {
            amt = Double.parseDouble(Sc.readLine());
        }
        catch(NumberFormatException e)
        {
            System.out.println("\nInvalid Input. Restarting Method.");
            F.XtoY();
        }
        System.out.println();


        System.out.print("Enter the currency code you wish to convert to. (Type AAA to display a list of all supported currency codes) : ");
        this.Changeto=Sc.readLine();

        if(Changeto.equalsIgnoreCase("AAA"))
        {
            F.DisplayFull();
            System.out.print("\nEnter the type of currency you wish to convert to : ");
            this.Changeto = Sc.readLine();
            BufferedReader br6 = new BufferedReader(new FileReader("CurrencyNames.txt"));
            
    
            while((j=br6.readLine())!=null)
            {   
                String to2[] = j.split(" ");
                if(to2[0].equalsIgnoreCase(this.Changeto)){
                    flag2=0;
                    break;
                 }
                 else{
                     flag2=1; 
                 }
             }
             if(flag2==1){
                 System.out.println("WRONG INPUT! Re-enter.");
                 F.XtoY();
             }
             
            
            System.out.println();
        }
        else{
        BufferedReader br5 = new BufferedReader(new FileReader("CurrencyNames.txt"));
            
            while((i=br5.readLine())!=null)
            {
                String to[] = i.split(" ");
                if(to[0].equalsIgnoreCase(this.Changeto)){
                    flag3=0;
                    break;
                 }
                 else{
                     flag3=1; 
                 }
             }
             if(flag3==1){
                 System.out.println("WRONG INPUT! Re-enter.");
                 F.XtoY();
             }
             
            System.out.println();
        }
            

		BufferedReader br1 = new BufferedReader(new FileReader("CurrencyRates.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("CurrencyRates.txt"));

		while((a=br1.readLine())!=null)
		{
			String W[] = a.split(" ");
			if(W[0].equalsIgnoreCase(this.ChangeFrom))
			{
				while((b=br2.readLine())!=null)
				{
					String W1[] = b.split(" ");
					if(W1[0].equalsIgnoreCase(this.Changeto))
					{
                        try
                        {
						    x=Double.parseDouble(W[1]);
						    y=Double.parseDouble(W1[1]);
                        }
                        catch(NumberFormatException e)
                        {
                            System.out.println("\nInvalid Input. Restarting Method.");
                            F.XtoY();
                        }
                        
                        this.converted = (x*amt)/y;
                        System.out.println( ChangeFrom.toUpperCase()+" "+ amt + " = " + Changeto.toUpperCase() + " " + this.converted );
                        System.out.println("\n");
                        br1.close();
					    br2.close();
					    return this.converted;
					}
				}
				//System.out.println("Error.Incorrect currency code. Restarting.");
                break;}
		} 
		//System.out.println("Error. Incorrect currency code. Restarting.");
		br1.close();
		br2.close();
        return -1;
       
    }
      
}
	
public class currconv
{
    int ch,choice;
    currconv()
    {
        this.choice = 0;
        this.ch = 0;
    }
    public void runpro()throws IOException
    {
        currconv pr = new currconv();
        int exitflag = 1;
        BufferedReader br = new BufferedReader(new FileReader("CurrencyRates.txt"));
        BufferedReader Sc = new BufferedReader(new InputStreamReader(System.in)); 

		FileHandling F = new FileHandling();
		
        do
        {
			System.out.println("\n******* CURRENCY CONVERTER MENU ******* \n");
			System.out.println("1.Convert any currency to any currency!");
            System.out.println("2.Exit.");
			System.out.print("Enter Choice : ");

			 
            try
            {      
			    this.choice = Integer.parseInt(Sc.readLine());
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid Input. Restarting Method.");
                pr.runpro();
            }
            
            ch = this.choice;
            switch(ch)
            {
                case 1:
                {              
                    F.XtoY();
                    break;
                
                }
                case 2:
                {
                    System.out.println("\nThank you!");
                    exitflag = 0;
                    System.exit(0);
                    break;
                }

                default :
                {
                    System.out.println("Invalid Input. Restarting.");
                    pr.runpro();
                }
            }
        }
        while(exitflag==1);
		System.out.println("END OF PROGRAM.");
        br.close();
        // close the file
    }
    
    public static void main(String[] args) throws IOException
	{
       currconv p = new currconv();
       p.runpro();	
	}
}
