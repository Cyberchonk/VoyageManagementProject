package com.fdmgroup.dao;

import java.util.ArrayList;

import com.fdmgroup.model.ISavable;

public interface ISaved <T extends ISavable>{

	public void create(T t);
	public Boolean findById(int id);
	public ArrayList<T> findAll();
	
}
