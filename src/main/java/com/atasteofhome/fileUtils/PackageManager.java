package com.atasteofhome.fileUtils;

import java.util.*;
import java.lang.reflect.*;

public class PackageManager{

	public static void runPackageDriver(String packageName) 
			throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException{

		String rootPackage = "com.atasteofhome";
		if(packageName==null||packageName.length()<=0){
			return;
		}

		if(packageName.length()<=rootPackage.length() || !packageName.substring(0,rootPackage.length()).equals(rootPackage)){
			packageName = rootPackage + "." + packageName;
		}
		
        //get the driver class from the specified package
        Class driver = Class.forName(packageName + ".Driver");
        //get the run method from the driver class
        Method driverRun = driver.getDeclaredMethod("run",null);
        //get an instance of said class
        Object driverInstance = driver.newInstance();
        //attempt to run it
        driverRun.invoke(driverInstance, null);
	}
}