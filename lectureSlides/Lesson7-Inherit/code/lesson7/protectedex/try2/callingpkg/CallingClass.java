package lesson7.protectedex.try2.callingpkg;

import lesson7.protectedex.try2.objrefpkg.ObjRefClass;
import lesson7.protectedex.try2.superpkg.SuperClass;

public class CallingClass extends SuperClass {
	public void methodCall(ObjRefClass cl){
		
		//this is ok because ObjRefClass is a subclass
		//of CallingClass
		String s = cl.getVal();
		
	}
}
