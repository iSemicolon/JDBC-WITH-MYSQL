package org.kol.LightApp;

//Object Creation Using Factory Method

public class LightFactory {
	
	public static ISwitch getLight(String type)
	{
		if(type.equalsIgnoreCase("TubeLight"))
		{
			return new TubeLightImpl();
		}
		
		else if (type.equalsIgnoreCase("LedLight"))
		{
			return new LedLightImpl();
		}
		
		else
		{
			System.err.println("Light Not Found");
			
			
		}
		return null;
	}

}
