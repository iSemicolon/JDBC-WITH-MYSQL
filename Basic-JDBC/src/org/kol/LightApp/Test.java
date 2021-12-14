package org.kol.LightApp;
import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Type of Light");
		String type=sc.next();
		sc.close();
		ISwitch selectSwitch= LightFactory.getLight(type);
		
		if(selectSwitch!=null)
		{
			selectSwitch.switchOn();
			selectSwitch.switchOff(); // consumer or utilization logic
		}
			
	}

}
