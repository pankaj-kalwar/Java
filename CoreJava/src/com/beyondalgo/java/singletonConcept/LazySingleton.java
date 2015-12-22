package com.beyondalgo.java.singletonConcept;

public class LazySingleton {
	private static LazySingleton lazySingletonInstance = null;
	
	// Preventing object to reate its instance
	private LazySingleton(){
	}
	
	public LazySingleton getLazySingletonInstance(){
		if(lazySingletonInstance == null){
			synchronized (lazySingletonInstance) {
				lazySingletonInstance = new LazySingleton();
			}
		}
		return lazySingletonInstance;
	}
}
